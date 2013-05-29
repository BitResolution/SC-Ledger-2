package com.bitresolution.ledger.core.files;

import com.bitresolution.ledger.core.ledger.Entry;
import com.bitresolution.ledger.core.ledger.Report;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.CharBuffer;

public class ReportFileReader implements Readable {

    private static final Logger log = LoggerFactory.getLogger(ReportFileReader.class);

    private final LineNumberReader reader;

    public ReportFileReader(File source) throws FileNotFoundException {
        reader = new LineNumberReader(new FileReader(source));
    }

    @Override
    public int read(CharBuffer charBuffer) throws IOException {
        return reader.read(charBuffer);
    }

    public Report readReport() throws IOException {
        Report.Builder report = new Report.Builder();
        String line;
        while((line = reader.readLine()) != null) {
            LineType lineType = LineType.of(line);
            log.trace("line[{}] is type {}", new Object[]{reader.getLineNumber(), lineType.name()});
            switch(lineType) {
                case PERIOD_OF_REPORT:
                    parsePeriodOfReport(line, lineType, report);
                    break;

                case REPORT_FILING_DATE:
                    parseFilingDate(line, lineType, report);
                    break;

                case ENTRY:
                    parseEntry(line, lineType, report);
                    break;

                case SKIPPABLE:
                    break;
            }
        }
        return report.build();
    }

    private void parseEntry(String line, LineType type, Report.Builder report) {
        try {
            String[] values = line.split("[\\s]{2,}");
            Entry.Builder entryBuilder = new Entry.Builder();
            entryBuilder.setNameOfIssuer(values[0]);
            entryBuilder.setTitleOfClass(values[1]);
            entryBuilder.setCusip(values[2]);
            entryBuilder.setMarketValue(values[3]);
            entryBuilder.setAmount(values[4]);
            entryBuilder.setCall(values[5]);
            entryBuilder.setInvestmentDescretion(values[6]);
            entryBuilder.setOtherManagers("");
            entryBuilder.setVotingAuthoritySole(values[7]);
            entryBuilder.setShared(values[8]);
            entryBuilder.setNone(values[9]);
            Entry entry = entryBuilder.build();

            report.addEntry(entry);
            log.debug("Line [{}] - parsed entry: {}", reader.getLineNumber(), entry);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            log.error("Error parsing entry line [{}]: {}", reader.getLineNumber(), line);
        }
    }

    private void parseFilingDate(String line, LineType type, Report.Builder report) {
        String value = line.substring(type.getPrefixLength()).trim();
        DateTime filingDate = new DateTime(value);
        report.setFilingDate(filingDate);
        log.debug("Line [{}] - parsed 'filing date': {}", reader.getLineNumber(), filingDate);
    }

    private void parsePeriodOfReport(String line, LineType type, Report.Builder report) {
        String value = line.substring(type.getPrefixLength()).trim();
        DateTime periodOfReport = new DateTime(value);
        report.setPeriodOfReport(periodOfReport);
        log.debug("Line [{}] - parsed 'period of report': {}", reader.getLineNumber(), periodOfReport);
    }
}

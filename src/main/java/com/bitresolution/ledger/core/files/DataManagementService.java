package com.bitresolution.ledger.core.files;

import com.bitresolution.ledger.core.ledger.Report;
import com.bitresolution.ledger.core.ledger.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Allows the loading of report files in to the system, including history. It is not
 * possible to upload multiple copies of the same report
 */
@Service
public class DataManagementService {

    private static final Logger log = LoggerFactory.getLogger(DataManagementService.class);

    private final ReportFileReaderFactory reportFileReader;
    private final ReportService reportService;

    @Autowired
    public DataManagementService(ReportService reportService, ReportFileReaderFactory reportFileReader) {
        this.reportService = reportService;
        this.reportFileReader = reportFileReader;
    }

    public void load(File reportFile) {
        try {
            ReportFileReader reader = reportFileReader.getReader(reportFile);
            Report report = reader.readReport();
            reportService.save(report);
        }
        catch (FileNotFoundException e) {
            log.error("Could not find report file: {}", reportFile);
        }
        catch (IOException e) {
            log.error("Failed to parse report file: {}", reportFile, e);
        }
    }
}

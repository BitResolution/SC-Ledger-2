package com.bitresolution.ledger.core.files;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;

@Component
public class DefaultReportFileReaderFactory implements ReportFileReaderFactory {

    @Override
    public ReportFileReader getReader(File source) throws FileNotFoundException {
        return new ReportFileReader(source);
    }
}

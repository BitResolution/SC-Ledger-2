package com.bitresolution.ledger.core.files;

import java.io.File;
import java.io.FileNotFoundException;

public interface ReportFileReaderFactory {

    public ReportFileReader getReader(File source) throws FileNotFoundException;
}

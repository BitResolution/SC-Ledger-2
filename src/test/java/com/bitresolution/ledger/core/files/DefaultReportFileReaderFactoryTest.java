package com.bitresolution.ledger.core.files;

import com.bitresolution.UnitTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;
import java.io.FileNotFoundException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

@Category(UnitTest.class)
public class DefaultReportFileReaderFactoryTest {

    @Test
    public void shouldCreateInstancesOfReportFileReader() throws Exception {
        //given
        ReportFileReaderFactory factory = new DefaultReportFileReaderFactory();
        File source = new File(this.getClass().getResource("/single-entry-example.txt").toURI());

        //when
        ReportFileReader reader = factory.getReader(source);

        //then
        assertThat(reader, is(not(nullValue())));
        assertThat(reader, is(instanceOf(ReportFileReader.class)));
    }

    @Test(expected = FileNotFoundException.class)
    public void shouldProgagateExceptions() throws Exception {
        //given
        ReportFileReaderFactory factory = new DefaultReportFileReaderFactory();
        File source = new File("file-that-should-never-exist");
        assumeThat(source.exists(), is(false));

        //when
        factory.getReader(source);

        //then expect error
    }
}

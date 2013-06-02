package com.bitresolution.ledger.core.files

import com.bitresolution.UnitTest
import com.bitresolution.ledger.core.ledger.Entry
import com.bitresolution.ledger.core.ledger.Report
import com.google.common.collect.Lists
import org.joda.time.DateTime
import spock.lang.Specification

@org.junit.experimental.categories.Category(UnitTest.class)
class ReportFileReaderSpec extends Specification {

    def "should create report with correct PeriodOfReport"() {
        given:
        File source = new File(this.getClass().getResource("/single-entry-example.txt").toURI())
        ReportFileReader reader = new ReportFileReader(source)

        when:
        Report report = reader.readReport()

        then:
        assert report.periodOfReport == new DateTime("20120331")
    }

    def "should create report with correct FilingDate"() {
        given:
        File source = new File(this.getClass().getResource("/single-entry-example.txt").toURI())
        ReportFileReader reader = new ReportFileReader(source)

        when:
        Report report = reader.readReport()

        then:
        assert report.filingDate == new DateTime("20120515")
    }

    def "should create report with multiple entries"() {
        given:
        File source = new File(this.getClass().getResource("/10-entry-example.txt").toURI())
        ReportFileReader reader = new ReportFileReader(source)

        when:
        Report report = reader.readReport()

        then:
        assert report == new Report(
                null,
                new DateTime("20120331-01-01T00:00:00.000Z"),
                new DateTime("20120515-01-01T00:00:00.000Z")
        )
    }
}

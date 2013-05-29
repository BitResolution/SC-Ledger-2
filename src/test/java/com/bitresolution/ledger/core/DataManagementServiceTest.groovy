package com.bitresolution.ledger.core

import com.bitresolution.ledger.core.files.DataManagementService
import com.bitresolution.ledger.core.files.ReportFileReaderFactory
import com.bitresolution.ledger.core.ledger.Report
import com.bitresolution.ledger.core.files.ReportFileReader
import com.bitresolution.ledger.core.ledger.ReportService
import spock.lang.Specification


class DataManagementServiceTest extends Specification {

    def "should be able to upload a report file"() {
        given:
        ReportService reportService = Mock()
        ReportFileReaderFactory factory = Mock()
        ReportFileReader reader = Mock()
        Report report = Mock()
        File source = new File(this.getClass().getResource("/single-entry-example.txt").toURI())

        DataManagementService service = new DataManagementService(reportService, factory)
        factory.getReader(source) >> reader
        reader.readReport() >> report

        when:
        service.load(source)

        then:
        1 * reportService.save(report)
    }
}

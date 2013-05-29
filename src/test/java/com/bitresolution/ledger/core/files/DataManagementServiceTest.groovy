package com.bitresolution.ledger.core.files

import com.bitresolution.ledger.core.files.DataManagementService
import com.bitresolution.ledger.core.files.ReportFileReaderFactory
import com.bitresolution.ledger.core.ledger.Report
import com.bitresolution.ledger.core.files.ReportFileReader
import com.bitresolution.ledger.core.ledger.ReportService
import spock.lang.Specification


class DataManagementServiceTest extends Specification {

    def "should be able to upload a report file"() {
        given:
        ReportService reportService = Mock(ReportService)
        ReportFileReaderFactory factory = Mock(ReportFileReaderFactory)
        ReportFileReader reader = Mock(ReportFileReader)
        Report report = Mock(Report)
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

package com.bitresolution.ledger.core.ledger

import com.bitresolution.IntegrationTest
import com.bitresolution.ledger.core.LedgerApplication
import org.joda.time.DateTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

@org.junit.experimental.categories.Category(IntegrationTest.class)
@ContextConfiguration(classes = [LedgerApplication])
@Transactional
class ReportRepositorySpec extends Specification {

    @Autowired
    ReportRepository repository

    def "should insert reports"() {
        given:
        Report report = new Report()
        report.periodOfReport = new DateTime(2013, 01, 04, 00, 00, 00, 00)
        report.filingDate = new DateTime(2013, 04, 04, 0, 00, 00, 00)

        when:
        Report result = repository.save(report)

        then:
        assert result.id != null
        assert result.periodOfReport == new DateTime(2013, 01, 04, 00, 00, 00, 00)
        assert result.filingDate == new DateTime(2013, 04, 04, 00, 00, 00, 00)
    }
}

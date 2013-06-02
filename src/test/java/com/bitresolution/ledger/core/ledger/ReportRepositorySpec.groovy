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
        Report report = new Report(null, new DateTime(2013, 1, 4, 00, 00, 00, 00), new DateTime(2013, 4, 4, 0, 00, 00, 00));

        when:
        Report result = repository.save(report)

        then:
        assert result.id != null
        assert result.periodOfReport == new DateTime(2013, 1, 4, 00, 00, 00, 00)
        assert result.filingDate == new DateTime(2013, 4, 4, 00, 00, 00, 00)
    }

    def "should find report by periodOfReport"() {
        given:
        DateTime periodOfReport = new DateTime(2013, 1, 4, 00, 00, 00, 00)
        Report report = new Report(null, periodOfReport, new DateTime(2013, 4, 4, 0, 00, 00, 00));
        repository.save(report)

        when:
        List<Report> reports = repository.findByPeriodOfReport(periodOfReport)

        then:
        assert reports.size() == 1
        assert reports[0].id != null
        assert reports[0].periodOfReport == new DateTime(2013, 1, 4, 00, 00, 00, 00)
        assert reports[0].filingDate == new DateTime(2013, 4, 4, 00, 00, 00, 00)
    }

    def "should list all reports by periodOfReport"() {
        given:
        Report reportA = new Report(null, new DateTime(2013, 1, 4, 00, 00, 00, 00), new DateTime(2013, 4, 4, 0, 00, 00, 00))
        Report reportB = new Report(null, new DateTime(2013, 5, 4, 00, 00, 00, 00), new DateTime(2013, 8, 4, 0, 00, 00, 00))
        Report reportC = new Report(null, new DateTime(2013, 9, 4, 00, 00, 00, 00), new DateTime(2013, 12, 4, 0, 00, 00, 00))
        repository.save(reportA)
        repository.save(reportB)
        repository.save(reportC)

        when:
        List<Report> reports = repository.findAll().toList()

        then:
        assert reports.size() == 3
    }
}

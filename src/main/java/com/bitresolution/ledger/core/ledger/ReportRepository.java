package com.bitresolution.ledger.core.ledger;

import org.joda.time.DateTime;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReportRepository extends CrudRepository<Report, Long> {
    List<Report> findByPeriodOfReport(DateTime period);
}

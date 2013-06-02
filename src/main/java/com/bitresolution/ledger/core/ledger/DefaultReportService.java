package com.bitresolution.ledger.core.ledger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DefaultReportService implements ReportService {

    private final ReportRepository repository;

    @Autowired
    public DefaultReportService(ReportRepository repository) {
        this.repository = repository;
    }

    @Override
    public Report save(Report report) {
        return repository.save(report);
    }
}

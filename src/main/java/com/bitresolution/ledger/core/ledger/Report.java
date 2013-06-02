package com.bitresolution.ledger.core.ledger;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Report {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime periodOfReport;

    @Column
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime filingDate;

    @Transient
    private List<Entry> entries;

    public Report() {
        this.entries = new ArrayList<Entry>();
    }

    public Report(Long id, DateTime periodOfReport, DateTime filingDate, List<Entry> entries) {
        this.id = id;
        this.periodOfReport = periodOfReport;
        this.filingDate = filingDate;
        this.entries = Lists.newArrayList(entries);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTime getPeriodOfReport() {
        return periodOfReport;
    }

    public void setPeriodOfReport(DateTime periodOfReport) {
        this.periodOfReport = periodOfReport;
    }

    public DateTime getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(DateTime filingDate) {
        this.filingDate = filingDate;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, periodOfReport, filingDate, entries);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Report other = (Report) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.periodOfReport, other.periodOfReport) && Objects.equal(this.filingDate, other.filingDate) && Objects.equal(this.entries, other.entries);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("periodOfReport", periodOfReport)
                .add("filingDate", filingDate)
                .add("entries", entries)
                .toString();
    }
}

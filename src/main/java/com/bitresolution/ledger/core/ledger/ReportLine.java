package com.bitresolution.ledger.core.ledger;

import com.google.common.base.Objects;

import javax.persistence.*;

@Entity
public class ReportLine {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String nameOfIssuer;
    @Column
    private String titleOfClass;
    @Column
    private String cusip;
    @Column
    private String value;
    @Column
    private String amount;
    @Column
    private String sbOrPrm;
    @Column
    private String putOrCall;
    @Column
    private String investmentDiscretion;
    @Column
    private String otherManagers;
    @Column
    private String votingRole;
    @Column
    private String authorityShared;
    @Column
    private String none;

    public ReportLine(String nameOfIssuer, String titleOfClass, String cusip, String value, String amount, String sbOrPrm, String putOrCall, String investmentDiscretion, String otherManagers, String votingRole, String authorityShared, String none) {
        this.nameOfIssuer = nameOfIssuer;
        this.titleOfClass = titleOfClass;
        this.cusip = cusip;
        this.value = value;
        this.amount = amount;
        this.sbOrPrm = sbOrPrm;
        this.putOrCall = putOrCall;
        this.investmentDiscretion = investmentDiscretion;
        this.otherManagers = otherManagers;
        this.votingRole = votingRole;
        this.authorityShared = authorityShared;
        this.none = none;
    }

    public String getNameOfIssuer() {
        return nameOfIssuer;
    }

    public void setNameOfIssuer(String nameOfIssuer) {
        this.nameOfIssuer = nameOfIssuer;
    }

    public String getTitleOfClass() {
        return titleOfClass;
    }

    public void setTitleOfClass(String titleOfClass) {
        this.titleOfClass = titleOfClass;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSbOrPrm() {
        return sbOrPrm;
    }

    public void setSbOrPrm(String sbOrPrm) {
        this.sbOrPrm = sbOrPrm;
    }

    public String getPutOrCall() {
        return putOrCall;
    }

    public void setPutOrCall(String putOrCall) {
        this.putOrCall = putOrCall;
    }

    public String getInvestmentDiscretion() {
        return investmentDiscretion;
    }

    public void setInvestmentDiscretion(String investmentDiscretion) {
        this.investmentDiscretion = investmentDiscretion;
    }

    public String getOtherManagers() {
        return otherManagers;
    }

    public void setOtherManagers(String otherManagers) {
        this.otherManagers = otherManagers;
    }

    public String getVotingRole() {
        return votingRole;
    }

    public void setVotingRole(String votingRole) {
        this.votingRole = votingRole;
    }

    public String getAuthorityShared() {
        return authorityShared;
    }

    public void setAuthorityShared(String authorityShared) {
        this.authorityShared = authorityShared;
    }

    public String getNone() {
        return none;
    }

    public void setNone(String none) {
        this.none = none;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameOfIssuer, titleOfClass, cusip, value, amount, sbOrPrm, putOrCall, investmentDiscretion, otherManagers, votingRole, authorityShared, none);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final ReportLine other = (ReportLine) obj;
        return Objects.equal(this.nameOfIssuer, other.nameOfIssuer) && Objects.equal(this.titleOfClass, other.titleOfClass) && Objects.equal(this.cusip, other.cusip) && Objects.equal(this.value, other.value) && Objects.equal(this.amount, other.amount) && Objects.equal(this.sbOrPrm, other.sbOrPrm) && Objects.equal(this.putOrCall, other.putOrCall) && Objects.equal(this.investmentDiscretion, other.investmentDiscretion) && Objects.equal(this.otherManagers, other.otherManagers) && Objects.equal(this.votingRole, other.votingRole) && Objects.equal(this.authorityShared, other.authorityShared) && Objects.equal(this.none, other.none);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("nameOfIssuer", nameOfIssuer)
                .add("titleOfClass", titleOfClass)
                .add("cusip", cusip)
                .add("value", value)
                .add("amount", amount)
                .add("sbOrPrm", sbOrPrm)
                .add("putOrCall", putOrCall)
                .add("investmentDiscretion", investmentDiscretion)
                .add("otherManagers", otherManagers)
                .add("votingRole", votingRole)
                .add("authorityShared", authorityShared)
                .add("none", none)
                .toString();
    }
}

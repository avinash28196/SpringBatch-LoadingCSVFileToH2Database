package com.LendingClub.demo.model;


public class LendingClub {

    private Long member_id;
    private String loan_amnt;
    private String funded_amnt_inv;
    private String term ;
    private String int_rate ;
    private String installment ;
    private String grade ;
    private String emp_title ;
    private String emp_length ;
    private String home_ownership;
    private String annual_inc ;
    private String issue_d ;
    private String verification_status ;
    private String loan_status ;
    private String descr ;
    private String purpose ;
    private String title ;
    private String addr_state ;
    private String last_pymnt_d ;
    private String last_pymnt_amnt;

    @Override
    public String toString() {
        return "LendingClub{" +
                "member_id=" + member_id +
                ", loan_amnt='" + loan_amnt + '\'' +
                ", funded_amnt_inv='" + funded_amnt_inv + '\'' +
                ", term='" + term + '\'' +
                ", int_rate='" + int_rate + '\'' +
                ", installment='" + installment + '\'' +
                ", grade='" + grade + '\'' +
                ", emp_title='" + emp_title + '\'' +
                ", emp_length='" + emp_length + '\'' +
                ", home_ownership='" + home_ownership + '\'' +
                ", annual_inc='" + annual_inc + '\'' +
                ", issue_d='" + issue_d + '\'' +
                ", verification_status='" + verification_status + '\'' +
                ", loan_status='" + loan_status + '\'' +
                ", descr='" + descr + '\'' +
                ", purpose='" + purpose + '\'' +
                ", title='" + title + '\'' +
                ", addr_state='" + addr_state + '\'' +
                ", last_pymnt_d='" + last_pymnt_d + '\'' +
                ", last_pymnt_amnt='" + last_pymnt_amnt + '\'' +
                '}';
    }

    public Long getMember_id() {
        return member_id;
    }

    public void setMember_id(Long member_id) {
        this.member_id = member_id;
    }

    public String getLoan_amnt() {
        return loan_amnt;
    }

    public void setLoan_amnt(String loan_amnt) {
        this.loan_amnt = loan_amnt;
    }

    public String getFunded_amnt_inv() {
        return funded_amnt_inv;
    }

    public void setFunded_amnt_inv(String funded_amnt_inv) {
        this.funded_amnt_inv = funded_amnt_inv;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getInt_rate() {
        return int_rate;
    }

    public void setInt_rate(String int_rate) {
        this.int_rate = int_rate;
    }

    public String getInstallment() {
        return installment;
    }

    public void setInstallment(String installment) {
        this.installment = installment;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmp_title() {
        return emp_title;
    }

    public void setEmp_title(String emp_title) {
        this.emp_title = emp_title;
    }

    public String getEmp_length() {
        return emp_length;
    }

    public void setEmp_length(String emp_length) {
        this.emp_length = emp_length;
    }

    public String getHome_ownership() {
        return home_ownership;
    }

    public void setHome_ownership(String home_ownership) {
        this.home_ownership = home_ownership;
    }

    public String getAnnual_inc() {
        return annual_inc;
    }

    public void setAnnual_inc(String annual_inc) {
        this.annual_inc = annual_inc;
    }

    public String getIssue_d() {
        return issue_d;
    }

    public void setIssue_d(String issue_d) {
        this.issue_d = issue_d;
    }

    public String getVerification_status() {
        return verification_status;
    }

    public void setVerification_status(String verification_status) {
        this.verification_status = verification_status;
    }

    public String getLoan_status() {
        return loan_status;
    }

    public void setLoan_status(String loan_status) {
        this.loan_status = loan_status;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddr_state() {
        return addr_state;
    }

    public void setAddr_state(String addr_state) {
        this.addr_state = addr_state;
    }

    public String getLast_pymnt_d() {
        return last_pymnt_d;
    }

    public void setLast_pymnt_d(String last_pymnt_d) {
        this.last_pymnt_d = last_pymnt_d;
    }

    public String getLast_pymnt_amnt() {
        return last_pymnt_amnt;
    }

    public void setLast_pymnt_amnt(String last_pymnt_amnt) {
        this.last_pymnt_amnt = last_pymnt_amnt;
    }
}


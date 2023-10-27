package vn.edu.iuh.fit.entity;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
public class Experience {
    @Id
    @Column(name = "exp_id")
    private long expID;
    @Column(name = "company", columnDefinition = "varchar(120)")
    private String company;
    @Column(name = "from_date")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate fromDate;
    @Column(name = "to_date")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate toDate;
    @Column(name = "role", columnDefinition = "tinyint(4)")
    private int role;
    @Column(name = "work_desc", columnDefinition = "varchar(400)")
    private String workDesc;
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    public Experience() {
    }

    public Experience(long expID, String company, LocalDate fromDate, LocalDate toDate, int role, String workDesc, Candidate candidate) {
        this.expID = expID;
        this.company = company;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.role = role;
        this.workDesc = workDesc;
        this.candidate = candidate;
    }

    public Experience(long expID, String company, LocalDate fromDate, LocalDate toDate, int role, String workDesc) {
        this.expID = expID;
        this.company = company;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.role = role;
        this.workDesc = workDesc;
    }

    public long getExpID() {
        return expID;
    }

    public void setExpID(long expID) {
        this.expID = expID;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getWorkDesc() {
        return workDesc;
    }

    public void setWorkDesc(String workDesc) {
        this.workDesc = workDesc;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "expID=" + expID +
                ", company='" + company + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", role=" + role +
                ", workDesc='" + workDesc + '\'' +
                ", candidate=" + candidate +
                '}';
    }
}

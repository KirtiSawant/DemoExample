package com.demo.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;


import java.util.Set;

@Data
@Table("BRANCH")
public class Branch {

    @Id
    private int branchId;

    @Column("branchName")
    private String branchName;

    private String description;

    @MappedCollection(keyColumn = "branchId", idColumn = "branchId")
    private Set<Student> students;

    public Branch(int branchId, String branchName, String description, Set<Student> students) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.description = description;
        this.students = students;
    }

    public int getBranchId() {
        return branchId;
    }
    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}

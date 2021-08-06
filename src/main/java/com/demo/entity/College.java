package com.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Data
@Table("College")
public class College {

    @Id
    private int id;

    @Column("college_name")
    @NotBlank(message = "Please provide collegeName")
    private String collegeName;

    @NotBlank(message = "Please provide place")
    @Column("place")
    private String place;
    @NotBlank
    @Min(value = 1, message = "required")
    @Column("college_code")
    private String clgCode;

    public College(int id, String collegeName, String place, String clgCode) {

        this.id = id;
        this.collegeName = collegeName;
        this.place = place;
        this.clgCode = clgCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getClgCode() {
        return clgCode;
    }

    public void setClgCode(String clgCode) {
        this.clgCode = clgCode;
    }
}


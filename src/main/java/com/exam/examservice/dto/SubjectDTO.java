package com.exam.examservice.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SubjectDTO {

    @NotNull(message = "Name of the subject must be present")
    @NotBlank(message = "Name of the subject must not be empty")
    private String name;

    private int creditPoints;

    @NotNull(message = "Name of the professor must be present")
    @NotBlank(message = "Name of the professor must not be empty")
    private String professor;

    @NotNull(message = "The group id must be present")
    private int groupId;

    public SubjectDTO(){}

    public SubjectDTO(String name, int creditPoints, String professor, int groupId) {
        this.name = name;
        this.creditPoints = creditPoints;
        this.professor = professor;
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(int creditPoints) {
        this.creditPoints = creditPoints;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}

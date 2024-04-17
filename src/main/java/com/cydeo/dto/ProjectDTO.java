package com.cydeo.dto;

import com.cydeo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    private String projectName;
    private String projectCode;
    private UserDTO assignedManager; // this has to be UserDTO, because we created our users as a UserDTO.

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate projectStartDate;
    @DateTimeFormat(pattern ="yyyy-MM-dd")

    private LocalDate projectEndDate;
    private String projectDetail;

    private Status projectStatus;  // we need this. Its not in the <form> but it in in the Project List. Thats why we need to provide it by ENUM


//    <td th:text="${project.unfinishedTaskCounts + '/' + project.completeTaskCounts}"></td>  these are from project-status.html and not in this class.we need to define it.
    private int unfinishedTaskCounts;
    private int completeTaskCounts;

    //we need to create one more constructor without those 2 fields;


    public ProjectDTO(String projectName, String projectCode, UserDTO assignedManager, LocalDate projectStartDate, LocalDate projectEndDate, String projectDetail, Status projectStatus) {
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.assignedManager = assignedManager;
        this.projectStartDate = projectStartDate;
        this.projectEndDate = projectEndDate;
        this.projectDetail = projectDetail;
        this.projectStatus = projectStatus;
    } // this is for Project Create page.
    // other constructor is for Project Status page because we needed.
}

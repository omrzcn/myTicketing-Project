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

    private Status projectStatus;  // we need this. Its not in the <form> but it in in the Project List. Thats why we need to provice it by ENUM



}

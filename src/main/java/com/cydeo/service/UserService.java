package com.cydeo.service;

import com.cydeo.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserService extends CrudService<UserDTO,String> { // we made string because we gonna search with usernama

    List<UserDTO> findManager(); // this is for: when i on Project Create page, i want to see only managers on the Assigned Manager Dropdown. Not employess
    List<UserDTO> findEmployee();
    // this is specific for users.

}

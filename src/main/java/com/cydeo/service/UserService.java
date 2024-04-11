package com.cydeo.service;

import com.cydeo.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserService extends CrudService<UserDTO,String> { // we made string because we gonna search with usernama



}

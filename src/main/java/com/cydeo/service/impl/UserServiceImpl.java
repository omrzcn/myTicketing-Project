package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractMapService<UserDTO,String> implements UserService {





    @Override
    public UserDTO save(UserDTO user) { // from extends AbstractMapService<UserDTO,String>

      return super.save(user.getUserName(), user);
    }



    @Override
    public UserDTO findById(String username) {
        return super.findById(username);

    }


    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String username) {
    super.deleteById(username);
    }

    @Override
    public void update(UserDTO object) {
        super.update(object.getUserName(),object);
    }


    @Override
    public List<UserDTO> findManager() {
        return findAll().stream().filter(user->user.getRole().getId()==2).collect(Collectors.toList()); // this is for only UserService to findManagers.

        // 2 is coming from here   RoleDTO managerRole = new RoleDTO(2L,"Manager");  2L. it's id.
    }
}

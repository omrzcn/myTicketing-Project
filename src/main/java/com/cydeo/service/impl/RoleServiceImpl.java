package com.cydeo.service.impl;

import com.cydeo.dto.RoleDTO;
import com.cydeo.service.RoleService;

import java.util.List;

public class RoleServiceImpl extends AbstractMapService<RoleDTO,Long> implements RoleService { // first we'll wrire implements RoleService , than override, than add extends AbstractMapService


    @Override
    public RoleDTO save(RoleDTO user) {
        return super.save(user.getId(), user);
    }

    @Override
    public RoleDTO findById(Long username) {
        return super.findById(username);
    }

    @Override
    public List<RoleDTO> findAll() { // we used super because of "extends AbstractMapService"
        return super.findAll();
    }

    @Override
    public void deleteById(Long username) {
        super.deleteById(username);
    }
}

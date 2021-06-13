package com.cybertek.implementations;

import com.cybertek.cnverters.MapperUtil;
import com.cybertek.dto.RoleDTO;
import com.cybertek.entity.Role;
import com.cybertek.repo.RoleRepo;
import com.cybertek.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
private RoleRepo roleRepo;


    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;

    }



    @Override
    public String findById(Integer id) {
        Role role = roleRepo.findById(id).get();
        return role.getName();
    }
}

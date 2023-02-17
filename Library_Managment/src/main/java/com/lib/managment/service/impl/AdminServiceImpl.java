package com.lib.managment.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.managment.dtos.AdminDto;
import com.lib.managment.helper.RoleEnum;
import com.lib.managment.models.Admin;
import com.lib.managment.models.UserRole;
import com.lib.managment.repository.AdminRepository;
import com.lib.managment.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public AdminDto addAdmin(AdminDto adminDto) {
		
		Admin admin = modelMapper.map(adminDto, Admin.class);
		UserRole userRole = new UserRole();
		userRole.setRid(102);
		userRole.setName(RoleEnum.ADMIN.getRole());
		admin.setRole(userRole);
		admin = adminRepository.save(admin);
		return modelMapper.map(admin, adminDto.getClass());
	}

}

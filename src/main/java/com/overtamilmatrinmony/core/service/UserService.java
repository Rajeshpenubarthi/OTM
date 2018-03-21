package com.overtamilmatrinmony.core.service;

import java.util.List;

import com.overtamilmatrinmony.core.dto.Reference;
import com.overtamilmatrinmony.core.dto.User;
import com.overtamilmatrinmony.core.dto.UserDetail;

public interface UserService
	{

		public long save(User userDto);

		public long registorUser(User userDto) throws Exception;

		public User get(long id);

		public void editReference(List<Reference> reference, int id) throws Exception;

		public void editUserDetails(UserDetail userdetail, int id)throws Exception;
	}

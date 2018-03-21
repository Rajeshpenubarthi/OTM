package com.overtamilmatrinmony.core.dao;

import java.util.List;

import com.overtamilmatrinmony.core.model.ReferenceModel;
import com.overtamilmatrinmony.core.model.UserDetailModel;
import com.overtamilmatrinmony.core.model.UserModel;

public interface UserDao
	{

		public long save(UserModel user);

		public long registor(UserModel user) throws Exception;

		public UserModel get(long id);

		public UserModel getUser(int id) throws Exception;

		public void editReference(List<ReferenceModel> referenceModel,UserModel user) throws Exception;

		public void editUserDetails(UserDetailModel userdetail, UserModel userModel) throws Exception;

	}

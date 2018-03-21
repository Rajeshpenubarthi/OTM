package com.overtamilmatrinmony.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.overtamilmatrinmony.core.dao.UserDao;
import com.overtamilmatrinmony.core.dto.Reference;
import com.overtamilmatrinmony.core.dto.User;
import com.overtamilmatrinmony.core.dto.UserDetail;
import com.overtamilmatrinmony.core.model.ReferenceModel;
import com.overtamilmatrinmony.core.model.UserDetailModel;
import com.overtamilmatrinmony.core.model.UserModel;
import com.overtamilmatrinmony.core.utility.Converter;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService
	{

		@Autowired
		private UserDao userDao;

		@Override
		public long save(User userDto)
			{
				return 1;// userDao.save(Converter.convertToUserModel(userDto));
			}

		@Override
		public long registorUser(User userDto) throws Exception
			{
				return userDao.registor(Converter.convertToUserModel(userDto));
			}

		@Override
		public User get(long id)
			{
				return Converter.convertToDTO(userDao.get(id));
			}

		@Override
		public void editReference(List<Reference> reference, int id) throws Exception
			{

				try {
					UserModel userModel = userDao.getUser(id);

					List<ReferenceModel> referenceModel = new ArrayList<ReferenceModel>(reference.size());
					for (Reference ref : reference) {
						if (ref.getUser().getUserId() == id) {
							referenceModel.add(Converter.convertToReferenceModel(ref, userModel));
						}
					}

					userDao.editReference(referenceModel, userModel);

				} catch (Exception e) {
					// TODO: handle exception
				}
				return;
			}

		@Override
		public void editUserDetails(UserDetail userDetail, int id) throws Exception
			{

				try {
					UserModel userModel = userDao.getUser(id);
					if (userDetail.getUser().getUserId() == id) 
						userDao.editUserDetails(Converter.convertToUserDetailModel(userDetail, userModel),userModel);

				} catch (Exception e) {
					// TODO: handle exception
				}
				return;
			}	
	}

package com.overtamilmatrinmony.core.utility;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.overtamilmatrinmony.core.dto.Login;
import com.overtamilmatrinmony.core.dto.Reference;
import com.overtamilmatrinmony.core.dto.User;
import com.overtamilmatrinmony.core.dto.UserDetail;
import com.overtamilmatrinmony.core.model.LoginModel;
import com.overtamilmatrinmony.core.model.ReferenceModel;
import com.overtamilmatrinmony.core.model.UserDetailModel;
import com.overtamilmatrinmony.core.model.UserModel;

public class Converter
	{

		public static Login convertToLoginDTO(LoginModel loginModel)
			{

				ModelMapper modelMapper = new ModelMapper();
				Login loginDto = modelMapper.map(loginModel, Login.class);
				// loginDto.setUser(convertToUserDTO(loginModel.getUser(), loginDto));
				return loginDto;

			}

		public static LoginModel convertToLoginModel(Login logindto, UserModel usermodel)
			{

				ModelMapper modelMapper = new ModelMapper();
				LoginModel loginModel = modelMapper.map(logindto, LoginModel.class);
				/*
				 * loginModel.setUser(convertToUserModel(logindto.getUser(),loginModel));
				 */
				// loginModel.setUser(usermodel);
				return loginModel;

			}

		public static User convertToUserDTO(UserModel user, Login login)
			{

				ModelMapper modelMapper = new ModelMapper();
				User userDto = modelMapper.map(user, User.class);
				userDto.setLogin(login);
				userDto.setUserDetail(convertToUserDetail(user.getUserDetail(), userDto));
				List<Reference> referencedto = getReference(user.getReference());
				userDto.setReference(referencedto);

				return userDto;

			}

		private static List<Reference> getReference(List<ReferenceModel> referenceModel)
			{
				List<Reference> reference = new ArrayList<Reference>(referenceModel.size());
				for (ReferenceModel r : referenceModel) {
					reference.add(convertToReferenceDTO(r));
				}
				return reference;
			}

		public static UserModel convertToUserModel(User userDto, LoginModel loginModel)
			{

				ModelMapper modelMapper = new ModelMapper();
				UserModel userModel = modelMapper.map(userDto, UserModel.class);
				userModel.setUserDetail(convertToUserDetailModel(userDto.getUserDetail(), userModel));
				List<ReferenceModel> referenceModel = getReferenceModel(userDto.getReference(), userModel);
				userModel.setReference(referenceModel);

				return userModel;
			}

		public static User convertToDTO(UserModel user)
			{

				ModelMapper modelMapper = new ModelMapper();
				User userDto = modelMapper.map(user, User.class);
				userDto.setUserDetail(convertToUserDetail(user.getUserDetail(), userDto));
				return userDto;

			}

		public static UserModel convertToUserModel(User userDto)
			{

				ModelMapper modelMapper = new ModelMapper();
				UserModel userModel = modelMapper.map(userDto, UserModel.class);

				userModel.setUserDetail(convertToUserDetailModel(userDto.getUserDetail(), userModel));

				userModel.setLogin(convertToLoginModel(userDto.getLogin(), userModel));

				List<ReferenceModel> referenceModel = getReferenceModel(userDto.getReference(), userModel);
				userModel.setReference(referenceModel);
				return userModel;
			}

		private static List<ReferenceModel> getReferenceModel(List<Reference> reference, UserModel user)
			{
				List<ReferenceModel> referenceModel = new ArrayList<ReferenceModel>(reference.size());
				for (Reference r : reference) {
					referenceModel.add(convertToReferenceModel(r, user));
				}
				return referenceModel;
			}

		public static UserDetailModel convertToUserDetailModel(UserDetail userDetail, UserModel userModel)
			{

				ModelMapper modelMapper = new ModelMapper();
				UserDetailModel userDetailModel = modelMapper.map(userDetail, UserDetailModel.class);
				// userDetailModel.setUser(userModel);
				return userDetailModel;
			}

		public static UserDetail convertToUserDetail(UserDetailModel userDetailModel, User userDto)
			{
				ModelMapper modelMapper = new ModelMapper();

				UserDetail userDetail = modelMapper.map(userDetailModel, UserDetail.class);
				userDetail.setUser(userDto);
				return userDetail;
			}

		public static ReferenceModel convertToReferenceModel(Reference referenceDto, UserModel user)
			{

				ModelMapper modelMapper = new ModelMapper();
				ReferenceModel referenceModel = modelMapper.map(referenceDto, ReferenceModel.class);
				referenceModel.setUser(user);

				return referenceModel;
			}

		public static Reference convertToReferenceDTO(ReferenceModel referencemodel)
			{

				ModelMapper modelMapper = new ModelMapper();
				Reference referenceDto = modelMapper.map(referencemodel, Reference.class);
				// userDto.setUserDetail(convertToUserDetailDTO(user.getUserDetail(), userDto));
				return referenceDto;

			}
	}

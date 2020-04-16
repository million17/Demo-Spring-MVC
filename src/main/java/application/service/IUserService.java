package application.service;

import application.constant.StatusRegisterUserEnum;
import application.entity.UserEntity;

public interface IUserService {
    StatusRegisterUserEnum registerNewUser(UserEntity userEntity);
}

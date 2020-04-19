package application.service;

import application.constant.StatusRegisterUserEnum;
import application.entity.RoleEntity;
import application.entity.UserEntity;

import java.util.*;

public interface IUserService {
    StatusRegisterUserEnum registerNewUser(UserEntity userEntity);
    List<RoleEntity> getActiveListRole(int userId);
    List<RoleEntity> getListRole();
}

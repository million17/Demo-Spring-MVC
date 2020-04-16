package application.service.impl;

import application.constant.StatusRegisterUserEnum;
import application.constant.SystemConstants;
import application.entity.RoleEntity;
import application.entity.UserEntity;
import application.entity.UserRoleEntity;
import application.repository.RoleRepository;
import application.repository.UserRepository;
import application.repository.UserRoleRepository;
import application.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public StatusRegisterUserEnum registerNewUser(UserEntity userEntity) {
            try {
                userEntity.setUserName(userEntity.getUserName());
                userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
                userEntity.setStatus(1);


                userEntity.setRoles(userEntity.getRoles());

                userRepository.save(userEntity);



                UserRoleEntity userRoleEntity = new UserRoleEntity();
                userRoleEntity.setRoleId(SystemConstants.ROLE_USER);
                userRoleEntity.setUserId(userEntity.getId());

                userRoleRepository.save(userRoleEntity);


                return StatusRegisterUserEnum.Success;
            } catch (Exception ex) {
                System.out.println("Error Register" + ex.getMessage());
                return StatusRegisterUserEnum.Error_OnSystem;
            }

    }
}

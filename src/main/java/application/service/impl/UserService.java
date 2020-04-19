package application.service.impl;

import application.constant.StatusRegisterUserEnum;
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

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
        return StatusRegisterUserEnum.Error_OnSystem;
    }

    @Override
    public List<RoleEntity> getActiveListRole(int userId) {
        List<UserRoleEntity> listUserRoles = StreamSupport
                .stream(userRoleRepository.findRolesOfUser(userId).spliterator(),false).collect(Collectors.toList());
        return getListRole().stream().filter(roleEntity -> {
            return (listUserRoles.stream().filter(userRoleEntity -> userRoleEntity.getRoleId() == roleEntity.getId()).findFirst().orElse(null) != null);
        }).collect(Collectors.toList());
    }

    @Override
    public List<RoleEntity> getListRole() {
        return StreamSupport
                .stream(roleRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }


}

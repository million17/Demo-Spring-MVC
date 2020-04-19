package application.service.impl;

import application.constant.SystemConstants;
import application.dto.MyUser;
import application.entity.RoleEntity;
import application.entity.UserEntity;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstants.STATUS_ACTIVE);
        if (userEntity == null ) {
            throw new UsernameNotFoundException("User Not Found !");
        }

        List<RoleEntity> listActiveRoles = userService.getActiveListRole(userEntity.getId());
        boolean isActive = true;
        if(listActiveRoles.size() == 0) {
            isActive = false;
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        for(RoleEntity role : listActiveRoles){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        //put thong tin vao security duy tri he thong khi login
        MyUser myUser = new MyUser(userEntity.getUserName(),userEntity.getPassword(),
                true,true,true,true,authorities);
        myUser.setFullName(userEntity.getFullName());

        return myUser;
    }
}

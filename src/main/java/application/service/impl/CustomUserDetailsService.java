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
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstants.STATUS_ACTIVE);
        if (userEntity == null ){
            throw new UsernameNotFoundException("User Not Found !");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        for(RoleEntity role : userEntity.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
        }
        //put thong tin vao security duy tri he thong khi login
        MyUser myUser = new MyUser(userEntity.getUserName(),userEntity.getPassword(),
                true,true,true,true,authorities);
        myUser.setFullName(userEntity.getFullName());

        return myUser;
    }
}

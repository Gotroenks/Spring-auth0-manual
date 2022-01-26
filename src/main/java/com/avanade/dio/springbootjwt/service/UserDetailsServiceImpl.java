package com.avanade.dio.springbootjwt.service;

import com.avanade.dio.springbootjwt.data.UserData;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetailsServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserData userData = findUser(username);
        // if(userData == null) throw new UsernameNotFoundException(username);

        return new User(userData.getUserName(), userData.getPassword(), emptyList());
    }

    private UserData findUser(String searchName) {
        UserData userData = new UserData();
        userData.setUserName("admin");
        userData.setPassword(bCryptPasswordEncoder.encode("amimino"));

        return userData;
    }

    public List<UserData> listUsers() {
        ArrayList<UserData> list = new ArrayList<>();
        list.add(findUser("admin"));
        return list;
    }
}


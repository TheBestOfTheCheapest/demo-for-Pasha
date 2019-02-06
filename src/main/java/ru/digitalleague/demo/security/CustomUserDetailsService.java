/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package ru.digitalleague.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.digitalleague.demo.domain.UserEntity;
import ru.digitalleague.demo.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepo;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = this.userRepo.findByEmail(email);

        List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                .map(authorityEntity -> new SimpleGrantedAuthority(authorityEntity.getName()))
                .collect(Collectors.toList());
        return new User(user.getEmail(),user.getPassword(), grantedAuthorities);
        //return new User(user.getEmail(),user.getPassword(), AuthorityUtils.createAuthorityList(AuthoritiesConstants.ADMIN));
       // return new User("user",new BCryptPasswordEncoder().encode("u"), AuthorityUtils.createAuthorityList("USER"));
    }
}

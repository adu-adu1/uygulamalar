package com.projectteam3.recipeproject.app.sec.security;

import com.projectteam3.recipeproject.app.usr.dao.UsrUserDao;
import com.projectteam3.recipeproject.app.usr.entity.UsrUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private final UsrUserDao usrUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsrUser usrUser = usrUserDao.findByUsername(username);
        return JwtUserDetails.create(usrUser);
    }
}

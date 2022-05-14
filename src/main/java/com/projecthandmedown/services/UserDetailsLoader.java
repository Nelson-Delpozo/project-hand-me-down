package com.projecthandmedown.services;
import com.projecthandmedown.models.User;
import com.projecthandmedown.models.UserWithRoles;
import com.projecthandmedown.repositories.RoleRepository;
import com.projecthandmedown.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customUserDetailService")
public class UserDetailsLoader implements UserDetailsService {
    private final UserRepository users;
    private final RoleRepository roles;

    public UserDetailsLoader(UserRepository users, RoleRepository roles) {
        this.users = users;
        this.roles = roles;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }
        System.out.println(roles.ofUserWith(username));
        return new UserWithRoles(user, roles.ofUserWith(username));
    }
}


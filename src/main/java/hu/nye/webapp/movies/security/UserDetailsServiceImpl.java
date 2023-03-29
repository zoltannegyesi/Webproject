package hu.nye.webapp.movies.security;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        findUser(username);
        return new User("test", "password", Collections.emptyList());
    }

    private void findUser(String username) {
        if (!"test".equals(username)) {
            throw new RuntimeException("User not found");
        }
    }

}

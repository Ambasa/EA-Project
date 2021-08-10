package ars.cs.miu.edu.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MyUserDetailsService implements UserDetailsService {
    Collection<GrantedAuthority> roles = new ArrayList<>();
    public static Map<String, User> userActionList;
    static {
        userActionList = new HashMap<>();
        SimpleGrantedAuthority passengerAuthority = new SimpleGrantedAuthority("ROLE_PASSENGER");
        SimpleGrantedAuthority agentAuthority = new SimpleGrantedAuthority("ROLE_AGENT");
        SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
        List<SimpleGrantedAuthority> passengerAuthorities = new ArrayList<SimpleGrantedAuthority>();
        List<SimpleGrantedAuthority> agentAuthorities = new ArrayList<SimpleGrantedAuthority>();
        List<SimpleGrantedAuthority> adminAuthorities = new ArrayList<SimpleGrantedAuthority>();
        passengerAuthorities.add(passengerAuthority);
        agentAuthorities.add(agentAuthority);
        agentAuthorities.add(passengerAuthority);
        adminAuthorities.add(adminAuthority);
        userActionList.put("hira", new User("hira", "12345",adminAuthorities));
        userActionList.put("john", new User("john", "12345",passengerAuthorities));
        userActionList.put("frank", new User("frank", "12345",agentAuthorities));
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if(userActionList.containsKey(s)){
            return userActionList.get(s);
        }
        else {
            return new User("user", "secret",
                    new ArrayList<>());
        }
    }
}
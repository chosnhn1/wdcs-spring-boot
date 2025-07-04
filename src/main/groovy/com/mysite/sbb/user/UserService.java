package com.mysite.sbb.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String username, String email, String password) {
        SiteUser user = new SiteUser();
        user.setUsername(username);
        user.setEmail(email);

//      encrypt password
//      the code below do encode with new encoder from the package; which is not good for sake of reusable programming
//      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//      what's more appropriate is: do encoder setting in SecurityConfig and load it like this:
        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);
        return user;
    }
}

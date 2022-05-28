package digifarmfoodservice.services;

import digifarmfoodservice.entities.User;
import digifarmfoodservice.exception.ConstraintsViolationException;
import digifarmfoodservice.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * The type User user details service.
 */
@Slf4j
@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService
{

    private final UserRepository userRepository;

    private static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    /**
     * Instantiates a new User user details service.
     *
     * @param userRepository the User repository
     */
    public UserDetailsServiceImpl(final UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }


    public User getCurrentUser()
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(userDetails.getUsername()).orElseThrow(() -> new IllegalStateException("Could not retrieve user info"));
    }

    public User create(String username, String password) throws ConstraintsViolationException
    {
        String encodedPassword = PASSWORD_ENCODER.encode(password);
        User user = new User(null, username, encodedPassword, null, null);
        try
        {
            user = userRepository.save(user);
        }
        catch (DataIntegrityViolationException e)
        {
            log.warn("ConstraintsViolationException while creating the user: {}", user, e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return user;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {

        Optional<User> User = userRepository.findByUsername(username);
        if (!User.isPresent())
        {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(User.get().getUsername(), User.get().getPassword(),
            new ArrayList<>());
    }
}


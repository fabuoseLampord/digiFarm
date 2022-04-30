package digifarmfoodservice.services;

import digifarmfoodservice.entities.User;
import digifarmfoodservice.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * The type User user details service.
 */
@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService
{

    private final UserRepository userRepository;


    /**
     * Instantiates a new User user details service.
     *
     * @param userRepository the User repository
     */
    public UserDetailsServiceImpl(final UserRepository userRepository)
    {
        this.userRepository = userRepository;
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


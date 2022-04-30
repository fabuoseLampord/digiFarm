package digifarmfoodservice.services;

import digifarmfoodservice.entities.User;
import digifarmfoodservice.repositories.UserRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
    @Autowired
    UserRepository userRepository;


    public User getCurrentUser()
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(userDetails.getUsername()).orElseThrow(() -> new IllegalStateException("Could not retrieve user info"));
    }
}

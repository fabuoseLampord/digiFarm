package digifarmfoodservice.web;

import digifarmfoodservice.entities.User;
import digifarmfoodservice.exception.ConstraintsViolationException;
import digifarmfoodservice.exception.UnauthorizedException;
import digifarmfoodservice.services.UserDetailsServiceImpl;
import digifarmfoodservice.util.JwtTokenUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exposes the login API
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController
{

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final UserDetailsServiceImpl userDetailsService;


    /**
     * Instantiates a new Authentication controller.
     *
     * @param authenticationManager the authentication manager
     * @param jwtTokenUtil          the jwt token util
     * @param userDetailsService    the user details service
     */
    public AuthenticationController(
        final AuthenticationManager authenticationManager,
        final JwtTokenUtil jwtTokenUtil,
        final UserDetailsServiceImpl userDetailsService)
    {

        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }


    /**
     * Login response entity.
     *
     * @param username the username
     * @param password the password
     * @return the response entity
     * @throws UnauthorizedException the unauthorized exception
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) throws UnauthorizedException
    {

        authenticate(username, password);

        final UserDetails userDetails = userDetailsService
            .loadUserByUsername(username);

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok("Bearer " + token);
    }


    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestParam String username, @RequestParam String password) throws ConstraintsViolationException
    {

        User user = userDetailsService.create(username, password);

        return ResponseEntity.ok(user);
    }


    private void authenticate(String username, String password) throws UnauthorizedException
    {
        try
        {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch (Exception e)
        {
            throw new UnauthorizedException("Login failed for username: " + username);
        }

    }
}
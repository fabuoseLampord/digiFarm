package digifarmfoodservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Unauthorized exception.
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Login failed")
public class UnauthorizedException extends Exception
{

    /**
     * The Serial version uid.
     */
    static final long serialVersionUID = 7658858110410357891L;


    /**
     * Instantiates a new Unauthorized exception.
     *
     * @param message the message
     */
    public UnauthorizedException(String message)
    {
        super(message);
    }

}

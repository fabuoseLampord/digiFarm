package digifarmfoodservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Bad request exception.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Bad request")
public class BadRequestException extends Exception
{

    /**
     * The Serial version uid.
     */
    static final long serialVersionUID = -5002881708189603032L;


    /**
     * Instantiates a new Bad request exception.
     *
     * @param message the message
     */
    public BadRequestException(String message)
    {
        super(message);
    }

}

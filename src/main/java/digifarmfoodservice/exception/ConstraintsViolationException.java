package digifarmfoodservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Constraints violation exception.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Some constraints are violated ...")
public class ConstraintsViolationException extends Exception
{

    /**
     * The Serial version uid.
     */
    static final long serialVersionUID = -5108535771244147431L;


    /**
     * Instantiates a new Constraints violation exception.
     *
     * @param message the message
     */
    public ConstraintsViolationException(String message)
    {
        super(message);
    }

}

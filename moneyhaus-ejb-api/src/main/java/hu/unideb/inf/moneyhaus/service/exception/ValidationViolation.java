
package hu.unideb.inf.moneyhaus.service.exception;

/**
 * An object to contain validation failure messages.
 *
 * @author Nolbelt
 */
public class ValidationViolation {

    /**
     * The context the validation rule failed in.
     */
    private String context;
    /**
     * The failure message.
     */
    private String message;

    /**
     * Constructor
     *
     * @param context the context a validation rule failed in.
     * @param message the message of the failed validation rule
     */
    public ValidationViolation(String context, String message) {
        this.context = context;
        this.message = message;
    }

    /**
     * Returns the context of the failed validation rule.
     *
     * @return the context of the failed validation rule
     */
    public String getContext() {
        return context;
    }

    /**
     * Sets the context of the failed validation rule.
     *
     * @param context the context of the failed validation rule
     */
    public void setContext(String context) {
        this.context = context;
    }

    /**
     * Returns the message of the failed validation rule.
     *
     * @return the message of the failed validation rule
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message of the failed validation rule.
     *
     * @param message the message of the failed validation rule
     */
    public void setMessage(String message) {
        this.message = message;
    }

}

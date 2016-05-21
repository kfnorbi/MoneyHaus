
package hu.unideb.inf.moneyhaus.validation;

import java.util.Objects;

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
     * Constructor.
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

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.context);
        hash = 11 * hash + Objects.hashCode(this.message);
        return hash;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        System.out.println("nothing");
        if (this == obj) {
            System.out.println("reference");
            return true;
        }
        if (obj == null) {
            System.out.println("null");
            return false;
        }
        if (getClass() != obj.getClass()) {
            System.out.println("class");
            return false;
        }
        final ValidationViolation other = (ValidationViolation) obj;
        if (!this.context.equals(other.context)) {
            System.out.println("context");
            return false;
        }
        if (!this.message.equals(other.message)) {
            System.out.println("message");
            return false;
        }
        return true;
    }

}

package notification;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Class implements the notification object for the users
 */
public class Notification {
    private String movieName;
    private String message;


    /**
     * Constructor
     * @param movieName
     * @param message
     */
    public Notification(final String movieName, final String message) {
        this.movieName = movieName;
        this.message = message;
    }

    /**
     * Default constructor
     */
    public Notification() {
        this.movieName = null;
        this.message = null;
    }

    /**
     * Getter for movieName
     * @return the movieName
     */
    public String getMovieName() {
        return movieName;
    }

    /**
     * Set the movie name
     * @param movieName the movieName to set
     */
    public void setMovieName(final String movieName) {
        this.movieName = movieName;
    }

    /**
     * Getter for the message
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter for the message
     * @param message the message to set
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     * Method returns the notification object as a json object node
     * @return the object node
     */
    public ObjectNode getJson(){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("movieName", movieName);
        node.put("message", message);
        return node;
    }
}

package input;


/**
 * Class defines the input object for each desired
 * action
 */
public class ActionsInput {

    private String type;
    private String page;
    private String feature;
    private Credentials credentials;
    private String startsWith;
    private FiltersInput filters;
    private String movie;
    private String count;
    private int rate;

    /**
     * Constructor with parameters
     * @param type action type
     * @param page targeted page
     * @param feature targeted feature
     * @param credentials credentials
     * @param startsWith string to match
     * @param filters targeted filters
     * @param movie targeted movie
     * @param count ammout of tokens/balance
     * @param rate rate of the movie
     */
    public ActionsInput(final String type, final String page, final String feature,
                        final Credentials credentials, final String startsWith,
                        final FiltersInput filters, final String movie, final String count,
                        final int rate) {
        this.type = type;
        this.page = page;
        this.feature = feature;
        this.credentials = credentials;
        this.startsWith = startsWith;
        this.filters = filters;
        this.movie = movie;
        this.count = count;
        this.rate = rate;
    }

    /**
     * Default constructor
     */
    public ActionsInput() {
        this.type = "";
        this.page = "";
        this.feature = "";
        this.credentials = new Credentials();
        this.startsWith = "";
        filters = new FiltersInput();
        this.movie = "";
        this.count = "";
        this.rate = 0;
    }

    /**
     * Getter for the type of action
     * @return string type of action
     */
    public String getType() {
        return type;
    }

    /**
     * Getter for the current page
     * @return string current page
     */
    public String getPage() {
        return page;
    }

    /**
     * Getter for the feature
     * @return string feature
     */
    public String getFeature() {
        return feature;
    }

    /**
     * Getter for the credentials
     * @return credentials object
     */
    public Credentials getCredentials() {
        return credentials;
    }

    /**
     * Getter for the string to match
     * @return string to match
     */
    public String getStartsWith() {
        return startsWith;
    }

    /**
     * Getter for the filters
     * @return FiltersInput object
     */
    public FiltersInput getFilters() {
        return filters;
    }

    /**
     * Getter for the movie
     * @return string movie name
     */
    public String getMovie() {
        return movie;
    }

    /**
     * Getter for the count
     * @return string count
     */
    public String getCount() {
        return count;
    }

    /**
     * Getter for the rate
     * @return int rate
     */
    public int getRate() {
        return rate;
    }

    /**
     * Setter for the type
     * @param type string type
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * Setter for the page
     * @param page string page
     */
    public void setPage(final String page) {
        this.page = page;
    }

    /**
     * Setter for the feature
     * @param feature string feature
     */
    public void setFeature(final String feature) {
        this.feature = feature;
    }

    /**
     * Setter for the credentials
     * @param credentials Credentials object
     */
    public void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
    }

    /**
     * Setter for the string to match
     * @param startsWith string to match
     */
    public void setStartsWith(final String startsWith) {
        this.startsWith = startsWith;
    }

    /**
     * Setter for the filters
     * @param filters FiltersInput object
     */
    public void setFilters(final FiltersInput filters) {
        this.filters = filters;
    }

    /**
     * Setter for the movie name
     * @param movie string movie name
     */
    public void setMovie(final String movie) {
        this.movie = movie;
    }

    /**
     * Setter for the count
     * @param count string count
     */
    public void setCount(final String count) {
        this.count = count;
    }

    /**
     * Setter for the rate
     * @param rate int rate
     */
    public void setRate(final int rate) {
        this.rate = rate;
    }
}

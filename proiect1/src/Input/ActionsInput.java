package Input;

public class ActionsInput {
    private String type;
    private String page;
    private String feature;
    private Credentials credentials;
    private String startsWith;

    private FiltersInput filters;

    public ActionsInput(String type, String page, String feature,
                        Credentials credentials, String startsWith,
                        FiltersInput filters) {
        this.type = type;
        this.page = page;
        this.feature = feature;
        this.credentials = credentials;
        this.startsWith = startsWith;
        this.filters = filters;
    }

    public ActionsInput() {
        this.type = "";
        this.page = "";
        this.feature = "";
        this.credentials = new Credentials();
        this.startsWith = "";
        filters = new FiltersInput();
    }

    public String getType() {
        return type;
    }

    public String getPage() {
        return page;
    }

    public String getFeature() {
        return feature;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public String getStartsWith() {
        return startsWith;
    }

    public FiltersInput getFilters() {
        return filters;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public void setStartsWith(String startsWith) {
        this.startsWith = startsWith;
    }

    public void setFilters(FiltersInput filters) {
        this.filters = filters;
    }


}

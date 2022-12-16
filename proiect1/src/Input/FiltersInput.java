package Input;

public class FiltersInput {

    private SortInput sort;

    public FiltersInput() {
        this.sort = new SortInput();
    }

    public FiltersInput(SortInput sort) {
        this.sort = sort;
    }

    public SortInput getSort() {
        return sort;
    }

    public void setSort(SortInput sort) {
        this.sort = sort;
    }
}

package springframework_core_technology.study.part12_databindingAbstract;

public class DataBindingEvent {
    private Integer id;
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DataBindingEvent(Integer id) {
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return "DataBindingEvent{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}

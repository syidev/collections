package fm.austria.model.announcer;

public abstract class Announcer {
    protected String name;

    public Announcer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

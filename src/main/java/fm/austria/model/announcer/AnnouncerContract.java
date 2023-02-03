package fm.austria.model.announcer;

public class AnnouncerContract extends Announcer {
    private String resume;

    public AnnouncerContract(String name, String resume) {
        super(name);
        this.resume = resume;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}

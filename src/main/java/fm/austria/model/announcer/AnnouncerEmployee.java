package fm.austria.model.announcer;

import fm.austria.builder.Builder;
import fm.austria.model.program.Ad;
import fm.austria.model.program.Interview;
import fm.austria.model.program.Program;
import fm.austria.model.program.Song;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AnnouncerEmployee extends Announcer {
    private int workExperience;

    public AnnouncerEmployee(String name) {
        super(name);
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public void createFamousPersonInterview(Builder builder) {
        builder.setAnnouncer(this);
        builder.setMaxLengthMinute(10);

        Program interview = new Interview(4, "Sting");
        Program ad = new Ad(1, "Glastonbury Festival of Contemporary Performing Arts");
        Program song = new Song(5, "Shape of my heart", "Sting");

        Queue<Program> playList = new LinkedList<>(List.of(interview, ad, song));

        builder.setPlaylist(playList);
    }
}

package fm.austria.builder;

import fm.austria.model.announcer.Announcer;
import fm.austria.model.program.Program;

import java.util.Queue;

public interface Builder {
    void setMaxLengthMinute(double maxLengthMinute);
    void setPlaylist(Queue<Program> playList);
    void setAnnouncer(Announcer announcer);
}

package fm.austria.builder;

import fm.austria.model.announcer.Announcer;
import fm.austria.model.broadcast.Broadcast;
import fm.austria.model.program.Program;

import java.util.Queue;

public class BroadcastBuilder implements Builder {
    private double maxLengthMinute;
    private Queue<Program> playList;
    private Announcer announcer;

    @Override
    public void setMaxLengthMinute(double maxLengthMinute) {
        this.maxLengthMinute = maxLengthMinute;
    }

    @Override
    public void setPlaylist(Queue<Program> playList) {
        this.playList = playList;
    }

    @Override
    public void setAnnouncer(Announcer announcer) {
        this.announcer = announcer;
    }

    public Broadcast getResult() throws Exception {
        return new Broadcast(maxLengthMinute, announcer, playList);
    }
}

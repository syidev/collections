package fm.austria.visitor;

import fm.austria.model.program.*;

import java.util.Queue;

public class LengthVisitor implements Visitor {
    public double export(Queue<Program> playList) {
        double length = 0.0;

        for (Program program: playList) {
            length += program.acceptDouble(this);
        }

        return length;
    }

    public double exportCommercial(Queue<Program> playList) {
        double length = 0.0;

        for (Program program: playList) {
            if (program instanceof Commercializable) {
                length += program.acceptDouble(this);
            }
        }

        return length;
    }

    public double visitSong(Song song) {
        return getLength(song);
    }

    public double visitInterview(Interview interview) {
        return getLength(interview);
    }

    public double visitAd(Ad ad) {
        return getLength(ad);
    }

    private double getLength(Program program) {
        return program.getLength();
    }
}

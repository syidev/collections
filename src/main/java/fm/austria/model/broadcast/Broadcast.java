package fm.austria.model.broadcast;

import fm.austria.model.announcer.Announcer;
import fm.austria.model.program.Commercializable;
import fm.austria.model.program.Program;
import fm.austria.model.radiostation.Radiostation;
import fm.austria.visitor.LengthVisitor;
import fm.austria.visitor.ProfitVisitor;

import java.util.Currency;
import java.util.LinkedList;
import java.util.Queue;
public class Broadcast {
    private static final int PERCENT_OF_COMMERCIAL = 50;
    private double lengthMinute;
    private Queue<Program> playList = new LinkedList<>();
    private Announcer announcer;

    public Broadcast(double maxLengthMinute, Announcer announcer, Queue<Program> playList) throws Exception {
        this.lengthMinute = maxLengthMinute;
        this.announcer = announcer;

        if (playList.isEmpty()) {
            throw new Exception("Playlist is empty");
        }

        for (Program program : playList) {
            addProgram(program);
        }
    }

    public double getLength() { return lengthMinute; }

    public void setLengthMinute(double lengthMinute) {
        this.lengthMinute = lengthMinute;
    }

    public Queue<Program> getPlayList() {
        return playList;
    }

    public void setPlayList(Queue<Program> playList) {
        this.playList = playList;
    }

    public Announcer getAnnouncer() {
        return announcer;
    }

    public void setAnnouncer(Announcer announcer) {
        this.announcer = announcer;
    }

    public void addProgram(Program program) throws Exception {
        try {
            checkCommercial(program);
            checkAvailableTime(program);
            this.playList.add(program);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public double getProfit() {
        ProfitVisitor visitor = new ProfitVisitor();

        return visitor.export(playList);
    }

    public double getPlayListLength() {
        LengthVisitor visitor = new LengthVisitor();

        return visitor.export(playList);
    }

    public void printProfit() {
        System.out.printf("Profit: %.2f %s", getProfit(),  Currency.getInstance(Radiostation.CURRENCY).getSymbol());
    }

    public String getDescription() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Length: ").append(getLength()).append(" min").append("\n");
        sb.append("Announcer: ").append(getAnnouncer().getName()).append("\n");
        sb.append("Playlist:").append("\n");

        for (Program program : playList) {
            sb.append(program.getDescription()).append("\n");
        }

        return sb.toString();
    }

    private double getCommercialLength() {
        LengthVisitor visitor = new LengthVisitor();

        return visitor.exportCommercial(playList);
    }

    private void checkCommercial(Program program) throws Exception {
        if (program instanceof Commercializable) {
            if (program.getLength() + getCommercialLength() > ((getLength() / 100) * PERCENT_OF_COMMERCIAL)) {
                throw new Exception("Too much commercial");
            }
        }
    }

    private void checkAvailableTime(Program program) throws Exception {
        if (program.getLength() > getLength() - getPlayListLength()) {
            throw new Exception("Not enough time for the program");
        }
    }
}

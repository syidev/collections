package fm.austria.visitor;

import fm.austria.model.program.*;

import java.util.Queue;

public class ProfitVisitor implements Visitor {
    public double export(Queue<Program> queue) {
        double profit = 0.0;

        for (Program program: queue) {
            profit += program.acceptDouble(this);
        }

        return profit;
    }

    public double visitSong(Song song) {
        return getProfit(song);
    }

    public double visitInterview(Interview interview) {
        return getProfit(interview);
    }

    public double visitAd(Ad ad) {
        return getProfit(ad);
    }

    private double getProfit(Program program) {
        if (program instanceof Commercializable) {
            return ((Commercializable) program).getProfit();
        }

        return 0.0;
    }
}

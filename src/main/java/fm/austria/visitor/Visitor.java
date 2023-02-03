package fm.austria.visitor;

import fm.austria.model.program.Ad;
import fm.austria.model.program.Interview;
import fm.austria.model.program.Song;

public interface Visitor {
    double visitSong(Song song);

    double visitInterview(Interview interview);

    double visitAd(Ad ad);
}

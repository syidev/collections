package fm.austria.model.program;

import fm.austria.visitor.Visitor;

public class Song extends Program {
    private String songName;
    private String singer;

    public Song(int lengthMinute, String songName, String singer) {
        super(lengthMinute);

        this.songName = songName;
        this.singer = singer;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public double acceptDouble(Visitor visitor) {
        return visitor.visitSong(this);
    }

    @Override
    public String getDescription() {
        return "Song{" +
                "songName='" + getSongName() + '\'' +
                ", singer='" + getSinger() + '\'' +
                ", lengthMinute=" + getLength() +
                '}';
    }
}

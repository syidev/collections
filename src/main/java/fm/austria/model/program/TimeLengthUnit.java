package fm.austria.model.program;

public enum TimeLengthUnit {
    SECOND(1),
    MINUTE(60);

    private final int seconds;
    TimeLengthUnit(int seconds) {
        this.seconds = seconds;
    }
    public int getSeconds() {
        return seconds;
    }
}

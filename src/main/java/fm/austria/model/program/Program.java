package fm.austria.model.program;

import fm.austria.visitor.Visitor;

public abstract class Program {
    protected double lengthMinute;

    public Program(double lengthMinute) {
        this.lengthMinute = lengthMinute;
    }
    public double getLength() {
        return lengthMinute;
    }

    public abstract String getDescription();

    public abstract double acceptDouble(Visitor visitor);
}

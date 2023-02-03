package fm.austria.model.program;

import fm.austria.visitor.Visitor;

public class Interview extends Program implements Commercializable {
    private String intervieweeName;
    private static final double PRICE_PER_COMMERCIAL_TIMEUNIT = 30.0;
    private static final TimeLengthUnit COMMERCIAL_TIMEUNIT = TimeLengthUnit.MINUTE;

    public Interview(int lengthMinute, String intervieweeName) {
        super(lengthMinute);

        this.intervieweeName = intervieweeName;
    }

    public String getIntervieweeName() {
        return intervieweeName;
    }

    public void setIntervieweeName(String intervieweeName) {
        this.intervieweeName = intervieweeName;
    }
    public double getProfit() {
        return ((getLength() * 60) / COMMERCIAL_TIMEUNIT.getSeconds()) * PRICE_PER_COMMERCIAL_TIMEUNIT;
    }

    @Override
    public double acceptDouble(Visitor visitor) {
        return visitor.visitInterview(this);
    }

    @Override
    public String getDescription() {
        return "Interview{" +
                "intervieweeName='" + getIntervieweeName() + '\'' +
                ", lengthMinute=" + getLength() +
                '}';
    }
}

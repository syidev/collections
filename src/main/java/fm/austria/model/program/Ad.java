package fm.austria.model.program;

import fm.austria.visitor.Visitor;

public class Ad extends Program implements Commercializable {
    private String productName;
    private static final double PRICE_PER_COMMERCIAL_TIMEUNIT = 5.0;
    private static final TimeLengthUnit COMMERCIAL_TIMEUNIT = TimeLengthUnit.SECOND;

    public Ad(double lengthMinute, String productName) {
        super(lengthMinute);

        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProfit() {
        return ((getLength() * 60) / COMMERCIAL_TIMEUNIT.getSeconds()) * PRICE_PER_COMMERCIAL_TIMEUNIT;
    }

    @Override
    public double acceptDouble(Visitor visitor) {
        return visitor.visitAd(this);
    }

    @Override
    public String getDescription() {
        return "Ad{" +
                "productName='" + getProductName() + '\'' +
                ", lengthMinute=" + getLength() +
                '}';
    }
}

public class Television extends Electrodomestic{
    final private double RESOLUTION_DEFAULT = 20;
    final private boolean SINTONIZATOR_DEFAULT = false;
    private double resolution;
    private boolean sintonizatorTDT;

    public  Television() {
        super();
        setResolution(getResolutionDefault());
        setSintonizatorTDT(getSintonizatorDefault());
    }

    public Television(double priceBase, double weight) {
        super(priceBase, weight);
        setResolution(getResolutionDefault());
        setSintonizatorTDT(getSintonizatorDefault());
    }

    public Television(double priceBase, double weight, String color, char electricityConsumption, double resolution, boolean sintonizatorTDT) {
        super(priceBase, weight, color, electricityConsumption);
        setSintonizatorTDT(sintonizatorTDT);
        setResolution(resolution);
    }

    public double getResolutionDefault() {
        return RESOLUTION_DEFAULT;
    }

    public boolean getSintonizatorDefault() {
        return SINTONIZATOR_DEFAULT;
    }

    public double getResolution() {
        return resolution;
    }

    public void setResolution(double resolution) {
        this.resolution = resolution;
    }

    public boolean getSintonizatorTDT() {
        return sintonizatorTDT;
    }

    public void setSintonizatorTDT(boolean sintonizatorTDT) {
        this.sintonizatorTDT = sintonizatorTDT;
    }

    public double priceFinal() {
        double varPriceFinal = super.priceFinal();
        if (getResolution() > 40) {
            varPriceFinal += (varPriceFinal * 0.30);
        }
        if (getSintonizatorTDT()) {
            varPriceFinal += 50;
        }
        return varPriceFinal;
    }
}

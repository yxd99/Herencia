public class WashingMachine extends Electrodomestic{
    final private double LOAD_DEFAULT = 50;
    private double load;

    public  WashingMachine() {
        super();
        setLoad(getLoadDefault());
    }

    public WashingMachine(double priceBase, double weight) {
        super(priceBase, weight);
        setLoad(getLoadDefault());
    }

    public WashingMachine(double priceBase, double weight, String color, char electricityConsumption, double load) {
        super(priceBase, weight, color, electricityConsumption);
        setLoad(load);
        System.out.println(priceBase +" - "+ weight +" - "+ electricityConsumption +" - "+ load);
    }

    public double getLoadDefault() {
        return LOAD_DEFAULT;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    public double priceFinal() {
        double superPriceFinal = super.priceFinal();
        double load = getLoad();
        return load > 30 ? (superPriceFinal + 50) : superPriceFinal;
    }
}

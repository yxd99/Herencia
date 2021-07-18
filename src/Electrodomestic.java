import helpers.Converters;
import helpers.Dialogs;
import java.util.Arrays;
import java.util.HashMap;

public class Electrodomestic {
    private String[] avaibleColours = {"blanco", "negro", "rojo", "azul", "gris"};
    private int[] lettersElectricityConsumption = {65, 66, 67, 68, 69, 70};
    private HashMap<Character, Integer> priceElectricityConsumption = new HashMap<>();

    private double priceBase;
    private String color;
    private char electricityConsumption;
    private double weight;

    final private double PRICE_BASE_DEFAULT = 100;
    final private String COLOR_DEFAULT = avaibleColours[0];
    final private char ELECTRICITY_CONSUMPTION_DEFAULT = 'F';
    final private double WEIGHT_DEFAULT = 5;

    public  Electrodomestic() {
        loadValuesElectricityConsumption();
        this.setColor(this.getColorDefault());
        this.setElectricityConsumption(this.getElectricityConsumptionDefault());
        this.setPriceBase(this.getPriceBaseDefault());
        this.setWeight(this.getWeightDefault());
    }

    public Electrodomestic(double priceBase, double weight) {
        loadValuesElectricityConsumption();
        this.setColor(this.getColorDefault());
        this.setElectricityConsumption(this.getElectricityConsumptionDefault());
        this.setPriceBase(priceBase);
        this.setWeight(weight);
    }

    public Electrodomestic(double priceBase, double weight, String color, char electricityConsumption) {
        loadValuesElectricityConsumption();
        this.setColor(color);
        this.setElectricityConsumption(electricityConsumption);
        this.setPriceBase(priceBase);
        this.setWeight(weight);
    }

    private void loadValuesElectricityConsumption() {
        priceElectricityConsumption.put('A', 100);
        priceElectricityConsumption.put('B', 80);
        priceElectricityConsumption.put('C', 60);
        priceElectricityConsumption.put('D', 50);
        priceElectricityConsumption.put('E', 30);
        priceElectricityConsumption.put('F', 10);
    }

    public int getValueElectricityConsumption(int position) {
        return lettersElectricityConsumption[position];
    }

    public String[] getValuesElectricityConsumption() {
        String[] data = new String[priceElectricityConsumption.size()];
        for (int i = 0; i < data.length; i++) {
            char letter = Converters.toChar(lettersElectricityConsumption[i]);
            data[i] =  letter + " - " + checkElectricityConsumption(letter) + "€";
        }
        return data;
    }

    public String[] getAvaibleColours() {
        return avaibleColours;
    }

    public double getPriceBase(){
        return priceBase;
    }

    public void setPriceBase(double priceBase) {
        this.priceBase = priceBase;
    }

    public String getColor() {
        return color;
    }

    public String getColorOption(int option) {
        return avaibleColours[option];
    }

    public boolean setColor(String color) {
        if (!contains(getAvaibleColours(), color)) {
            Dialogs.showMessage("El color no está en la lista de colores disponibles\n" +
                    "Por lo tanto se guardara con el color por defecto (" + this.getColorDefault() + ")");
            this.color = this.getColorDefault();
            return false;
        }
        this.color = color;
        return true;
    }

    public char getElectricityConsumption() {
        return electricityConsumption;
    }

    public boolean setElectricityConsumption(char electricityConsumption) {
        if (!priceElectricityConsumption.containsKey(electricityConsumption)) {
            Dialogs.showMessage("El tipo de consumo de electricidad no está en nuestra lista" +
                    "Se guardara el valor por defecto (" + getElectricityConsumptionDefault() + ")");
            this.electricityConsumption = getElectricityConsumptionDefault();
            return false;
        }
        this.electricityConsumption = electricityConsumption;
        return true;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPriceBaseDefault() {
        return PRICE_BASE_DEFAULT;
    }

    public String getColorDefault() {
        return COLOR_DEFAULT;
    }

    public char getElectricityConsumptionDefault() {
        return ELECTRICITY_CONSUMPTION_DEFAULT;
    }

    public double getWeightDefault() {
        return WEIGHT_DEFAULT;
    }

    private boolean contains(String[] array, String value) {
        return Arrays.asList(array).contains(value);
    }

    private int checkElectricityConsumption(char value) {
        return priceElectricityConsumption.get(value);
    }

    public double priceFinal() {
        double varPriceFinal = getPriceBase()+checkElectricityConsumption(getElectricityConsumption());
        double weight = getWeight();
        if (weight > 80) {
            varPriceFinal += 100;
        } else if (weight > 50) {
            varPriceFinal += 80;
        } else if (weight > 20) {
            varPriceFinal += 50;
        } else {
            varPriceFinal += 10;
        }
        return varPriceFinal;
    }
}

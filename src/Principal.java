import helpers.Converters;
import helpers.Dialogs;

public class Principal {
    public static void main(String[] args) {
        Electrodomestic[] electrodomestics = new Electrodomestic[10];
        final String[] typesElectrodomestics = {"Televisión", "Lavadora"};
        final String[] modeElectrodomestic = {"Sencilla", "Normal", "Compleja"};
        double priceTvs = 0, priceWashingMachines = 0, priceElectrodomestics = 0;
        int selectTypeElectrodomestic, selectModeElectrodomestic;
        for (int i = 0; i < electrodomestics.length; i++) {
            selectTypeElectrodomestic = Dialogs.readOptions("Tipo de electrodomestico",
                    "[Electrodomestico #" + (i+1) + "] " +
                            "Seleccione el tipo de electrodomestico a crear ",
                    typesElectrodomestics);
            selectModeElectrodomestic = Dialogs.readOptions("Tipo de creación",
                    "Seleccione el tipo de creación",
                    modeElectrodomestic);
            switch (selectTypeElectrodomestic) {
                case 0 -> {
                    electrodomestics[i] = createTV(selectModeElectrodomestic);
                }
                case 1 -> {
                    electrodomestics[i] = createWashingMachine(selectModeElectrodomestic);
                }
            }
        }

        for (int i = 0; i < electrodomestics.length; i++) {
            if (electrodomestics[i] instanceof WashingMachine) {
                priceWashingMachines += electrodomestics[i].priceFinal();
            } else if (electrodomestics[i] instanceof Television) {
                priceTvs += electrodomestics[i].priceFinal();
            }
        }

        Dialogs.showMessage("Precio final de:\n" +
                "Lavadoras: " + priceWashingMachines + " €\n" +
                "Televisores: " + priceTvs + " €");
    }

    public static Electrodomestic createTV(int option) {
        switch (option) {
            case 1 -> {
                double priceBase = Dialogs.readDouble("Cuál es el precio base");
                double weight = Dialogs.readDouble("Cuál es el peso");
                return new Television(priceBase, weight);
            }

            case 2 -> {
                Electrodomestic electrodomestic = new Electrodomestic();
                String[] optSintonizator = {"No", "Si"};
                double priceBase = Dialogs.readDouble("Cuál es el precio base");
                double weight = Dialogs.readDouble("Cuál es el peso");
                int selectColor = Dialogs.readOptions("Colores",
                        "Seleccione un color para el producto",
                    electrodomestic.getAvaibleColours());
                int selectElectricityConsumption = Dialogs.readOptions("Consumo de energia",
                        "Seleccione un tipo de consumo de energia",
                        electrodomestic.getValuesElectricityConsumption());
                double resolution = Dialogs.readDouble("Ingrese la resolución en pulgadas.");
                int sintonizatorTDT = Dialogs.readOptions("Sintonizador TDT",
                        "Tiene sintonizador TDT?",
                        optSintonizator);
                return new Television(priceBase,
                        weight,
                        electrodomestic.getColorOption(selectColor),
                        Converters.toChar(electrodomestic.getValueElectricityConsumption(selectElectricityConsumption)),
                        resolution,
                        sintonizatorTDT > 0);
            }

            default -> {
                return new Television();
            }
        }
    }

    public static Electrodomestic createWashingMachine(int option) {
        switch (option) {
            case 1 -> {
                double priceBase = Dialogs.readDouble("Cuál es el precio base");
                double weight = Dialogs.readDouble("Cuál es el peso");
                return new WashingMachine(priceBase, weight);
            }

            case 2 -> {
                Electrodomestic electrodomestic = new Electrodomestic();
                String[] optSintonizator = {"No", "Si"};
                double priceBase = Dialogs.readDouble("Cuál es el precio base");
                double weight = Dialogs.readDouble("Cuál es el peso");
                int selectColor = Dialogs.readOptions("Colores",
                        "Seleccione un color para el producto",
                        electrodomestic.getAvaibleColours());
                int selectElectricityConsumption = Dialogs.readOptions("Consumo de energia",
                        "Seleccione un ",
                        electrodomestic.getValuesElectricityConsumption());
                double load = Dialogs.readDouble("Ingrese la carga en kg");
                return new WashingMachine(priceBase,
                        weight,
                        electrodomestic.getColorOption(selectColor),
                        Converters.toChar(electrodomestic.getValueElectricityConsumption(selectElectricityConsumption)),
                        load);
            }

            default -> {
                return new WashingMachine();
            }
        }
    }
}

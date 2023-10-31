package study;
import javax.xml.bind.SchemaOutputResolver;
import java.util.HashMap;
import java.util.Map;

class Car {
    private String engineType;
    private double engineSize;
    private boolean hasABS;
    private boolean hasESP;
    private int airbags;
    private boolean hasComputer;
    private boolean hasAC;
    private String interior;
    private double price;

    public Car(String engineType, double engineSize, boolean hasABS, boolean hasESP,
               int airbags, boolean hasComputer, boolean hasAC,
               String interior, double price) {
        this.engineType = engineType;
        this.engineSize = engineSize;
        this.hasABS = hasABS;
        this.hasESP = hasESP;
        this.airbags = airbags;
        this.hasComputer = hasComputer;
        this.hasAC = hasAC;
        this.interior = interior;
        this.price = price;
    }


    public String getEngineType() {
        return engineType;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public boolean hasABS() {
        return hasABS;
    }

    public boolean hasESP() {
        return hasESP;
    }

    public int getAirbags() {
        return airbags;
    }

    public boolean hasComputer() {
        return hasComputer;
    }

    public boolean hasAC() {
        return hasAC;
    }

    public String getInterior() {
        return interior;
    }

    public double getPrice() {
        return price;
    }

}

class CarBuilder {
    private String engineType;
    private double engineSize;
    private boolean hasABS;
    private boolean hasESP;
    private int airbags;
    private boolean hasComputer;
    private boolean hasAC;
    private String interior;
    private double price;

    public CarBuilder setEngineType(String engineType) {
        this.engineType = engineType;
        return this;
    }

    public CarBuilder setEngineSize(double engineSize) {
        this.engineSize = engineSize;
        return this;
    }

    public CarBuilder setHasABS(boolean hasABS) {
        this.hasABS = hasABS;
        return this;
    }

    public CarBuilder setHasESP(boolean hasESP) {
        this.hasESP = hasESP;
        return this;
    }

    public CarBuilder setAirbags(int airbags) {
        this.airbags = airbags;
        return this;
    }

    public CarBuilder setHasComputer(boolean hasComputer) {
        this.hasComputer = hasComputer;
        return this;
    }

    public CarBuilder setHasAC(boolean hasAC) {
        this.hasAC = hasAC;
        return this;
    }

    public CarBuilder setInterior(String interior) {
        this.interior = interior;
        return this;
    }
    public CarBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public Car build() {
        return new Car(engineType, engineSize, hasABS, hasESP,
                airbags, hasComputer, hasAC, interior, price);
    }
}

class CarShowroom {
    private Map<String, Car> cars = new HashMap<>();

    public void addCar(String configurationName, Car car) {
        cars.put(configurationName, car);
    }

    public Car getCar(String configurationName) {
        return cars.get(configurationName);
    }
}

public class Main {
    public static void main(String[] args) {
        CarBuilder builder = new CarBuilder();

        // Створюємо різні комплектації автомобілів та додаємо їх до салону
        CarShowroom showroom = new CarShowroom();
        showroom.addCar("Стандарт", builder
                .setEngineType("Бензиновий")
                .setEngineSize(2.0)
                .setHasABS(true)
                .setHasESP(true)
                .setAirbags(6)
                .setHasComputer(true)
                .setHasAC(true)
                .setInterior("Шкіряна")
                .setPrice(10000)
                .build());
        showroom.addCar("Покращений", builder
                .setEngineType("Дизельний")
                .setEngineSize(2.2)
                .setHasABS(true)
                .setHasESP(true)
                .setAirbags(8)
                .setHasComputer(true)
                .setHasAC(true)
                .setInterior("Тканинна")
                .setPrice(12000)
                .build());
        showroom.addCar("Люкс", builder
                .setEngineType("Дизельний")
                .setEngineSize(2.5)
                .setHasABS(true)
                .setHasESP(true)
                .setAirbags(10)
                .setHasComputer(true)
                .setHasAC(true)
                .setInterior("Шкіряна")
                .setPrice(15000)
                .build());
        showroom.addCar("Преміум", builder
                .setEngineType("Гібридний")
                .setEngineSize(2.0)
                .setHasABS(true)
                .setHasESP(true)
                .setAirbags(12)
                .setHasComputer(true)
                .setHasAC(true)
                .setInterior("Шкіряна")
                .setPrice(20000)
                .build());

        String configurationName = "Стандарт";
        Car premiumCar = showroom.getCar(configurationName);
        if (premiumCar != null) {
            System.out.println("Характеристики автомобіля \"" + configurationName + "\":");
            System.out.println("Двигун: " + premiumCar.getEngineType());
            System.out.println("Об'єм двигуна: " + premiumCar.getEngineSize() + " л");
            System.out.println("ABS: " + (premiumCar.hasABS() ? "Присутній" : "Відсутній"));
            System.out.println("ESP: " + (premiumCar.hasESP() ? "Присутній" : "Відсутній"));
            System.out.println("Подушки безпеки: " + premiumCar.getAirbags());
            System.out.println("Бортовий комп'ютер: " + (premiumCar.hasComputer()));
            System.out.println("Кондиціонер: " + (premiumCar.hasAC() ? "Присутній" : "Відсутній"));
            System.out.println("Обшивка салону: " + premiumCar.getInterior());
            System.out.println("Ціна: " + premiumCar.getPrice() + " $") ;
        } else {
            System.out.println("Комплектація \"" + configurationName + "\" не знайдена.");
        }
    }
}


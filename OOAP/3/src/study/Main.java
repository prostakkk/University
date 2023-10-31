package study;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Jewelry {
    protected String type;
    protected String material;
    protected double weight;
    protected double price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // задати загально materialPrice і перевірку
    // і задати загальну ціну на матеріал?
    public abstract void create();
}

class Earrings extends Jewelry {
    public Earrings(String material, double weight) {
        this.type = "Сережки";
        this.material = material;
        this.weight = weight;
    }

    /*
     (золоті сережки однакової ваги можуть мати різну вартість).
     Я можу створити додаткову змінну складності роботи і визначати користувачем її
     І тоді при введені однакової ваги можна буде вказати ціну роботи іншу, так?
     */
    @Override
    public void create() {
        double materialPrice = 0.0;
        if (material.equals("Золото")) {
            materialPrice = 20; // Ціна золота за грам
        } else if (material.equals("Срібло")) {
            materialPrice = 5; // Ціна срібла за грам
        }
        price = weight * materialPrice;
    }
}

class Rings extends Jewelry {
    public Rings(String material, double weight) {
        this.type = "Каблучки";
        this.material = material;
        this.weight = weight;
    }

    @Override
    public void create() {
        double materialPrice = 0.0;
        if (material.equals("Золото")) {
            materialPrice = 16;
        } else if (material.equals("Срібло")) {
            materialPrice = 8;
        }
        price = weight * materialPrice;
    }
}

class Necklaces extends Jewelry {
    public Necklaces(String material, double weight) {
        this.type = "Ланцюжки";
        this.material = material;
        this.weight = weight;
    }

    @Override
    public void create() {
        double materialPrice = 0.0;
        if (material.equals("Золото")) {
            materialPrice = 10;
        } else if (material.equals("Срібло")) {
            materialPrice = 5;
        }
        price = weight * materialPrice;
    }
}

class Pendants extends Jewelry {
    public Pendants(String material, double weight) {
        this.type = "Підвіски";
        this.material = material;
        this.weight = weight;
    }

    @Override
    public void create() {
        double materialPrice = 0.0;
        if (material.equals("Золото")) {
            materialPrice = 10;
        } else if (material.equals("Срібло")) {
            materialPrice = 5;
        }
        price = weight * materialPrice;
    }
}

class Bracelets extends Jewelry {
    public Bracelets(String material, double weight) {
        this.type = "Підвіски";
        this.material = material;
        this.weight = weight;
    }

    @Override
    public void create() {
        double materialPrice = 0.0;
        if (material.equals("Золото")) {
            materialPrice = 17;
        } else if (material.equals("Срібло")) {
            materialPrice = 9;
        }
        price = weight * materialPrice;
    }
}

// Абстрактна фабрика
abstract class JewelryFactory {
    public abstract Jewelry createEarrings(double weight);

    public abstract Jewelry createRings(double weight);

    public abstract Jewelry createNecklaces(double weight);

    public abstract Jewelry createPendants(double weight);

    public abstract Jewelry createBracelets(double weight);

}

// Конкретна фабрика для золотих прикрас
class GoldJewelryFactory extends JewelryFactory {
    @Override
    public Jewelry createEarrings(double weight) {
        return new Earrings("Золото", weight);
    }

    @Override
    public Jewelry createRings(double weight) {
        return new Rings("Золото", weight);
    }

    @Override
    public Jewelry createNecklaces(double weight) {
        return new Necklaces("Золото", weight);
    }

    @Override
    public Jewelry createPendants(double weight) {
        return new Pendants("Золото", weight);
    }

    @Override
    public Jewelry createBracelets(double weight) {
        return new Bracelets("Золото", weight);
    }
}

// Конкретна фабрика для срібних прикрас
class SilverJewelryFactory extends JewelryFactory {
    @Override
    public Jewelry createEarrings(double weight) {
        return new Earrings("Срібло", weight);
    }

    public Jewelry createRings(double weight) {
        return new Rings("Срібло", weight);
    }

    public Jewelry createNecklaces(double weight) {
        return new Necklaces("Срібло", weight);
    }

    public Jewelry createPendants(double weight) {
        return new Pendants("Срібло", weight);
    }

    public Jewelry createBracelets(double weight) {
        return new Bracelets("Срібло", weight);
    }

}

public class Main {

    public static void main(String[] args) {
        ArrayList<Jewelry> jewelryCatalog = new ArrayList<>();

        JewelryFactory goldFactory = new GoldJewelryFactory();
        JewelryFactory silverFactory = new SilverJewelryFactory();

        Jewelry goldEarringOne = goldFactory.createEarrings(5.0);
        goldEarringOne.create();
        Jewelry goldEarringTwo = goldFactory.createEarrings(15.0);
        goldEarringTwo.create();
        Jewelry goldRing = goldFactory.createRings(5.0);
        goldRing.create();
        Jewelry goldNecklace = goldFactory.createNecklaces(5.0);
        goldNecklace.create();
        Jewelry goldPendant = goldFactory.createPendants(5.0);
        goldPendant.create();
        Jewelry goldBracelet = goldFactory.createBracelets(5.0);
        goldBracelet.create();

        Jewelry silverEarringOne = silverFactory.createEarrings(5.0);
        silverEarringOne.create();
        Jewelry silverEarringTwo = silverFactory.createEarrings(15.0);
        silverEarringTwo.create();

        Jewelry silverRing = silverFactory.createRings(5.0);
        silverRing.create();
        Jewelry silverNecklace = silverFactory.createNecklaces(5.0);
        silverNecklace.create();
        Jewelry silverPendant = silverFactory.createPendants(5.0);
        silverPendant.create();
        Jewelry silverBracelet = silverFactory.createBracelets(5.0);
        silverBracelet.create();

        jewelryCatalog.add(goldEarringOne);
        jewelryCatalog.add(goldEarringTwo);
        jewelryCatalog.add(goldRing);
        jewelryCatalog.add(goldNecklace);
        jewelryCatalog.add(goldPendant);
        jewelryCatalog.add(goldBracelet);

        jewelryCatalog.add(silverEarringOne);
        jewelryCatalog.add(silverEarringTwo);
        jewelryCatalog.add(silverRing);
        jewelryCatalog.add(silverNecklace);
        jewelryCatalog.add(silverPendant);
        jewelryCatalog.add(silverBracelet);

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println();
            System.out.println("Каталог товарів:");
            System.out.println("1. Золоті вироби");
            System.out.println("2. Срібні вироби");
            System.out.println("3. Вихід з програми");

            System.out.print("Оберіть опцію: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayJewelry(jewelryCatalog, "Золото");
                    break;
                case 2:
                    displayJewelry(jewelryCatalog, "Срібло");
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
                    break;
            }
        }
    }

    public static void displayJewelry(ArrayList<Jewelry> jewelryCatalog, String material) {
        System.out.println();
        System.out.println("Каталог виробів " + "(" + material + "): ");
        for (Jewelry jewelry : jewelryCatalog) {
            if (jewelry.material.equals(material)) {
                System.out.println("Назва: " + jewelry.getType());
                System.out.println("Матеріал: " + jewelry.getMaterial());
                System.out.println("Вага: " + jewelry.getWeight() + " грам");
                System.out.println("Кінцева ціна: " + jewelry.getPrice() + " грн");
                System.out.println();
            }
        }

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Що робити далі?");
            System.out.println("1. Назад до меню");
            System.out.println("2. Вихід з програми");

            System.out.print("Оберіть опцію: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    exit = true;
                    break;
                case 2:
                   System.exit(0);
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
                    break;
            }
        }
    }
}


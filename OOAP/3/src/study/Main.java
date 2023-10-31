package study;

// додати поля Name типу шоб була назва виробу ( сережки, перстень і тд) + матеріал, calculate кинути в кінець ієрархії
// встановити вагу однакову типу шо на заводі роблять однакову вагу
// Абстрактна фабрика для створення ювелірних виробів
interface JewelryFactory {
    Earring createEarring();
    Ring createRing();
    Necklace createNecklace();
    Pendant createPendant();
    Bracelet createBracelet();
}

// Конкретна фабрика для виготовлення золотих виробів
class GoldJewelryFactory implements JewelryFactory {
    public Earring createEarring() {
        return new GoldEarring();
    }

    public Ring createRing() {
        return new GoldRing();
    }

    public Necklace createNecklace() {
        return new GoldNecklace();
    }

    public Pendant createPendant() {
        return new GoldPendant();
    }

    public Bracelet createBracelet() {
        return new GoldBracelet();
    }
}

// Конкретна фабрика для виготовлення срібних виробів
class SilverJewelryFactory implements JewelryFactory {
    public Earring createEarring() {
        return new SilverEarring();
    }

    public Ring createRing() {
        return new SilverRing();
    }

    public Necklace createNecklace() {
        return new SilverNecklace();
    }

    public Pendant createPendant() {
        return new SilverPendant();
    }

    public Bracelet createBracelet() {
        return new SilverBracelet();
    }
}

// Базовий клас для усіх ювелірних виробів
abstract class Jewelry {
    protected String material;
    protected double weight;
    protected double complexity;

    public Jewelry(String material, double weight, double complexity) {
        this.material = material;
        this.weight = weight;
        this.complexity = complexity;
    }



    public abstract double calculateCost();
}

// Конкретні реалізації ювелірних виробів
abstract class Earring extends Jewelry {
    public Earring(String material, double weight, double complexity) {
        super(material, weight, complexity);
    }

}

abstract class Ring extends Jewelry {
    public Ring(String material, double weight, double complexity) {
        super(material, weight, complexity);
    }
}

abstract class Necklace extends Jewelry {
    public Necklace(String material, double weight, double complexity) {
        super(material, weight, complexity);
    }
}

abstract class Pendant extends Jewelry {
    public Pendant(String material, double weight, double complexity) {
        super(material, weight, complexity);
    }
}

abstract class Bracelet extends Jewelry {
    public Bracelet(String material, double weight, double complexity) {
        super(material, weight, complexity);
    }
}


class SilverEarring extends Earring {
    public SilverEarring(String material, double weight, double complexity) {
        super(material, weight, complexity);
    }


    @Override
    public double calculateCost() {
        // Логіка розрахунку вартості сережок
        return weight * complexity * 100; // Приклад логіки
    }
}

class SilverRing extends Ring {
    public SilverRing(String material, double weight, double complexity) {
        super(material, weight, complexity);
    }

    @Override
    public double calculateCost() {
        // Логіка розрахунку вартості сережок
        return weight * complexity * 100; // Приклад логіки
    }
}

class SilverNecklace extends Necklace {
    public SilverNecklace(String material, double weight, double complexity) {
        super(material, weight, complexity);
    }

    @Override
    public double calculateCost() {
        // Логіка розрахунку вартості сережок
        return weight * complexity * 100; // Приклад логіки
    }
}

class SilverPendant extends Pendant {
    public SilverPendant(String material, double weight, double complexity) {
        super(material, weight, complexity);
    }

    @Override
    public double calculateCost() {
        // Логіка розрахунку вартості сережок
        return weight * complexity * 100; // Приклад логіки
    }
}

class SilverBracelet extends Bracelet {
    public SilverBracelet(String material, double weight, double complexity) {
        super(material, weight, complexity);
    }

    @Override
    public double calculateCost() {
        // Логіка розрахунку вартості сережок
        return weight * complexity * 100; // Приклад логіки
    }
}

class GoldEarring extends Earring {
    public GoldEarring(String material, double weight, double complexity) {
        super(material, weight, complexity);
    }

    @Override
    public double calculateCost() {
        // Логіка розрахунку вартості сережок
        return weight * complexity * 100; // Приклад логіки
    }
}

class GoldRing extends Ring {
    public GoldRing(String material, double weight, double complexity) {
        super(material, weight, complexity);
    }

    @Override
    public double calculateCost() {
        // Логіка розрахунку вартості сережок
        return weight * complexity * 100; // Приклад логіки
    }
}

class GoldNecklace extends Necklace {
    public GoldNecklace(String material, double weight, double complexity) {
        super(material, weight, complexity);
    }

    @Override
    public double calculateCost() {
        // Логіка розрахунку вартості сережок
        return weight * complexity * 100; // Приклад логіки
    }
}

class GoldPendant extends Pendant {
    public GoldPendant(String material, double weight, double complexity) {
        super(material, weight, complexity);
    }

    @Override
    public double calculateCost() {
        // Логіка розрахунку вартості сережок
        return weight * complexity * 100; // Приклад логіки
    }
}

class GoldBracelet extends Bracelet {
    public GoldBracelet(String material, double weight, double complexity) {
        super(material, weight, complexity);
    }

    @Override
    public double calculateCost() {
        // Логіка розрахунку вартості сережок
        return weight * complexity * 100; // Приклад логіки
    }
}

public class Main {
    public static void main(String[] args) {
        JewelryFactory goldFactory = new GoldJewelryFactory();
        JewelryFactory silverFactory = new SilverJewelryFactory();

        Earring goldEarring = goldFactory.createEarring();
        Ring silverRing = silverFactory.createRing();
        Necklace goldNecklace = goldFactory.createNecklace();
        Pendant silverPendant = silverFactory.createPendant();
        Bracelet goldBracelet = goldFactory.createBracelet();

        // Додайте інші вироби та виведіть їх характеристики
    }
}



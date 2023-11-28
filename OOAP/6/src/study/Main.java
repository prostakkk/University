package study;

import java.util.HashMap;
import java.util.Map;

interface HousePrototype extends Cloneable {
    HousePrototype clone() throws CloneNotSupportedException;
    void display();
}

class House implements HousePrototype {
    private double area;
    private int floors;
    private String address;
    private Owner owner;

    public House(double area, int floors, String address, Owner owner) {
        this.area = area;
        this.floors = floors;
        this.address = address;
        this.owner = owner;
    }

    protected House(House source) throws CloneNotSupportedException {
        this.area = source.area;
        this.floors = source.floors;
        this.address = source.address;
        this.owner = source.owner.clone();
    }

    @Override
    public HousePrototype clone() throws CloneNotSupportedException {
        return new House(this);
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

       @Override
    public void display() {
        System.out.println("House: " + area + " sq. m, " + floors + " floors, Address: " + address);
        owner.display();
    }
}

class Owner implements Cloneable {
    private String ownerName;
    private String contactNumber;

    public Owner(String ownerName, String contactNumber) {
        this.ownerName = ownerName;
        this.contactNumber = contactNumber;
    }

    public Owner(Owner source) {
        this.ownerName = source.ownerName;
        this.contactNumber = source.contactNumber;
    }

    @Override
    public Owner clone() throws CloneNotSupportedException {
        return (Owner) super.clone();
    }


    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    // Інакший метод від інтерфейсу, просто виводить значення про Owner`a (власника),
    // не відноситься до House
    public void display() {
        System.out.println("Owner: " + ownerName + ", Contact Number: " + contactNumber);
    }
}

class ApartmentBuilding extends House {
    private int numberOfApartments;

    public ApartmentBuilding(double area, int floors, String address, Owner owner, int numberOfApartments) {
        super(area, floors, address, owner);
        this.numberOfApartments = numberOfApartments;
    }

    protected ApartmentBuilding(ApartmentBuilding source) throws CloneNotSupportedException {
        super(source);
        this.numberOfApartments = source.numberOfApartments;
    }

    @Override
    public HousePrototype clone() throws CloneNotSupportedException {
        return new ApartmentBuilding(this);
    }
    @Override
    public void display() {
        super.display();
        System.out.println("Number of Apartments: " + numberOfApartments);
    }

    public int getNumberOfApartments() {
        return numberOfApartments;
    }

    public void setNumberOfApartments(int numberOfApartments) {
        this.numberOfApartments = numberOfApartments;
    }
}

class Cottage extends House {
    private boolean hasGarden;

    public Cottage(double area, int floors, String address, Owner owner, boolean hasGarden) {
        super(area, floors, address, owner);
        this.hasGarden = hasGarden;
    }

    private Cottage(Cottage source) throws CloneNotSupportedException {
        super(source);
        this.hasGarden = source.hasGarden;
    }

    @Override
    public HousePrototype clone() throws CloneNotSupportedException {
        return new Cottage(this);
    }

    public boolean isHasGarden() {
        return hasGarden;
    }

    public void setHasGarden(boolean hasGarden) {
        this.hasGarden = hasGarden;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Garden available: " + hasGarden);
    }
}

class HouseContainer {
    private Map<String, House> houseMap = new HashMap<>();

    public void addHouse(String key, House house) {
        houseMap.put(key, house);
    }
    // отримання будинку клону відбувається за ключем
    public House getHouseClone(String key) {
        try {
            return (House) houseMap.get(key).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void displayHouses() {
        for (Map.Entry<String, House> entry : houseMap.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            entry.getValue().display();
            System.out.println("------------------------");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Owner owner1 = new Owner("John Doe", "123-456-7890");
        Owner owner2 = new Owner("Jane Doe", "987-654-3210");

        ApartmentBuilding apartmentBuilding = new ApartmentBuilding(300.0, 5, "789 Main St", owner1, 10);
        Cottage cottage = new Cottage(150.0, 2, "456 Oak St", owner2, true);

        HouseContainer container = new HouseContainer();

        container.addHouse("apartmentBuilding", apartmentBuilding);
        container.addHouse("cottage", cottage);

        container.displayHouses();

        HousePrototype clonedHouse = container.getHouseClone("apartmentBuilding");
        if (clonedHouse != null) {
            ((ApartmentBuilding) clonedHouse).setNumberOfApartments(15);
            container.addHouse("clonedApartmentBuilding", (House) clonedHouse);
        }

        container.displayHouses();
    }
}

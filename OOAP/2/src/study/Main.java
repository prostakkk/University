package study;

abstract class Shape {
    public abstract double calculateArea();

    public Shape() {
        System.out.println("Об'єкт створено!");
    }
}

class Square extends Shape {
    private double side;

    public Square(double side) {
        super();
        this.side = side;
        System.out.println("Площа квадрата = " + calculateArea());

    }
    
    @Override
    public double calculateArea() {
        return side * side;
    }

}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        super();
        this.length = length;
        this.width = width;
        System.out.println("Площа прямокутника = " + calculateArea());
    }


    @Override
    public double calculateArea() {
        return length * width;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super();
        this.radius = radius;
        System.out.println("Площа кола = " + calculateArea());
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        Square square = new Square(5);
        Rectangle rectangle = new Rectangle(4, 6);
        Circle circle = new Circle(3);
    }
}

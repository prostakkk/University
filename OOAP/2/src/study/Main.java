package study;

abstract class Shape {
    public void displayMessage() {
        System.out.println("Об'єкт створено");
    }
}

class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void displayMessage() {
        super.displayMessage();
        System.out.println( "Площа квадрату: " + side * side);
    }

}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void displayMessage() {
        super.displayMessage();
        System.out.println("Площа прямокутника: " +  length * width);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void displayMessage() {
        super.displayMessage();
        System.out.println("Площа круга: " + Math.PI * radius * radius);
    }
}

public class Main {
    public static void main(String[] args) {
        Square square = new Square(5);
        square.displayMessage();

        Rectangle rectangle = new Rectangle(4, 6);
        rectangle.displayMessage();

        Circle circle = new Circle(3);
        circle.displayMessage();
    }
}

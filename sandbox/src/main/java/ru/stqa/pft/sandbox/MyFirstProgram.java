package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        hello("world");

        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s.area());

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь  прямоугольника со сторонами " + r.a + " и " + r.b + " равна " + r.area());
    }

    public static void hello (String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }

}
package ru.stqa.pft.sandbox;

public class PrintDistance {
    public static void main(String[] args) {

        Point p = new Point(1, 2);
        Point t = new Point(3, 4);
        System.out.println("Расстояние между точками равно " + p.distance(t));
    }

}

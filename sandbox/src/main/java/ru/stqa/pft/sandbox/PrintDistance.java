package ru.stqa.pft.sandbox;

public class PrintDistance {
    public static void main(String[] args) {
        calc(2,3,1,5);
        calc(1,2,3,4);
    }

    private static void calc(int x1, int y1, int x2, int y2){
        Point pointA = new Point();
        Point pointB = new Point();
        pointA.x = x1;
        pointB.y = y1;
        pointA.x = x2;
        pointB.y = y2;

        System.out.println("Расстояние между точками pointA и pointB равно " + Point.distance(pointA, pointB));
    }
}

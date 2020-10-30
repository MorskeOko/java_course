package ru.stqa.pft.sandbox;

import org.junit.Test;
import org.testng.Assert;

public class PointTest {

    @Test
    public void testDistance () {
        Point p = new Point (1, 2);
        Point x = new Point (3, 4);
        Assert.assertEquals(p.distance(x), 2.8284271247461903, 0);
    }

    @Test
    public void testDistanceNew () {
        Point p = new Point (2, 3);
        Point x = new Point (4, 5);
        Assert.assertEquals(p.distance(x), 0, 0);
    }

}

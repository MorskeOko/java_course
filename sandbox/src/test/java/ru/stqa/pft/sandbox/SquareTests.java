package ru.stqa.pft.sandbox;

import jdk.jfr.StackTrace;
import org.junit.Assert;
import org.junit.Test;

public class SquareTests {

    @Test
    public void testArea() {
        Square s = new Square(5);
        Assert.assertEquals(s.area(),25.0, 0);

    }
}

package com.jdktomcat.pack.dsa.algorithm.book.offer.stack.p37;

import org.junit.Assert;
import org.junit.Test;

public class AsteroidCollisionTest {

    @Test
    public void asteroidCollision() {
        int[] asteroids = {4, 5, -6, 4, 8, -5};
        int[] exists = AsteroidCollision.asteroidCollision(asteroids);
        Assert.assertEquals(-6, exists[0]);
        Assert.assertEquals(4, exists[1]);
        Assert.assertEquals(8, exists[2]);
    }
}
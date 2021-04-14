package br.com.guisfco.onlineshopping.util;

public class RandomUtils {

    public static int nextInt(final int minInclusive, final int maxExclusive) {
        return minInclusive + (int) (Math.random() * (maxExclusive - minInclusive));
    }

    public static double nextDouble(final int min, final int max) {
        return (Math.random() * (max - min)) + min;
    }
}

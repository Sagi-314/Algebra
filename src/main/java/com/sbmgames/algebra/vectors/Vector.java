package com.sbmgames.algebra.vectors;

/**
 * this Vector class represents an immutable point.
 */
public class Vector
{
    private final double x;
    private final double y;

    public Vector(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public void distance(Vector other)
    {
        distance(this, other);
    }

    public static double distance(Vector vector1, Vector vector2)
    {
        return Math.sqrt(Math.pow(vector2.x - vector1.x, 2) + Math.pow(vector2.y - vector1.y, 2));
    }

    @Override
    public String toString()
    {
        return "Vector{" +
                "x=" + String.format("%.2f", x) +
                ", y=" + String.format("%.2f", y) +
                '}';
    }

    public double x()
    {
        return x;
    }

    public double y()
    {
        return y;
    }
}
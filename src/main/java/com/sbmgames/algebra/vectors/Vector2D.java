package com.sbmgames.algebraaa.vectors;

/**
 * this Vector2D class represents a line between two points.
 * the line has:
 * a tail - the point it starts at.
 * a magnitude - the length of the line.
 * a direction - the angle (degrees) between the line and the positive X-axis part (where x > 0). the angle is calculated counterclockwise.
 * a head - the point it ends at.
 */
public class Vector2D
{
    private Vector tail;
    private double magnitude;
    private double direction;

    public Vector2D(Vector tail, Vector head)
    {
        this(tail, Vector.distance(tail, head), calculateDirectionDegrees(tail, head));
    }
    public Vector2D(Vector tail, double magnitude, double direction)
    {
        this.tail = tail;
        this.magnitude = magnitude;
        this.direction = direction;
    }


    public Vector getTail()
    {
        return tail;
    }
    public double getMagnitude()
    {
        return magnitude;
    }
    public double getDirection()
    {
        return direction;
    }
    public Vector getHead()
    {
        return calculateHead(tail, magnitude, direction);
    }


    public void setTail(Vector tail)
    {
        this.tail = tail;
    }
    public void setMagnitude(double magnitude)
    {
        this.magnitude = magnitude;
    }
    public void setDirection(double direction)
    {
        this.direction = direction;
    }
    public void setHead(Vector head)
    {
        setMagnitude(Vector.distance(tail, head));
        setDirection(calculateDirectionDegrees(tail, head));
    }


    public static Vector calculateHead(double tailX, double tailY, double magnitude, double direction)
    {
        double directionInRadians = Math.toRadians(direction);

        double inclineX = Math.cos(directionInRadians);
        double inclineY = Math.sin(directionInRadians);

        return new Vector(tailX + (magnitude * inclineX),  tailY + (magnitude * inclineY));
    }
    public static Vector calculateHead(Vector tail, double magnitude, double direction)
    {
        return calculateHead(tail.x(), tail.y(), magnitude, direction);
    }
    public static double calculateDirectionRadians(Vector tail, Vector head)
    {
        return Math.atan2(head.y() - tail.y(), head.x() - tail.x());
    }
    public static double calculateDirectionDegrees(Vector tail, Vector head)
    {
        return Math.toDegrees(calculateDirectionRadians(tail, head));
    }


    @Override
    public String toString()
    {
        return "Vector2D{" +
                "tail=" + tail +
                ", magnitude=" + magnitude +
                ", direction=" + direction +
                "head=" + getHead() +
                '}';
    }
}
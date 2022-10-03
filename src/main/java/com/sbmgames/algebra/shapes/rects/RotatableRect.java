package com.sbmgames.algebra.rects;

import com.sbmgames.algebraaa.vectors.Vector;
import com.sbmgames.algebraaa.vectors.Vector2D;

public class RotatableRect extends Rect
{
    private static final int BOTTOM = 45;
    private static final int LEFT = 135;
    private static final int TOP = 225;
    private static final int RIGHT = 315;

    private double rotation;

    public RotatableRect()
    {
        this(0,0,0,0);
    }
    public RotatableRect(double x, double y, double width, double height)
    {
        this(x, y, width, height, 0);
    }
    public RotatableRect(double x, double y, double width, double height, double rotation)
    {
        set(x, y, width, height, rotation);
    }

    public void setFrom(RotatableRect from)
    {
        set(from.getX(), from.getY(), from.getWidth(), from.getHeight(), from.getRotation());
    }
    public void set(double x, double y, double width, double height, double rotation)
    {
        super.set(x, y, width, height);

        setRotation(rotation);
    }

    public void setRotation(double rotation)
    {
        this.rotation = rotation % 360 + (rotation < 0 ? 360 : 0);
    }

    @Override
    public RotatableRect getCopy()
    {
        return new RotatableRect(getX(), getY(), getWidth(), getHeight(), getRotation());
    }
    public void copyTo(RotatableRect to)
    {
        to.set(getX(), getY(), getWidth(), getHeight(), getRotation());
    }

    public double getRotation()
    {
        return rotation;
    }

    public Vector getTopVertex()
    {
        return getVertex(TOP);
    }
    public Vector getLeftVertex()
    {
        return getVertex(LEFT);
    }
    public Vector getRightVertex()
    {
        return getVertex(RIGHT);
    }
    public Vector getBottomVertex()
    {
        return getVertex(BOTTOM);
    }
    private Vector getVertex(int vertex)
    {
        return Vector2D.calculateHead(getCenterX(), getCenterY(), getDiagonalWidth() / 2, (getRotation() % 90) + vertex);
    }

    private double getDiagonalWidth()
    {
        return Math.sqrt(Math.pow(getWidth(), 2) + Math.pow(getHeight(), 2));
    }

    @Override
    public String toString()
    {
        return "RotatableRect{" +
                "width=" + getWidth() +
                ", height=" + getHeight() +
                ", x=" + getX() +
                ", y=" + getY() +
                ", rotation=" + rotation +
                '}';
    }
}
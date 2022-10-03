package com.sbmgames.algebra.shapes.rects;

import com.sbmgames.algebra.vectors.Vector;

public class Rect
{
    private double x;
    private double y;
    private double width;
    private double height;

    public Rect()
    {
        this(0,0,0,0);
    }
    public Rect(double x, double y, double width, double height)
    {
        set(x, y, width, height);
    }


    public void setFrom(Rect from)
    {
        set(from.getX(), from.getY(), from.getWidth(), from.getHeight());
    }
    public void set(double x, double y, double width, double height)
    {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    public void setX(double x)
    {
        this.x = x;
    }
    public void setY(double y)
    {
        this.y = y;
    }
    public void setWidth(double width)
    {
        this.width = width;
    }
    public void setHeight(double height)
    {
        this.height = height;
    }

    
    public Rect getCopy()
    {
        return new Rect(getX(), getY(), getWidth(), getHeight());
    }
    public void copyTo(Rect to)
    {
        to.set(getX(), getY(), getWidth(), getHeight());
    }

    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
    public double getWidth()
    {
        return width;
    }
    public double getHeight()
    {
        return height;
    }
    

    public Vector getCenter()
    {
        return new Vector(getCenterX(), getCenterY());
    }
    public double getCenterX()
    {
        return getX() + getWidth() / 2.0;
    }
    public double getCenterY()
    {
        return getY() + getHeight() / 2.0;
    }

    @Override
    public String toString()
    {
        return "Rect{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
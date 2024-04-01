package entity;

public class Operations {
    public double biggestValue(double v1, double v2)
    {
        return Math.max(v1, v2);
    }

    public double smallestValue(double v1, double v2)
    {
        return Math.min(v1, v2);
    }

    public double squareRoot(double v1)
    {
        return Math.sqrt(v1);
    }

    public double divide(double v1, double v2)
    {
        return v1 / v2;
    }

    public double multiply(double v1, double v2)
    {
        return v1 * v2;
    }

    public double accumulate(int limit)
    {
        return Math.incrementExact(limit);
    }

    public double sum(double v1, double v2)
    {
        return v1 + v2;
    }
}


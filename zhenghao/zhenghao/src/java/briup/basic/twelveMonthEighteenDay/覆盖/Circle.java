package java.briup.basic.twelveMonthEighteenDay.覆盖;

/**
 * Created by ZH on 2015/12/18.
 */
public class Circle extends Shape{
    private double r;

    public Circle(){}
    public Circle(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "r=" + r +
                '}';
    }
}

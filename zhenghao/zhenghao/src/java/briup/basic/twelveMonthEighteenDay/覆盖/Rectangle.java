package java.briup.basic.twelveMonthEighteenDay.覆盖;

/**
 * Created by ZH on 2015/12/18.
 */
public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(){}
    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}

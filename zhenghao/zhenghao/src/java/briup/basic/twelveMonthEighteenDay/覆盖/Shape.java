package java.briup.basic.twelveMonthEighteenDay.覆盖;

/**
 * Created by ZH on 2015/12/18.
 */
public class Shape {

    /** 计算矩形的周长 */
    public double caculatorCircle(double width,double height){
        return 2*(width+height);
    }
    /** 计算圆的周长 */
    public double caculatorCircle(double r){
        return 2*3.14*r;
    }
    /** 计算矩形的面积 */
    public double caculatorArea(double width,double height){
        return width*height;
    }
    /** 计算圆的面积 */
    public double caculatorArea(double r){
        return 3.14*r*r;
    }
}

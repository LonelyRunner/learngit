package java.briup.DesignMode.InterfaceMode;

/**
 * Created by ZH on 2015/12/10.
 */
public interface RocketSim {
    public abstract double getMass();
    public double getThtust();
    void setSimTime(double t);

    /** 默认方法都为abstract 可以省略 */
}

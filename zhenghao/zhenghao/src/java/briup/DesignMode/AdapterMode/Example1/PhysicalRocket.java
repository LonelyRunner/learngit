package java.briup.DesignMode.AdapterMode.Example1;

/**
 * Created by ZH on 2015/12/10.
 */
public class PhysicalRocket {
    public double burnArea;
    public double burnRate;
    public double fuelMass;
    public double totalMass;

    public double getBurnTime(){
        return totalMass/burnRate;
    }

    public double getMass(){
        return totalMass;
    }

    public double getThrust(){
        return fuelMass;
    }
}

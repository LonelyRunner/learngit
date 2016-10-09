package java.briup.DesignMode.AdapterMode.Example1;

/**
 * Created by ZH on 2015/12/10.
 */
public class OozinozRocket extends PhysicalRocket implements RocketSim{
    private double time;
    public OozinozRocket(double burnArea, double burnRate, double fuelMass, double totalMass) {
        super();
    }

    public double getMass(){
        return 11.2;
    }
    public double getThrust(){
        return 11.2;
    }
    public void setSimTime(double t){
        this.time = t;
    }

}

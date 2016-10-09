package basic;

import java.util.Map;

/**
 * Created by ZH on 2016/9/19.
 */
public class ClassTwo {

    private String name;

    private Map<String,Number> chargeMap;

    private Number sum;

    public ClassTwo() {
    }

    public ClassTwo(String name, Map<String, Number> chargeMap, Number sum) {
        this.name = name;
        this.chargeMap = chargeMap;
        this.sum = sum;
    }

    public Number getSum() {
        return sum;
    }

    public void setSum(Number sum) {
        this.sum = sum;
    }

    public Map<String, Number> getChargeMap() {
        return chargeMap;
    }

    public void setChargeMap(Map<String, Number> chargeMap) {
        this.chargeMap = chargeMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassTwo{" +
                "name='" + name + '\'' +
                ", chargeMap=" + chargeMap +
                ", sum=" + sum +
                '}';
    }
}

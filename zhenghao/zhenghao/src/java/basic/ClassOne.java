package basic;

/**
 * Created by ZH on 2016/9/19.
 */
public class ClassOne {

    private String chargeType;

    private Number shouldGet;

    private Number factGet;

    private Number settle;

    public ClassOne() {
    }

    public ClassOne(String chargeType, Number shouldGet, Number factGet, Number settle) {
        this.chargeType = chargeType;
        this.shouldGet = shouldGet;
        this.factGet = factGet;
        this.settle = settle;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public Number getShouldGet() {
        return shouldGet;
    }

    public void setShouldGet(Number shouldGet) {
        this.shouldGet = shouldGet;
    }

    public Number getFactGet() {
        return factGet;
    }

    public void setFactGet(Number factGet) {
        this.factGet = factGet;
    }

    public Number getSettle() {
        return settle;
    }

    public void setSettle(Number settle) {
        this.settle = settle;
    }

    @Override
    public String toString() {
        return "ClassOne{" +
                "chargeType='" + chargeType + '\'' +
                ", shouldGet=" + shouldGet +
                ", factGet=" + factGet +
                ", settle=" + settle +
                '}';
    }
}

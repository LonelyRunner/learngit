package HeadFirst.templateMode;

public abstract class Beverage {

    //煮沸水
    private void boil(){
        System.out.println("将水煮沸...");
    }

    //将水与茶叶或者咖啡豆混合
    public abstract void mixUp();

    //将饮料倒入杯子中
    private void water(){
        System.out.println("将饮料倒入杯子中...");
    }

    //添加饰品
    public abstract void addDesc();

    //钩子类 Hook  饰品的添加与否  在子类中实现
    public boolean isAddDesc(){
        return true;
    }

    //制作饮料全过程
    protected final void makeProcess(){
        boil();
        mixUp();
        water();
        if(isAddDesc()){
            addDesc();
        }
    }
}

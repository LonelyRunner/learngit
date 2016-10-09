package HeadFirst.templateMode;

public class Coffee extends Beverage{
    @Override
    public void mixUp() {
        System.out.println("煮咖啡...");
    }

    @Override
    public void addDesc() {
        System.out.println("添加牛奶和糖...");
    }
}

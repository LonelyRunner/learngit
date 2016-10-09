package HeadFirst.templateMode;

public class TestBeverage {

    public static void main(String args[]){
        Beverage tea = new Tea();
        System.out.println("制作中式茶水开始...");
        tea.makeProcess();
        System.out.println("制作中式茶水完成...");

        System.out.println("\n***********************************\n");

        Beverage coffee = new Coffee();
        System.out.println("制作咖啡开始...");
        coffee.makeProcess();
        System.out.println("制作咖啡完成...");
    }
}

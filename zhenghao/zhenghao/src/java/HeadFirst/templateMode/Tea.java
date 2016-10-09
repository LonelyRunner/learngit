package HeadFirst.templateMode;

public class Tea extends Beverage{

    @Override
    public void mixUp() {
        System.out.println("用80°的水浸泡茶叶...");
    }

    @Override
    public void addDesc() {
        System.out.println("添加柠檬...");
    }

    @Override
    public boolean isAddDesc(){
        return false;
    }
}

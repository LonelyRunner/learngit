package HeadFirst.AdapterMode;

public class NoteBook {
    private ThreePower threePower;

    public NoteBook(ThreePower threePower){
        this.threePower = threePower;
    }

    public void charge(){
        threePower.powerByThree();
    }

    public static void main(String args[]){
        GBTwoPower twoPower = new GBTwoPower();
        ThreePower three = new TranTwoToThree(twoPower);
        NoteBook noteBook = new NoteBook(three);
        noteBook.charge();

        System.out.println("\r----------------------------------适配器模式----------------------------------\r");

        ThreePower three1 = new TranTwoToThreeExtends();
        NoteBook noteBook1 = new NoteBook(three1);
        noteBook1.charge();
    }
}

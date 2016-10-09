package java.innerClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ZH on 2016/3/3.
 */
public class Card {
    private String cardId;
    private String cardPassword;

    public Card() {

    }

    public Card(String cardId, String cardPassword) {
        this.cardId = cardId;
        this.cardPassword = cardPassword;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardPassword() {
        return cardPassword;
    }

    public void setCardPassword(String cardPassword) {
        this.cardPassword = cardPassword;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId='" + cardId + '\'' +
                ", cardPassword='" + cardPassword + '\'' +
                '}';
    }

    public static void main(String args[]){
        List<Card> cardList = new ArrayList<>();
        System.out.println("请输入用户名:");
        Scanner scanner1 = new Scanner(System.in);
        int i = scanner1.nextInt();
        System.out.println("请输入密码 :");
        Scanner scanner2 = new Scanner(System.in);
        int j = scanner2.nextInt();

        System.out.println("-------------------------------------------------");
        System.out.println("           欢迎登陆网上银行系统请稍后...            ");
        System.out.println("请选择相关业务            ");
        System.out.println("           1.查询余额            ");
        System.out.println("           2.修改密码            ");
        System.out.println("           3.退出登陆            ");
        System.out.println("-------------------------------------------------");

    }
}

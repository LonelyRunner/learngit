package briup.connectOracle;

/**
 * Created by ZH on 2016/7/18.
 */
public class Hero {
    private String heroName;
    private String heroQ;
    private String heroW;
    private String heroE;
    private String heroR;
    private String heroPassive;
    private String heroImg;

    public Hero() {
    }

    public Hero(String heroName, String heroQ, String heroW, String heroE, String heroR, String heroPassive, String heroImg) {
        this.heroName = heroName;
        this.heroQ = heroQ;
        this.heroW = heroW;
        this.heroE = heroE;
        this.heroR = heroR;
        this.heroPassive = heroPassive;
        this.heroImg = heroImg;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroQ() {
        return heroQ;
    }

    public void setHeroQ(String heroQ) {
        this.heroQ = heroQ;
    }

    public String getHeroW() {
        return heroW;
    }

    public void setHeroW(String heroW) {
        this.heroW = heroW;
    }

    public String getHeroE() {
        return heroE;
    }

    public void setHeroE(String heroE) {
        this.heroE = heroE;
    }

    public String getHeroR() {
        return heroR;
    }

    public void setHeroR(String heroR) {
        this.heroR = heroR;
    }

    public String getHeroPassive() {
        return heroPassive;
    }

    public void setHeroPassive(String heroPassive) {
        this.heroPassive = heroPassive;
    }

    public String getHeroImg() {
        return heroImg;
    }

    public void setHeroImg(String heroImg) {
        this.heroImg = heroImg;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "heroName='" + heroName + '\'' +
                ", heroQ='" + heroQ + '\'' +
                ", heroW='" + heroW + '\'' +
                ", heroE='" + heroE + '\'' +
                ", heroR='" + heroR + '\'' +
                ", heroPassive='" + heroPassive + '\'' +
                ", heroImg='" + heroImg + '\'' +
                '}';
    }
}

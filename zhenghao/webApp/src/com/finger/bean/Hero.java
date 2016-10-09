package com.finger.bean;

/**
 * Created by ZH on 2016/7/21.
 */
public class Hero {
    private Integer id;
    private String hero_name;
    private String hero_Q;
    private String hero_W;
    private String hero_E;
    private String hero_R;
    private String hero_passive;
    private String hero_img;

    public Hero() {
    }

    public Hero(Integer id, String hero_name, String hero_Q, String hero_W, String hero_E, String hero_R, String hero_passive, String hero_img) {
        this.id = id;
        this.hero_name = hero_name;
        this.hero_Q = hero_Q;
        this.hero_W = hero_W;
        this.hero_E = hero_E;
        this.hero_R = hero_R;
        this.hero_passive = hero_passive;
        this.hero_img = hero_img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHero_name() {
        return hero_name;
    }

    public void setHero_name(String hero_name) {
        this.hero_name = hero_name;
    }

    public String getHero_Q() {
        return hero_Q;
    }

    public void setHero_Q(String hero_Q) {
        this.hero_Q = hero_Q;
    }

    public String getHero_W() {
        return hero_W;
    }

    public void setHero_W(String hero_W) {
        this.hero_W = hero_W;
    }

    public String getHero_E() {
        return hero_E;
    }

    public void setHero_E(String hero_E) {
        this.hero_E = hero_E;
    }

    public String getHero_R() {
        return hero_R;
    }

    public void setHero_R(String hero_R) {
        this.hero_R = hero_R;
    }

    public String getHero_passive() {
        return hero_passive;
    }

    public void setHero_passive(String hero_passive) {
        this.hero_passive = hero_passive;
    }

    public String getHero_img() {
        return hero_img;
    }

    public void setHero_img(String hero_img) {
        this.hero_img = hero_img;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", hero_name='" + hero_name + '\'' +
                ", hero_Q='" + hero_Q + '\'' +
                ", hero_W='" + hero_W + '\'' +
                ", hero_E='" + hero_E + '\'' +
                ", hero_R='" + hero_R + '\'' +
                ", hero_passive='" + hero_passive + '\'' +
                ", hero_img='" + hero_img + '\'' +
                '}';
    }
}

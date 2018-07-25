package com.zedney.rokouch.models;

public class Comment {

    private String desc, date, userName, userImage, nbStars;

    public Comment() {
    }

    public Comment(String desc, String date, String userName, String userImage, String nbStars) {
        this.desc = desc;
        this.date = date;
        this.userName = userName;
        this.userImage = userImage;
        this.nbStars = nbStars;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getNbStars() {
        return nbStars;
    }

    public void setNbStars(String nbStars) {
        this.nbStars = nbStars;
    }
}

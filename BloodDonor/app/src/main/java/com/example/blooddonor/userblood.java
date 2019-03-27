package com.example.blooddonor;

public class userblood {
    private String name;
    private String bg;
    private String hospital;
    private String mobile;
    //    private String age;
//    private String hospitalital;
    private String loc;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    //    private String bg;
    private userblood() {

    }

    public userblood(String name, String bg, String hospital, String mobile, String loc) {
        this.name = name;
        this.bg = bg;
        this.hospital = hospital;
        this.mobile = mobile;
        this.loc = loc;
    }

    public userblood(String name, String bg, String hospital) {
        this.name = name;
        this.bg = bg;
        this.hospital = hospital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public String gethospital() {
        return hospital;
    }

    public void sethospital(String hospital) {
        this.hospital = hospital;
    }

   @Override
    public String toString() {
        return "Name : " + name + "\n"+ "Blood Group :"+ bg + "\n" + "hospital Name:" + "" +hospital +  "\n" + "Mobile Number:" + mobile;
   }

}

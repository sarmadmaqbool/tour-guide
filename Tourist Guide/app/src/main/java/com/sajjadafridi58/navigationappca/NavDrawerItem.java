package com.sajjadafridi58.navigationappca;

/**
 * Created by Sajjad on 5/8/2016.
 */
public class NavDrawerItem {

    private String title;
    private int icon;


    public NavDrawerItem() {
    }

    public NavDrawerItem(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }
    public NavDrawerItem(int icon)
    {
        this.icon=icon;
    }

    public String getTitle() {
        return this.title;
    }

    public int getIcon() {
        return this.icon;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }


}


package com.example.hesi100.barber_women;

/**
 * Created by hesi100 on 3/13/2018.
 */

public class Emkanat {
    String name;
    int cost;
    String id;
    boolean selected;
    String costandname;
    String url;
    Emkanat(String name,int cost)
    {
        this.name=name;
        this.cost=cost;
        selected=false;
    }
    Emkanat( String id,String name,int cost,String url)
    {
        this.id=id;
        this.name=name;
        this.cost=cost;
        costandname=name+" - "+cost;
        this.url=url;

    }
    public void findimagebylink(String u)
    {
        //i= set image
    }
}

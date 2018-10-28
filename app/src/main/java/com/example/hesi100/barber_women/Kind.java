package com.example.hesi100.barber_women;

import android.widget.CheckBox;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hesi100 on 3/13/2018.
 */

public class Kind {
    List<Emkanat> boland;
    public boolean b;
    List<Emkanat> motavaset;
    public boolean m;
    List<Emkanat> kuchak;
    public boolean k;
    Kind()
    {
        b=false;
        m=true;
        k=false;
        boland = new ArrayList<>();
        motavaset = new ArrayList<>();
        kuchak = new ArrayList<>();
    }
    public void setcheckbox(CheckBox boland,CheckBox motavaset,CheckBox kuchak)
    {
            boland.setChecked(b);
            motavaset.setChecked(m);
            kuchak.setChecked(k);
    }
    public void setsize(int s)
    {
        
        if(s==0)
        {
            b=true;
            m=false;
            k=false;
        }
        else if(s==1)
        {
            m=true;
            b=false;
            k=false;
        }
        else if(s==2)
        {
            k=true;
            m=false;
            b=false;
        }
        else {
            k = false;
            m = false;
            b = false;
        }
    }
    public int unset(int x)
    {
        for (int i=0;i<boland.size();i++)
        {
            if(boland.get(i).selected)
            {
                x-=boland.get(i).cost;
            }
            boland.get(i).selected=false;
            if(kuchak.get(i).selected)
            {
                x-=kuchak.get(i).cost;
            }
            kuchak.get(i).selected=false;
            if(motavaset.get(i).selected)
            {
                x-=motavaset.get(i).cost;
            }
            motavaset.get(i).selected=false;
        }
        return x;
    }
    public int bolandselect(int x)
    {
        for (int i=0;i<boland.size();i++)
        {
            if(kuchak.get(i).selected)
            {
                x-=kuchak.get(i).cost;
            }
            kuchak.get(i).selected=false;
            if(motavaset.get(i).selected)
            {
                x-=motavaset.get(i).cost;
            }
            motavaset.get(i).selected=false;
        }
        return x;
    }
    public int motavasetselect(int x)
    {
        for (int i=0;i<boland.size();i++)
        {
            if(kuchak.get(i).selected)
            {
                x-=kuchak.get(i).cost;
            }
            kuchak.get(i).selected=false;
            if(boland.get(i).selected)
            {
                x-=boland.get(i).cost;
            }
            boland.get(i).selected=false;
        }
        return x;
    }
    public int kuchakselect(int x)
    {
        for (int i=0;i<boland.size();i++)
        {
            if(motavaset.get(i).selected)
            {
                x-=motavaset.get(i).cost;
            }
            motavaset.get(i).selected=false;
            if(boland.get(i).selected)
            {
                x-=boland.get(i).cost;
            }
            boland.get(i).selected=false;
        }
        return x;
    }
    public void setBoland(List<Emkanat> boland)
    {
        this.boland = boland;
    }

    public void setMotavaset(List<Emkanat> motavaset)
    {

        this.motavaset = motavaset;
    }

    public void setKuchak(List<Emkanat> kuchak) {
        this.kuchak = kuchak;
    }

}


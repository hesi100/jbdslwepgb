package com.example.hesi100.barber_women;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hesi100 on 11/21/2017.
 */

public class Barber {
    String shop;
    String id;
    String phone;
    String address;
    String shahr;
    String mahalle;
    String takhfif;
    String status;
    float puan;
    int user;
    Kind hair;
    Kind haircolor;
    Kind nakhon;
    List<Emkanat> eplasion;
    List<Emkanat> abro;
    List<Emkanat> makeup;
    boolean isfavorite;

    Barber(String id,String shop,String address,String takhfif,boolean isfavorite)
    {
        this.id=id;
        this.shop=shop;

        this.address=address;
        this.takhfif=takhfif;
        this.isfavorite=isfavorite;

        hair=  new Kind();
        haircolor=new Kind();
        nakhon=new Kind();
        abro=new ArrayList<Emkanat>();
        eplasion=new ArrayList<Emkanat>();
        makeup=new ArrayList<Emkanat>();
    }
    public void sethair(List<Kind> h)
    {

    }
    public void setother()
    {

        this.puan= (float) 3.5;
        this.user=25;
        this.address=" تبریز حجتی خیابان قطزان جدید پلاک 18";
        setAbro();
        setArayesh();
        setEplasion();
        setbollandhair();
        setbollandhaircolor();
        setkutahhair();
        setkutahhaircolor();
        setmotavasethair();
        setmotavasethaircolor();
        setbollandnakhon();
        setmotavasetnakhon();
        setkutahnakhon();

    }
    public void setbollandhair()
    {
        //send query

        Emkanat e1=new Emkanat("شینیون",5000);
        Emkanat e2=new Emkanat("سشوار",4000);
        hair.boland.add(e1);
        hair.boland.add(e2);
    }
    public void setmotavasethair()
    {
        //send query

        Emkanat e1=new Emkanat("شینیون",4000);
        Emkanat e2=new Emkanat("سشوار",3000);
        hair.motavaset.add(e1);
        hair.motavaset.add(e2);
    }
    public void setkutahhair()
    {
        //send query

        Emkanat e1=new Emkanat("شینیون",3000);
        Emkanat e2=new Emkanat("سشوار",2000);
        hair.kuchak.add(e1);
        hair.kuchak.add(e2);
    }
    public void setbollandhaircolor()
    {
        //send query

        Emkanat e1=new Emkanat("خارجی",8000);
        Emkanat e2=new Emkanat("داخلی",5000);
        haircolor.boland.add(e1);
        haircolor.boland.add(e2);
    }
    public void setmotavasethaircolor()
    {
        //send query
        Emkanat e1=new Emkanat("خارجی",7000);
        Emkanat e2=new Emkanat("داخلی",4000);
        haircolor.motavaset.add(e1);
        haircolor.motavaset.add(e2);
    }
    public void setkutahhaircolor()
    {
        //send query

        Emkanat e1=new Emkanat("خارجی",6000);
        Emkanat e2=new Emkanat("داخلی",3000);
        haircolor.kuchak.add(e1);
        haircolor.kuchak.add(e2);
    }
    public void setbollandnakhon()
    {
        //send query

        Emkanat e1=new Emkanat("گل گلی",5000);
        Emkanat e2=new Emkanat("خاکی خاکی",5000);
        nakhon.boland.add(e1);
        nakhon.boland.add(e2);
    }
    public void setmotavasetnakhon()
    {
        //send query

        Emkanat e1=new Emkanat("گل گلی",4000);
        Emkanat e2=new Emkanat("خاکی خاکی",4000);
        nakhon.motavaset.add(e1);
        nakhon.motavaset.add(e2);
    }
    public void setkutahnakhon() {
        //send query

        Emkanat e1=new Emkanat("گل گلی",3000);
        Emkanat e2=new Emkanat("خاکی خاکی",3000);
        nakhon.kuchak.add(e1);
        nakhon.kuchak.add(e2);
    }
    public void setArayesh()
    {
        //send query

        Emkanat e1=new Emkanat("روزانه",8000);
        Emkanat e2=new Emkanat("شبانه",7000);
        makeup.add(e1);
        makeup.add(e2);
    }
    public void setAbro()
    {
        //send query

        Emkanat e1=new Emkanat("تتو",10000);
        Emkanat e2=new Emkanat("اصلاح",9000);
        abro.add(e1);
        abro.add(e2);

    }
    public void setEplasion()
    {
        //send query

        Emkanat e1=new Emkanat("دست",5000);
        Emkanat e2=new Emkanat("پا",8000);
        eplasion.add(e1);
        eplasion.add(e2);
    }
    public List<Emkanat> getList(int daste,int size)
    {
        if((daste==0)&&(size==0))
            return hair.boland;
        else if((daste==0)&&(size==1))
            return hair.motavaset;
        else if((daste==0)&&(size==2))
            return hair.kuchak;
        if((daste==1)&&(size==0))
            return haircolor.boland;
        else if((daste==1)&&(size==1))
            return haircolor.motavaset;
        else if((daste==1)&&(size==2))
            return haircolor.kuchak;
        if((daste==2))
            return makeup;
        else if((daste==3))
            return abro;
        if((daste==4)&&(size==0))
            return nakhon.boland;
        else if((daste==4)&&(size==1))
            return nakhon.motavaset;
        else if((daste==4)&&(size==2))
            return nakhon.kuchak;
        else if((daste==5))
            return eplasion;
        return null;

    }
    public void seteverything()
    {
        setEmkanatmoboland();
        setEmkanatmomotavaset();
        setEmkanatmokuchak();
        setEmkanathaircolorboland();
        setEmkanathaircolormotavaset();
        setEmkanathaircolorkuchak();
        setEmkanatnakhonboland();
        setEmkanatnakhonmotavaset();
        setEmkanatnakhonkuchak();
        seteplasion();
        setmakeup();
        setabro();

    }
    
    public void setEmkanatmoboland()
    {
        JSONObject jsonObject=null;
        JSONObject jmo;
        int i=0;
        try {
            jmo=jsonObject.getJSONObject("mo0");
            while(jmo!=null)
            {
                Emkanat b=new Emkanat(jmo.getString("id"), jmo.getString("name") , jmo.getInt("cost") , jmo.getString("url") );
                hair.boland.add(b);
                i++;
                jmo=jsonObject.getJSONObject("mo"+i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void setEmkanatmomotavaset()
    {
        JSONObject jsonObject=null;
        JSONObject jmo;
        int i=0;
        try {
            jmo=jsonObject.getJSONObject("mo0");
            while(jmo!=null)
            {
                Emkanat b=new Emkanat(jmo.getString("id"), jmo.getString("name") , jmo.getInt("cost") , jmo.getString("url") );
                hair.motavaset.add(b);
                i++;
                jmo=jsonObject.getJSONObject("mo"+i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void setEmkanatmokuchak()
    {
        JSONObject jsonObject=null;
        JSONObject jmo;
        int i=0;
        try {
            jmo=jsonObject.getJSONObject("mo0");
            while(jmo!=null)
            {
                Emkanat b=new Emkanat(jmo.getString("id"), jmo.getString("name") , jmo.getInt("cost") , jmo.getString("url") );
                hair.kuchak.add(b);
                i++;
                jmo=jsonObject.getJSONObject("mo"+i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void setEmkanathaircolorboland()
    {
        JSONObject jsonObject=null;
        JSONObject jhaircolor;
        int i=0;
        try {
            jhaircolor=jsonObject.getJSONObject("haircolor0");
            while(jhaircolor!=null)
            {
                Emkanat b=new Emkanat(jhaircolor.getString("id"), jhaircolor.getString("name") , jhaircolor.getInt("cost") , jhaircolor.getString("url") );
                haircolor.boland.add(b);
                i++;
                jhaircolor=jsonObject.getJSONObject("haircolor"+i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void setEmkanathaircolormotavaset()
    {
        JSONObject jsonObject=null;
        JSONObject jhaircolor;
        int i=0;
        try {
            jhaircolor=jsonObject.getJSONObject("haircolor0");
            while(jhaircolor!=null)
            {
                Emkanat b=new Emkanat(jhaircolor.getString("id"), jhaircolor.getString("name") , jhaircolor.getInt("cost") , jhaircolor.getString("url") );
                haircolor.motavaset.add(b);
                i++;
                jhaircolor=jsonObject.getJSONObject("haircolor"+i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void setEmkanathaircolorkuchak()
    {
        JSONObject jsonObject=null;
        JSONObject jhaircolor;
        int i=0;
        try {
            jhaircolor=jsonObject.getJSONObject("haircolor0");
            while(jhaircolor!=null)
            {
                Emkanat b=new Emkanat(jhaircolor.getString("id"), jhaircolor.getString("name") , jhaircolor.getInt("cost") , jhaircolor.getString("url") );
                haircolor.kuchak.add(b);
                i++;
                jhaircolor=jsonObject.getJSONObject("haircolor"+i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void setEmkanatnakhonboland()
    {
        JSONObject jsonObject=null;
        JSONObject jnakhon;
        int i=0;
        try {
            jnakhon=jsonObject.getJSONObject("nakhon0");
            while(jnakhon!=null)
            {
                Emkanat b=new Emkanat(jnakhon.getString("id"), jnakhon.getString("name") , jnakhon.getInt("cost") , jnakhon.getString("url") );
                nakhon.boland.add(b);
                i++;
                jnakhon=jsonObject.getJSONObject("nakhon"+i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void setEmkanatnakhonmotavaset()
    {
        JSONObject jsonObject=null;
        JSONObject jnakhon;
        int i=0;
        try {
            jnakhon=jsonObject.getJSONObject("nakhon0");
            while(jnakhon!=null)
            {
                Emkanat b=new Emkanat(jnakhon.getString("id"), jnakhon.getString("name") , jnakhon.getInt("cost") , jnakhon.getString("url") );
                nakhon.motavaset.add(b);
                i++;
                jnakhon=jsonObject.getJSONObject("nakhon"+i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void setEmkanatnakhonkuchak()
    {
        JSONObject jsonObject=null;
        JSONObject jnakhon;
        int i=0;
        try {
            jnakhon=jsonObject.getJSONObject("nakhon0");
            while(jnakhon!=null)
            {
                Emkanat b=new Emkanat(jnakhon.getString("id"), jnakhon.getString("name") , jnakhon.getInt("cost") , jnakhon.getString("url") );
                nakhon.kuchak.add(b);
                i++;
                jnakhon=jsonObject.getJSONObject("nakhon"+i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void seteplasion()
    {
        JSONObject jsonObject=null;
        JSONObject jeplasion;
        int i=0;
        try {
            jeplasion=jsonObject.getJSONObject("eplasion0");
            while(jeplasion!=null)
            {
                Emkanat b=new Emkanat(jeplasion.getString("id"), jeplasion.getString("name") , jeplasion.getInt("cost") , jeplasion.getString("url") );
                eplasion.add(b);
                i++;
                jeplasion=jsonObject.getJSONObject("eplasion"+i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void setabro()
    {
        JSONObject jsonObject=null;
        JSONObject jabro;
        int i=0;
        try {
            jabro=jsonObject.getJSONObject("abro0");
            while(jabro!=null)
            {
                Emkanat b=new Emkanat(jabro.getString("id"), jabro.getString("name") , jabro.getInt("cost") , jabro.getString("url") );
                abro.add(b);
                i++;
                jabro=jsonObject.getJSONObject("abro"+i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void setmakeup()
    {
        JSONObject jsonObject=null;
        JSONObject jmakeup;
        int i=0;
        try {
            jmakeup=jsonObject.getJSONObject("makeup0");
            while(jmakeup!=null)
            {
                Emkanat b=new Emkanat(jmakeup.getString("id"), jmakeup.getString("name") , jmakeup.getInt("cost") , jmakeup.getString("url") );
                makeup.add(b);
                i++;
                jmakeup=jsonObject.getJSONObject("makeup"+i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
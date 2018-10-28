package com.example.hesi100.barber_women;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hesi100 on 3/16/2018.
 */

public class Reservation {
    String idreserve;
    String idbarber;
    String hair;
    String haircolor;
    String nakhon;
    String makeup;
    String abro;
    String eplasion;
    String comment;
    String status;
    Barber barber;
    int puan;
    int cost;
    Reservation( String idreserve,String idbarber,String status)
    {
        this.idreserve=idreserve;
        this.idbarber=idbarber;
        this.status=status;
        //findbarber();

    }
    public void setBarber(String id,Barber barber)
    {
        this.barber=barber;
    }
    public void findbarber()  {
        JSONObject jsonObject=null;
        try {
            barber = new Barber(idbarber, jsonObject.getString("shop"), jsonObject.getString("address"), jsonObject.getString("takhfif"),jsonObject.getBoolean("isfavorite"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void setOtherReserv() {
        JSONObject jsonObject = null;
        try {
            idbarber = jsonObject.getString("idbarber");
            idreserve = jsonObject.getString("idreserve");
            status = jsonObject.getString("status");
            hair = (jsonObject.getString("mo"));
             hair=jsonObject.getString("hair");
             haircolor=jsonObject.getString("haircolor");
             nakhon=jsonObject.getString("nakhon");
             makeup=jsonObject.getString("makeup");
             abro=jsonObject.getString("abro");
             eplasion=jsonObject.getString("eplasion");
            puan = Integer.parseInt(jsonObject.getString("puan"));
            cost = Integer.parseInt(jsonObject.getString("cost"));
        } catch (JSONException e) {
            e.printStackTrace();

        }
        // Return new object

    }
    public void setOthers(String idreserve)
    {
         hair="شینیون";
         haircolor="خارجی";
         nakhon="گلی ";
         makeup=" روزانه";
         abro="تتو";
         eplasion="---";
         comment=" عالی بود";
         puan=4;
         cost=19000;
    }
}

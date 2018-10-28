package com.example.hesi100.barber_women;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;
import com.zarinpal.ewallets.purchase.OnCallbackRequestPaymentListener;
import com.zarinpal.ewallets.purchase.OnCallbackVerificationPaymentListener;
import com.zarinpal.ewallets.purchase.PaymentRequest;
import com.zarinpal.ewallets.purchase.ZarinPal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static com.example.hesi100.barber_women.R.id.puan;

public class barber_reserve extends AppCompatActivity {
    TextView price;
    int x=0;
    Barber barber;
    int position;
    RecyclerView comments;
    TextView puans;
    TextView users;
    TextView fulladdress;
    TextView shop;
    TextView barberoff;
    TextView date;
    CheckBox boland;
    CheckBox motavaset;
    CheckBox kutah;
    LinearLayout[] options;
    LinearLayout select_andaze;
    ImageView favorite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barber_reserve);
        Setting_person.setTheme((LinearLayout) findViewById(R.id.background));
        favorite= (ImageView) findViewById(R.id.favorite);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        position=0;
        options= new LinearLayout[6];
        options[0]= (LinearLayout) findViewById(R.id.hair);
        options[1]= (LinearLayout) findViewById(R.id.haircolor);
        options[2]= (LinearLayout) findViewById(R.id.makeup);
        options[3]= (LinearLayout) findViewById(R.id.abro);
        options[4]= (LinearLayout) findViewById(R.id.naxon);
        options[5]= (LinearLayout) findViewById(R.id.eplasion);
        boland= (CheckBox) findViewById(R.id.bolnad);
        motavaset= (CheckBox) findViewById(R.id.motavaset);
        motavaset.setChecked(true);
        kutah= (CheckBox) findViewById(R.id.kutah);
        select_andaze= (LinearLayout) findViewById(R.id.select_andaze);
        shop= (TextView) findViewById(R.id.barbername);
        price= (TextView) findViewById(R.id.price);
        users= (TextView) findViewById(R.id.users);
        barberoff= (TextView) findViewById(R.id.barberoff);
        date= (TextView) findViewById(R.id.date_reserve);
        getcomments();
        final ImageView favorite=(ImageView) findViewById(R.id.favorite);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        ImageView im= (ImageView) findViewById(R.id.navigation);
        final DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.barber_reserve);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                    mDrawerLayout.closeDrawer(Gravity.RIGHT);
                } else {
                    mDrawerLayout.openDrawer(Gravity.RIGHT);
                }
            }
        });
        fulladdress= (TextView) findViewById(R.id.fulladdress);
        puans=(TextView) findViewById(puan);
        price.setText( ""+x);
        String id= b.getString("id","");
        String shopname=  b.getString("shop");
        String shahr=b.getString("shahr");
        String mahalle=b.getString("mahalle");
        String takhfif=b.getString("takhfif");
        boolean isfavorite=b.getBoolean("isfavorite");
        barber =new Barber(id,shopname,shahr,takhfif,isfavorite);
        barber.setother();
        setAdap(position,barber.hair.b,barber.hair.m,barber.hair.k);
        if(isfavorite)
        {
            favorite.setImageResource(R.drawable.star1);
            favorite.setTag("star1");
        }
        barberoff.setText(barber.takhfif);
        shop.setText(barber.shop);
        if (barber.user!=0)
        {
            users.setText(""+barber.user);
            float puan=barber.puan;
            puans.setText(""+puan);
            if (puan>4)
            {
                puans.setTextColor(getResources().getColor(R.color.perfect));
            }
            else if(puan>3)
            {
                puans.setTextColor(getResources().getColor(R.color.nice));
            }
            else if(puan>2)
            {
                puans.setTextColor(getResources().getColor(R.color.average));
            }
            else if(puan>1)
            {
                puans.setTextColor(getResources().getColor(R.color.bad));
            }
            else
            {
                puans.setTextColor(getResources().getColor(R.color.terrible));
            }

        }
        String address=barber.address;
        address=" آدرس کامل : "+address;
        fulladdress.setText(address);
        favorite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String backgroundImageName = String.valueOf(favorite.getTag());
                if(backgroundImageName.equals("star1"))
                {

                    favorite.setImageResource(R.drawable.star2);
                    favorite.setTag("star2");

                }
                else
                {
                    favorite.setImageResource(R.drawable.star1);
                    favorite.setTag("star1");
                }
            }

        });




        final ImageView back= (ImageView) findViewById(R.id.finish);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        settoday();
        Uri data =getIntent().getData();
        ZarinPal.getPurchase(this).verificationPayment(data, new OnCallbackVerificationPaymentListener() {
            @Override
            public void onCallbackResultVerificationPayment(boolean isPaymentSuccess, String refID, PaymentRequest paymentRequest) {
                if(isPaymentSuccess)
                {

                }
            }
        });

    }
    public void getcomments()
    {
        List<comment> list=getcomment();
        comments= (RecyclerView) findViewById(R.id.comments);
        final adapter_comment adapter = new adapter_comment(getApplicationContext(),list);
        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(getApplicationContext());
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        comments.setLayoutManager(mLinearLayoutManagerVertical);
        comments.setAdapter(adapter);
        final ImageView back= (ImageView) findViewById(R.id.finish);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public List<comment> getcomment()
    {
        List<comment> list=new ArrayList<>();
        comment a0=new comment("hesi100"," عالی بود","2017/6/23");
        comment a1=new comment("hesi200"," خوب بود","2017/6/28");
        list.add(a0);
        list.add(a1);
        //sendquery
        return list;
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    public void settime(View v) {
        // TODO Auto-generated method stub

        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(barber_reserve.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                String minute;
                if(selectedMinute<10)
                {
                    minute="0"+selectedMinute;
                }
                else
                {
                    minute=""+selectedMinute;
                }

                String s=""+selectedHour+" : "+minute;
                TextView t= (TextView) findViewById(R.id.time_reserve);
                t.setText(s);

            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("زمان خود را انتخاب کنید.");
        mTimePicker.show();

    }
    public void setdate(View view)
    {
        final PersianCalendar now = new PersianCalendar();
        final DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() {
                                                                                   @Override
                                                                                   public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                                                                                       Toast.makeText(getApplicationContext(), "" + year + "/" + monthOfYear + "/" + dayOfMonth, Toast.LENGTH_SHORT).show();
                                                                                       String dat="" + year + "/" + monthOfYear + "/" + dayOfMonth;
                                                                                       date.setText(dat);
                                                                                   }
                                                                               }, now.getPersianYear(),
                now.getPersianMonth(),
                now.getPersianDay());
        datePickerDialog.setThemeDark(true);
        datePickerDialog.show(getFragmentManager(), "tpd");
        datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                Log.d("TimePicker", "Dialog was cancelled");
            }
        });

    }
    public void settoday()
    {
        final PersianCalendar now = new PersianCalendar();
        int mYear = now.getPersianYear();
        int mMonth = now.getPersianMonth()+1;
        int mDay = now.getPersianDay();
        date.setText("" + mYear + "/" + mMonth + "/" + mDay);

    }
    public void selectit(View v)
    {
        int i;
        int t=Integer.parseInt(v.getTag().toString());
        for (i=0;i<6;i++)
        {
            options[i].setBackground(getResources().getDrawable(R.drawable.select));
        }
        options[t].setBackground(getResources().getDrawable(R.drawable.selected));
        if((t==0)||(t==1)||(t==4))
        {
            select_andaze.setVisibility(View.VISIBLE);

        }
        else
            select_andaze.setVisibility(View.GONE);
        int id = v.getId();
        switch (id)
        {
            case R.id.hair :
                barber.hair.setcheckbox(boland,motavaset,kutah);
                setAdap(t,barber.hair.b,barber.hair.m,barber.hair.k);
                position=t;
                break;
            case R.id.haircolor :
                barber.haircolor.setcheckbox(boland,motavaset,kutah);
                setAdap(t,barber.haircolor.b,barber.haircolor.m,barber.haircolor.k);
                position=t;
                break;
            case R.id.makeup :
                position=t;
                setAdap(t,false,false,false);
                break;
            case R.id.abro :
                setAdap(t,false,false,false);
                position=t;
                break;
            case R.id.naxon :
                barber.nakhon.setcheckbox(boland,motavaset,kutah);
                setAdap(t,barber.nakhon.b,barber.nakhon.m,barber.nakhon.k);
                position=t;
                break;
            case R.id.eplasion :
                setAdap(t,false,false,false);
                position=t;
                break;
        }

    }
    public void setsize(View v)
    {
        x=Integer.parseInt(price.getText().toString());
        int size=Integer.parseInt(v.getTag().toString());
        boolean b = false;
        boolean m=false;
        boolean k = false;
        if(size==0) {b=true; m=false; k=false;}
        if(size==1) {m=true; b=false; k=false;}
        if(size==2) {k=true; m=false; b=false;}
        if(boland.isChecked()|| motavaset.isChecked() || kutah.isChecked()) {
            switch (position) {
                case 0:
                    x=barber.hair.unset(x);
                    price.setText(""+x);
                    barber.hair.setsize(size);
                    setAdap(position, b, m, k);
                    break;
                case 1:
                    x=barber.haircolor.unset(x);
                    price.setText(""+x);
                    barber.haircolor.setsize(size);
                    setAdap(position, b, m, k);
                    break;
                case 2:
                    setAdap(position, false, false, false);
                    break;
                case 3:
                    setAdap(position, false, false, false);
                    break;
                case 4:
                    x=barber.nakhon.unset(x);
                    price.setText(""+x);
                    barber.nakhon.setsize(size);
                    setAdap(position, b, m, k);
                    break;
                case 5:
                    setAdap(position, false, false, false);
                    break;
            }


        }
        else
        {
            x=Integer.parseInt(price.getText().toString());
            switch (position) {
                case 0:
                    barber.hair.setsize(-1);
                    x=barber.hair.unset(x);
                    break;
                case 1:

                    barber.haircolor.setsize(-1);
                    x=barber.haircolor.unset(x);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    barber.nakhon.setsize(-1);
                    x=barber.nakhon.unset(x);
                    break;
                case 5:

                    break;
            }
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.select_service);
            recyclerView.setVisibility(View.GONE);
            price.setText(""+x);
        }
        if(size==0)
        {
            motavaset.setChecked(false);
            kutah.setChecked(false);
        }
        else if(size==1)
        {
            boland.setChecked(false);
            kutah.setChecked(false);
        }
        else
        {
            motavaset.setChecked(false);
            boland.setChecked(false);
        }

    }
   public void setAdap(int t,boolean b,boolean m,boolean k)
   {
       int a=-1;
       if(b) {
           a = 0;

       }
       if(m) {
           a = 1;

       }
       if(k) {
           a = 2;

       }

           List<Emkanat> emkanats = barber.getList(t , a);
           x = Integer.parseInt(price.getText().toString());
           RecyclerView recyclerView = (RecyclerView) findViewById(R.id.select_service);
           recyclerView.setVisibility(View.VISIBLE);
           final adapter_emkanats adapter = new adapter_emkanats(getApplicationContext(), emkanats, price, x);
           LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(getApplicationContext());
           mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
           recyclerView.setLayoutManager(mLinearLayoutManagerVertical);
           recyclerView.setAdapter(adapter);

   }
    @Override
    protected void onResume() {
        super.onResume();
        Setting_person.setTheme((LinearLayout) findViewById(R.id.background));
    }
    public void pay(View v)
    {
        if(Internet.isInternetOn()) {
            ZarinPal purchase = ZarinPal.getPurchase(this);
            PaymentRequest payment = ZarinPal.getPaymentRequest();

            // payment.setMerchantID();
            payment.setAmount(x);//100 tuman
            payment.setDescription(" پرداخت برای رزرو");
            payment.setCallbackURL("return://zarinpalpayment");
            purchase.startPayment(payment, new OnCallbackRequestPaymentListener() {
                @Override
                public void onCallbackResultPaymentRequest(int status, String authority, Uri paymentGatewayUri, Intent intent) {
                    if (status == 100) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(barber_reserve.this, "nashod", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else
        {
            Toast.makeText(this, "لطفا اینترنت خود را باز کنید", Toast.LENGTH_SHORT).show();
        }
    }
    public void see_reserves(View v)
    {
        Intent intent = new Intent(this, seereserve_time.class);
        startActivity(intent);
    }
    public void see_comments(View v)
    {
        Intent intent = new Intent(this, fullcomennt_barber.class);
        startActivity(intent);
    }

}
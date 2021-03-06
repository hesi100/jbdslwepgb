package com.example.hesi100.barber_women;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class main extends AppCompatActivity {
    Spinner search;
    TextView searchby;
    LinearLayout l1;
    LinearLayout l2;
    LinearLayout l3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Setting_person.setTheme((LinearLayout) findViewById(R.id.background));
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        final ImageView favorite=(ImageView) findViewById(R.id.favorite);
        l1= (LinearLayout) findViewById(R.id.litab1);
        l2= (LinearLayout) findViewById(R.id.litab2);
        l3= (LinearLayout) findViewById(R.id.litab3);
        ImageView im= (ImageView) findViewById(R.id.navigation);
        final DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
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

        searchby= (TextView) findViewById(R.id.searchby);
        search = (Spinner)findViewById(R.id.search);
        ArrayAdapter<String> spinneradapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.searchby));
        search.setAdapter(spinneradapter);
        search.setPrompt(" نوع جستجو خود را انتخاب کنید ");
        search.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String s;
                search.getSelectedItem().toString();
                s= " جستجو بر اساس نام "+search.getSelectedItem().toString()+" ...";
                searchby.setHint(s);

            }
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
        List<Barber> list=getbarbers();
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.Recycle);
        final adapter adapter = new adapter(getApplicationContext(),list);
        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(getApplicationContext());
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayoutManagerVertical);
        recyclerView.setAdapter(adapter);
        final ImageView home= (ImageView) findViewById(R.id.tabhome);
        final ImageView discount= (ImageView) findViewById(R.id.tabdiscount);
        final ImageView tabfavorite= (ImageView) findViewById(R.id. tabfavorite);
        final LinearLayout tab1= (LinearLayout) findViewById(R.id.tab1);
        final LinearLayout tab2= (LinearLayout) findViewById(R.id.tab2);
        final LinearLayout tab3= (LinearLayout) findViewById(R.id.tab3);
        final LinearLayout litab1= (LinearLayout) findViewById(R.id.litab1);
        final LinearLayout litab2= (LinearLayout) findViewById(R.id.litab2);
        final LinearLayout litab3= (LinearLayout) findViewById(R.id.litab3);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                litab1.setBackground(getResources().getDrawable(R.drawable.tabselected));
                litab2.setBackground(getResources().getDrawable(R.drawable.tabs));
                litab3.setBackground(getResources().getDrawable(R.drawable.tabs));
                home.setImageResource(R.drawable.home1);
                discount.setImageResource(R.drawable.discount);
                tabfavorite.setImageResource(R.drawable.tabstar);
                tab1.setVisibility(View.VISIBLE);
                tab2.setVisibility(View.INVISIBLE);
                tab3.setVisibility(View.INVISIBLE);
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                litab1.setBackground(getResources().getDrawable(R.drawable.tabs));
                litab2.setBackground(getResources().getDrawable(R.drawable.tabselected));
                litab3.setBackground(getResources().getDrawable(R.drawable.tabs));
                home.setImageResource(R.drawable.home2);
                discount.setImageResource(R.drawable.discount1);
                tabfavorite.setImageResource(R.drawable.tabstar);
                tab1.setVisibility(View.INVISIBLE);
                tab2.setVisibility(View.VISIBLE);
                tab3.setVisibility(View.INVISIBLE);
            }
        });
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                litab1.setBackground(getResources().getDrawable(R.drawable.tabs));
                litab2.setBackground(getResources().getDrawable(R.drawable.tabs));
                litab3.setBackground(getResources().getDrawable(R.drawable.tabselected));
                home.setImageResource(R.drawable.home2);
                discount.setImageResource(R.drawable.discount);
                tabfavorite.setImageResource(R.drawable.tabstar1);
                tab1.setVisibility(View.INVISIBLE);
                tab2.setVisibility(View.INVISIBLE);
                tab3.setVisibility(View.VISIBLE);
            }
        });
        final ImageView back= (ImageView) findViewById(R.id.finish);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public List<Barber> getbarbers()
    {
        List<Barber> list=new ArrayList<>();

        Barber a0=new Barber("1","سعید" ," تبریز منجم"," 10%",false);
        Barber a1=new Barber("2","اکبر" ," تبریز یکه دکان"," 15%",false);
        list.add(a0);
        list.add(a1);
        //sendquery
        return list;
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    @Override
    protected void onResume() {
        super.onResume();
        Setting_person.setTheme((LinearLayout) findViewById(R.id.background));
    }

}




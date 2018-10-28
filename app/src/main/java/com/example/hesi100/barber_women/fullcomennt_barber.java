package com.example.hesi100.barber_women;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class fullcomennt_barber extends AppCompatActivity {
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullcomennt_barber);

        recycler=(RecyclerView) findViewById(R.id.recycler_comment);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        //  String id=b.getString("idbarber"); \
        // send request
        final adapter_comment adapter = new adapter_comment(getApplicationContext(),getcomment());
        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(getApplicationContext());
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(mLinearLayoutManagerVertical);
        recycler.setAdapter(adapter);
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
}



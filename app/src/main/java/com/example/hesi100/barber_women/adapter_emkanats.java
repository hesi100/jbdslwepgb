package com.example.hesi100.barber_women;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hesi100 on 12/15/2017.
 */

public class adapter_emkanats extends RecyclerView.Adapter<adapter_emkanats.myViewHolder> {
    Context context;
    List<Emkanat> emkanats;
    TextView p;
    int xp;
    public adapter_emkanats(Context context,List<Emkanat> b,TextView price,int x)
    {
        emkanats=b;
        this.context=context;
        p=price;
        xp=x;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_service, parent  , false);
        return new adapter_emkanats.myViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(final adapter_emkanats.myViewHolder holder, final int position) {
        holder.service.setText(emkanats.get(position).name);
        holder.cost.setText(""+emkanats.get(position).cost);
        holder.check.setChecked(emkanats.get(position).selected);

        final CheckBox c=holder.check;
        holder.check.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                emkanats.get(position).selected = c.isChecked();
                if(c.isChecked())
                {
                    emkanats.get(position).selected=true;
                    xp+=emkanats.get(position).cost;
                    p.setText( ""+xp);
                }
                else
                {
                    emkanats.get(position).selected=false;
                    xp-=emkanats.get(position).cost;
                    p.setText( ""+xp);
                }
            }

        });



    }
    public int getItemCount() {
        return emkanats.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder
    {
        TextView service;
        TextView cost;
        CheckBox check;
        myViewHolder(View itemView) {

            super(itemView);
            service= (TextView) itemView.findViewById(R.id.service);
            cost=(TextView) itemView.findViewById(R.id.cost);
            check= (CheckBox) itemView.findViewById(R.id.check);
        }
    }


}

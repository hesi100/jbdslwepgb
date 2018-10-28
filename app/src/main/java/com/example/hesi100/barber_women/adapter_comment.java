package com.example.hesi100.barber_women;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hesi100 on 12/15/2017.
 */

public class adapter_comment extends RecyclerView.Adapter<adapter_comment.myViewHolder> {
    Context context;
    List<comment> comments;

    public adapter_comment(Context context,List<comment> b)
    {
        comments=b;
        this.context=context;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_commnet, parent  , false);
        return new adapter_comment.myViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(adapter_comment.myViewHolder holder, final int position) {
        holder.date.setText(comments.get(position).date);
        holder.username.setText(comments.get(position).username);
        holder.commenttext.setText(comments.get(position).nazar);
    }
    public int getItemCount() {
        return comments.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder
    {
        TextView date;
        TextView username;
        TextView commenttext;
        myViewHolder(View itemView) {

            super(itemView);
            date= (TextView) itemView.findViewById(R.id.date);
            username=(TextView) itemView.findViewById(R.id.username);
            commenttext=(TextView) itemView.findViewById(R.id.comment);

        }
    }
}

package com.tistory.coderkoo.androideigen.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tistory.coderkoo.androideigen.R;
import com.tistory.coderkoo.androideigen.model.EigenOperation;

import java.util.ArrayList;

/**
 * Created by koohanmo on 2017-01-31.
 */

public class EigenRecyclerAdapter extends RecyclerView.Adapter{

    private Context mcon;
    private ArrayList<EigenOperation> dataSet;

    public EigenRecyclerAdapter(Context mcon, ArrayList<EigenOperation> dataSet){
        this.mcon=mcon;
        this.dataSet=dataSet;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_recycler,parent,false);
        EigenViewHolder holder = new EigenViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        EigenViewHolder ev = (EigenViewHolder)holder;
        ev.txt_title.setText(dataSet.get(position).getOp());
        ev.txt_desc.setText(dataSet.get(position).getDesc());
        ev.setOnclickView(dataSet.get(position).getmClass());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    private class EigenViewHolder extends RecyclerView.ViewHolder{
        private View itemView;
        private AppCompatTextView txt_title;
        private TextView txt_desc;

        public EigenViewHolder(View itemView) {
            super(itemView);
            this.itemView=itemView;
            this.txt_title = (AppCompatTextView)itemView.findViewById(R.id.item_opname);
            this.txt_desc = (TextView)itemView.findViewById(R.id.item_desc);
        }

        public void setOnclickView(final Class<?> mClass){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(mcon,mClass);
                    mcon.startActivity(i);
                }
            });
        }
    }
}

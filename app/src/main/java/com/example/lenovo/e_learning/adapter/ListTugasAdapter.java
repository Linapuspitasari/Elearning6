package com.example.lenovo.e_learning.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.e_learning.R;
import com.example.lenovo.e_learning.model.SemuatugasItem;

import java.util.List;

/**
 * Created by Lenovo on 11/12/2018.
 */

public class ListTugasAdapter extends RecyclerView.Adapter<ListTugasAdapter.CategoryViewHolder>{

    private Context context;

    List<SemuatugasItem> semuatugasItemList;

    public ListTugasAdapter(Context context, List<SemuatugasItem> tugasList) {
        this.context = context;
        semuatugasItemList = tugasList;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tugas, parent, false);
        CategoryViewHolder vHolder = new CategoryViewHolder(itemRow);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        final SemuatugasItem semuatugasItem = semuatugasItemList.get(position);
        holder.tvName.setText(semuatugasItem.getDosen());
        holder.tvMakul.setText(semuatugasItem.getMakul());
        holder.tvJudul.setText(semuatugasItem.getJudul());

        Glide.with(context)
                .load(semuatugasItem.getFoto())
                .override(55, 55)
                .crossFade()
                .into(holder.imgPhoto);

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Intent tugasIntent = new Intent(context, DetailTugasActivity.class);
               // tugasIntent.putExtra(DetailTugasActivity.EXTRA_ID, semuatugasItem.getId());
               // context.startActivities(new Intent[]{tugasIntent});
            }
        });

    }

    @Override
    public int getItemCount() {
        return semuatugasItemList.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvJudul;
        TextView tvMakul;
        ImageView imgPhoto, imgPhotos;
        private Button btnDetail;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.textView8);
            tvJudul = itemView.findViewById(R.id.textView10);
            tvMakul = (TextView)itemView.findViewById(R.id.textView9);
            imgPhoto = (ImageView)itemView.findViewById(R.id.imageView);
        }
    }
}



package com.jiaoniban.client.model.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jiaoniban.client.R;
import com.jiaoniban.client.activity.ContentActivity;
import com.jiaoniban.client.model.base.BaseDescType;

import java.util.ArrayList;

public class DescAdapter extends RecyclerView.Adapter <DescAdapter.DescViewHolder> {
    private Context mContext;
    private ArrayList<BaseDescType> descList;

    public DescAdapter(Context context,ArrayList<BaseDescType> descList){
        this.mContext=context;
        this.descList=descList;
    }

    private String parseAuthor(String author){
        Log.d(author, "parseAuthor: ");
        if(author.equals("dean")){
            return "教务处";
        }
        return "null";
    }

    @NonNull
    @Override
    public DescViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DescViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_rv_desc_item,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DescViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(descList.get(position).getTitle());
        holder.author.setText(parseAuthor(descList.get(position).getAuthor()));
        holder.date.setText(descList.get(position).getDate());
        holder.text.setText(descList.get(position).getDesc());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, ContentActivity.class);
                intent.putExtra("opt",descList.get(position).getAuthor());
                intent.putExtra("id",descList.get(position).getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return descList.size();
    }

    class DescViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView author;
        private TextView date;
        private TextView text;
        public DescViewHolder(View itemView){
            super(itemView);
            title=itemView.findViewById(R.id.tv_desc_title);
            author=itemView.findViewById(R.id.tv_desc_author);
            date=itemView.findViewById(R.id.tv_desc_date);
            text=itemView.findViewById(R.id.tv_desc_txt);
        }
    }

}

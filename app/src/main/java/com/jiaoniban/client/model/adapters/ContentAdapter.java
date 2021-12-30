package com.jiaoniban.client.model.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.jiaoniban.client.R;
import org.jetbrains.annotations.NotNull;

public class ContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private String[] contentList;
    private Context context;

    private enum ViewType{
        IMAGE,STRING,TABLE
    }

    public ContentAdapter(String[] contentList, Context context) {
        this.contentList = contentList;
        this.context = context;
    }

    private int judgeViewType(String str){
        if(str.startsWith("([")){
            String[] tmp=str.split(".");
            if(tmp.length==1) return ViewType.STRING.ordinal();
            if(tmp[1]=="jpeg"||tmp[1]=="png"||tmp[1]=="jpg") return ViewType.IMAGE.ordinal();
        }
        return ViewType.STRING.ordinal();
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        if(viewType==ViewType.STRING.ordinal()){
            return new TextViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_rv_content_tv,parent,false));
        }else{
            return new ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_rv_content_imgv,parent,false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        return judgeViewType(contentList[position]);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        int t=holder.getItemViewType();
        if(t==ViewType.STRING.ordinal()){
            TextViewHolder h=(TextViewHolder)holder;
            h.subtext.setText(contentList[position]);
        }
        if(t==ViewType.IMAGE.ordinal()){
          ImageViewHolder h=(ImageViewHolder)holder;
          int len=contentList[position].length();
          String fn=contentList[position].substring(2,len-2);
          String url=String.format("%s/%s",context.getString(R.string.server),fn);
          Glide.with(context).load(url).into(h.subimage);
        }
    }

    @Override
    public int getItemCount() {
        return contentList.length;
    }


    class TextViewHolder extends RecyclerView.ViewHolder{
        private TextView subtext;
        public TextViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            subtext=itemView.findViewById(R.id.tv_content);
        }
    }

    class ImageViewHolder extends RecyclerView.ViewHolder{
        private ImageView subimage;
        public ImageViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            subimage=itemView.findViewById(R.id.imgv_content);
        }
    }

}

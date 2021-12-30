package com.jiaoniban.client.activity;

import android.content.Intent;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jiaoniban.client.R;
import com.jiaoniban.client.model.adapters.ContentAdapter;
import com.jiaoniban.client.model.parsers.JSONParser;
import com.jiaoniban.client.model.requesters.CourseRequester;

public class ContentActivity extends AppCompatActivity {

    private RecyclerView mRvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        Intent intent = getIntent();
        String opt=intent.getStringExtra("opt");
        String id=intent.getStringExtra("id");
        String content=CourseRequester.getContentJSON(this.getString(R.string.server),opt,id);
        String[] contentList=JSONParser.parseContent(content).getBody().split("\n");
        mRvContent=findViewById(R.id.rv_content);
        if(mRvContent==null){
            Log.d("NULL MRVCONTENT", "onCreate: ");
        }
        mRvContent.setLayoutManager(new LinearLayoutManager(ContentActivity.this));
        mRvContent.setAdapter(new ContentAdapter(contentList,this));
    }
}
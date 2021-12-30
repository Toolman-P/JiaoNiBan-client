package com.jiaoniban.client.activity;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jiaoniban.client.R;
import com.jiaoniban.client.controller.PushServiceController;
import com.jiaoniban.client.model.adapters.DescAdapter;
import com.jiaoniban.client.model.parsers.JSONParser;
import com.jiaoniban.client.model.requesters.CourseRequester;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRvMain;
    private PushServiceController pushServiceController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);
        String jsonRaw= CourseRequester.getLatestListJSON(this.getString(R.string.server));
        pushServiceController= new PushServiceController(MainActivity.this);
        pushServiceController.initPushService();
        String[] tags="STUDENT_ALL".split(" ");
        pushServiceController.registerTagRule(tags);

        mRvMain=findViewById(R.id.rv_desc);
        mRvMain.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRvMain.setAdapter(new DescAdapter(MainActivity.this, JSONParser.parseDescList(jsonRaw)));   //适配器
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
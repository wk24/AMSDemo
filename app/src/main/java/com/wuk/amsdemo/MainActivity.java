package com.wuk.amsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View viewById = findViewById(R.id.tv);
        viewById.setOnClickListener(v ->{
            //执行插桩
            Test test = new Test();
            test.test();
        });

    }

//    private void test() {
//        int a = 1;
//        int b = 2;
//        Log.e("TAG", "test: " + (a+b) );
//    }
}
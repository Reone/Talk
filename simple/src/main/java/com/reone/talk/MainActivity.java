package com.reone.talk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.reone.talklibrary.TalkApp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.toast).setOnClickListener(clickListener);
        findViewById(R.id.toast1).setOnClickListener(clickListener);
        findViewById(R.id.toast2).setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.toast:
                    TalkApp.talk(R.string.app_name);
                    break;
                case R.id.toast1:
                    TalkApp.talk("9527");
                    break;
                case R.id.toast2:
                    new Thread(){
                        @Override
                        public void run() {
                            TalkApp.talk("this is demo in thread");
                        }
                    }.start();
                    break;
            }
        }
    };
}

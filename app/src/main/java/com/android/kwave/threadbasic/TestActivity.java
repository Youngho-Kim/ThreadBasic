package com.android.kwave.threadbasic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TestActivity extends AppCompatActivity implements  View.OnClickListener{
    Button back,run10, runThread;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // 1. 버튼을 클릭하면 1부터 10만까지 출력하는 함수를 실행
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
        run10 = (Button) findViewById(R.id.run10);
        run10.setOnClickListener(this);
        runThread = (Button) findViewById(R.id.runThread);
        runThread.setOnClickListener(this);


        // 2. Thread 클래스에서 1부터 10만까지 출력하는 함수를 실행


        // 3. 위의 Thread 클래스 실행 순서를 1번과 바꿔서 실행


    }

    public void print100T(String caller){
        for(int i=0; i<100; i++){
            Log.i("Thread Test", caller+ "Current Number=========="+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(caller + "Current Nymber");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back :
                finish();
                break;
            case R.id.run10 :
                // 2. Thread 클래스에서 1부터 10만까지 출력하는 함수를 실행
                new LogThread().start();
                // 3. 위의 Thread 클래스 실행 순서를 1번과 바꿔서 실행
                new Thread(){
                @Override
                public void run() {
                    new LogThread().start();
                }
            };
                break;
            case R.id.runThread :
                // 2. Thread 클래스에서 1부터 10만까지 출력하는 함수를 실행
                print100T("SubThread ");
                // 3. 위의 Thread 클래스 실행 순서를 1번과 바꿔서 실행

                break;

        }

    }
    class LogThread extends Thread{
        @Override
        public void run() {
            count++;
            print100T("SubThread " + count);
        }
    }
}


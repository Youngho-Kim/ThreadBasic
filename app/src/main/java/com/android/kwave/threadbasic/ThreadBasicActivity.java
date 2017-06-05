package com.android.kwave.threadbasic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class ThreadBasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_basic);


        // 1.1 Thread 생성
        Thread thread = new Thread(){
            @Override
            public void run(){
                Log.i("Thread Test","Hello Thread");
            }
        };
        // 1.2 Thread 실행
        thread.start();

        // 2.1 Thread 생성
        Runnable thread2 = new Runnable() {
            @Override
            public void run() {
                Log.i("Thread Test","Hello Runnable");
            }
        };
        // 2.2 Thread 실행
        new Thread(thread2).start();


        CustomThread thread3 = new CustomThread();
        thread3.start();
        CustomRunnable thread4 = new CustomRunnable();
        new Thread(thread4).start();

    }
}

// 3.1 Thread 생성
class CustomThread extends Thread{
    @Override
    public void run() {
        Log.i("Thread Test","Hello Custom Thread");
    }
}

// 4.1 Thread 생성
class CustomRunnable implements Runnable{
    @Override
    public void run() {
        Log.i("Thread Test","Hello Custom Runnable");
    }
}
package com.android.kwave.threadbasic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class ThreadBasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_basic);
//        new Thread() {      // 코드가 있는 실제 클래스이기 때문에 실행할 수 있다.
//        new Runnable        // 껍데기만 있는 인터페이스로 new로 메모리에 로드가 안된다.
        // 1.1 Thread 생성하기
        Thread thread = new Thread() {      // 코드가 있는 실제 클래스이기 때문에 실행할 수 있다.
            @Override
            public void run() {
                Log.i("Thead Test", "Hello Thread");
            }
        };
        // 1.2 Thread 실행하기
        thread.start();     //run()함수를 실행시킴


        // 2.1 Thread Runnable 생성하기
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("Thread Runnable Test", "Hello Thread Runnable");
            }
        });
        // 2.2 Thread Runnable 실행하기
        thread1.start();

        Runnable thread4 = new Runnable() {
            @Override
            public void run() {

            }
        };
        new Thread(thread4).start();

        // 3.2 Custom Thread 실행하기
        CustomThread thread2 = new CustomThread();
        thread2.start();

        // 4.2 Custom Runnable 실행하기
        CustomRunnable thread3 = new CustomRunnable();
        thread3.start();
    }
}
    // 3.1 Custom Thread 생성하기
    class CustomThread extends Thread{
        @Override
        public void run() {
            Log.i("CustomThread Test", "Hello CustomThread");
        }
    }

    // 4.1 CustromRunnable 생성하기
    class CustomRunnable extends Thread implements Runnable{
        @Override
        public void run() {
            Log.i("CustomRunnable Test", "Hello CustomRunnable");
        }
    }

































//
//public class ThreadBasicActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_thread_basic);
//
//
//        // 1.1 Thread 생성
//        Thread thread = new Thread(){
//            @Override
//            public void run(){
//                Log.i("Thread Test","Hello Thread");
//            }
//        };
//        // 1.2 Thread 실행
//        thread.start();
//
//        // 2.1 Thread 생성
//        Runnable thread2 = new Runnable() {
//            @Override
//            public void run() {
//                Log.i("Thread Test","Hello Runnable");
//            }
//        };
//        // 2.2 Thread 실행
//        new Thread(thread2).start();
//
//
//        CustomThread thread3 = new CustomThread();
//        thread3.start();
//        CustomRunnable thread4 = new CustomRunnable();
//        new Thread(thread4).start();
//
//    }
//}
//
//// 3.1 Thread 생성
//class CustomThread extends Thread{
//    @Override
//    public void run() {
//        Log.i("Thread Test","Hello Custom Thread");
//    }
//}
//
//// 4.1 Thread 생성
//class CustomRunnable implements Runnable{
//    @Override
//    public void run() {
//        Log.i("Thread Test","Hello Custom Runnable");
//    }
//}
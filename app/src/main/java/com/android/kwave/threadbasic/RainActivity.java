package com.android.kwave.threadbasic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RainActivity extends AppCompatActivity {

    FrameLayout ground;
    Stage stage;
    Button button;
    int one = 0;
    int deviceWidth, deviceHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rain);

        ground = (FrameLayout) findViewById(R.id.stage);
        button = (Button) findViewById(R.id.button);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        deviceWidth = metrics.widthPixels;   // 스마트폰의 가로 사이즈
        deviceHeight = metrics.heightPixels;

        // 커스텀 뷰를 생성하고
        stage = new Stage(getBaseContext());

        // 레이아웃에 담아주면 화면에 커스텀뷰의 내용이 출력된다.
        ground.addView(stage);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(one == 0){

                    runTask();
                    one = 1;
                }
                else{
                    noRunTask();
                    one = 0;
                }
            }
        });

    }
    private void runTask(){     // 빗방울을 만드는 역할
        // 빗방울을 1초마다 1개씩 랜덤하게 생성
        Rain rain = new Rain();
        rain.start();
        // 화면을 1초에 1번씩 갱신
        DrawCanvas drawCanvas = new DrawCanvas();
        drawCanvas.start();
    }
    private void noRunTask(){     // 빗방울을 만드는 역할
        // 빗방울을 1초마다 1개씩 랜덤하게 생성
//        Rain rain = new Rain();
//        rain.interrupt();
        // 화면을 1초에 1번씩 갱신
        DrawCanvas drawCanvas = new DrawCanvas();
        drawCanvas.interrupt();
    }
    // 화면을 1초에  한번씩 그려주는 클래스(onDraw를 호출)
class DrawCanvas extends  Thread{
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stage.postInvalidate();
        }
    }
}
    // 빗방울을 만들어 주는 클래스
    class Rain extends Thread {
        @Override
        public void run() {
            // 특정 범위의 숫자를 랜덤하게 생성할 때 사용
            Random random = new Random();
            for(int j = 0; j<100; j++){
                //빗방울 하나 생성해서 stage에 더한다.
                RainDrop rainDrop = new RainDrop();
                rainDrop.radius = random.nextInt(20)+5;
                rainDrop.x = random.nextInt(deviceWidth);      //0부터 ~  디바이스 가로 사이즈 사이
                rainDrop.y = 0f;
                rainDrop.speed = random.nextInt(10) + 5;     // 초당 이동하는 픽셀 거리
                Paint paint = new Paint();
                 paint.setColor(Color.BLUE);
                rainDrop.paint = paint;

                // 생성한 빗방울을 stage에 넣어준다.
                stage.addRainDrop(rainDrop);

                // 생성한 빗방울을 동작시킨다.
                rainDrop.start();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    class Stage extends View {
        Paint paint;
        List<RainDrop> rainDrops = new ArrayList<>();
        public Stage(Context context) {     // 인자값으로 context을 받는 이유 : 시스템 자원을 사용하기 위해서
            super(context);
            paint = new Paint();
            paint.setColor(Color.BLUE);
        }

        // 화면에 로드되는 순간 호출되는 함수


        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            for(RainDrop drop : rainDrops){
                // canvas.drawCircle(x좌표, y좌표, 반지름, 컬러, 굵기 등);  단위는 pixel
                canvas.drawCircle(drop.x, drop.y, drop.radius, drop.paint);
            }
        }

        public void addRainDrop(RainDrop rainDrop) {
            this.rainDrops.add(rainDrop);
        }
    }

class RainDrop extends Thread{
    Paint paint; // 색깔
    float radius; // 크기
    float x, y; // 좌표
    int speed;  // 속도
    boolean run = true;
    @Override
    public void run() {
        int count = 0;
        while(y < deviceHeight){
            count++;
            y = count * speed;
            Log.i("RainDrop","y=============="+y);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        run = false;

    }
}


}

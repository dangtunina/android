package com.example.dangt.baitaptextchange;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    TextView tv;

    public void Start(View view) {
        tv=(TextView)findViewById(R.id.tv_start);
        Thread th = new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i=0;i<=65536;i++){
                    final int finali=i;
                    Log.i("VT",String.valueOf(i));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText(String.valueOf(finali));
                        }
                    });


                }
            }
        });
        th.start();

    }
int flag=0;
int frun=0;
int start=0;
    public void Start2(View view) throws InterruptedException {

        tv = (TextView) findViewById(R.id.tv_start);
        start=Integer.valueOf(tv.getText().toString());
        if(flag==0) {

             new Thread(myR).start();
           // Log.i("log","Stop1");
        }else{
          //  Log.i("log","Stop");
            if(flag%2!=0){
                frun=1;
                //Log.i("log","ko chia het 2");
            }else{
                frun=0;
                new Thread(myR).start();
               // Log.i("log","tiep tuc chay"+frun);
            }


        }
        flag++;
    }
    myRunnable myR=new myRunnable();

    myAsyn myAsyncTask;
    public void Start3(View view) {
        //Khởi tạo tiến trình của bạn
        //Truyền Activity chính là MainActivity sang bên tiến trình của mình
        myAsyncTask = new myAsyn(MainActivity.this);
        //Gọi hàm execute để kích hoạt tiến trình
        myAsyncTask.execute();

    }

    public class  myRunnable implements  Runnable{
        @Override
        public void run() {

            for(int i=start;i<=65536;i++){
             //   SystemClock.sleep(1000);
                try {
                    Thread.sleep(1000);
                    if(frun ==1){
                        return;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final int finali2=i;
                Log.i("VT",String.valueOf(i));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        tv.setText(String.valueOf(finali2));
                    }
                });


            }
        }
    }

}


package com.example.dangt.baitaptextchange;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by dangt on 10/7/2017.
 */

public class myAsyn extends AsyncTask <Void,Integer,Void>{
    Activity contextParent;
    public myAsyn(Activity contextParent) {
        this.contextParent = contextParent;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        Toast.makeText(contextParent, "Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        //Hàm được được hiện tiếp sau hàm onPreExecute()
        //Hàm này thực hiện các tác vụ chạy ngầm

        for (int i = 0; i <= 100; i++) {
            SystemClock.sleep(100);
            //khi gọi hàm này thì onProgressUpdate sẽ thực thi
            publishProgress(i);
        }
        return null;
    }
    @Override
    protected void onProgressUpdate(Integer... values) {
        //Hàm thực hiện update giao diện khi có dữ liệu từ hàm doInBackground gửi xuống

        int number = values[0];
        TextView textView = (TextView) contextParent.findViewById(R.id.tv_start);
        textView.setText(number + "%");
    }
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Hàm này được thực hiện khi tiến trình kết thúc
        //Ở đây mình thông báo là đã "Finshed" để người dùng biết
        Toast.makeText(contextParent, "Finished", Toast.LENGTH_SHORT).show();
    }




}

package com.example.lab4milestone1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button buttonStartThread;
    private volatile boolean stopThread = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonStartThread = findViewById(R.id.startbutt);
    }
    public void startThread (View view) {
        stopThread = false;
        ExRunnable runnable = new ExRunnable(10);
        new Thread(runnable).start();
    }
    public void stopThread (View view) {
        stopThread = true;
    }
    class ExRunnable implements Runnable {
        int seconds;
        ExRunnable (int seconds) {
            this.seconds = seconds;
        }
        @Override
        public void run() {
            for (int i = 0; i < seconds; i++) {
                if (stopThread) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            buttonStartThread.setText("Start");
                        }
                    });
                    return;
                }
                if (i == 1) {
                    runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            buttonStartThread.setText("10%");
                        }
                    });
                }
                if (i == 2) {
                    runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            buttonStartThread.setText("20%");
                        }
                    });
                }
                if (i == 3) {
                    runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            buttonStartThread.setText("30%");
                        }
                    });
                }
                if (i == 4) {
                    runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            buttonStartThread.setText("40%");
                        }
                    });
                }
                if (i == 5) {
                    runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            buttonStartThread.setText("50%");
                        }
                    });
                }
                if (i == 6) {
                    runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            buttonStartThread.setText("60%");
                        }
                    });
                }
                if (i == 1) {
                    runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            buttonStartThread.setText("10%");
                        }
                    });
                }
                if (i == 7) {
                    runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            buttonStartThread.setText("70%");
                        }
                    });
                }
                if (i == 8) {
                    runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            buttonStartThread.setText("80%");
                        }
                    });
                }
                if (i == 9) {
                    runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            buttonStartThread.setText("90%");
                        }
                    });
                }
                Log.d(TAG,"startThread: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    buttonStartThread.setText("Start");
                }
            });
        }
    }
}



package com.app.aos.aos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Arnold on 12/8/15.
 */
public class SPlashScreen extends Activity {

    private int Delay_time = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Thread timer = new Thread()
        {
            public void run()
            {

                try {
                    sleep(Delay_time);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                finally {
                    Intent splash = new Intent(SPlashScreen.this,Home.class);
                    startActivity(splash);
                }
            }
        };timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
    }


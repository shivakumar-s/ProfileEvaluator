package cvcrop.profileevaluator;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class LoadingActivity extends AppCompatActivity {

    private static ProgressBar spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        Thread welcomeLoad=new Thread(){

            @Override
            public void run(){

                try{
                    super.run();
                    spinner=(ProgressBar)findViewById(R.id.progressBar);
                    spinner.getIndeterminateDrawable().setColorFilter(0xFFBF0A30, PorterDuff.Mode.MULTIPLY);
                    System.out.println("Before");
                    sleep(3000);
                    System.out.println("After");
                }
                catch (Exception e)
                {

                }
                finally {
                    Intent i=new Intent(LoadingActivity.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }

        };
        welcomeLoad.start();
    }
}

package com.example.multithreading;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    Handler hand=new Handler();
    Button clickme;
    TextView timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer=(TextView) findViewById(R.id.tv2);
        clickme=(Button) findViewById(R.id.button);
        hand.postDelayed(this::updateTimer,1000);
    }

    public void updateTimer() {
        timer.setText("" + (Integer.parseInt(timer.getText().toString()) - 1));
        if (Integer.parseInt(timer.getText().toString()) == 0) {
            clickme.setVisibility(View.VISIBLE);
        } else {
            hand.postDelayed(this::updateTimer, 1000);
        }
    }
    
}

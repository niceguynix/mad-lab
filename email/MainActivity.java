package com.example.email;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void EmailButton(View view) {
        Uri uriEmail = Uri.parse("mailto:jeni10rose@gmail.com" + "?subject=" +
                Uri.encode("request to send MAD Lab Manual")+"&body=" + Uri.encode("Hi Jeni,\n I need your help as you know that I was absent yesterday and has not executed the lab Experiment.I just need the MAD Lab manual , if have it please do forward me. I would be highly thankful to you if you help.\n Thank You. \n\n"));
        Intent intentEmail = new Intent(Intent.ACTION_SENDTO);
        intentEmail.setData(uriEmail);
        startActivity(intentEmail);
    }
}

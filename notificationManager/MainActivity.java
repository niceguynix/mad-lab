package com.example.notificationmanager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    public static String channelId="My channel";
    Notification n;
    NotificationManager notificationManager;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.editTextTextPersonName);
        Drawable drawable= ResourcesCompat.getDrawable(getResources(),R.drawable.img,null);
        BitmapDrawable bitmapDrawable=(BitmapDrawable) drawable;
        Bitmap largeIcon= bitmapDrawable.getBitmap();
        notificationManager=(NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        Button btn=(Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    n=new Notification.Builder(MainActivity.this)
                            .setLargeIcon(largeIcon)
                            .setSmallIcon(R.drawable.img)
                            .setContentText(et.getText().toString())
                            .setSubText("Notification from this app")
                            .setChannelId(channelId)
                            .build();
                    notificationManager.createNotificationChannel(new
                            NotificationChannel(channelId,"new channel",NotificationManager.IMPORTANCE_HIGH));
                }else{
                    n=new Notification.Builder(MainActivity.this)
                            .setLargeIcon(largeIcon)
                            .setSmallIcon(R.drawable.icon)
                            .setContentText(et.getText().toString())
                            .setSubText("Notification from this app")
                            .build();
                }
                notificationManager.notify(channelId,100,n);
                et.setText("");
            }
        });
    }
}
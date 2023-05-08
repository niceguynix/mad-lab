package com.example.ex2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    EditText et_1,et_2;
    TextView tv_1;
    Button bt_1,bt_2,bt_3,bt_4;
    int num1,num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_1=findViewById(R.id.et1);
        et_2=findViewById(R.id.et2);
        tv_1=findViewById(R.id.tv1);
        bt_1=findViewById(R.id.bt1);
        bt_2=findViewById(R.id.bt2);
        bt_3=findViewById(R.id.bt3);
        bt_4=findViewById(R.id.bt4);
        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Integer.parseInt(et_1.getText().toString());
                num2 = Integer.parseInt(et_2.getText().toString());
                int sum=num1+num2;
                tv_1.setText(Double.toString(sum));
            }
        });
        bt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Integer.parseInt(et_1.getText().toString());
                num2 = Integer.parseInt(et_2.getText().toString());
                int sum=num1-num2;
                tv_1.setText(Double.toString(sum));
            }
        });
        bt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Integer.parseInt(et_1.getText().toString());
                num2 = Integer.parseInt(et_2.getText().toString());
                int sum=num1*num2;
                tv_1.setText(Double.toString(sum));
            }
        });
        bt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Integer.parseInt(et_1.getText().toString());
                num2 = Integer.parseInt(et_2.getText().toString());
                double sum=num1/num2;
                tv_1.setText(Double.toString(sum));
            }
        });
    }
}
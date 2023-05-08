package com.example.ex1;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    TextView tv1;
    RadioButton rb_1, rb_2, rb_3;
    RadioGroup rg_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg_1 = findViewById(R.id.idRadioGroup);
        tv1 = findViewById(R.id.idTVStatus);
        rg_1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int checkedRadioButtonId = rg_1.getCheckedRadioButtonId();
                if (checkedRadioButtonId == R.id.rb1) {
                    RadioButton radioButton = group.findViewById(checkedId);
                    tv1.setText(radioButton.getText());
                    tv1.setTextColor(0XFF03DAC5);
                } else if (checkedRadioButtonId == R.id.rb2) {
                    RadioButton rb_2 = group.findViewById(checkedId);
                    tv1.setText(rb_2.getText());
                    Typeface face = Typeface.DEFAULT_BOLD;
                    tv1.setTypeface(face);
                    tv1.setTextSize(30);
                } else if (checkedRadioButtonId == R.id.rb3) {
                    RadioButton rb_3 = group.findViewById(checkedId);
                    tv1.setText(rb_3.getText());
                    tv1.setBackgroundColor(0XFF3700B3);
                }
            }
        });
    }
}
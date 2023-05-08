package com.example.healthcare;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    TextView tv1;
    EditText et1,et2,et3;
    Button b1,b2,b3,b4;
    String pid,name,disease;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        tv1=findViewById(R.id.tv1);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        DBHelper dbHelper=new DBHelper(this);
        db=dbHelper.getWritableDatabase();
        db=dbHelper.getReadableDatabase();
    }
    public void onSubmit(View view)
    {
        pid=et1.getText().toString();
        name=et2.getText().toString();
        disease=et3.getText().toString();
        if(pid.equals("")||name.equals("")||disease.equals(""))
        {
            Toast.makeText(this,"please enter values",Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            ContentValues values = new ContentValues();
            values.put("patientid", pid);
            values.put("name", name);
            values.put("disease", disease);
            db.insert("patient", null, values);
            Toast.makeText(this, "Inserted successfully", Toast.LENGTH_SHORT).show();
        }
    }
    public void onUpdate(View view)
    {
        pid=et1.getText().toString();
        name=et2.getText().toString();
        disease=et3.getText().toString();
        if(pid.equals("")||name.equals("")||disease.equals(""))
        {
            Toast.makeText(this,"please enter values",Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            ContentValues values = new ContentValues();
            values.put("patientid", pid);
            values.put("name", name);
            values.put("disease", disease);
            db.update("patient",values,"patientid="+pid,null);
            Toast.makeText(this, "Updated successfully", Toast.LENGTH_SHORT).show();
        }
    }
    public void onView(View view)
    {
        StringBuffer buffer=new StringBuffer();
        Cursor c=db.rawQuery("select * from patient",null);
        while(c.moveToNext())
        {
            buffer.append("\t"+c.getString(0));
            buffer.append("\t"+c.getString(1));
            buffer.append("\t"+c.getString(2));
        }
        Toast.makeText(this,buffer.toString(),Toast.LENGTH_SHORT).show();
    }
    public void onDelete(View view)
    {
        pid=et1.getText().toString();
        name=et2.getText().toString();
        disease=et3.getText().toString();
        if(pid.equals(""))
        {
            Toast.makeText(this,"please enter values",Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            ContentValues values = new ContentValues();
            values.put("patientid", pid);
            values.put("name", name);
            values.put("disease", disease);
            db.delete("patient","patientid="+pid,null);
            Toast.makeText(this, "Deleted successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
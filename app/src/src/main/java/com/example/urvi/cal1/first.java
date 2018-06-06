package com.example.urvi.cal1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by urvi on 6/6/18.
 */
public class first extends AppCompatActivity {
    private static final String TAG ="first";
    private Button btndate;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        btndate= (Button) findViewById(R.id.btndate);

        btndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(first.this,cal1.class);
                startActivity(intent);

            }
        });
    }

}

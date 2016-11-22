package com.example.a5alumno.activitymanagermartinga;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button btnDisplay, btnNewActivity;
    private String messageToShow;
    TextView txtvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageToShow = "No info returned";
        txtvInfo = (TextView) findViewById(R.id.txt1Info);
        btnDisplay = (Button) findViewById(R.id.btn1Display);
        btnNewActivity = (Button) findViewById(R.id.btn2);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (messageToShow.equals("No info returned")) {
                    Toast.makeText(getApplicationContext(), "Nothing to show", Toast.LENGTH_SHORT).show();
                } else {
                    txtvInfo.setText(messageToShow);
                }
            }
        });

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null)
            messageToShow = data.getStringExtra("resultadinho");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putString("message", messageToShow.toString());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        txtvInfo.setText(savedInstanceState.getString("message"));
        messageToShow=savedInstanceState.getString("message");
    }
}

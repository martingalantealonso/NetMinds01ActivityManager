package com.example.a5alumno.activitymanagermartinga;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private EditText edtxtMessage;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        edtxtMessage = (EditText) findViewById(R.id.edtxt2Info);
        btnOk = (Button) findViewById(R.id.btn2Ok);


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtxtMessage.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "You need introduce some info", Toast.LENGTH_SHORT).show();
                } else {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("resultadinho", edtxtMessage.getText().toString());
                    setResult(1, resultIntent);
                    finish();
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putString("messageEdTxt", edtxtMessage.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }

    //region Esto no hace falta proque se hace solo para los editText
    /*
       @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (edtxtMessage.getText() != null)
            edtxtMessage.setText(savedInstanceState.getString("messageEdTxt"));
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "onStop: Volvemos a la activity principal", Toast.LENGTH_SHORT).show();
        super.onStop();
    }
      */
    //endregion
}

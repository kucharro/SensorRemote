package com.example.kucharro.sensorremote;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private Button buttonDown, buttonUp, buttonNewActivity;
    private TextView textView;

    int counter=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListeners();
        textView = (TextView) findViewById(R.id.HelloTextView);
        textView.setText(Integer.toString(counter));

    }

    private void initListeners() {
        buttonDown = (Button) findViewById(R.id.HelloButtonDown);
        buttonDown.setOnClickListener(this);

        buttonUp = (Button) findViewById(R.id.HelloButtonUp);
        buttonUp.setOnClickListener(this);

        buttonNewActivity = (Button) findViewById(R.id.HelloButtonNewActivity);
        buttonNewActivity.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.HelloButtonDown) {
            textView.setText(Integer.toString(--counter));
            }

        if(v.getId() == R.id.HelloButtonUp){
            textView.setText(Integer.toString(++counter));
        }
        if(v.getId() == R.id.HelloButtonNewActivity) {
            Intent intent = new Intent(this, ActivityTwo.class);
            intent.putExtra("NAZWA", "Kamil");
            startActivity(intent);
        }
        if(counter == 0) {
            textView.setText("BANG!!!");
            textView.setTextColor(getResources().getColor(R.color.colorAccent));
            textView.setTextSize(90);}
    }

}

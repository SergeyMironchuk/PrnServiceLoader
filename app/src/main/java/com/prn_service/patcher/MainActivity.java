package com.prn_service.patcher;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

    public void process(View view) {
        TextView userName = (TextView) findViewById(R.id.userName);
        TextView password = (TextView) findViewById(R.id.password);
        TextView orderNumber = (TextView) findViewById(R.id.orderNumber);
//        Toast.makeText(
//                    MainActivity.this,
//                    String.format("Process clicked: %s", userName.getText()),
//                    Toast.LENGTH_SHORT).show();
        Snackbar.make(
                view,
                String.format("Process clicked: %s", userName.getText()),
                Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show();
    }
}

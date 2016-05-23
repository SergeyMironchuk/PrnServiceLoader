package com.prn_service.patcher;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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
        EditText userName = (EditText) findViewById(R.id.userName);
        EditText password = (EditText) findViewById(R.id.password);
        EditText orderNumber = (EditText) findViewById(R.id.orderNumber);
        final TextView resultView = (TextView) findViewById(R.id.resultView);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://www.google.com";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    resultView.setText("Response is: " + response.substring(0, 500));
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    resultView.setText("That didn't work!");
                }
            }
        );
        queue.add(stringRequest);

        Toast.makeText(
                    this,
                    String.format("Process clicked: %s", userName.getText()),
                    Toast.LENGTH_SHORT).show();
//        Snackbar.make(
//                view,
//                String.format("Process clicked: %s", userName.getText()),
//                Snackbar.LENGTH_LONG)
//                .setAction("Action", null)
//                .show();
    }
}

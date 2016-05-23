package com.prn_service.patcher;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by mironchuk on 23.05.2016.
 */
public class RequestQueueSingleton {
    private static RequestQueueSingleton _instance;
    private RequestQueue _requestQueue;
    private static Context _ctx;

    private RequestQueueSingleton(Context context) {
        _ctx = context;
        _requestQueue = getRequestQueue();
    }

    public static synchronized RequestQueueSingleton getInstance(Context context) {
        if (_instance == null) {
            _instance = new RequestQueueSingleton(context);
        }
        return _instance;
    }

    public <T> void addToRequestQueue(Request<T> request){
        getRequestQueue().add(request);
    }

    public RequestQueue getRequestQueue() {
        if (_requestQueue == null) {
            _requestQueue = Volley.newRequestQueue(_ctx.getApplicationContext());
        }
        return _requestQueue;
    }
}

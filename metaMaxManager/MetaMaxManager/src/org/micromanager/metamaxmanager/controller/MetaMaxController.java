package org.micromanager.metamaxmanager.controller;


import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import org.apache.http.message.BasicNameValuePair;
import org.apache.xpath.operations.Bool;
import org.json.JSONObject;
import org.micromanager.metamaxmanager.model.Device;
import org.micromanager.metamaxmanager.model.Intensity;
import org.micromanager.metamaxmanager.model.Model;
import org.micromanager.metamaxmanager.view.MetaMaxView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MetaMaxController {
    Model model;
    MetaMaxView view;
    HttpClient client;
    Gson gson;


    public MetaMaxController(MetaMaxView v, Model m) {
        this.client = new DefaultHttpClient();
        this.model = m;
        this.view = v;
        this.gson = new Gson();
    }

    public boolean isConnected() throws Exception {
        String url = model.generateDeviceURL();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        Device device = gson.fromJson(reader.readLine(), Device.class);
        model.setDevice(device);
        
        // if-statement for testing purposes
        if (view != null) {
            //view.setConnectedField(device.isConnected())
        }
        
        return Boolean.parseBoolean(device.isConnected());
    }
    
    public void setIntensity(int intensity_value) throws Exception {
        // if-statement for testing purposes
        
        if (view != null) {
            //int intensity_value = view.getIntensityValue();
        }
        Intensity intensity_model = new Intensity(intensity_value);

        StringEntity postingString = new StringEntity(gson.toJson(intensity_model));//gson.tojson() converts your pojo to json

        String url = model.generateFunctionURL("setIntensity");
        HttpPost post = new HttpPost(url);
        //post.setEntity(new UrlEncodedFormEntity(urlParameters));

        post.setEntity(postingString);
        post.setHeader("Content-type", "application/json");

        HttpResponse response = client.execute(post);
    }
}

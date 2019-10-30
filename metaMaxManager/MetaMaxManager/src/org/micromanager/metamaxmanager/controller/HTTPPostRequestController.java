//package org.micromanager.metamaxmanager.controller;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.message.BasicNameValuePair;
//import org.micromanager.metamaxmanager.model.Model;
//import org.micromanager.metamaxmanager.view.MetaMaxView;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
//public class HTTPPostRequestController {
//
//
//    HttpClient client;
//    List<NameValuePair> urlParameters;
//
//
//    public HTTPPostRequestController(List<NameValuePair> url_params, Model m, String func) {
//        this.model = m;
//        this.function = func;
//        //this.url = ;//"https://api.particle.io/v1/devices/4b001c001851373237343331/led?access_token=b0b4abf352e4813771428d70189ad7b128a5fba3";
//        this.client = new DefaultHttpClient();
//        this.urlParameters = url_params;
//
//        // generate url
//        if (function.isEmpty()){
//            this.url = model.generateDeviceURL();
//        } else {
//            this.url = model.generateFunctionURL(function);
//        }
//        this.post = new HttpPost(url);
//
//    }
//
//    public String process() throws Exception {
//        // throws exception
//        post.setEntity(new UrlEncodedFormEntity(urlParameters));
//
//        HttpResponse response = client.execute(post);
//        System.out.println("\nSending 'POST' request to URL : " + url);
//        System.out.println("Post parameters : " + post.getEntity());
//        System.out.println("Response Code : " +
//                response.getStatusLine().getStatusCode());
//
//        BufferedReader rd = new BufferedReader(
//                new InputStreamReader(response.getEntity().getContent()));
//
//        StringBuffer result = new StringBuffer();
//        String line = "";
//        while ((line = rd.readLine()) != null) {
//            result.append(line);
//        }
//
//        return result.toString();
//
//    }
//}

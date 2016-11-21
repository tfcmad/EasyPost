package com.logic;

import android.os.AsyncTask;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Luke on 21/11/2016.
 * Added some code to get from a server
 */

public class DataService extends AsyncTask<String, String, String>{

    public DataService(){
        //Set context
    }

    //Test post method
    public String doInBackground(String... params){

        InputStream inputBytes = null;
        String postURL = params[0];

        String results = "";

        try {
            //Make the string url into a URL object
            URL url = new URL(postURL);

            //Create the urlConnection object
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            //Convert to bytes
            inputBytes = new BufferedInputStream(urlConnection.getInputStream());

        }
        catch (Exception e){
            System.out.println(e.getMessage());

            return e.getMessage();
        }

        try{
            results = IOUtils.toString(inputBytes, "UTF-8");
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return results;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String Result){
        //Update UI
    }
}
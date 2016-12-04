package com.example.aksel.s232324_mappe3;

import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Aksel on 03/12/2016.
 */

public class Lokasjon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public String hentkoordinater(String minadresse) {
        GetLocationTask hentadresser = new GetLocationTask(minadresse);
        hentadresser.execute();
        return hentadresser.lokasjon;
    }

    private class GetLocationTask extends AsyncTask<Void, Void, String> {
        JSONObject jsonObject;
        String address;
        String lokasjon;

        public GetLocationTask(String a) {
            this.address = a;
        }

        @Override
        protected String doInBackground(Void... params) {
            String s = "";
            String output = "";
            String query = "http://maps.google.com/maps/api/geocode/json?address=" + address.replaceAll(" ", "%20")
                    + "&sensor=false";
            try {
                URL urlen = new URL(query);
                HttpURLConnection conn = (HttpURLConnection) urlen.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code: " + conn.getResponseCode());
                }
                Log.d("Lok", lokasjon+"");
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                while ((s = br.readLine()) != null) {
                    output = output + s;
                }
                jsonObject = new JSONObject(output.toString());
                conn.disconnect();
                Double lon = Double.valueOf(0);
                Double lat = Double.valueOf(0);

                lon = ((JSONArray)
                        jsonObject.get("results")).getJSONObject(0).getJSONObject("geometry")
                        .getJSONObject("location").getDouble("lng");
                lat = ((JSONArray)
                        jsonObject.get("results")).getJSONObject(0).getJSONObject("geometry")
                        .getJSONObject("location").getDouble("lat");
                lokasjon = String.valueOf(lon) + " : " + String.valueOf(lat);
                Log.d("Lok", lokasjon+"");
                return lokasjon;

            } catch (Exception e) {
                return "Noe gikk galt";
            }


        }

        @Override
        protected void onPostExecute(String resultat) {
            Log.d("Resultat", resultat);
            lokasjon = resultat;
        }
    }
}


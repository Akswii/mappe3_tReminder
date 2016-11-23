package com.example.aksel.s232324_mappe3;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Aksel on 23/11/2016.
 */

public class Instillinger extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("");
        getFragmentManager().beginTransaction().replace(android.R.id.content, new InstFragment()).commit();
    }

    public static class InstFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.inst_layout);
        }
    }
}

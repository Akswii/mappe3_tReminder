package com.example.aksel.s232324_mappe3;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

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
        Lokasjon lok;
        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.inst_layout);
            lok = new Lokasjon();

            EditTextPreference inst = (EditTextPreference) findPreference("tekst_inst");
            final EditText et = inst.getEditText();

            inst.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    Log.d("LOKASJON","" + lok.hentkoordinater(et.getText().toString()));
                    Log.d("test", et.getText().toString());
                    return false;
                }
            });
        }
    }
}

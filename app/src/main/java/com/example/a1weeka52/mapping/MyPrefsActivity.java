package com.example.a1weeka52.mapping;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by 1weeka52 on 08/03/2017.
 */
public class MyPrefsActivity extends PreferenceActivity
{
    public void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}

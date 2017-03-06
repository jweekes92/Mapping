package com.example.a1weeka52.mapping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;


public class SetLocationActivity extends Activity implements View.OnClickListener{

    MapView mv;

    public void onCreate (Bundle savedInstanceState)
    {
        super.onCreate (savedInstanceState);
        setContentView(R.layout.activity_main);

        Configuration.getInstance().load
                (this, PreferenceManager.getDefaultSharedPreferences(this));

        mv = (MapView)findViewById(R.id.map1);

        Button b = (Button)findViewById(R.id.btn1);
        b.setOnClickListener(this);

        mv.getController().setCenter(new GeoPoint(52.95, -1.15));
    }


    public void onClick(View view)
    {
        TextView tv1 = (TextView)findViewById(R.id.latv);
        TextView tv2 = (TextView)findViewById(R.id.lonv);
        EditText lat = (EditText)findViewById(R.id.et1);
        EditText lon = (EditText)findViewById(R.id.et2);

        double latitude = Double.parseDouble(lat.getText().toString());
        double longitude = Double.parseDouble(lon.getText().toString());

        Intent intent2 = new Intent();
        Bundle bundle2 = new Bundle();
    }

}

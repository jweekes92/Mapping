package com.example.a1weeka52.mapping;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

import org.osmdroid.config.Configuration;
import org.osmdroid.views.MapView;
import org.osmdroid.util.GeoPoint;

public class HelloMap extends Activity implements OnClickListener
{

    MapView mv;

    public void onCreate (Bundle savedInstanceState)
    {
        super.onCreate (savedInstanceState);
        setContentView(R.layout.activity_main);

        Configuration.getInstance().load
                (this, PreferenceManager.getDefaultSharedPreferences(this));

        mv = (MapView)findViewById(R.id.map1);

        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(14);
        mv.getController().setCenter(new GeoPoint(51.05,-0.72));

        Button b = (Button)findViewById(R.id.btn1);
        b.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        TextView tv1 = (TextView)findViewById(R.id.latv);
        TextView tv2 = (TextView)findViewById(R.id.lonv);
        EditText lat = (EditText)findViewById(R.id.et1);
        EditText lon = (EditText)findViewById(R.id.et2);

        double latitude = Double.parseDouble(lat.getText().toString());
        double longitude = Double.parseDouble(lon.getText().toString());

    }
}

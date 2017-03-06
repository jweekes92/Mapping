package com.example.a1weeka52.mapping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
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

        Button b = (Button)findViewById(R.id.btn1);
        b.setOnClickListener(this);

        mv.getController().setCenter(new GeoPoint(52.95, -1.15));
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_hello_map, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.choosemap)
        {
            //System.exit(0);

            Intent intent = new Intent(this, MapChooseActivity.class);
            startActivityForResult(intent,0);

            return true;
        }
        return false;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        if (requestCode==0)
        {
            if (resultCode==RESULT_OK)
            {
                Bundle extras=intent.getExtras();
                boolean cyclemap = extras.getBoolean("com.example.cyclemap");
                if(cyclemap==true)
                {
                    mv.setTileSource(TileSourceFactory.CYCLEMAP);
                }
                else
                {
                    mv.setTileSource(TileSourceFactory.MAPNIK);
                }
            }
        }
        if (requestCode==1)
        {
            if (resultCode==)
        }
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

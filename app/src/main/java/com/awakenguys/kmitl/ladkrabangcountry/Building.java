package com.awakenguys.kmitl.ladkrabangcountry;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListActivity;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import java.io.File;

/**
 * Created by Xync on 09-Sep-15.
 */




/*public class Building extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacultyProvider fac = new FacultyProvider();
        fac.onCreate(savedInstanceState);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_default, menu);
        return true;
    }






}*/

public class Building extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faculty_all);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_default, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void filter(View view){
        Intent intent = new Intent(this,BuildingProvider.class);
        intent.putExtra("contains",view.getTag().toString());
        startActivity(intent);
    }

}




interface Constants extends BaseColumns {
    public static final String TABLE_NAME = "buildings";
    public static final String TITLE = "title";
    public static final String FACULTY = "faculty";
    public static final String LAT = "lat";
    public static final String LNG = "lng";
}







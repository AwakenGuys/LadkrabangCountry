package com.awakenguys.kmitl.ladkrabangcountry;

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
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.io.File;

public class BuildingProvider extends ListActivity {
    private BuildingDB buildingDB;
    private static String[] COLUMNS = {BaseColumns._ID, Constants.TITLE, Constants.FACULTY, Constants.LAT, Constants.LNG};
    private static int[] VIEWS = {R.id.title};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick);
        buildingDB = new BuildingDB(this);
        if (!buildingDB.checkDataBase(this)) {
            addAll();
        }
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String contains = bundle.getString("contains");
            showFilter(contains);
        }
    }

    private void addAll() {
        add("อาคารเรียนรวม 12 ชั้น(E12)", "วิศวกรรมศาสตร์", 13.727621f, 100.772344f);
        add("อาคารปฏิบัติการรวม CCA", "วิศวกรรมศาสตร์", 13.726530f, 100.772984f);
        add("โรงอาหาร C", "วิศวกรรมศาสตร์", 13.726863f, 100.772091f);
        add("อาคารยิมเนเซียม 1", "วิศวกรรมศาสตร์", 13.726826f, 100.773569f);
        add("ภาควิชาวิศวกรรมอุตสาหการ", "วิศวกรรมศาสตร์", 13.727688f, 100.773359f);
        add("ภาควิชาวิศวกรรมเครื่องกล(ME)", "วิศวกรรมศาสตร์", 13.727669f, 100.773965f);
        add("ภาควิชาวิศวกรรมการวัดคุม", "วิศวกรรมศาสตร์", 13.727442f, 100.774419f);
        add("โรงอาหาร J", "วิศวกรรมศาสตร์", 13.727711f, 100.774730f);
        add("อาคาร B", "วิศวกรรมศาสตร์", 13.727556f, 100.775307f);
        add("ภาควิชาวิศวกรรมโทรคมนาคม", "วิศวกรรมศาสตร์", 13.727472f, 100.776110f);
        add("หอประชุมสถาบัน", "วิศวกรรมศาสตร์", 13.727360f, 100.777301f);
        add("อาคาร A", "วิศวกรรมศาสตร์", 13.726974f, 100.776373f);
        add("โรงอาหาร A", "วิศวกรรมศาสตร์", 13.726954f, 100.775664f);
        add("สโมสรนักศึกษาวิศวกรรมศาสตร์", "วิศวกรรมศาสตร์", 13.726929f, 100.774204f);
        add("ภาควิชาวิศวกรรมโยธา", "วิศวกรรมศาสตร์", 13.726951f, 100.774367f);
        add("อาคารเฉลิมพระเกียรติ 84 พรรษาภูมิพลมหาราชา(HM)", "วิศวกรรมศาสตร์", 13.726552f, 100.775154f);
        add("อาคารปฏิบัติการไฟฟ้า(L)", "วิศวกรรมศาสตร์", 13.728486f, 100.775537f);
        add("โรงอาหาร L", "วิศวกรรมศาสตร์", 13.f, 100.77f);
        add("อาคารปฏิบัติการรวมวิศวกรรมศาสตร์ 2", "วิศวกรรมศาสตร์", 13.729158f, 100.775511f);
        add("อาคารบูรณาการ", "สถาปัตยกรรมศาสตร์", 13.725755f, 100.773841f);
        add("อาคารเรียนรวมสถาปัตยกรรมศาสตร์", "สถาปัตยกรรมศาสตร์", 13.725206f, 100.775100f);
        add("หอประชุมศาสตราจารย์ประสม รังสิโรจน์", "สถาปัตยกรรมศาสตร์", 13.725689f, 100.775117f);
        add("สำนักงานคณบดีคณบดีสถาปัตยกรรมศาสตร์", "สถาปัตยกรรมศาสตร์", 13.725275f, 100.776649f);
        add("Convention Hall", "ทั่วไป", 13.726469f, 100.779294f);
        add("สำนักหอสมุดกลาง", "ทั่วไป", 13.727659f, 100.778589f);
        add("อาคารกรมหลวงนราธิวาสราชนครินทร์(สำนักงานอธิการบดี)", "สถาปัตยกรรมศาสตร์", 13.730806f, 100.777616f);
        add("หอพักนักศึกษา(เก่า)", "ทั่วไป", 13.728962f, 100.773941f);
        add("หอพักนักศึกษา(ใหม่)", "ทั่วไป", 13.729640f, 100.774683f);
        add("สมาคมศิษย์เก่า", "ทั่วไป", 13.731067f, 100.774665f);
        add("อาคารเรียนรวมสมเด็จพระเทพฯ", "ทั่วไป", 13.730115f, 100.776802f);
        add("อาคารเฉลิมพระเกียรติ 55 พรรษา สมเด็จพระเทพฯ", "ทั่วไป", 13.729952f, 100.775283f);
        add("อาคารองค์การนักศึกษา", "ทั่วไป", 13.728772f, 100.778624f);
        add("อาคารสำนักบริการคอมพิวเตอร์และวิทยาลัยการบริหารและจัดการ", "ทั่วไป", 13.731218f, 100.780278f);
        add("อาคารวิทยาลัยการบริหารและจัดการ", "วิทยาลัยการบริหารและการจัดการ", 13.731218f, 100.780278f);
        add("อาคารหอพระราชประวัติ ร.4", "ทั่วไป", 13.731213f, 100.778577f);
        add("สนามกีฬากลางพระจอมเกล้าลาดกระบัง", "ทั่วไป", 13.730202f, 100.772183f);
        add("อาคารยิมเนเซียม 2", "ทั่วไป", 13.728669f, 100.772869f);
        add("อาคารฝึกงานซ่อมสร้างวิทยาศาสตร์", "วิทยาศาสตร์", 13.729298f, 100.778598f);
        add("อาคารคณะวิทยาศาสตร์", "วิทยาศาสตร์", 13.729261f, 100.779189f);
        add("อาคารหอประชุมจุฬาภรณ์วลัยลักษณ์", "วิทยาศาสตร์", 13.729708f, 100.779698f);
        add("อาคารจุฬาภรณ์วลัยลักษณ์ 1", "วิทยาศาสตร์", 13.729658f, 100.779978f);
    }

    private void add(String title, String faculty, float lat, float lng) {
        SQLiteDatabase db = buildingDB.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.TITLE, title);
        values.put(Constants.FACULTY, faculty);
        values.put(Constants.LAT, lat);
        values.put(Constants.LNG, lng);
        db.insertOrThrow(Constants.TABLE_NAME, null, values);
    }


    public Cursor getAll() {
        SQLiteDatabase db = buildingDB.getReadableDatabase();
        Cursor cursor = db.query(Constants.TABLE_NAME, COLUMNS, null, null, null, null, Constants.TITLE + (" ASC"));
        return cursor;
    }

    public Cursor getByFaculty(String faculty) {
        SQLiteDatabase db = buildingDB.getReadableDatabase();
        Cursor cursor = db.query(Constants.TABLE_NAME, COLUMNS, "faculty=?", new String[]{faculty},
                null, null, Constants.TITLE + " ASC");
        return cursor;
    }

    public Cursor getById(long id) {
        SQLiteDatabase db = buildingDB.getReadableDatabase();
        Cursor cursor = db.query(Constants.TABLE_NAME, COLUMNS, "_id=?", new String[]{(int) id + ""},
                null, null, Constants.TITLE + " ASC");
        return cursor;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String title = null;
        float lat = 0, lng = 0;
        Cursor cursor = getById(id);

        if (cursor.moveToFirst() && cursor.getCount() >= 1)
            title = cursor.getString(1);
        if (cursor.moveToFirst() && cursor.getCount() >= 1)
            lat = cursor.getFloat(3);
        if (cursor.moveToFirst() && cursor.getCount() >= 1)
            lng = cursor.getFloat(4);
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("geo:" + lat + ", " + lng + "?q=" + lat + ", " + lng + " (" + title + ")"));
        intent.setComponent(new ComponentName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity"));
        startActivity(intent);

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


    public void showFilter(String  str){
        Cursor cursor;
        try {
            if(str.equals("")) {
                cursor = getAll();
            }
            else {
                cursor = getByFaculty(str);
            }
            show(cursor);
        } finally {
            buildingDB.close();
        }
    }

    private void show(Cursor cursor) {
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.building_all,
                cursor, new String[]{Constants.TITLE}, VIEWS, 0);
        setListAdapter(adapter);
    }



}

class BuildingDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "building.db";
    private static final int DATABASE_VERSION = 1;

    public BuildingDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + Constants.TABLE_NAME + " (" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Constants.TITLE + " TEXT, " + Constants.FACULTY + " TEXT, " + Constants.LAT + " FLOAT, " + Constants.LNG + " FLOAT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS buildings");
        onCreate(db);
    }

    public boolean checkDataBase(ContextWrapper context) {
        File dbFile = context.getDatabasePath(DATABASE_NAME);
        return dbFile.exists();
    }
}

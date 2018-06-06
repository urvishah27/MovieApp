package com.example.urvi.cal1;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

public class cal1 extends AppCompatActivity {
    public static int a = 0;
    private static final String TAG ="cal1";
    private CalendarView mcal1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal1);
        mcal1=(CalendarView) findViewById(R.id.calendarView);
        mcal1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date1=(i1+1)+"/"+(i2)+"/"+i;
                a=i2;
                Log.d(TAG,"onSelectedDayChange: mm/dd/yyyy"+date1);
                Context context = null;
                Database db=new Database(context);
                db.getInformation(i2);

            }
        });

    }
    public class Database extends SQLiteOpenHelper {
        public static final String database_name="movie.db";
        public static final String table_name="tablem";
        public static final String col_1="date";
        public static final String movie="movie_name";

        public Database(Context context) {
            super(context, database_name, null, 1);
            SQLiteDatabase db=this.getWritableDatabase();

        }



        public Cursor getInformation(int b){
            SQLiteDatabase db=this.getReadableDatabase();
            Cursor cursor=db.rawQuery("select * from "+table_name,null);


            return cursor;
           // String[] proj=(cal1.a.)

        }
        @Override
        public void onCreate(SQLiteDatabase db) {
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            onCreate(db);
        }
    }


}

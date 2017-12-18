package com.example.jasmin.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;



public class MainActivity extends AppCompatActivity {
    SharedPreferences prefs;
    TextView t;
    Intent intent;
    Date currentTime;
    TimeZone tz;
    DateFormat formatter;
    Calendar now, now_berlin;
    int shift;
    int calc;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
      prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()); //getPreferences(MODE_PRIVATE);
       // SharedPreferences.Editor e = prefs.edit();

        System.out.println("geht");
        /*
        e.putInt("Hour_LA",0);
        e.putInt("Hour_Minsk",0);
        e.putInt("Hour_Toronto",0);
        e.putInt("Hour_Reykjavik",0);
        e.putInt("Hour_Tokyo",0);
        */
       // e.commit();
        now_berlin = Calendar.getInstance();
        tz = TimeZone.getTimeZone("GMT+1:00");
        now_berlin.setTimeZone(tz);
        intent = new Intent(this,Main2Activity.class);
        t = findViewById(R.id.t);
       // formatter = new SimpleDateFormat("HH:mm:ss");
        //tz = TimeZone.getTimeZone("GMT+1");
        //now = Calendar.getInstance(Locale.GERMANY);
        // tz = now.getTimeZone();
        //  now = Calendar.getInstance();
        //tz = now.getTimeZone();
        // now = Calendar.getInstance(tz);
       // System.out.print("TiemZine"+ tz);
        // now = Calendar.getInstance(Calendar.ZONE_OFFSET);
        //now = Calendar.getInstance(


    }


    public void wartung_click(View aView){
        t.setText("");
        startActivity(intent);
    }
    /*
        @Override
        protected void onStart() {
            super.onStart();
            SharedPreferences.Editor e = prefs.edit();
            e.putInt("Hour_LA",0);
            e.putInt("Hour_Minsk",0);
            e.putInt("Hour_Toronto",0);
            e.putInt("Hour_Reykjavik",0);
            e.putInt("Hour_Tokyo",0);
            e.commit();
        }
    */
    public void c1_click(View aView){
        /*s
        currentTime = new Date();
        System.out.println("Time:" + now.get(Calendar.HOUR) + ":" + now.get(Calendar.MINUTE)+ ":" + now.get(Calendar.SECOND));
        //t.setText()
        System.out.print("Time"  + now.getTime());
        currentTime = now.getTime();
        Date now1 = new Date();
        String format3 = new SimpleDateFormat("HH:mm:ss").format(now1);

        t.setText(format3);
*/try{
           shift = prefs.getInt("Hour_LA",-20);
            System.out.println("SHIFT NOW" + shift);
            String time;
            now = Calendar.getInstance();
            tz = TimeZone.getTimeZone("GMT-8:00");
            now.setTimeZone(tz);

            if(shift==-20){


                time = "" + now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND);

                // currentTime = now.getTime();
                //String format3 = new SimpleDateFormat("HH:mm:ss").format(currentTime);
                t.setText(time);
               SharedPreferences.Editor e = prefs.edit();
              e.putInt("Hour_LA",-9);
               e.commit();
            }
            else{
                System.out.println("nowberlin"+ (now_berlin.get(Calendar.HOUR_OF_DAY)));
                if (now_berlin.get(Calendar.HOUR_OF_DAY)>=shift){
                    calc = (now_berlin.get(Calendar.HOUR_OF_DAY)+ shift)%24;
                }
                else{
                    calc = 24 + (now_berlin.get(Calendar.HOUR_OF_DAY)-shift);
                }
                time = "" + calc + ":" + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND);
                t.setText(time);
            }
        }
        catch(Exception e){
            System.out.print(e.getStackTrace());
        }


    }

    public void c2_click(View aView){
try{
            shift = prefs.getInt("Hour_Toronto",-20);
            System.out.println("SHIFT NOW" + shift);
            String time;
            now = Calendar.getInstance();
            tz = TimeZone.getTimeZone("GMT-5:00");
            now.setTimeZone(tz);
            if(shift==-20){
                time = "" + now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND);
                t.setText(time);
                SharedPreferences.Editor e = prefs.edit();
                e.putInt("Hour_Toronto",-6);
                e.commit();
            }
            else{
                System.out.println("nowberlin"+ (now_berlin.get(Calendar.HOUR_OF_DAY)));
                if (now_berlin.get(Calendar.HOUR_OF_DAY)>=shift){
                    calc = (now_berlin.get(Calendar.HOUR_OF_DAY)+ shift)%24;
                }
                else{
                    calc = 24 + (now_berlin.get(Calendar.HOUR_OF_DAY)-shift);
                }
                time = "" + calc + ":" + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND);
                t.setText(time);
            }
        }
        catch(Exception e){
            System.out.print(e.getStackTrace());
        }

    }
    public void c3_click(View aView){
        try{
            shift = prefs.getInt("Hour_Reykjavik",-20);
            System.out.println("SHIFT NOW" + shift);
            String time;
            now = Calendar.getInstance();
            tz = TimeZone.getTimeZone("GMT0:00");
            now.setTimeZone(tz);
            if(shift==-20){
                time = "" + now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND);
                t.setText(time);
                SharedPreferences.Editor e = prefs.edit();
                e.putInt("Hour_Reykjavik",-1);
                e.commit();
            }
            else{
                System.out.println("nowberlin"+ (now_berlin.get(Calendar.HOUR_OF_DAY)));
                if (now_berlin.get(Calendar.HOUR_OF_DAY)>=shift){
                    calc =(now_berlin.get(Calendar.HOUR_OF_DAY)+ shift)%24;
                }
                else{
                    calc = 24 + (now_berlin.get(Calendar.HOUR_OF_DAY)-shift);
                }
                time = "" + calc + ":" + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND);
                t.setText(time);
            }
        }
        catch(Exception e){
            System.out.print(e.getStackTrace());
        }
    }
    public void c4_click(View aView){
        try{
            shift = prefs.getInt("Hour_Minsk",-20);
            System.out.println("SHIFT NOW" + shift);
            String time;
            now = Calendar.getInstance();
            tz = TimeZone.getTimeZone("GMT+3:00");
            now.setTimeZone(tz);
            if(shift==-20){
                time = "" + now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND);
                t.setText(time);
                SharedPreferences.Editor e = prefs.edit();
                e.putInt("Hour_Minsk",+2);
                e.commit();
            }
            else{
                System.out.println("nowberlin"+ (now_berlin.get(Calendar.HOUR_OF_DAY)));
                if (now_berlin.get(Calendar.HOUR_OF_DAY)>=shift){
                    calc = (now_berlin.get(Calendar.HOUR_OF_DAY)+ shift)%24;
                }
                else{
                    calc = 24 + (now_berlin.get(Calendar.HOUR_OF_DAY)-shift);
                }
                time = "" + calc + ":" + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND);
                t.setText(time);
            }
        }
        catch(Exception e){
            System.out.print(e.getStackTrace());
        }
    }
    public void c5_click(View aView){

        try{
            shift = prefs.getInt("Hour_Tokyo",-20);
            System.out.println("SHIFT NOW" + shift);
            String time;
            now = Calendar.getInstance();
            tz = TimeZone.getTimeZone("GMT+9:00");
            now.setTimeZone(tz);
            if(shift==-20){
                time = "" + now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND);
                t.setText(time);
                SharedPreferences.Editor e = prefs.edit();
                e.putInt("Hour_Tokyo",8);
                e.commit();
            }
            else{
                System.out.println("nowberlin"+ (now_berlin.get(Calendar.HOUR_OF_DAY)));
                if (now_berlin.get(Calendar.HOUR_OF_DAY)>=shift){
                    calc = (now_berlin.get(Calendar.HOUR_OF_DAY)+ shift)%24;
                }
                else{
                    calc = 24 + (now_berlin.get(Calendar.HOUR_OF_DAY)-shift);
                }
                time = "" + calc + ":" + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND);
                t.setText(time);
            }
        }
        catch(Exception e){
            System.out.print(e.getStackTrace());
        }
    }


}

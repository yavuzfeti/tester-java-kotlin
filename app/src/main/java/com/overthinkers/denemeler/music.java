package com.overthinkers.denemeler;

import static android.provider.MediaStore.Audio.AudioColumns.IS_MUSIC;
import static android.provider.MediaStore.MediaColumns.DATA;
import static android.provider.MediaStore.MediaColumns.DISPLAY_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Audio.Media;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class music extends AppCompatActivity
{

    ListView listview;
    ArrayAdapter<String> list_view_adapter;

    int[] sarkilar_sample = {R.raw.music, R.raw.sarki, R.raw.ses, R.raw.klavyeses};

    String[] sarkilar_isim_sample = {"1. Şarkı ismi - Sanatçı", "2. Şarkı ismi - Sanatçı", "3. Şarkı ismi - Sanatçı", "4. Şarkı ismi - Sanatçı"};

    public void baslangic()
    {
        listele();
    }

    public void init()
    {
        listview = findViewById(R.id.listview);
    }

    public void listele()
    {
        dosyalari_al();
        list_view_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sarki_list);
        listview.setAdapter(list_view_adapter);
    }

    public void yenile(View view){listele();}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);
        init();
        baslangic();
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.anim, R.anim.anim2);
        finish();
    }


    MediaPlayer MuzikCalar;
    ArrayList<String> sarki_list;
    ArrayList<String> sarki_yol_list;



    public void dosyalari_al()
    {

        sarki_list = new ArrayList<>();
        sarki_yol_list = new ArrayList<>();




        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
        else
        {

            String musicName,musicYol;
            Cursor cursor;
            String selection = IS_MUSIC;
            String[] projection = {DISPLAY_NAME,DATA};

            cursor = getContentResolver().query(Media.EXTERNAL_CONTENT_URI,projection ,selection, null, null);

            if (cursor != null)
            {
            while (cursor.moveToNext())
            {
                musicName = cursor.getString(cursor.getColumnIndex(DISPLAY_NAME));
                musicYol = cursor.getString(cursor.getColumnIndex(DATA));
                sarki_list.add(musicName);
                sarki_yol_list.add(musicYol);
            }
            cursor.close();
            }
        }
        MuzikCalar =MediaPlayer.create(getApplicationContext(), Uri.parse(sarki_yol_list.get(0)));
        MuzikCalar.start();
    }
}
package com.lhe.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {

    Date currentTime = Calendar.getInstance().getTime();

    static GridListAdapter adapter;


    TextView txt_date;

    GridView gridView_region;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String current = sdf.format(currentTime);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView_region = findViewById(R.id.gridView_region);

        adapter = new GridListAdapter();

        new Covid19Task().execute();

        gridView_region.setAdapter(adapter);

        txt_date = findViewById(R.id.txt_date);
        txt_date.setText(current+" 기준");
    }




}
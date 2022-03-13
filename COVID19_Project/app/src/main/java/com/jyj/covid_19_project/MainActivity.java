package com.jyj.covid_19_project;

import static java.lang.Float.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.HorizontalBarChart;

public class MainActivity extends AppCompatActivity {

    Button Pfizer, Moderna, Janssen, AZ, Novavax;
    TextView contry, platform, cnt, time, storage, delivery, corona_cnt;
    ListView list;
    static HorizontalBarChart mchart;
    static HorizontalBarChart totalVaccine;
    static int[] colorArray = new int[]{Color.parseColor("#EC6E8D"), Color.parseColor("#F39A9B"), Color.parseColor("#F9C7A8")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Pfizer = findViewById(R.id.Pfizer);
        Moderna = findViewById(R.id.Moderna);
        Janssen = findViewById(R.id.Janssen);
        AZ = findViewById(R.id.AZ);
        Novavax = findViewById(R.id.Novavax);

        contry = findViewById(R.id.contry);
        platform = findViewById(R.id.platform);
        cnt = findViewById(R.id.cnt);
        time = findViewById(R.id.time);
        storage = findViewById(R.id.storage);
        delivery = findViewById(R.id.delivery);

        //차트
        mchart = findViewById(R.id.oldbarchar);
        totalVaccine = findViewById(R.id.totalVaccine);

        mchart.getAxisRight().setAxisMaxValue(100);

        //차트실행
        Covid19VanccinCnt old = new Covid19VanccinCnt();
        old.execute();



        //버튼 클릭시 화면 이동
        list = findViewById(R.id.list);

        Vaccine_CustomAdapter adapter = new Vaccine_CustomAdapter();

        adapter.addItem(new VaccinVO("코로나 19예방접종", "사전예약", "https://ncv.kdca.go.kr/kor/img/main/main_top_ban_01.png"));
        adapter.addItem(new VaccinVO("코로나 19 예방접종 후", "건강상태 확인하기", "https://ncv.kdca.go.kr/kor/img/main/main_top_ban_02.png"));
        adapter.addItem(new VaccinVO("코로나 19", "전자예방접종증명", "https://ncv.kdca.go.kr/kor/img/main/main_top_ban_03.png"));
        adapter.addItem(new VaccinVO("코로나 19", "예방접종 후 이상반응", "https://ncv.kdca.go.kr/kor/img/main/main_top_ban_09.png"));

        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                VaccinVO item = (VaccinVO) adapter.getItem(i);
                Intent change;
                switch (i) {
                    case 0:
                        change = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ncvr2.kdca.go.kr/"));
                        startActivity(change);
                        break;
                    case 1:
                        change = new Intent(Intent.ACTION_VIEW, Uri.parse("https://nip.kdca.go.kr/irgd/covid.do?MnLv1=3"));
                        startActivity(change);

                        break;
                    case 2:
                        change = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ncv.kdca.go.kr/coov"));
                        startActivity(change);

                        break;
                    case 3:
                        change = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ncv.kdca.go.kr/menu.es?mid=a12601010000"));
                        startActivity(change);

                        break;
                }


            }
        });

        Pfizer.setOnClickListener(click);
        Moderna.setOnClickListener(click);
        Janssen.setOnClickListener(click);
        AZ.setOnClickListener(click);
        Novavax.setOnClickListener(click);


        //
    }



    //버튼들
    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Pfizer:

                    contry.setText("미국/독일");
                    platform.setText("mRNA 백신(핵산백신)");
                    cnt.setText("2회");
                    time.setText("21일");
                    storage.setText("-90°C ~ -60°C(6개월)");
                    delivery.setText("2~8°C(5일)");

                    Pfizer.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    Pfizer.setTextColor(Color.parseColor("#545A5F"));
                    Pfizer.setTypeface(Typeface.DEFAULT_BOLD);

                    Moderna.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    Moderna.setTextColor(Color.parseColor("#545A5F"));
                    Moderna.setTypeface(Typeface.DEFAULT);

                    Janssen.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    Janssen.setTextColor(Color.parseColor("#545A5F"));
                    Janssen.setTypeface(Typeface.DEFAULT);

                    AZ.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    AZ.setTextColor(Color.parseColor("#545A5F"));
                    AZ.setTypeface(Typeface.DEFAULT);

                    Novavax.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    Novavax.setTextColor(Color.parseColor("#545A5F"));
                    Novavax.setTypeface(Typeface.DEFAULT);


                    break;
                case R.id.Moderna:

                    contry.setText("미국");
                    platform.setText("mRNA 백신(핵산백신)");
                    cnt.setText("2회");
                    time.setText("28일");
                    storage.setText("-25°C ~ -15°C(7개월)");
                    delivery.setText("2~8°C(30일)");

                    Pfizer.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    Pfizer.setTextColor(Color.parseColor("#545A5F"));
                    Pfizer.setTypeface(Typeface.DEFAULT);

                    Janssen.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    Janssen.setTextColor(Color.parseColor("#545A5F"));
                    Janssen.setTypeface(Typeface.DEFAULT);

                    AZ.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    AZ.setTextColor(Color.parseColor("#545A5F"));
                    AZ.setTypeface(Typeface.DEFAULT);

                    Novavax.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    Novavax.setTextColor(Color.parseColor("#545A5F"));
                    Novavax.setTypeface(Typeface.DEFAULT);


                    Moderna.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    Moderna.setTextColor(Color.parseColor("#545A5F"));
                    Moderna.setTypeface(Typeface.DEFAULT_BOLD);

                    break;
                case R.id.Janssen:
                    contry.setText("미국");
                    platform.setText("바이러스 벡터 백신");
                    cnt.setText("1회 * (임상결과에 따른 변경가능)");
                    time.setText("-");
                    storage.setText("-25°C ~ -15°C(24개월)");
                    delivery.setText("2~8°C(4.5개월)");

                    Pfizer.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    Pfizer.setTextColor(Color.parseColor("#545A5F"));
                    Pfizer.setTypeface(Typeface.DEFAULT);

                    Moderna.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    Moderna.setTextColor(Color.parseColor("#545A5F"));
                    Moderna.setTypeface(Typeface.DEFAULT);

                    AZ.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    AZ.setTextColor(Color.parseColor("#545A5F"));
                    AZ.setTypeface(Typeface.DEFAULT);

                    Novavax.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    Novavax.setTextColor(Color.parseColor("#545A5F"));
                    Novavax.setTypeface(Typeface.DEFAULT);


                    Janssen.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    Janssen.setTextColor(Color.parseColor("#545A5F"));
                    Janssen.setTypeface(Typeface.DEFAULT_BOLD);


                    break;
                case R.id.AZ:
                    contry.setText("영국");
                    platform.setText("바이러스 벡터 백신");
                    cnt.setText("2회");
                    time.setText("8~12주");
                    storage.setText("2~8°C(6개월)");
                    delivery.setText("2~8°C(6개월)");

                    Pfizer.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    Pfizer.setTextColor(Color.parseColor("#545A5F"));
                    Pfizer.setTypeface(Typeface.DEFAULT);


                    Moderna.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    Moderna.setTextColor(Color.parseColor("#545A5F"));
                    Moderna.setTypeface(Typeface.DEFAULT);

                    Janssen.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    Janssen.setTextColor(Color.parseColor("#545A5F"));
                    Janssen.setTypeface(Typeface.DEFAULT);

                    Novavax.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    Novavax.setTextColor(Color.parseColor("#545A5F"));
                    Novavax.setTypeface(Typeface.DEFAULT);


                    AZ.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    AZ.setTextColor(Color.parseColor("#545A5F"));
                    AZ.setTypeface(Typeface.DEFAULT_BOLD);


                    break;
                case R.id.Novavax:
                    contry.setText("미국");
                    platform.setText("유전자 재조합 백신");
                    cnt.setText("2회");
                    time.setText("21일");
                    storage.setText("2~8°C(5개월)");
                    delivery.setText("2~8°C(5개월)");

                    Pfizer.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    Pfizer.setTextColor(Color.parseColor("#545A5F"));
                    Pfizer.setTypeface(Typeface.DEFAULT);

                    Moderna.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    Moderna.setTextColor(Color.parseColor("#545A5F"));
                    Moderna.setTypeface(Typeface.DEFAULT);

                    Janssen.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    Janssen.setTextColor(Color.parseColor("#545A5F"));
                    Janssen.setTypeface(Typeface.DEFAULT);

                    AZ.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    AZ.setTextColor(Color.parseColor("#545A5F"));
                    AZ.setTypeface(Typeface.DEFAULT);

                    Novavax.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    Novavax.setTextColor(Color.parseColor("#545A5F"));
                    Novavax.setTypeface(Typeface.DEFAULT_BOLD);


                    break;
            }

        }
    };


}

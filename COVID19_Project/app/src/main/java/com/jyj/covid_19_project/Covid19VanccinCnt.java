package com.jyj.covid_19_project;

import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;

import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Covid19VanccinCnt extends AsyncTask<String, String, ArrayList<String>> {
    String date;
    float firstCnt, secondCnt, thirdCnt;

    @Override
    protected ArrayList<String> doInBackground(String... strings) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder urlBuilder = new StringBuilder("https://nip.kdca.go.kr/irgd/cov19stats.do?list=all");

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = builder.parse(urlBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }


        System.setProperty("https.protocols", "TLSv1.2");
        doc.normalize();

        NodeList dateTagList = doc.getElementsByTagName("dataTime");

        date = dateTagList.item(0).getTextContent();
        result.add(date);


        NodeList infoTagList = doc.getElementsByTagName("item");


        for (int i = 2; i < infoTagList.getLength(); i++) {
            NodeList childNodes = infoTagList.item(i).getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                String cnt = childNodes.item(j).getTextContent();
                switch (childNodes.item(j).getNodeName()) {

                    case "firstCnt":
                    case "secondCnt":
                    case "thirdCnt":
                        if(i==2){
                            float a = (Float.parseFloat(cnt)/51306264)*100;
                            float b =  (float) (Math.floor(a*10)/10);
                            result.add(""+b);
                        }
                        if(i==3) {
                            result.add(""+childNodes.item(j).getTextContent());
                        }
                }
            }
            //oldCnt.add( Integer.parseInt(childNodes.item(j).getTextContent()));
        }

        Log.d("covid19", firstCnt + "," + secondCnt);
        Log.d("covid19", "" + result);


        return result;
    }

    @Override
    protected void onPostExecute(ArrayList<String> s) {

        super.onPostExecute(s);

        //전체 코로나 백신 차트
        ArrayList<BarEntry> datVales = new ArrayList<>();
        ArrayList<ILineDataSet> lineDataSetTotal = new ArrayList<>();
        float two = Float.parseFloat(s.get(2))-Float.parseFloat(s.get(3)) ;
        float tree = Float.parseFloat(s.get(1))-Float.parseFloat(s.get(2));
        Log.d("%", tree+","+s.get(3)+","+s.get(2)+","+two);


        datVales.add(new BarEntry(0, new float[]{Float.parseFloat(s.get(3)), two,tree}));

        MainActivity.totalVaccine.getDescription().setEnabled(false);
        MainActivity.totalVaccine.setDrawValueAboveBar(false);
        MainActivity.totalVaccine.setHighlightFullBarEnabled(false);


        BarDataSet barDataSettotal = new BarDataSet(datVales, s.get(0) + " 집계 기준");

        barDataSettotal.setStackLabels(new String[]{"3차"+s.get(3)+"%", "2차"+s.get(2)+"%", "1차"+s.get(1)+"%"});

        barDataSettotal.setColors(MainActivity.colorArray);

        BarData barDataTotal = new BarData(barDataSettotal);
        barDataTotal.setDrawValues(false);
        barDataTotal.setBarWidth(40f);

        MainActivity.totalVaccine.setData(barDataTotal);
        MainActivity.totalVaccine.setPinchZoom(false);
        MainActivity.totalVaccine.setTouchEnabled(false);



        XAxis xAxisTotal = MainActivity.totalVaccine.getXAxis();
        xAxisTotal.setDrawAxisLine(false);
        xAxisTotal.setEnabled(false);
        xAxisTotal.setLabelCount(s.size());
        xAxisTotal.setLabelRotationAngle(270f);
        MainActivity.totalVaccine.animateY(2000);
        MainActivity.totalVaccine.invalidate();

        YAxis axisLeftTotal = MainActivity.totalVaccine.getAxisLeft();
        //축 설정
        axisLeftTotal.setAxisMinimum(0f);
        axisLeftTotal.setAxisMaxValue(100f);

        axisLeftTotal.setDrawGridLines(false);
        axisLeftTotal.setDrawAxisLine(false);
        //axisLeftTotal.setTextSize(13f);
        axisLeftTotal.setEnabled(false);

        YAxis axisRightTotal = MainActivity.totalVaccine.getAxisRight();
        axisRightTotal.setDrawGridLines(false);
        axisRightTotal.setDrawAxisLine(false);
        axisRightTotal.setEnabled(false);






        //60세 이상 접종률 차트
        ArrayList<BarEntry> datVals = new ArrayList<>();
        ArrayList<ILineDataSet> lineDataSet = new ArrayList<>();
        float oldtwo = Float.parseFloat(s.get(5))-Float.parseFloat(s.get(6)) ;
        float lodtree = Float.parseFloat(s.get(4))-Float.parseFloat(s.get(5));

        datVals.add(new BarEntry(0, new float[]{Float.parseFloat(s.get(6)),oldtwo,lodtree}));


        MainActivity.mchart.getDescription().setEnabled(false);
        MainActivity.mchart.setDrawValueAboveBar(false);
        MainActivity.mchart.setHighlightFullBarEnabled(false);

        BarDataSet barDataSet = new BarDataSet(datVals, s.get(0) + " 집계 기준");
        barDataSet.setStackLabels(new String[]{"3차"+s.get(6)+"%", "2차"+s.get(5)+"%", "1차"+s.get(4)+"%"});
        barDataSet.getStackSize();



        MainActivity.mchart.setPinchZoom(false);
        MainActivity.mchart.setTouchEnabled(false);


        barDataSet.setColors(MainActivity.colorArray);

        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(40f);

        MainActivity.mchart.setData(barData);
        barData.setDrawValues(false);


        Legend l = MainActivity.mchart.getLegend();
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);



        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();

        dataSets.add(barDataSet);


        XAxis xAxis = MainActivity.mchart.getXAxis();
        xAxis.setDrawAxisLine(false);
        xAxis.setEnabled(false);
        xAxis.setLabelCount(s.size());
        xAxis.setLabelRotationAngle(270f);
        MainActivity.mchart.animateY(2000);
        MainActivity.mchart.invalidate();




        YAxis axisLeft = MainActivity.mchart.getAxisLeft();

        axisLeft.setAxisMinimum(0f);
        axisLeft.setAxisMaxValue(100f);
        axisLeft.setDrawGridLines(false);
        axisLeft.setDrawAxisLine(false);
        axisLeft.setTextSize(13f);
        axisLeft.setEnabled(false);

        YAxis axisRight = MainActivity.mchart.getAxisRight();
        axisRight.setDrawGridLines(false);
        axisRight.setDrawAxisLine(false);
        axisRight.setEnabled(false);

    }
}



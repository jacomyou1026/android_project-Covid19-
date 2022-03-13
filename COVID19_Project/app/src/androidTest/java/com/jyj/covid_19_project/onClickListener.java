package com.jyj.covid_19_project;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;

public interface onClickListener {
    MainActivity m = new MainActivity();

    View.OnClickListener click =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.Pfizer:

                    m.contry.setText("미국/독일");
                    m.platform.setText("mRNA 백신(핵산백신)");
                    m.cnt.setText("2회");
                    m.time.setText("21일");
                    m.storage.setText("-90°C ~ -60°C(6개월)");
                    m.delivery.setText("2~8°C(5일)");

                    m.Pfizer.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    m.Pfizer.setTextColor(Color.parseColor("#545A5F"));
                    m.Pfizer.setTypeface(Typeface.DEFAULT_BOLD);

                    m.Moderna.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    m.Moderna.setTextColor(Color.parseColor("#545A5F"));
                    m.Moderna.setTypeface(Typeface.DEFAULT);

                    m.Janssen.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    m.Janssen.setTextColor(Color.parseColor("#545A5F"));
                    m.Janssen.setTypeface(Typeface.DEFAULT);

                    m.AZ.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    m.AZ.setTextColor(Color.parseColor("#545A5F"));
                    m.AZ.setTypeface(Typeface.DEFAULT);

                    m.Novavax.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    m.Novavax.setTextColor(Color.parseColor("#545A5F"));
                    m.Novavax.setTypeface(Typeface.DEFAULT);




                    break;
                case R.id.Moderna:

                    m.contry.setText("미국");
                    m.platform.setText("mRNA 백신(핵산백신)");
                    m.cnt.setText("2회");
                    m.time.setText("28일");
                    m.storage.setText("-25°C ~ -15°C(7개월)");
                    m.delivery.setText("2~8°C(30일)");

                    m.Pfizer.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    m.Pfizer.setTextColor(Color.parseColor("#545A5F"));
                    m.Pfizer.setTypeface(Typeface.DEFAULT);

                    m.Janssen.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    m.Janssen.setTextColor(Color.parseColor("#545A5F"));
                    m.Janssen.setTypeface(Typeface.DEFAULT);

                    m.AZ.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    m.AZ.setTextColor(Color.parseColor("#545A5F"));
                    m.AZ.setTypeface(Typeface.DEFAULT);

                    m.Novavax.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    m.Novavax.setTextColor(Color.parseColor("#545A5F"));
                    m.Novavax.setTypeface(Typeface.DEFAULT);


                    m.Moderna.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    m.Moderna.setTextColor(Color.parseColor("#545A5F"));
                    m.Moderna.setTypeface(Typeface.DEFAULT_BOLD);

                    break;
                case R.id.Janssen:
                    m.contry.setText("미국");
                    m.platform.setText("바이러스 벡터 백신");
                    m.time.setText("-");
                    m.storage.setText("-25°C ~ -15°C(24개월)");
                    m.delivery.setText("2~8°C(4.5개월)");

                    m.Pfizer.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    m.Pfizer.setTextColor(Color.parseColor("#545A5F"));
                    m.Pfizer.setTypeface(Typeface.DEFAULT);

                    m.Moderna.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    m.Moderna.setTextColor(Color.parseColor("#545A5F"));
                    m.Moderna.setTypeface(Typeface.DEFAULT);

                    m.AZ.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    m.AZ.setTextColor(Color.parseColor("#545A5F"));
                    m.AZ.setTypeface(Typeface.DEFAULT);

                    m.Novavax.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    m.Novavax.setTextColor(Color.parseColor("#545A5F"));
                    m.Novavax.setTypeface(Typeface.DEFAULT);


                    m.Janssen.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    m. Janssen.setTextColor(Color.parseColor("#545A5F"));
                    m.Janssen.setTypeface(Typeface.DEFAULT_BOLD);



                    break;
                case R.id.AZ:
                    m.contry.setText("영국");
                    m. platform.setText("바이러스 벡터 백신");
                    m. cnt.setText("2회");
                    m.time.setText("8~12주");
                    m.storage.setText("2~8°C(6개월)");
                    m.delivery.setText("2~8°C(6개월)");

                    m.Pfizer.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    m.Pfizer.setTextColor(Color.parseColor("#545A5F"));
                    m.Pfizer.setTypeface(Typeface.DEFAULT);


                    m.Moderna.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    m.Moderna.setTextColor(Color.parseColor("#545A5F"));
                    m.Moderna.setTypeface(Typeface.DEFAULT);

                    m.Janssen.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    m.Janssen.setTextColor(Color.parseColor("#545A5F"));
                    m.Janssen.setTypeface(Typeface.DEFAULT);

                    m.Novavax.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    m.Novavax.setTextColor(Color.parseColor("#545A5F"));
                    m.Novavax.setTypeface(Typeface.DEFAULT);


                    m.AZ.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    m.AZ.setTextColor(Color.parseColor("#545A5F"));
                    m.AZ.setTypeface(Typeface.DEFAULT_BOLD);



                    break;
                case R.id.Novavax:
                    m.contry.setText("미국");
                    m.platform.setText("유전자 재조합 백신");
                    m.cnt.setText("2회");
                    m.time.setText("21일");
                    m.storage.setText("2~8°C(5개월)");
                    m.delivery.setText("2~8°C(5개월)");

                    m. Pfizer.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    m. Pfizer.setTextColor(Color.parseColor("#545A5F"));
                    m.Pfizer.setTypeface(Typeface.DEFAULT);

                    m.Moderna.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    m.Moderna.setTextColor(Color.parseColor("#545A5F"));
                    m.Moderna.setTypeface(Typeface.DEFAULT);

                    m.Janssen.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    m.Janssen.setTextColor(Color.parseColor("#545A5F"));
                    m.Janssen.setTypeface(Typeface.DEFAULT);

                    m.AZ.setBackgroundColor(Color.parseColor("#F5F5F5"));
                    m.AZ.setTextColor(Color.parseColor("#545A5F"));
                    m.AZ.setTypeface(Typeface.DEFAULT);

                    m. Novavax.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    m.Novavax.setTextColor(Color.parseColor("#545A5F"));
                    m.Novavax.setTypeface(Typeface.DEFAULT_BOLD);



                    break;
            }

        }
    };
}


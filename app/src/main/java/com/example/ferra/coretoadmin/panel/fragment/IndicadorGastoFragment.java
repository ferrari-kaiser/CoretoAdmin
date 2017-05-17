package com.example.ferra.coretoadmin.panel.fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.ferra.coretoadmin.R;
import com.example.ferra.coretoadmin.panel.presenter.IndicatorsFragmentPresenter;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.HashMap;


public class IndicadorGastoFragment extends Fragment implements OnChartValueSelectedListener {

    protected TableLayout mTableContainer;
    private ArrayList<Float> yData;
    private ArrayList<String> xData;
    private ArrayList < Integer > mColors;
    private Float mtotalSomaValue;
    protected PieChart mChart;
    private View mView;
    IndicatorsFragmentPresenter mIndicatorsFragmentPresenter;
    private HashMap<Integer, Integer> mMapChartPosition = new HashMap<Integer, Integer>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the fragment and get the view
        mView = inflater.inflate(R.layout.fragment_indicador_gasto, null);

        mChart = (PieChart)mView.findViewById(R.id.chart_applications_distribution);
        mTableContainer =(TableLayout)mView.findViewById(R.id.tl_values_table_container);

        yData = new ArrayList<Float>();
        xData = new ArrayList<String>();


        yData.add(300.0f);
        yData.add(2000.0f);
        yData.add(10000.0f);

        xData.add("Gasto 1");
        xData.add("Gasto 2");
        xData.add("Gasto 3");
        // add a lot of colors
        mColors = new ArrayList <Integer>();

        mColors.add(Color.parseColor("#71A9D7"));
        mColors.add(Color.parseColor("#32BBCF"));
        mColors.add(Color.parseColor("#FFE461"));
        mColors.add(Color.parseColor("#0C7CBA"));
        mColors.add(Color.parseColor("#0A5988"));
        mColors.add(Color.parseColor("#5D7AA1"));
        mColors.add(Color.parseColor("#87A5AF"));
        mColors.add(Color.parseColor("#BCD0AC"));
        mColors.add(Color.parseColor("#E6E88B"));
        mColors.add(Color.parseColor("#C2A370"));
        mColors.add(Color.parseColor("#936661"));
        mColors.add(Color.parseColor("#522F84"));
        mColors.add(Color.parseColor("#FF7043"));
        mColors.add(Color.parseColor("#9FC5F8"));
        mColors.add(Color.parseColor("#FF4081"));


        initChart();
        setTableData();

        return mView;
    }


    private void initChart() {

        mChart.setUsePercentValues(false);

        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColor(Color.WHITE);
        mChart.setOnChartValueSelectedListener(this);

        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);

        mChart.setHoleRadius(58f);
        mChart.setTransparentCircleRadius(61f);
        mChart.setCenterText("R$" + mtotalSomaValue);
        mChart.setDrawCenterText(true);

        mChart.setRotationAngle(0);
        mChart.setOnClickListener(tableItemClickListener());

        // enable rotation of the chart by touch
        mChart.setRotationEnabled(false);
        mChart.setHighlightPerTapEnabled(true);

        // add a selection listener
        mChart.setOnChartValueSelectedListener(this);

        addData();

        Legend l = mChart.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        l.setXEntrySpace(7);
        l.setYEntrySpace(5);

        // Hide the slice text
        mChart.setDrawSliceText(false);


        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);

        mChart.getLegend().setEnabled(false);

    }

    private void addData() {
        int listCounter = 0;
        int emptyCounter = 0;

        ArrayList<PieEntry> yVals1 = new ArrayList<PieEntry>();
        ArrayList<String> xvals = new ArrayList<String>();

        for (int i = 0; i < yData.size(); i++) {
            yVals1.add(new PieEntry(yData.get(i), i));
            xvals.add(xData.get(i));
            mMapChartPosition.put(emptyCounter, listCounter);
            emptyCounter++;
            listCounter++;
        }

        for (int i = 0; i < xData.size(); i++) {
            xvals.add(xData.get(i));
        }

        //Create pie Data Set
        PieDataSet dataset = new PieDataSet(yVals1, "Market");
        dataset.setSliceSpace(3);
        dataset.setSelectionShift(5);
        dataset.setColors(mColors);

        //Intantiate pie data object
        PieData data = new PieData(dataset);

        data.setValueFormatter(new PercentFormatter());

        mChart.setData(data);
        mChart.highlightValue(null);
        mChart.invalidate();
    }

    //    TableLayout
    private void setTableData() {
        mTableContainer.removeAllViews();
        int listCounter = 0;
        int emptyCounter = 0;

        for (int i = 0; i < xData.size(); i++) {

            String dataName = xData.get(i);
            String dataValue = ("R$ " + yData.get(i));

            View tableItem = getActivity().getLayoutInflater().inflate(R.layout.applications_distribution_item, mTableContainer, false);

            tableItem.setBackgroundColor((listCounter % 2 == 0) ? getResources().getColor(R.color.gt_transparent)
                    : getResources().getColor(R.color.gt_white));


            tableItem.setTag(i);
            ImageView colorBadge = (ImageView) tableItem.findViewById(R.id.ll_color_badge);
            intiImage(dataName, colorBadge);
            TextView productName = (TextView) tableItem.findViewById(R.id.tv_product_name);
            productName.setText(dataName);
            TextView productValue = (TextView) tableItem.findViewById(R.id.tv_product_value);
            productValue.setText(String.valueOf(dataValue));
            tableItem.setOnClickListener(tableItemClickListener());

            mTableContainer.addView(tableItem);
        }
    }



    public void intiImage(String imteName, ImageView itemImageView){
        switch (imteName){
            case"Transporte":
                itemImageView.setImageResource(R.mipmap.ic_transporte);
                break;
            case"Alimentação":
                itemImageView.setImageResource(R.mipmap.ic_refeicao);
                break;
            case"Residencia":
                itemImageView.setImageResource(R.mipmap.ic_residencia);
                break;
            case"Educação":
                itemImageView.setImageResource(R.mipmap.ic_estud);
                break;
            case"Saúde":
                itemImageView.setImageResource(R.mipmap.ic_saude);
                break;
            case"Entreterimento":
                itemImageView.setImageResource(R.mipmap.ic_saude);
                break;
            default:
                itemImageView.setImageResource(R.mipmap.ic_transporte);
                break;
        }

    }

    /**
     * Click listener for the table item, to highlight an item in the PieChart.
     * @return
     */
    private View.OnClickListener tableItemClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mPosition = (int) v.getTag();

                if (xData != null && xData.size() > 0) {

                    xData.get(mPosition);
                    mChart.highlightValue(mPosition, 0);
                    mChart.setCenterText(generateCenterSpannableText("R$" + String.valueOf(yData.get(mPosition))));
                    for (int i = 0; i < mTableContainer.getChildCount(); i++) {
                        TableRow row = (TableRow) mTableContainer.getChildAt(i);
                        ((TextView) row.findViewById(R.id.tv_product_name)).setTypeface(null, Typeface.NORMAL);
                    }

                    ((TextView) v.findViewById(R.id.tv_product_name)).setTypeface(null, Typeface.BOLD);
                }
            }
        };
    }

    private SpannableString generateCenterSpannableText(String text) {
        text = text.replace("R$", "");
        if (Float.parseFloat(text) == 100) {
            text = text.replace(".0", "");
            text = String.valueOf(Integer.parseInt(text)).concat("R$");
        } else {
            text = String.format("R$"+"%.2f", Float.parseFloat(text)).concat("").replace(".", ",");
        }

        SpannableString s = new SpannableString(text);
        s.setSpan(new RelativeSizeSpan(1.7f), 0, text.length(), 0);
        return s;
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        if (e == null) return;
        if (mTableContainer.getChildCount() > 0) {
            if (mMapChartPosition.get(h.getDataIndex()) != null) {

                int listIndex = mMapChartPosition.get(h.getDataIndex());

                for (int i = 0; i < mTableContainer.getChildCount(); i++) {
                    TableRow r = (TableRow) mTableContainer.getChildAt(i);
                    ((TextView) r.findViewById(R.id.tv_product_name)).setTypeface(null, Typeface.NORMAL);
                }
                TableRow row = (TableRow) mTableContainer.getChildAt(listIndex);
                ((TextView) row.findViewById(R.id.tv_product_name)).setTypeface(null, Typeface.BOLD);
            }
        }
    }

    //    Interface Calbacks
    @Override
    public void onNothingSelected() {

    }
}

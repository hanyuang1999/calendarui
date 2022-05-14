package cn.zpengc.application;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;

import cn.zpengc.application.databinding.ChartBinding;
import cn.zpengc.application.local.service.TodoService;

public class ChartActivity extends AppCompatActivity{

    private ChartBinding binding;
    private TodoService service;
    final int[] colors = {Color.RED, Color.GREEN, Color.CYAN};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ChartBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);

        service = new TodoService(this);

        binding.barBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo
                drawBarChart("2022-06-06", "2022-10-01");
            }
        });

        binding.pieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo
                drawPieChart("2022-06-06", "2022-10-01");
            }
        });
    }



    private void drawPieChart(String start, String end) {
        List<Integer> statistics = service.statistics(start, end);
        float ok = statistics.get(1) * 1.0f / (statistics.get(0) + statistics.get(1));  // 完成
        float no = statistics.get(0) * 1.0f / (statistics.get(0) + statistics.get(1)); // 待完成

        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(ok, "已完成"));
        entries.add(new PieEntry(no, "待完成"));
        PieDataSet pieDataSet = new PieDataSet(entries, start + "~" + end + "之间的todo完成情况");
        pieDataSet.setSliceSpace(5f);
        pieDataSet.setColors(colors);
        PieData pieData = new PieData(pieDataSet);
        pieData.setValueTextSize(20);
        binding.pieChart.setData(pieData);
        binding.pieChart.invalidate();
    }

    private void drawBarChart(String start, String end) {
        List<Integer> statistics = service.statistics(start, end);
        int ok = statistics.get(1);  // 完成
        int no = statistics.get(0); // 待完成

        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, no));  // 待完成
        entries.add(new BarEntry(1, ok));  // 完成
        BarDataSet barDataSet = new BarDataSet(entries, start + "~" + end + "之间的todo完成情况");
        barDataSet.setColors(colors);
        BarData barData = new BarData(barDataSet);
        binding.barChart.setData(barData);
        binding.barChart.invalidate();
    }
}

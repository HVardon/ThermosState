package rodez.iut.thermosstate;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(getDataPoint());
        graph.addSeries(series);
        //couleurs du tracé
        series.setColor(Color.rgb(255,109,0));
        //création de points
        series.setDrawDataPoints(true);

    }


    private DataPoint[] getDataPoint() {

        DataPoint[] dp= new DataPoint[]{
                new DataPoint(0, 5),
                new DataPoint(1, 9),
                new DataPoint(2, 14),
        };
        return (dp);
    }
}

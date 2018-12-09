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

    //format heure
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

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

        //affichage du nombre d'éléments sur l'axe des abscisses
        //graph.getGridLabelRenderer().setNumHorizontalLabels(10);

        //permet de gérer les valeurs de l'axe des abscisses
        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    return sdf.format(new Date((long) value));
                } else {
                    return super.formatLabel(value, isValueX);
                }
            }
        });
    };


    private DataPoint[] getDataPoint() {

        DataPoint[] dp= new DataPoint[]{
                new DataPoint(new Date().getTime(), 5),
                new DataPoint(new Date().getTime(), 9),
                new DataPoint(new Date().getTime(), 14),
        };
        return (dp);
    }
}

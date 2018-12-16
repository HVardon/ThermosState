package rodez.iut.thermosstate;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import java.text.SimpleDateFormat;
import java.util.Date;

import static rodez.iut.thermosstate.LectureFichier.lignesFichier;


public class MainActivity extends AppCompatActivity {

    //format horaire
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    private Button parametres;

    // intent pour accéder à l'activity Paramètres
    public void openParametres(){
        Intent intent = new Intent(this,Parametres.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //methode permetant d'appliquer l'intent suite à un clic
        parametres = findViewById(R.id.btn_Param);
        parametres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openParametres();
            }
        });

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(getDataPoint());
        graph.addSeries(series);
        //couleurs du tracé
        series.setColor(Color.rgb(255,109,0));
        //création de points
        series.setDrawDataPoints(true);

        //affichage du nombre d'éléments sur l'axe des abscisses
        //graph.getGridLabelRenderer().setNumHorizontalLabels(24);


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

        try {
            InputStream is = getAssets().open("Temperature.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // permet de zoomer et de scroller horizontalement
        graph.getViewport().setScalable(true);

    };

    private DataPoint[] getDataPoint() {


        DataPoint[] dp= new DataPoint[]{
                new DataPoint(new Date().getTime(),-5),
                new DataPoint(new Date().getTime(), lignesFichier("Temperature")),
                new DataPoint(new Date().getTime(), 9),

        };
        return (dp);
    }
}

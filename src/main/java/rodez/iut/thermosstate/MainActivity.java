package rodez.iut.thermosstate;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import java.text.SimpleDateFormat;
import java.util.Date;



public class MainActivity extends AppCompatActivity {

    //format date
    SimpleDateFormat sdf;

    private Button parametres;
    private Button jour;
    private Button semaine;
    private Button mois;

    GraphView graph;

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


        //Bouton jour qui permet l'affichage des horaires
        jour = findViewById(R.id.btn_Jour);
        //Bouton semaine qui permet l'affichage des dates
        semaine = findViewById(R.id.btn_Semaine);
        //Bouton mois qui permet l'affichage des dates
        mois = findViewById(R.id.btn_Mois);

        sdf = new SimpleDateFormat("dd/MM/yy");
        init();

        jour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sdf = new SimpleDateFormat("HH:mm:ss");
                init();
                graph.getViewport().setXAxisBoundsManual(true);
                graph.getViewport().setMinX(new Date(2018,11,25,0,1,1).getTime()-86400000);
                graph.getViewport().setMaxX(new Date(2018,11,25,0,1,1).getTime());
            }
        });

        semaine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sdf = new SimpleDateFormat("dd/MM/yy");
                init();
                graph.getViewport().setXAxisBoundsManual(true);
                graph.getViewport().setMinX(new Date(2018,11,25,0,1,1).getTime()-604800000);
                graph.getViewport().setMaxX(new Date(2018,11,25,0,1,1).getTime());
            }
        });

        mois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sdf = new SimpleDateFormat("dd/MM/yy");
                init();
                graph.getViewport().setXAxisBoundsManual(true);
                graph.getViewport().setMinX(new Date(2018,11,25,0,1,1).getTime() - 604800000*3 );
                graph.getViewport().setMaxX(new Date(2018,11,25,0,1,1).getTime());
            }
        });


    };

    private void init(){
        graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(getDataPoint());
        graph.addSeries(series);
        //couleurs du tracé
        series.setColor(Color.rgb(255,109,0));
        //création de points
        series.setDrawDataPoints(true);

        graph.getGridLabelRenderer().setNumHorizontalLabels(3);
        graph.getGridLabelRenderer().setNumVerticalLabels(5);
        graph.getGridLabelRenderer().setHumanRounding(false);
        //affichage du nombre d'éléments sur l'axe des abscisses
        //graph.getGridLabelRenderer().setNumHorizontalLabels(24);

        //permet de gérer les valeurs de l'axe des abscisses
        format();

        // permet de zoomer et de scroller horizontalement et verticalement
        graph.getViewport().setScalable(true);

    }

    private void format() {
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
    }

    private DataPoint[] getDataPoint() {

        Date m= new Date(2018,10,22,14,25,42);
        Date a= new Date(2018,11,22,14,25,42);
        Date b= new Date(2018,11,23,14,25,42);
        Date c= new Date(2018,11,24,14,25,42);
        Date d= new Date(2018,11,25,0,1,1);

        double temperatureA = -5;
        double temperatureB = 4;
        double temperatureC = 9;
        double temperatureD = 50;


        DataPoint[] dp= new DataPoint[]{
                new DataPoint(m.getTime(),temperatureA),
                new DataPoint(a.getTime(),temperatureA),
                new DataPoint(b.getTime(),temperatureB),
                new DataPoint(c.getTime(), temperatureC),
                new DataPoint(d.getTime(), temperatureD),

        };
        return (dp);
    }
}

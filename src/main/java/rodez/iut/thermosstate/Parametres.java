package rodez.iut.thermosstate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Parametres extends AppCompatActivity {
    Spinner spinnerVal, spinnerValType; // liste déroulante pour valeurs et type de valeurs

    private Button retour;
    // intent pour accéder à l'accueil
    public void openAccueil(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        spinnerVal = (Spinner) findViewById(R.id.spinnerVal);
        spinnerValType = (Spinner) findViewById(R.id.spinnerValType);
        // création d'un ArrayAdaptater permettant de changer l'arrayList d'un spinner, ici on lui attribu celle des secondes et minutes
        final ArrayAdapter<CharSequence> ADAPTERSM =  ArrayAdapter.createFromResource(this,R.array.valeur_SecMin,android.R.layout.simple_spinner_item);
        // création d'un ArrayAdaptater permettant de changer l'arrayList d'un spinner, ici on lui attribu celle des heures
        final ArrayAdapter<CharSequence> ADAPTERH =  ArrayAdapter.createFromResource(this,R.array.valeur_heure,android.R.layout.simple_spinner_item);

        //permet d'adapter la liste déroulante de valeur en fonction de celle du type
        spinnerValType.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinnerValType.getSelectedItem().equals("Seconde(s)") || spinnerValType.getSelectedItem().equals("Minute(s)")){
                    spinnerVal.setAdapter(ADAPTERSM);
                } else if(spinnerValType.getSelectedItem().equals("Heure(s)")) {
                    spinnerVal.setAdapter(ADAPTERH);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //methode permetant d'appliquer l'intent retour après un clic
        retour = findViewById(R.id.btn_Retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAccueil();
            }
        });
    }

}

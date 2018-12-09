package rodez.iut.thermosstate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Parametres extends AppCompatActivity {

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

        //methode permetant d'appliquer l'intent suite à un clic
        retour = findViewById(R.id.btn_Retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAccueil();
            }
        });
    }
}

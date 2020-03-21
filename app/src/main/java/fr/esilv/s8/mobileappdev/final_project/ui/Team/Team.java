package fr.esilv.s8.mobileappdev.final_project.ui.Team;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.esilv.s8.mobileappdev.final_project.R;

public class Team extends AppCompatActivity {

    private TextView mName;
    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        // boucle pour recup les données de la premiere activite
        Intent intent = getIntent();
        if(intent != null)
        {
            String str = "";
            if(intent.hasExtra("name")){ // vérifie qu'une valeur est associée à la clé “edittext”
                str = intent.getStringExtra("name"); // on récupère la valeur associée à la clé
            }
            TextView mName = (TextView) findViewById(R.id.activity_team_name);
            mName.setText(str); // on affiche le texte recupere
        }

        mButton = (Button) findViewById(R.id.activity_team_close);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish(); // close the activity
            }
        });

    }
}

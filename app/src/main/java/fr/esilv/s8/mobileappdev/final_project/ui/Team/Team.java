package fr.esilv.s8.mobileappdev.final_project.ui.Team;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.esilv.s8.mobileappdev.final_project.MainActivity;
import fr.esilv.s8.mobileappdev.final_project.R;
import fr.esilv.s8.mobileappdev.final_project.ui.Team.AdapterTeam;

public class Team extends AppCompatActivity {

    public TextView mName;
    private Button mButton;
    private RecyclerView rv;


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
            mName.setText(str + ", voici les membres de Slide Session, contacte les si tu as des questions !"); // on affiche le texte recupere
        }


        mButton = (Button) findViewById(R.id.activity_team_close);
        rv = (RecyclerView) findViewById(R.id.acticity_team_rv);

        int[] photo = new int[]{R.drawable.slide,R.drawable.guillaume, R.drawable.pauline,
                R.drawable.loris, R.drawable.pierre, R.drawable.marius, R.drawable.melvyn};

        String[] desc = new String[]{"L'association","Président\n -\n Guillaume BOULEY", "Vice-Présidente\n -\n Pauline RICHE", "Trésorier\n -\n Loris HUMBERT",
                "Vice-Trésorier\n -\n Pierre VERSINI", "Secrétaire\n -\n Marius HUTSON", "Responsable Communication\n -\n Melvyn CEYSSAT"};

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(linearLayoutManager);
        AdapterTeam adapterTeam = new AdapterTeam(this, photo, desc);
        rv.setAdapter(adapterTeam);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // close the activity
            }
        });


    }
}

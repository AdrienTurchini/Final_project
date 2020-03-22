package fr.esilv.s8.mobileappdev.final_project.ui.Asso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.esilv.s8.mobileappdev.final_project.R;

public class Asso extends AppCompatActivity {

    private Button mButton;
    private RecyclerView rv;
    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asso);

        // boucle pour recup les données de la premiere activite
        Intent intent = getIntent();
        if(intent != null)
        {
            String str = "";
            if(intent.hasExtra("name")){ // vérifie qu'une valeur est associée à la clé “edittext”
                str = intent.getStringExtra("name"); // on récupère la valeur associée à la clé
            }
            name = str;
        }

        mButton = (Button) findViewById(R.id.activity_asso_close);
        rv = (RecyclerView) findViewById(R.id.acticity_asso_rv);

        String[] title = new String[]{name,"L'histoire", "Ce que l'on fait","Voyage au ski","Altigliss","Nos sponsors","Notre devise"};
        String[] desc = new String[]{"voici toutes les informations qui feront de toi un véritable Slideur.","Slide Session est une asso créée en xxxx etc. ", "Tout au long de l'année nous nous engageons dans de nombreux projets etc.", "xxxx", "Altigliss c'est le championnat du monde étudiant de ski.", "xxxxxxx", "xxxxx" };
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
        AdapterAsso adapterAsso = new AdapterAsso(this,title,desc);
        rv.setAdapter(adapterAsso);


        /*
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new AdapterAsso());

*/


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // close the activity
            }
        });


    }
}

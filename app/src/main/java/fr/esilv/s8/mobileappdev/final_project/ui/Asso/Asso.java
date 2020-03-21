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

    private TextView mName;
    private Button mButton;
    private RecyclerView rv;




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
            TextView mName = (TextView) findViewById(R.id.activity_asso_name);
            mName.setText(str); // on affiche le texte recupere
        }

        mButton = (Button) findViewById(R.id.activity_asso_close);
        mName = (TextView) findViewById(R.id.activity_asso_name);

        rv = (RecyclerView) findViewById(R.id.acticity_asso_rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new AdapterAsso());




        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // close the activity
            }
        });


    }
}

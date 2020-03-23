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

        String[] title = new String[]{name,
                "L'histoire",
                "Voyage au ski",
                "Altigliss",
                "Nos sponsors"};
        String[] desc = new String[]{"Tu peux découvrir ici toutes les informations qui peuvent faire de toi un véritable Slideur. " +
                "D'Altigliss au voyage au ski, tu seras bientôt incollable sur tout ce qui concerne notre association et qui sait tu pourras ainsi peut-être la rejoidnre par la suite.", // présentation, name
                "Depuis le 27 Octobre 2000, Slide Session est l’association de glisse du Pôle Universitaire Léonard de Vinci.\n\n" +
                        "Situé à La Défense, ce pôle est constitué de 3 écoles : ESILV (école d’ingénieur), EMLV (école de management), " +
                        "IIM (école du multimédia) et rassemble plus de 6000 étudiants, ainsi que 2000 alumnis encore très actifs dans la vie du pôle." +
                        "L’association Slide Session est l’une des plus vieilles associations du pôle. Elle regroupe 55 membres actifs, provenant de toutes les écoles confondues.\n\n" +
                        "Cette année et pour la troisème fois consécutive, nous avons pour projet de participer au GEM Altigliss Challenge.", // l'histoire
                "Chaque année, Slide organise un voyage à la montagne ouvert à tous les étudiants du Pôle Universitaire Léonard de Vinci. " +
                        "Pour te donner une idée nous sommes partis cette année aux Alpes d'Huez, aux Menuires en 2019 ou encore à Serre Chevalier en 2018.\n\n" +
                        "Tu l'as compris, entre ski, snow, luge, bar d'altitude et soirées c'est une semaine inoubliable qui t'attend donc soit prêt lorsque les places sortent mi-novembre !",
                "Chaque année, l’association Altigliss de l’EM Grenoble organise la Coupe du monde de ski étudiante pour plus de 1000 participants, " +
                        "(ainsi que tous les étudiants de l’école) venus des meilleures écoles et universités d’Europe. " +
                        "La 21ème édition se déroulera encore une fois dans le mythique village de Val d’Isère. (1000 m2 de village au centre de la station)\n\n" +
                        "Cette compétition est aussi le moyen de sensibiliser les étudiants au développement durable, au handisport " +
                        "(trophée handisport avec la présence de Marie Bochet, championne paralympique de ski) et aux risques en montagne.\n\n" +
                "Quelques chiffres, plus de 1000 étudiants de 45 écoles, 30 nationalités et 10 pays présents, 3 compétitions soit 20 épreuves sportives !\n\n" +
                "Les différents challenges sont le Challenge Ski qui porte bien son nom, le Challenge Montagne avec des activités comme le biathlon ou la randonnée " +
                        "ainsi que le Challenge Village, un challenge d'ambiance qui se déroule toute la journée et qui permet de gagner en visibilité.",
                "Ils nous ont fait confiance : \n\n SAMT Armaturiers, Le Grenier à Pain, Baïonade, ASPOM, Le Grenier à Pain, la SNCF, Lydia, Alphonse, " +
                        "Viseu Peinture, Xtreamwave, VPEAS, Minoteries Chartres et Le Snooker."};
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

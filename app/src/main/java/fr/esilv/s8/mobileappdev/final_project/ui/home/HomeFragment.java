package fr.esilv.s8.mobileappdev.final_project.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import fr.esilv.s8.mobileappdev.final_project.MainActivity;
import fr.esilv.s8.mobileappdev.final_project.R;
import fr.esilv.s8.mobileappdev.final_project.ui.Asso.Asso;
import fr.esilv.s8.mobileappdev.final_project.ui.Team.Team;

public class HomeFragment extends Fragment {

    private TextView mWelcomeText;
    private EditText mName;
    private Button mButton_asso;
    private Button mButton_team;
    private ImageView mPhoto;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Mets en place les différents composants, lier xml au code java
        mWelcomeText = (TextView) root.findViewById(R.id.fragment_home_welcomeText);
        mName = (EditText) root.findViewById(R.id.fragment_home_name);
        mButton_asso = (Button) root.findViewById(R.id.fragment_home_button_asso);
        mButton_team = (Button) root.findViewById(R.id.fragment_home_button_team);

        mPhoto = (ImageView) root.findViewById(R.id.fragment_home_photo);

        //  désactive le bouton lors de la création de la page
        mButton_asso.setEnabled(false);
        mButton_team.setEnabled(false);

        // ajoute un listener pour voir quand modification du texte sous la forme d'une classe anonyme
        mName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // verifie qu'il y a au moins une lettre et active le bouton si oui
                mButton_asso.setEnabled(s.toString().length() != 0);
                mButton_team.setEnabled(s.toString().length() != 0);

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        // ajoute un listener qui regarde si on a cliqué sur le bouton
        mButton_asso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // l'utilisateur a cliqué sur le bouton et cela lance la nouvelle activite en communiquant avec l'ActivityManger de Android
                Intent Asso = new Intent(getActivity(), Asso.class);
                String name = mName.getText().toString(); // on convertit en string l'input
                Asso.putExtra("name", name); // on passe en putExtra pour passer a l'autre activite
                startActivityForResult(Asso, SECOND_ACTIVITY_REQUEST_CODE); // on lance l'autre activite
            }
        });

        mButton_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // l'utilisateur a cliqué sur le bouton et cela lance la nouvelle activite en communiquant avec l'ActivityManger de Android
                Intent Team = new Intent(getActivity(), Team.class);
                String name = mName.getText().toString(); // on convertit en string l'input
                Team.putExtra("name", name); // on passe en putExtra pour passer a l'autre activite
                startActivityForResult(Team, SECOND_ACTIVITY_REQUEST_CODE); // on lance l'autre activite
            }
        });




        return root;
    }
}
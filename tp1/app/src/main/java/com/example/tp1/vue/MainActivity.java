package com.example.tp1.vue;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tp1.R;
import com.example.tp1.controleur.Controle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        init() ;

    }

    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private RadioButton rdFemme;
    private TextView Labelimg;
    private ImageView Sadimg;
    private Controle controle;

private void init(){
    txtPoids = (EditText) findViewById(R.id.txtPoids);
    txtTaille =(EditText)  findViewById(R.id.txtTaille);
    txtAge =(EditText) findViewById(R.id.txtAge);
    rdHomme =(RadioButton) findViewById(R.id.rdHomme);
    rdFemme =(RadioButton) findViewById(R.id.rdFemme);
    Labelimg = (TextView) findViewById(R.id.Labelimg);
    Sadimg =(ImageView) findViewById(R.id.Sadimg);
    this.controle = Controle.getInstance(this) ;
    ecouteCalcul();
    recupProfil();
}

private void ecouteCalcul (){
    ((Button) findViewById(R.id.btnCalc)).setOnClickListener(new View.OnClickListener()  {
      public void onClick(View v){
         // Toast.makeText(MainActivity.this , "test" , Toast.LENGTH_SHORT).show() ;
          Integer poids = 0;
          Integer taille = 0;
          Integer age = 0;
          Integer sexe = 0;
          try {
              poids = Integer.parseInt(txtPoids.getText().toString());
              taille = Integer.parseInt(txtTaille.getText().toString());
              age = Integer.parseInt(txtAge.getText().toString());
          }catch(Exception e){};
          if (rdHomme.isChecked()){
              sexe = 1 ;
          }
          if(poids ==0 || taille==0 || age==0){
              Toast.makeText(MainActivity.this , "saisie incorrect" , Toast.LENGTH_SHORT).show() ;
          }else {
            afficheResult(poids , taille , age,sexe);
          }

        }
    }) ;
}

private void afficheResult (Integer poids , Integer taille, Integer age , Integer sexe){
   this.controle.creerProfil(poids , taille , age , sexe, this );
   float img = this.controle.getImg() ;
   String message = this.controle.getMessage() ;
if (message.equals("normal")){
    Sadimg.setImageResource(R.drawable.smileyface);
    Labelimg.setTextColor(Color.GREEN);
}else{
    Labelimg.setTextColor(Color.RED);
    if (message.equals("trop faible")){
        Sadimg.setImageResource(R.drawable.sadface);
    }else{
        Sadimg.setImageResource(R.drawable.sadface);
    }
}
Labelimg.setText(String.format("%.01f",img)+" : IMG "+message) ;
}

    private void recupProfil(){
        if(controle.getPoids() != null ){
            txtPoids.setText(String.valueOf(controle.getPoids())); // Convert Integer to String
            txtTaille.setText(String.valueOf(controle.getTaille())); // Convert Integer to String
            txtAge.setText(String.valueOf(controle.getAge()));
            rdFemme.setChecked(true);
            if(controle.getSexe()==1) {
                rdHomme.setChecked(true);
            }
            ((Button)findViewById(R.id.btnCalc)).performClick();

        }
    }
}
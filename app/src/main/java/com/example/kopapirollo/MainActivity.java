package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btnRock,btnPaper, btnScissors;
    private int player, comp;
    private TextView p_pont, c_pont;
    private ImageView player_view, copm_view;
    //private Toast eredmeny;
    private AlertDialog.Builder jatekVege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player_view.setImageResource(R.drawable.rock);
                if(gep()==0){
                    copm_view.setImageResource(R.drawable.rock);
                }
                else if(gep()==1){
                    copm_view.setImageResource(R.drawable.paper);
                    comp++;
                    c_pont.setText("Computer: "+String.valueOf(comp));
                    Toast.makeText(MainActivity.this, "Gép nyert!", Toast.LENGTH_SHORT).show();
                }
                else{
                    copm_view.setImageResource(R.drawable.scissors);
                    player++;
                    p_pont.setText("Ember: "+String.valueOf(player));
                    Toast.makeText(MainActivity.this, "Játékos nyert!", Toast.LENGTH_SHORT).show();
                }
                result();
            }
        });

        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player_view.setImageResource(R.drawable.paper);
                if(gep()==0){
                    copm_view.setImageResource(R.drawable.rock);
                    player++;
                    p_pont.setText("Ember: "+String.valueOf(player));
                    Toast.makeText(MainActivity.this, "Játékos nyert!", Toast.LENGTH_SHORT).show();
                }
                else if(gep()==1){
                    copm_view.setImageResource(R.drawable.paper);
                }
                else{
                    copm_view.setImageResource(R.drawable.scissors);
                    comp++;
                    c_pont.setText("Computer: "+String.valueOf(comp));
                    Toast.makeText(MainActivity.this, "Gép nyert!", Toast.LENGTH_SHORT).show();
                }
                result();
            }
        });

        btnScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player_view.setImageResource(R.drawable.scissors);
                if(gep()==0){
                    copm_view.setImageResource(R.drawable.rock);
                    comp++;
                    c_pont.setText("Computer: "+String.valueOf(comp));
                    Toast.makeText(MainActivity.this, "Gép nyert!", Toast.LENGTH_SHORT).show();
                }
                else if(gep()==1){
                    copm_view.setImageResource(R.drawable.paper);
                    player++;
                    p_pont.setText("Ember: "+String.valueOf(player));
                    Toast.makeText(MainActivity.this, "Játékos nyert!", Toast.LENGTH_SHORT).show();
                }
                else{
                    copm_view.setImageResource(R.drawable.scissors);
                }
                result();
            }
        });
    }

    public int gep(){
        int rand=new Random().nextInt(3);
        return rand;
    }

    private void ujJatek(){
        player=0;
        comp=0;
        c_pont.setText("Computer: 0");
        p_pont.setText("Ember: 0");
    }

    private  void result(){
        if(player==3 || comp==3){
            String result="";
            if (player>comp)
                result="Győzelem";
            else
                result="Vereség";
           jatekVege=new AlertDialog.Builder(MainActivity.this);
           jatekVege.setCancelable(false)
                   .setTitle(result)
                   .setMessage("Szeretne új játékot játszani?")
                   .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                           finish();
                       }
                   })
                   .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                           ujJatek();
                       }
                   })
                   .show();
        }
    }

    public void init(){
        player=0;
        comp=0;
        btnRock=findViewById(R.id.btnRock);
        btnPaper=findViewById(R.id.btnPaper);
        btnScissors=findViewById(R.id.btnSc);
        p_pont=findViewById(R.id.p_pont);
        c_pont=findViewById(R.id.c_pont);
        player_view=findViewById(R.id.img_p);
        copm_view=findViewById(R.id.img_g);
    }
}
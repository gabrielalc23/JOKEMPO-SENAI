package com.example.jokempo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

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
    }
    public void selectedRock(View view){
        this.optionSelected("Pedra");
    }
    public void selectedPaper(View view ){
        this.optionSelected("Papel");

    }
    public void selectedScissors(View view){
        this.optionSelected("Tesoura");
    }
    public void optionSelected(String option){
        ImageView imgApp = findViewById(R.id.imageResult);
        TextView textResult = findViewById(R.id.txtResult);

        System.out.println("Foi clicado o botão " + option);
        int numero = new Random().nextInt(3);

        String[] opcoes  = {"Pedra", "Papel", "Tesoura"};
        String optionApp = opcoes[numero];

        switch(optionApp){
            case "Pedra":
                imgApp.setImageResource(R.drawable.pedra);
            break;
            case "Papel":
                imgApp.setImageResource(R.drawable.papel);
            break;
            case "Tesoura":
                imgApp.setImageResource(R.drawable.tesoura);
            break;
        }
        if((optionApp == "Tesoura" && option == "Pedra") ||
                (optionApp == "Papel" && option == "Tesoura") ||
                (optionApp == "Pedra" && option == "Papel")) {
            textResult.setText("Você venceu :D ");
        } else if((optionApp == "Tesoura" && option == "Papel") ||
            (optionApp == "Papel" && option == "Pedra") ||
            (optionApp == "Pedra" && option == "Tesoura")) {
            textResult.setText("Você perdeu :( ");
    } else{
        textResult.setText("Empatamos ;)");
        }
    }
}
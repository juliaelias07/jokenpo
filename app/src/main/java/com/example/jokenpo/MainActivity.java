package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //clique na imagem -- método botão
    //view é componente de interface
    public void selecionadoPedra(View view) { this.opcaoSelecionada("pedra");}

    public void selecionadoPapel(View view) {this.opcaoSelecionada("papel");}

    public void selecionadoTesoura(View view) {this.opcaoSelecionada("tesoura");}

    public void opcaoSelecionada(String opcaoSelecionada) {
        //declarando o componente da interface
        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3); //escolha de 0,2,3
        //criando um array
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        //criando um comparativo
        switch (opcaoApp) {
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;

            case "tapel":
                imageResultado.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        //condicional para decretar campeão
        if ((opcaoApp == "tesoura" && opcaoSelecionada == "papel") || (opcaoApp == "papel" && opcaoSelecionada == "pedra")
                || (opcaoApp == "pedra" && opcaoSelecionada == "tesoura")) {
            textResultado.setText("Você perdeu! :( ");

        } else if ((opcaoSelecionada == "tesoura" && opcaoApp == "papel") || (opcaoSelecionada == "papel" && opcaoApp == "pedra")
                || (opcaoSelecionada == "pedra" && opcaoApp == "tesoura")) {
            textResultado.setText("Você ganhou! :D ");

        } else {
            textResultado.setText("Empate! :O ");
        }
    }


}
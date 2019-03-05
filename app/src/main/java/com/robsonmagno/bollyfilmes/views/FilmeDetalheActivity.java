package com.robsonmagno.bollyfilmes.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.robsonmagno.bollyfilmes.R;
import com.robsonmagno.bollyfilmes.entities.ItemFilme;

public class FilmeDetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme_detalhe);

        Intent intent = getIntent();
        ItemFilme itemFilme = (ItemFilme) intent.getSerializableExtra(MainActivity.KEY_FILME);

        TextView titulo = findViewById(R.id.item_titulo);
        titulo.setText(itemFilme.getTitulo());

        TextView desc = findViewById(R.id.item_desc);
        desc.setText(itemFilme.getDescricao());

        TextView data = findViewById(R.id.item_data);
        data.setText(itemFilme.getDataLancamento());

        RatingBar avaliacao = findViewById(R.id.item_avaliacao);
        avaliacao.setRating(itemFilme.getAvaliacao());

        Button btnTrailer = findViewById(R.id.item_btn_trailer);
    }
}

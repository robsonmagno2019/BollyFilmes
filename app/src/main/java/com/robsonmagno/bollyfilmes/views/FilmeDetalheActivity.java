package com.robsonmagno.bollyfilmes.views;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.robsonmagno.bollyfilmes.R;
import com.robsonmagno.bollyfilmes.entities.ItemFilme;
import com.robsonmagno.bollyfilmes.fragments.FilmeDetalheFragment;

public class FilmeDetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme_detalhe);

        Intent intent = getIntent();
        ItemFilme itemFilme = (ItemFilme) intent.getSerializableExtra(MainActivity.KEY_FILME);

        // Cria um gerenciador de fragment
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Cria uma transação de fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Cria a fragment para qual sera passada as informações
        FilmeDetalheFragment filmeDetalheFragment = new FilmeDetalheFragment();

        // Cria o pacote onde vai as informações.
        Bundle bundle = new Bundle();
        bundle.putSerializable(MainActivity.KEY_FILME, itemFilme);

        // Adiciona o pacote na fragment criada.
        filmeDetalheFragment.setArguments(bundle);

        // Executa a transação
        fragmentTransaction.commit();
    }
}

package com.robsonmagno.bollyfilmes.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.robsonmagno.bollyfilmes.R;
import com.robsonmagno.bollyfilmes.adapters.FilmesAdapter;
import com.robsonmagno.bollyfilmes.entities.ItemFilme;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_FILME = "FILME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list_filmes);

        final ArrayList<ItemFilme> arrayListFilmes = new ArrayList<>();

        arrayListFilmes.add(new ItemFilme("Homem Aranha", "Filme de heroi picado por uma aranha", "10/04/2018", 4));
        arrayListFilmes.add(new ItemFilme("Homem Cobra", "Filme de heroi picado por uma cobra", "06/01/2018", 2));
        arrayListFilmes.add(new ItemFilme("Homem Javali", "Filme de heroi mordido por um javali", "30/06/2018", 3));
        arrayListFilmes.add(new ItemFilme("Homem Passaro", "Filme de heroi picado por um passaro", "23/05/2018", 5));
        arrayListFilmes.add(new ItemFilme("Homem Cachorro", "Filme de heroi mordido por um cachorro", "14/02/2018", 3.5f));
        arrayListFilmes.add(new ItemFilme("Homem Gato", "Filme de heroi mordido por um gato", "10/04/2018", 2.5f));

        FilmesAdapter filmesAdapter = new FilmesAdapter(this, arrayListFilmes);

        listView.setAdapter(filmesAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ItemFilme itemFilme = arrayListFilmes.get(position);
                Intent intent = new Intent(MainActivity.this, FilmeDetalheActivity.class);
                intent.putExtra(KEY_FILME, itemFilme);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_atualizar:
                Toast.makeText(this, "Atualizando os filmes...", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

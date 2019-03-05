package com.robsonmagno.bollyfilmes.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.robsonmagno.bollyfilmes.R;
import com.robsonmagno.bollyfilmes.adapters.FilmesAdapter;
import com.robsonmagno.bollyfilmes.entities.ItemFilme;
import com.robsonmagno.bollyfilmes.views.FilmeDetalheActivity;
import com.robsonmagno.bollyfilmes.views.MainActivity;

import java.util.ArrayList;

public class MainFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ListView listView = view.findViewById(R.id.list_filmes);

        final ArrayList<ItemFilme> arrayListFilmes = new ArrayList<>();

        arrayListFilmes.add(new ItemFilme("Homem Aranha", "Filme de heroi picado por uma aranha", "10/04/2018", 4));
        arrayListFilmes.add(new ItemFilme("Homem Cobra", "Filme de heroi picado por uma cobra", "06/01/2018", 2));
        arrayListFilmes.add(new ItemFilme("Homem Javali", "Filme de heroi mordido por um javali", "30/06/2018", 3));
        arrayListFilmes.add(new ItemFilme("Homem Passaro", "Filme de heroi picado por um passaro", "23/05/2018", 5));
        arrayListFilmes.add(new ItemFilme("Homem Cachorro", "Filme de heroi mordido por um cachorro", "14/02/2018", 3.5f));
        arrayListFilmes.add(new ItemFilme("Homem Gato", "Filme de heroi mordido por um gato", "10/04/2018", 2.5f));

        FilmesAdapter filmesAdapter = new FilmesAdapter(getContext(), arrayListFilmes);

        listView.setAdapter(filmesAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ItemFilme itemFilme = arrayListFilmes.get(position);
                Intent intent = new Intent(getContext(), FilmeDetalheActivity.class);
                intent.putExtra(MainActivity.KEY_FILME, itemFilme);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_atualizar:
                Toast.makeText(getContext(), "Atualizando os filmes...", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

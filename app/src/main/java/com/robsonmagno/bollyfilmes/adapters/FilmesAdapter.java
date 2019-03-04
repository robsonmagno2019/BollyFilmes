package com.robsonmagno.bollyfilmes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.robsonmagno.bollyfilmes.R;
import com.robsonmagno.bollyfilmes.entities.ItemFilme;

import java.util.ArrayList;

public class FilmesAdapter extends ArrayAdapter<ItemFilme> {

    public FilmesAdapter(Context context, ArrayList<ItemFilme> filmes){
        super(context, 0, filmes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = convertView;

        if(itemView == null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.item_filme, parent, false);
        }

        ItemFilme filme = getItem(position);

        TextView titulo = itemView.findViewById(R.id.item_titulo);
        titulo.setText(filme.getTitulo());

        TextView desc = itemView.findViewById(R.id.item_desc);
        desc.setText(filme.getDescricao());

        TextView dataLancamento = itemView.findViewById(R.id.item_data);
        dataLancamento.setText(filme.getDataLancamento());

        RatingBar avaliacao = itemView.findViewById(R.id.item_avaliacao);
        avaliacao.setRating(filme.getAvaliacao());

        return itemView;
    }
}

package com.robsonmagno.bollyfilmes.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.robsonmagno.bollyfilmes.R;
import com.robsonmagno.bollyfilmes.entities.ItemFilme;
import com.robsonmagno.bollyfilmes.views.MainActivity;

public class FilmeDetalheFragment extends Fragment {

    private ItemFilme itemFilme;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
            itemFilme = (ItemFilme) getArguments().getSerializable(MainActivity.KEY_FILME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filme_detalhe, container, false);

        if(itemFilme == null)
            return view;

        TextView titulo = view.findViewById(R.id.item_titulo);
        titulo.setText(itemFilme.getTitulo());

        TextView desc = view.findViewById(R.id.item_desc);
        desc.setText(itemFilme.getDescricao());

        TextView data = view.findViewById(R.id.item_data);
        data.setText(itemFilme.getDataLancamento());

        RatingBar avaliacao = view.findViewById(R.id.item_avaliacao);
        avaliacao.setRating(itemFilme.getAvaliacao());

        Button btnTrailer = view.findViewById(R.id.item_btn_trailer);

        return view;
    }
}

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
    }
}

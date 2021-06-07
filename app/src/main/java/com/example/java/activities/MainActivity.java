package com.example.java.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.java.R;
import com.example.java.adapter.MainActivityAdapter;
import com.example.java.bean.Usuario;
import com.example.java.bo.UsuarioBo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Usuario> usuarios;
    private FloatingActionButton mFab;
    private ListView mListView;
    private MainActivityAdapter mainActivityAdapter;
//    private UsuarioBo usuarioBo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        usuarios = new ArrayList<>();
////        usuarioBo = new UsuarioBo(this);
//        usuarios = new UsuarioBo(this).list();


        mFab.setOnClickListener(v -> {

            Intent intent = new Intent(this, CadastroActivity.class);
            intent.putExtra("Alex", "Alexsandro");
            startActivity(intent);

            //----------------------------------------------------
//            startActivity(new Intent(this, CadastroActivity.class).putExtra("",3));
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        mainActivityAdapter = new MainActivityAdapter(this, new UsuarioBo(this).list("nome ASC"));
        mListView.setDivider(null);
        mListView.setAdapter(mainActivityAdapter);

        mListView.setOnItemClickListener((parent, view, position, id) -> {
            Usuario usuario = mainActivityAdapter.getItem(position);
            Log.e("Nome", "usuario " + usuario.getNome() );
            Log.e("Nome", "usuario " + usuario.getCpf() );

        });
    }

    public void initView(){
        mFab = findViewById(R.id.fab);
        mListView = findViewById(R.id.list_view);
    }


}
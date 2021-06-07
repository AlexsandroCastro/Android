package com.example.java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.java.R;
import com.example.java.bean.Usuario;

import java.text.SimpleDateFormat;
import java.util.List;

public class MainActivityAdapter extends ArrayAdapter<Usuario> {

    private Context context;

    public MainActivityAdapter(Context context, List<Usuario> usuarios) {
        super(context,0 ,usuarios);
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int i, @Nullable View convertView, @NonNull ViewGroup parent) {
        View root = LayoutInflater.from(getContext()).inflate(R.layout.adapter_main_activity, null);
        Usuario usuario = getItem(i);

        TextView nome = root.findViewById(R.id.nome_adapter);
        TextView cpf = root.findViewById(R.id.cpf_adapter);

        nome.setText("Nome = " + usuario.getNome());
        cpf.setText("CPF = " + usuario.getCpf());




        return root;
    }
}

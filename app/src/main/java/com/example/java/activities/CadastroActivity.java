package com.example.java.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.java.R;
import com.example.java.bean.Usuario;
import com.example.java.bo.UsuarioBo;

public class CadastroActivity extends AppCompatActivity {

    private EditText mEdtNome, mEdtCpf;
    private Button mBtnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        initView();

        String meuNome = (String) getIntent().getSerializableExtra("Alex");


        Log.e("Nome", "onCreate: " + meuNome );

        mBtnSalvar.setOnClickListener(v -> {
            Usuario usuario = new Usuario();

            if(!mEdtNome.getText().toString().isEmpty()){
                usuario.setNome(mEdtNome.getText().toString());
                usuario.setCpf(mEdtCpf.getText().toString());
                UsuarioBo usuarioBo = new UsuarioBo(this);
                usuarioBo.insert(usuario);
                finish();
            }else{
                Toast.makeText(this, "Nome obrigatorio", Toast.LENGTH_SHORT).show();
            }


        });



    }

    private void initView(){
        mEdtNome = findViewById(R.id.edt_01);
        mEdtCpf = findViewById(R.id.edt_02);
        mBtnSalvar = findViewById(R.id.btn_salvar);
    }
}

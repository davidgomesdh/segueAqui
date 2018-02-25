package com.example.davidsantos.segueaqui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText editEmail;
    private EditText editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        editEmail = findViewById(R.id.campoEmail);
        editSenha = findViewById(R.id.campoSenha);

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        if(currentUser!=null){
            //proxima tela
        }
    }

    public void login(View view){
        String email = editEmail.getText().toString().trim();
        String senha = editSenha.getText().toString().trim();

        if(email.equals("")){
            editEmail.setError("Preencha este campo!");
            return;
        }
        if(senha.equals("")){
            editSenha.setError("Preencha este campo!");
            return;
        }

        mAuth.signInWithEmailAndPassword(email,senha).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    updateUI(mAuth.getCurrentUser());
                }
                else{
                    Toast.makeText(LoginActivity.this, "Usúario ou senha incorretos!", Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
            }
        });

    }
    public void cadastrar(View view){
        Intent intent = new Intent(LoginActivity.this,CadastroActivity.class);
        startActivity(intent);
    }
}

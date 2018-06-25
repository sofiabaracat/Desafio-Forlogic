package projetofirebase.projetofirebase.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import projetofirebase.projetofirebase.DAO.ConfiguracaoFirebase;
import projetofirebase.projetofirebase.Entidades.Produtos;
import projetofirebase.projetofirebase.R;

public class CadastroOpiniao extends AppCompatActivity {

    private Button btnGravar, btnVoltarTelaInicial;
    private EditText edtNome, edtValor;
    private Produtos produtos;
    private DatabaseReference firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_opiniao);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtValor = (EditText) findViewById(R.id.edtValor);
        btnGravar = (Button) findViewById(R.id.btnGravar);
        btnVoltarTelaInicial = (Button) findViewById(R.id.btnVoltarTelaInicial);


        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                produtos = new Produtos();
                produtos.setNome(edtNome.getText().toString());
                produtos.setValor(Double.valueOf(edtValor.getText().toString()));


                salvarProduto(produtos);


            }
        });

        btnVoltarTelaInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarTelaInicial();
            }
        });
    }


    private boolean salvarProduto(Produtos produtos) {
        try {
            firebase = ConfiguracaoFirebase.getFirebase().child("addprodutos");
            firebase.child(produtos.getNome()).setValue(produtos);
            Toast.makeText(CadastroOpiniao.this, "Produto inserido com sucesso", Toast.LENGTH_LONG).show();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    private void voltarTelaInicial() {
        Intent intent = new Intent(CadastroOpiniao.this, PrincipalActivity.class);
        startActivity(intent);
        finish();
    }
}

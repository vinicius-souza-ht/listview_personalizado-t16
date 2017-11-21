package fabricadeprogramador.com.br.agendaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CadastroActivity extends AppCompatActivity {

    @BindView(R.id.ed_cadastro_nome)
    EditText edNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_cadastro_salvar)
    public void salvar(){
        //Retira o nome digitado no Edit Text
        String nome = edNome.getText().toString();

        Usuario usuario = new Usuario();

        if(nome != null && !nome.isEmpty()){
            usuario.setNome(nome);

            Intent irParaLista = new Intent(CadastroActivity.this, AgendaList.class);
            irParaLista.putExtra("usuario", usuario);
            startActivity(irParaLista);
        } else {
            Toast.makeText(CadastroActivity.this, "Insira o nome !", Toast.LENGTH_SHORT).show();
        }
    }
}

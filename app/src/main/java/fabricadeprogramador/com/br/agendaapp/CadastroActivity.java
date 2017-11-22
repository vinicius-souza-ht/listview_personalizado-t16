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

    Usuario usuarioSel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        ButterKnife.bind(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = getIntent();
        usuarioSel = (Usuario) intent.getSerializableExtra("usuarioSel");

        if(usuarioSel != null){
            edNome.setText(usuarioSel.getNome());
        }else {
            edNome.setText("");
        }
    }

    @OnClick(R.id.btn_cadastro_salvar)
    public void salvar(){
        //Retira o nome digitado no Edit Text
        String nome = edNome.getText().toString();

        if(usuarioSel == null){
            usuarioSel = new Usuario();
        }

        if(nome != null && !nome.isEmpty()){
            usuarioSel.setNome(nome);
            usuarioSel.setImagem(R.drawable.user1_image);


            Intent irParaLista = new Intent(CadastroActivity.this, AgendaList.class);
            irParaLista.putExtra("usuario", usuarioSel);
            usuarioSel = null;
            startActivity(irParaLista);
        } else {
            Toast.makeText(CadastroActivity.this, "Insira o nome !", Toast.LENGTH_SHORT).show();
        }
    }
}

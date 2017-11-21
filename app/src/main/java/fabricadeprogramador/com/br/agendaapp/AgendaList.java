package fabricadeprogramador.com.br.agendaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by viniciuspodi on 16/11/17.
 */

public class AgendaList extends AppCompatActivity {

    @BindView(R.id.agenda_lista)
    ListView lista;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Usuario usuario = (Usuario) intent.getSerializableExtra("usuario");
        GerenciadorAgenda.salvar(usuario);

        UsuarioListAdapter adapter = new UsuarioListAdapter(this, GerenciadorAgenda.getUsuarioList());
        lista.setAdapter(adapter);
    }

    @OnClick(R.id.btn_lista_fechar)
    public void fechar(){
        finish();
    }
}

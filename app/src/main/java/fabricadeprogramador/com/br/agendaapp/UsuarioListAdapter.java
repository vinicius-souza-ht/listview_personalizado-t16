package fabricadeprogramador.com.br.agendaapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by viniciuspodi on 16/11/17.
 */

public class UsuarioListAdapter extends ArrayAdapter<Usuario> {

    public UsuarioListAdapter(Context context, List<Usuario> userList) {
        super(context, R.layout.activity_item_lista, userList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder viewHolder;

        if(convertView == null){
            convertView = View.inflate(getContext(), R.layout.activity_item_lista, null);

            viewHolder = new ViewHolder();
            ButterKnife.bind(viewHolder, convertView);
            convertView.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Usuario usuario = getItem(position);

        if(usuario != null){
            viewHolder.nome.setText(usuario.getNome());
            viewHolder.imagem.setImageResource(usuario.getImagem());
        }

        return convertView;
    }

    public class ViewHolder{
        @BindView(R.id.tv_item_nome)
        TextView nome;

        @BindView(R.id.image)
        ImageView imagem;
    }
}

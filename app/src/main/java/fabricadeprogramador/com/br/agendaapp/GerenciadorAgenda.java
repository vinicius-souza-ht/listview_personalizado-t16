package fabricadeprogramador.com.br.agendaapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by viniciuspodi on 16/11/17.
 */

public class GerenciadorAgenda {

    private static List<Usuario> usuarioList = new ArrayList<>();
    private static long index = 1;

    public static List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public static void setUsuarioList(List<Usuario> usuarioList) {
        GerenciadorAgenda.usuarioList = usuarioList;
    }

    public static void salvar(Usuario usuario){
        if(usuario.getId() == null){
            inserir(usuario);
        } else {
            alterar(usuario);
        }
    }

    public static void inserir(Usuario usuario){
        usuario.setId(index);
        usuario.setImagem(R.drawable.user1_image);
        usuarioList.add(usuario);
        index++;
    }

    public static void alterar(Usuario usuario){
        for(Usuario usu : usuarioList){
            if(usu.equals(usuario)){
                int indice = usuarioList.indexOf(usu);
                usuarioList.set(indice,usuario);
            }
        }
    }

    public static void excluir(Usuario usuario){
        if(usuarioList.contains(usuario)){
            usuarioList.remove(usuario);
        }
    }
}

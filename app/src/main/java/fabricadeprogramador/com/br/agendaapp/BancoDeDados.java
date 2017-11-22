package fabricadeprogramador.com.br.agendaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by viniciuspodi on 21/11/17.
 */

public class BancoDeDados extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "fdpdb";
    public static final int VERSAO_BANCO = 1;

    public BancoDeDados(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE tb_usuario (id integer PRIMARY KEY, nome text, imagem integer)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS tb_usuario";
        db.execSQL(sql);
        onCreate(db);
    }

    //Métodos do CRUD

    public List<Usuario> buscarTodos(){
        SQLiteDatabase db = getWritableDatabase();

        List<Usuario> usuarioList = new ArrayList<>();
        String sql = "SELECT * FROM tb_usuario";

        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{

                Usuario usuario = new Usuario();

                usuario.setId(cursor.getLong(0));
                usuario.setNome(cursor.getString(1));
                usuario.setImagem(cursor.getInt(2));

                usuarioList.add(usuario);

            }while (cursor.moveToNext());
        }

        db.close();
        return usuarioList;
    }

    public void salvar(Usuario usuario){

        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("imagem", usuario.getImagem());

        if(usuario.getId() == null){
            adicionar(usuario,values);
        } else {
            editar(usuario,values);
        }
    }

    public void editar(Usuario usuario, ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();

        String[] arg = new String[1];
        arg[0] = usuario.getId().toString();
        db.update("tb_usuario", values, "id = ?", arg);

        db.close();
    }


    public void adicionar(Usuario usuario, ContentValues values){
        SQLiteDatabase db = getWritableDatabase();
        db.insert("tb_usuario", null, values);
        db.close();
    }

    public void excluir(Usuario usuario){

        SQLiteDatabase db = getWritableDatabase();
         db.delete("tb_usuario", "id = ?", new String[]{ usuario.getId().toString() });
         db.close();

    }
}

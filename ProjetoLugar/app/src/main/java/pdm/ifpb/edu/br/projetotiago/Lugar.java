package pdm.ifpb.edu.br.projetotiago;

import android.graphics.Bitmap;

/**
 * Created by tiago on 21/06/2016.
 */
public class Lugar {
    private String nome;
    private String descricao;
    private Bitmap foto;

    public Lugar(String nome, String descricao) {
        this.nome = nome;
        this.descricao=descricao;
        this.foto = null;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {return descricao;  }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {return this.nome + " / "+ this.descricao; }
}

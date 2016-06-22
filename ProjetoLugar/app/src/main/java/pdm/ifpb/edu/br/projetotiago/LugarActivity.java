package pdm.ifpb.edu.br.projetotiago;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class LugarActivity extends AppCompatActivity {

    private static final int FOTO = 1;
    private EditText etNome,etDescricao;
    private ImageView ivFoto;
    private Button btSalvar, btCancelar, btFoto;
    private Bitmap foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugar);

        this.instanciaComponentesInterface();
        this.listeners();
    }

    private void instanciaComponentesInterface(){
        this.etNome = (EditText) findViewById(R.id.etNomeLugar);
        this.etDescricao=(EditText) findViewById(R.id.etDescricaoLugar);
        this.ivFoto = (ImageView) findViewById(R.id.ivFotoLugar);
        this.btFoto = (Button) findViewById(R.id.btFotoLugar);
        this.btSalvar = (Button) findViewById(R.id.btSalvarLugar);
        this.btCancelar = (Button) findViewById(R.id.btCancelarLugar);
    }

    private void listeners(){
        OnClick oc = new OnClick();
        this.btFoto.setOnClickListener(oc);
        this.btSalvar.setOnClickListener(oc);
        this.btCancelar.setOnClickListener(oc);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (requestCode == FOTO){
                this.foto = data.getParcelableExtra("data");
                this.ivFoto.setImageBitmap(this.foto);
            }
        }
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (v.equals(LugarActivity.this.btFoto)){
                Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(it, FOTO);
            }else if (v.equals(LugarActivity.this.btSalvar)){
                Intent it = new Intent();
                it.putExtra("NOME", LugarActivity.this.etNome.getText().toString());
                it.putExtra("DESCRICAO", LugarActivity.this.etDescricao.getText().toString());
                it.putExtra("FOTO", LugarActivity.this.foto);
                setResult(RESULT_OK, it);
                finish();
            }else{
                finish();
            }
        }
    }
}
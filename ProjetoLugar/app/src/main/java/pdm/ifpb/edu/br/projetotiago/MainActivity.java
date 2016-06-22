package pdm.ifpb.edu.br.projetotiago;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static final int APP = 2;
    private static final int NOVO = 1;
    private ListView listView;
    private Local localPDM;

    public MainActivity() {
        this.localPDM = new Local();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = (ListView) findViewById(R.id.listView);

        //ArrayAdapter<Discente> adapter = new ArrayAdapter<Discente>(this, android.R.layout.simple_list_item_1, this.turmaPDM.get());
        LugarAdapter adapter = new LugarAdapter(this.localPDM, this);
        this.listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, NOVO, 1, "Cadastrar Lugar");
        menu.add(0, APP, 2, "Sobre APP");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case NOVO:
                Intent it = new Intent(this, LugarActivity.class);
                startActivityForResult(it, NOVO);
                break;
            case APP:
                Intent at= new Intent(this,AppActivity.class);
                startActivityForResult(at,APP);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (requestCode == NOVO){
                Lugar d = new Lugar(data.getStringExtra("NOME"),data.getStringExtra("DESCRICAO"));
                d.setFoto((Bitmap) data.getParcelableExtra("FOTO"));
                this.localPDM.add(d);
                //((ArrayAdapter)this.listView.getAdapter()).notifyDataSetChanged();
                ((LugarAdapter)this.listView.getAdapter()).notifyDataSetChanged();
            }
        }
    }
}

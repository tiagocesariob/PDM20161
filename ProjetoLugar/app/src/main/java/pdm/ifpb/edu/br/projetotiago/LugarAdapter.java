package pdm.ifpb.edu.br.projetotiago;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tiago on 21/06/2016.
 */
public class LugarAdapter extends BaseAdapter {
    private Local local;
    private Context context;

    public LugarAdapter(Local local, Context context) {
        this.local = local;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.local.getQuantidade();
    }

    @Override
    public Object getItem(int position) {
        return this.local.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        Lugar d = this.local.get(position);

        if (convertView == null){
            LayoutInflater li = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.layout_lugar, null);
        }else{
            view = convertView;
        }

        view.setMinimumHeight(300);

        ImageView ivFoto = (ImageView) view.findViewById(R.id.ivFotoCelula);
        TextView tvNome = (TextView) view.findViewById(R.id.tvNomeCelula);
        TextView tvDescricao = (TextView) view.findViewById(R.id.tvDescricaoCelula);

        if (d.getFoto() != null)
            ivFoto.setImageBitmap(d.getFoto());

        tvNome.setText(d.getNome());
        tvDescricao.setText(d.getDescricao());

        return view;
    }
}

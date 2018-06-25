package projetofirebase.projetofirebase.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import projetofirebase.projetofirebase.Entidades.Produtos;
import projetofirebase.projetofirebase.R;

/**
 * Created by Daniel Lopes on 23/06/2017.
 */

public class ProdutosAdapter extends ArrayAdapter<Produtos> {

    private ArrayList<Produtos> produto;
    private Context context;

    public ProdutosAdapter(Context c, ArrayList<Produtos> objects) {
        super(c, 0, objects);

        this.context = c;
        this.produto = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        if (produto != null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.lista_produtos, parent, false);

            TextView textViewNome = (TextView) view.findViewById(R.id.textViewNome);
            TextView textViewValor = (TextView) view.findViewById(R.id.textViewValor);

            Produtos produtos2 = produto.get(position);
            textViewNome.setText(produtos2.getNome());
            textViewValor.setText(produtos2.getValor().toString());

        }

        return view;
    }
}

package alexjalg.compras.de.lista.app.com.applistadecompras.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import alexjalg.compras.de.lista.app.com.applistadecompras.R;

/**
 * Created by 3PSI on 24/10/2016.
 */

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ViewHolder>{

    private String[] myData;

    public ListaAdapter(String[] myData){
        this.myData = myData;
        if (this.myData == null){
            this.myData = new String[]{"EStaba nulo"};
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titulo.setText(myData[position]);
    }

    @Override
    public int getItemCount() {
        return myData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView titulo;
        public TextView listanombre;
        public ViewHolder(View itemView) {
            super(itemView);
            titulo = (TextView)itemView.findViewById(R.id.titulo);
            listanombre = (TextView)itemView.findViewById(R.id.listanombre);
        }
    }

}

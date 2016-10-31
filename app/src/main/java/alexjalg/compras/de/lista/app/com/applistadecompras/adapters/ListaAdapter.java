package alexjalg.compras.de.lista.app.com.applistadecompras.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import alexjalg.compras.de.lista.app.com.applistadecompras.R;

/**
 * Created by 3PSI on 24/10/2016.
 */

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ViewHolder>{

    Context context;
    CursorAdapter cursorAdapter;

    public ListaAdapter(Context context, Cursor cursor){
        this.context = context;
        this.cursorAdapter = new CursorAdapter(context, cursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                View view = inflater.inflate(R.layout.item , parent , false);
                return view;
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView titulo = (TextView) view.findViewById(R.id.titulo);
                TextView listanombre = (TextView) view.findViewById(R.id.listanombre);
                titulo.setText(cursor.getColumnIndex(cursor.getColumnName(1)));
                listanombre.setText(cursor.getColumnIndex(cursor.getColumnName(2)));
            }
        };
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
        //holder.titulo.setText(myData[position]);
        cursorAdapter.getCursor().moveToPosition(position);
        cursorAdapter.bindView(holder.itemView, context, cursorAdapter.getCursor());
    }

    @Override
    public int getItemCount() { return  cursorAdapter.getCount(); }

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

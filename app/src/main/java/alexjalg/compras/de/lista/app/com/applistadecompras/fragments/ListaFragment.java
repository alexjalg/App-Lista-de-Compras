package alexjalg.compras.de.lista.app.com.applistadecompras.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

import alexjalg.compras.de.lista.app.com.applistadecompras.R;
import alexjalg.compras.de.lista.app.com.applistadecompras.adapters.ListaAdapter;
import alexjalg.compras.de.lista.app.com.applistadecompras.helpers.DataBaseHelper;

/**
 * Created by 3PSI on 19/10/2016.
 */

public class ListaFragment extends Fragment {
    RecyclerView recyclerView;
    ListaAdapter adapter;
    private static final String TAG = "RecyclerViewFragment";
    DataBaseHelper dataBaseHelper;

    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.lista_fragment,container,false);
        rootView.setTag(TAG);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        dataBaseHelper = new DataBaseHelper(getActivity().getApplicationContext());
        try {
            dataBaseHelper.createDataBase();
        } catch (IOException e) {
            throw new Error("No se puede crear base de datos");
        }
        dataBaseHelper.openDataBase();
        Cursor cursor = dataBaseHelper.fethAllList();
        if(cursor!= null){
            adapter = new ListaAdapter(getActivity().getApplicationContext(), cursor);
            recyclerView.setAdapter(adapter);
        }

        return rootView;
    }
}
































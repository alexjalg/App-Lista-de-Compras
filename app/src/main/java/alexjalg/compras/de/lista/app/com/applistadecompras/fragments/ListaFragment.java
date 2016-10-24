package alexjalg.compras.de.lista.app.com.applistadecompras.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import alexjalg.compras.de.lista.app.com.applistadecompras.R;
import alexjalg.compras.de.lista.app.com.applistadecompras.adapters.ListaAdapter;

/**
 * Created by 3PSI on 19/10/2016.
 */

public class ListaFragment extends Fragment {
    RecyclerView recyclerView;
    ListaAdapter adapter;
    private static final String TAG = "RecyclerViewFragment";
    String[] data = new String[]{
            "Elemento1","Elemento2","Elemento3","Elemento4",
            "Elemento1","Elemento2","Elemento3","Elemento4",
            "Elemento1","Elemento2","Elemento3","Elemento4",
            "Elemento1","Elemento2","Elemento3","Elemento4",
            "Elemento1","Elemento2","Elemento3","Elemento4",
            "Elemento1","Elemento2","Elemento3","Elemento4"};
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.lista_fragment,container,false);
        rootView.setTag(TAG);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapter = new ListaAdapter(data);
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}
































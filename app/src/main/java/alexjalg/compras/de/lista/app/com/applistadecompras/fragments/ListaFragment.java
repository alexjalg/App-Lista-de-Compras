package alexjalg.compras.de.lista.app.com.applistadecompras.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import alexjalg.compras.de.lista.app.com.applistadecompras.R;

/**
 * Created by 3PSI on 19/10/2016.
 */

public class ListaFragment extends Fragment {

    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.lista_fragment, container, false);
        return rootView;
    }
}

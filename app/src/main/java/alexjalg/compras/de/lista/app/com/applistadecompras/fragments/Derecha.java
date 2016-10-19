package alexjalg.compras.de.lista.app.com.applistadecompras.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import alexjalg.compras.de.lista.app.com.applistadecompras.R;

/**
 * Created by alejandro on 15/10/16.
 */

public class Derecha extends Fragment{
    View rootView;
    TextView textView;
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
        ){
        rootView = inflater.inflate(R.layout.derecha  , container, false);
        textView = (TextView)rootView.findViewById(R.id.textView);
        return rootView;
    }

    public void obtenerDatos(String mensaje) {
        textView.setText(mensaje);
    }
}

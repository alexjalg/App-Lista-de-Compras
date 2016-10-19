package alexjalg.compras.de.lista.app.com.applistadecompras.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import alexjalg.compras.de.lista.app.com.applistadecompras.EnviarMensaje;
import alexjalg.compras.de.lista.app.com.applistadecompras.R;

/**
 * Created by alejandro on 15/10/16.
 */

public class Izquierda extends Fragment{

    View rootView;
    EditText editText;
    Button button;
    EnviarMensaje EM;

    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ){
        rootView = inflater.inflate(R.layout.izquierda, container, false);
        editText = (EditText)rootView.findViewById(R.id.editText);
        button = (Button)rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String mensaje = editText.getText().toString();
                EM.enviarDatos(mensaje);
            }
        });
        return rootView;
    }

    public void onAttach(Activity context){
        super.onAttach(context);
        try {
            EM = (EnviarMensaje)context;
        }catch (ClassCastException e){
            throw new ClassCastException("Necesita implementar");
        }
    }
}

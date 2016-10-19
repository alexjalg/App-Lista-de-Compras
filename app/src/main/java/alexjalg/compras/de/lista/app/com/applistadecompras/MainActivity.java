package alexjalg.compras.de.lista.app.com.applistadecompras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import alexjalg.compras.de.lista.app.com.applistadecompras.fragments.Derecha;

public class MainActivity extends AppCompatActivity implements EnviarMensaje{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void enviarDatos(String mensaje) {
        Derecha derecha = (Derecha)getFragmentManager().findFragmentById(R.id.derecha);
        derecha.obtenerDatos(mensaje);
    }
}

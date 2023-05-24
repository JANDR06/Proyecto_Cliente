package es.ieslavereda.proyecto_cliente.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import es.ieslavereda.proyecto_cliente.API.CallMethods;
import es.ieslavereda.proyecto_cliente.API.Connector;
import es.ieslavereda.proyecto_cliente.R;
import es.ieslavereda.proyecto_cliente.activities.model.Oficio;
import es.ieslavereda.proyecto_cliente.activities.model.Usuario;
import es.ieslavereda.proyecto_cliente.base.BaseActivity;
import es.ieslavereda.proyecto_cliente.base.CallInterface;
import es.ieslavereda.proyecto_cliente.base.Parameters;

public class MainActivity extends BaseActivity implements CallInterface {


    private List<Usuario> usuarios;
    private List<Oficio> oficios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void doInBackground() {
        usuarios = Connector.getConector().getAsList(Usuario.class, Parameters.URL+"usuarios/");
        oficios = Connector.getConector().getAsList(Oficio.class, Parameters.URL+"oficios/");
    }

    @Override
    public void doInUI() {
        hideProgress();

        Adaptador.setDatos(usuarios, oficios)
    }
}
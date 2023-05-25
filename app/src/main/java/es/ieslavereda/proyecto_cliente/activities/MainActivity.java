package es.ieslavereda.proyecto_cliente.activities;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
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
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showProgress();
        executeCall(this);
    }

    @Override
    public void doInBackground() {
        usuarios = Connector.getConector().getAsList(Usuario.class, Parameters.URL+"usuarios/");
        oficios = Connector.getConector().getAsList(Oficio.class, Parameters.URL+"oficios/");
    }

    @Override
    public void doInUI() {
        hideProgress();
        recyclerView = findViewById(R.id.recyclerView);

        Adaptador adaptador = new Adaptador(this, usuarios, oficios);

        recyclerView.setAdapter(adaptador);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
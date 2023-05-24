package es.ieslavereda.proyecto_cliente.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.ieslavereda.proyecto_cliente.R;
import es.ieslavereda.proyecto_cliente.activities.model.Usuario;
import es.ieslavereda.proyecto_cliente.base.ImageDownloader;
import es.ieslavereda.proyecto_cliente.base.Parameters;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {


    private List<Usuario> usuarios;
    private final LayoutInflater inflater;
    //Preparamos el viewholder para que sea clicable
    private View.OnClickListener onClickListener;

    public MyRecyclerViewAdapter(Context context) {
        listaUsuarios = UsuarioRepository.getInstance();
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

//    public MyRecyclerViewAdapter(Context context, List<Usuario> usuarios) {
//        this(context);
//        this.usuarios = usuarios;
//    }

    // Creamos el ViewHolder con la vista de un elemento sin personalizar
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflamos la vista desde el xml
        View view = inflater.inflate(R.layout.simple_element, parent, false);
        //ponemos el listener para que sea clicable
        view.setOnClickListener(onClickListener);
        return new ViewHolder(view);
    }

    // Usando como base el ViewHolder y lo personalizamos
    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.ViewHolder holder, int position) {
        Usuario usuario = listaUsuarios.get(position);
        Profesion profesion = ProfesionRepository.getInstance().getProfesionByImage(usuario.getIdProfesion());
        holder.nombre.setText(usuario.getApellidos() + ", " + usuario.getNombre());
        holder.profesion.setText(profesion.getNombre());
        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + holder.imagen);
    }

    // Indicamos el número de elementos de la lista
    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    //Creamos nuestro ViewHolder, con los tipos de elementos a modificar
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre;
        private TextView profesion;
        private ImageView imagen;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.textViewNombre);
            profesion = itemView.findViewById(R.id.textViewOficio);
            imagen = itemView.findViewById(R.id.imageView);
        }
    }

    //setter del atributo onClickListener
    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

}
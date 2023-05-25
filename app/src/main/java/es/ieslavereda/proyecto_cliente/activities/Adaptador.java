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
import es.ieslavereda.proyecto_cliente.activities.model.Oficio;
import es.ieslavereda.proyecto_cliente.activities.model.Usuario;
import es.ieslavereda.proyecto_cliente.base.ImageDownloader;
import es.ieslavereda.proyecto_cliente.base.Parameters;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    private List<Usuario> usuarios;
    private List<Oficio> oficios;
    private LayoutInflater inflater;
    private View.OnClickListener onClickListener;

    public Adaptador(Context context, List<Usuario> usuarios, List<Oficio> oficios) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.simple_element, parent, false);
        view.setOnClickListener(onClickListener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nombre.setText(usuarios.get(position).getApellidos() + ", " + usuarios.get(position).getNombre());
        holder.oficio.setText(oficios.get(usuarios.get(position).getIdOficio()-1).getDescripcion());
        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + oficios.get(usuarios.get(position).getIdOficio()).getUrlImagen(), holder.imagen);

    }

    @Override
    public int getItemCount() {
        if (usuarios != null) {
            return usuarios.size();
        }
        return 0;
    }

    public void setInfo(List<Usuario> usuario, List<Oficio> oficio) {
        this.usuarios = usuario;
        this.oficios = oficio;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre;
        private TextView oficio;
        private ImageView imagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.textViewNombre);
            oficio = itemView.findViewById(R.id.textViewOficio);
            imagen = itemView.findViewById(R.id.imageView);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

}
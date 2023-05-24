package es.ieslavereda.proyecto_cliente.activities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    private LayoutInflater inflater;
    private Root root;

    public Adaptador(Context context, Root r) {
        this.root = r;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.simple_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Date date = new Date(root.list.get(position).dt * 1000L);
        holder.fecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(date));
        holder.hora.setText(new SimpleDateFormat("HH:mm").format(date));
        holder.diasemana.setText(new SimpleDateFormat("EEEE",new Locale("es","ES")).format(date));
        holder.temperatura.setText(root.list.get(position).main.temp + "º");
        holder.estado.setText(root.list.get(position).weather.get(0).description);
        holder.maximo.setText(root.list.get(position).main.temp_max + "º");
        holder.minimo.setText(root.list.get(position).main.temp_min + "º");
        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + root.list.get(position).weather.get(0).icon + Parameters.ICON_URL_POST, holder.image);


         holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), MainActivityDetails.class);
            intent.putExtra("extra", root);
             intent.putExtra("numero", position);
            view.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return root.list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView diasemana;
        TextView fecha;
        TextView hora;
        TextView estado;
        TextView temperatura;
        TextView minimo;
        TextView maximo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imagen);
            diasemana = itemView.findViewById(R.id.dia);
            fecha = itemView.findViewById(R.id.fecha);
            hora = itemView.findViewById(R.id.hora);
            estado = itemView.findViewById(R.id.estadoCielo);
            temperatura = itemView.findViewById(R.id.temperatura);
            minimo = itemView.findViewById(R.id.minimo);
            maximo = itemView.findViewById(R.id.maximo);
        }
    }
}
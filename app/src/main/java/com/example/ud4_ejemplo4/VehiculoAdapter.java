package com.example.ud4_ejemplo4;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class VehiculoAdapter extends RecyclerView.Adapter<VehiculoAdapter.MiViewHolder> {

    private ArrayList<Vehiculo> lista;
    private View.OnClickListener onClickListener; // Atributo para el evento


    public static class MiViewHolder extends RecyclerView.ViewHolder  {
        public TextView nombretextView;
        public TextView apariciontextView;

        public MiViewHolder(View view) {
            super(view);

            this.nombretextView = itemView.findViewById(R.id.nombreTextView);
            this.apariciontextView = itemView.findViewById(R.id.aparicionTextView);

        }
    }

    public VehiculoAdapter(ArrayList<Vehiculo> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public VehiculoAdapter.MiViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Creamos las views de los vehículos
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View view = inflater.inflate(R.layout.elementos_lista, viewGroup, false);

        view.setOnClickListener(this.onClickListener);

        MiViewHolder miViewHolder = new MiViewHolder(view);

        return miViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VehiculoAdapter.MiViewHolder holder, int position) {
        // Establecemos el nombre y aparición para el vehículo de esa posición
        String nombre = lista.get(position).getNombre();

        holder.nombretextView.setText(nombre);

        String aparicion = lista.get(position).getAparicion();

        holder.apariciontextView.setText(aparicion);
    }

    @Override
    public int getItemCount() {
        if (lista == null)
            return 0;
        else
            return lista.size();
    }

    /**
     * Método para devolver el onClickListener creado
     * @param onClickListener
     */
    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}


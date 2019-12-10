# Ud4_Ejemplo4
_Ejemplo 4 de la Unidad 4._ 

Vamos a modificar [Ud4_Ejemplo3](https://github.com/Fpcarlosc/Ud4_Ejemplo3) para que al pulsar un elemento de la lista
aparezca un mensaje por pantalla con el nombre y aparición del vehículo.

Los cambios que deberemos realizar son los siguientes (los ficheros _activity_main.xml_, _elementos_lista.xml_ y _Vehiculo.java_ son
idénticos al _Ud4_Ejemplo3_):

## _VehiculoAdapter.java_

En esta clase es donde creamos el _onClickListener_ y lo asociamos a nuestro _ViewHolder_ creado.

Para ello debemos crear un atributo de tipo _onClickListener_:

```
public class VehiculoAdapter extends RecyclerView.Adapter<VehiculoAdapter.MiViewHolder> {

    private ArrayList<Vehiculo> lista;
    private View.OnClickListener onClickListener; // Atributo para el evento
    ...
```
Asignarlo al _ViewHolder_ en el método _onCreateViewHolder_:
```
    public VehiculoAdapter.MiViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Creamos las views de los vehículos
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View view = inflater.inflate(R.layout.elementos_lista, viewGroup, false);

        view.setOnClickListener(this.onClickListener);

        MiViewHolder miViewHolder = new MiViewHolder(view);

        return miViewHolder;
    }
```
Y para poder asignar posteriormente el _onCLickListener_ al adaptador que usaremos en la clase _MainActivity_, creamos el 
método _setOnItemClickListener_ que asiganrá el _onClickListener_ pasado al de la clase:
```
    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
```

## _MainActivity.java_

En la clase principal deberemos añadir la asignación del _onclickListener_ al _adapter_ e implementar el mensaje a mostrar
por pantalla al pulsar el elemento:
```
...
        // Asignamos el evento creado en VehiculoAdapter
        adapter.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Al utilizar la variable recycler en la inner class debemos declararla final
                Vehiculo vehiculo = vehiculos.get(recycler.getChildAdapterPosition(v));
                Toast.makeText(MainActivity.this, vehiculo.getNombre() + "\n" + vehiculo.getAparicion(), Toast.LENGTH_SHORT).show();
            }
        });

        recycler.setAdapter(adapter);

    }
}
```
Recordad que para poder utilizar la clase _RecyclerView_ deberemos incluir la dependencia _com.android.support:recyclerview-v7:28.0.0_ en el fichero _build.gradle(Module:app)_.

**NOTA:** Para las nuevas versiones, en lugar de incluir la dependencia anterior, se deberá incluir la dependencia indicada en _https://developer.android.com/jetpack/androidx/releases/recyclerview_.

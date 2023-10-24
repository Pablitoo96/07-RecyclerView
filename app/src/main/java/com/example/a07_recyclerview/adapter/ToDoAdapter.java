package com.example.a07_recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a07_recyclerview.MainActivity;
import com.example.a07_recyclerview.R;
import com.example.a07_recyclerview.modelos.ToDo;

import java.util.ArrayList;
import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ToDoVH> {
    //necesito la lista de las cosas que quiero mostrar
    private List<ToDo> object;
    //necesito la fila del elemento view/layout que quiero mostrar
    private int resource;

    //necesito el contecto que sera la actividad donde le voy a mostrar
    private Context context;

    public ToDoAdapter(ArrayList<ToDo> objects, int resource, Context context) {
        this.object = objects;
        this.resource = resource;
        this.context = context;
    }


    //instaciar tantos elementos como quepan en la pantalla
    @NonNull
    @Override
    public ToDoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View todoView = LayoutInflater.from(context).inflate(resource,null);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        todoView.setLayoutParams(layoutParams);
        return new ToDoVH(todoView);
    }

    //Se llama de forma automatica para pintar cada uno de los elementos
    @Override
    public void onBindViewHolder(@NonNull ToDoVH holder, int position) {
        ToDo toDo = object.get(position);

        holder.lbTitulo.setText(toDo.getTitulo());
        holder.lbContenido.setText(toDo.getContenido());
        holder.lbFecha.setText(toDo.getFecha().toString());

        if(toDo.isCompletado()){
            holder.btnCompletado.setImageResource(android.R.drawable.checkbox_on_background);
        }else{
            holder.btnCompletado.setImageResource(android.R.drawable.checkbox_off_background);
        }

        holder.btnCompletado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDo.setCompletado(!toDo.isCompletado());
                notifyDataSetChanged();
            }
        });
    }
    //cuantos elementos tengo para mostar
    @Override
    public int getItemCount() {
        return object.size();
    }

    public class ToDoVH extends RecyclerView.ViewHolder{
        TextView lbTitulo, lbContenido,lbFecha;
        ImageButton btnCompletado;
        public ToDoVH(@NonNull View itemView) {
            super(itemView);

            lbTitulo = itemView.findViewById(R.id.lbTituloViewModel);
            lbContenido = itemView.findViewById(R.id.lbContenidoViewModel);
            lbFecha = itemView.findViewById(R.id.lbFechaViewModel);
            btnCompletado = itemView.findViewById(R.id.btnCompletadoToDoModel);


        }
    }
}

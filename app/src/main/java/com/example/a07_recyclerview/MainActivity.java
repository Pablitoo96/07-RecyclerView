package com.example.a07_recyclerview;

import android.os.Bundle;

import com.example.a07_recyclerview.adapter.ToDoAdapter;
import com.example.a07_recyclerview.modelos.ToDo;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.View;


import com.example.a07_recyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private ArrayList<ToDo> toDoList;
    private ToDoAdapter adapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toDoList = new ArrayList<>();
        crearTareas();

        adapter = new ToDoAdapter(toDoList, R.layout.todo_view_model,MainActivity.this);
        binding.contentMain.contenedor.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        binding.contentMain.contenedor.setLayoutManager(layoutManager);



        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void crearTareas() {
        for (int i = 0; i < 1000000; i++) {
            toDoList.add(new ToDo("Titulo " + i , "Contenido " + i));
        }
    }

}
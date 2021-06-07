package com.example.uts_akb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private List<Task> listTask;
    private Context context;
    private TextView judul, date, kategori, isi;
    private Button editButton, deleteButton;

    public ListViewAdapter(List<Task> listTask, Context context) {
        this.listTask = listTask;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listTask.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public android.view.View getView(int position, android.view.View convertView, ViewGroup parent) {
        android.view.View view = LayoutInflater.from(context).inflate(R.layout.task_card,null);

        judul = view.findViewById(R.id.cardJudul);
        date = view.findViewById(R.id.cardDate);
        kategori = view.findViewById(R.id.cardKategori);
        isi = view.findViewById(R.id.cardIsi);
        editButton = view.findViewById(R.id.editButton);
        deleteButton = view.findViewById(R.id.deleteButton);

        judul.setText(listTask.get(position).getJudul());
        date.setText(listTask.get(position).getDate());
        kategori.setText(listTask.get(position).getKategori());
        isi.setText(listTask.get(position).getIsi());

        editButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intent = new Intent(context, EditActivity.class);
                intent.putExtra("Id", listTask.get(position).getId());
                intent.putExtra("Judul", listTask.get(position).getJudul());
                intent.putExtra("Date", listTask.get(position).getDate());
                intent.putExtra("Kategori", listTask.get(position).getKategori());
                intent.putExtra("Isi", listTask.get(position).getIsi());

                context.startActivity(intent);
            }
        });

        deleteButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DeleteActivity.class);
                intent.putExtra("Id", listTask.get(position).getId());

                context.startActivity(intent);
            }
        });

        return view;
    }
}



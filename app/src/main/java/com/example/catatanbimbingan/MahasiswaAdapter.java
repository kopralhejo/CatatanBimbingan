package com.example.catatanbimbingan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {

    private List<Mahasiswa> listmahasiswa;

    public MahasiswaAdapter(List<Mahasiswa> listmahasiswa1) {
        this.listmahasiswa = listmahasiswa1;
    }

    @NonNull
    @Override
    public MahasiswaAdapter.MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater flat = LayoutInflater.from(parent.getContext());
        View view = flat.inflate(R.layout.item_mahasiswa, parent,false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaAdapter.MahasiswaViewHolder holder, int position) {
    holder.nama.setText(listmahasiswa.get(position).getNama());
    holder.jurusan.setText(listmahasiswa.get(position).getProdi());
    holder.angkatan.setText(listmahasiswa.get(position).getAngkatan());
    }

    @Override
    public int getItemCount() {
        return listmahasiswa.size();
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder{

        private TextView nama,jurusan,angkatan,tanggal,jmlbimbingan;

        public MahasiswaViewHolder(View view){
            super(view);
            nama = view.findViewById(R.id.tv_nama);
            jurusan = view.findViewById(R.id.tv_jurusan);
            angkatan = view.findViewById(R.id.tv_angkatan);
            tanggal = view.findViewById(R.id.tv_tanggal);
            jmlbimbingan = view.findViewById(R.id.tv_jumlahbimbingan);
        }
    }
}

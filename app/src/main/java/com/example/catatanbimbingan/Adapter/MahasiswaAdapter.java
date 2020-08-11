package com.example.catatanbimbingan.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catatanbimbingan.ListCatatanActivity;
import com.example.catatanbimbingan.Model.Mahasiswa;
import com.example.catatanbimbingan.R;
import com.example.catatanbimbingan.UpdateMahasiswaActivity;

import java.util.List;


public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {

    public List<Mahasiswa> listmahasiswa;

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
    public void onBindViewHolder(@NonNull MahasiswaAdapter.MahasiswaViewHolder holder, final int position) {
    holder.nama.setText(listmahasiswa.get(position).getNama());
    holder.jurusan.setText(listmahasiswa.get(position).getProdi());
    holder.angkatan.setText(listmahasiswa.get(position).getAngkatan()+"");
    if (listmahasiswa.get(position).getJumlahbimbingan()==null){
        holder.jmlbimbingan.setText("0");
    } else {
        holder.jmlbimbingan.setText(listmahasiswa.get(position).getJumlahbimbingan()+"");
    }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), ListCatatanActivity.class);
                mIntent.putExtra("id", listmahasiswa.get(position).getId());
                mIntent.putExtra("nim", listmahasiswa.get(position).getNim());
                mIntent.putExtra("jml", listmahasiswa.get(position).getJumlahbimbingan());
                mIntent.putExtra("nama", listmahasiswa.get(position).getNama());
                mIntent.putExtra("hp", listmahasiswa.get(position).getHp());
                mIntent.putExtra("prodi", listmahasiswa.get(position).getProdi());
                mIntent.putExtra("angkatan", listmahasiswa.get(position).getAngkatan());
                view.getContext().startActivity(mIntent);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                Intent mIntent = new Intent(view.getContext(), UpdateMahasiswaActivity.class);
                mIntent.putExtra("id", listmahasiswa.get(position).getId());
                mIntent.putExtra("nim", listmahasiswa.get(position).getNim());
                mIntent.putExtra("nama", listmahasiswa.get(position).getNama());
                mIntent.putExtra("hp", listmahasiswa.get(position).getHp());
                mIntent.putExtra("prodi", listmahasiswa.get(position).getProdi());
                mIntent.putExtra("angkatan", listmahasiswa.get(position).getAngkatan());
                mIntent.putExtra("jml", listmahasiswa.get(position).getJumlahbimbingan());
                view.getContext().startActivity(mIntent);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listmahasiswa.size();
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder{
        public TextView nama,jurusan,angkatan,tanggal,jmlbimbingan;

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

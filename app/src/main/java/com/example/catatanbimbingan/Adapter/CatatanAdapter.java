package com.example.catatanbimbingan.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catatanbimbingan.EditCatatanActivity;
import com.example.catatanbimbingan.ListCatatanActivity;
import com.example.catatanbimbingan.Model.Catatan;
import com.example.catatanbimbingan.Model.Catatan;
import com.example.catatanbimbingan.R;

import java.util.List;


public class CatatanAdapter extends RecyclerView.Adapter<CatatanAdapter.CatatanViewHolder> {

    public List<Catatan> listcatatan;
    public CatatanAdapter(List<Catatan> listcatatan1) {
        this.listcatatan = listcatatan1;
    }

    @NonNull
    @Override
    public CatatanAdapter.CatatanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater flat = LayoutInflater.from(parent.getContext());
        View view = flat.inflate(R.layout.item_catatan, parent,false);
        return new CatatanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatatanAdapter.CatatanViewHolder holder, final int position) {
        holder.nama.setText(listcatatan.get(position).getJudul());
        holder.jurusan.setText(listcatatan.get(position).getCatatan());
        holder.angkatan.setText(listcatatan.get(position).getTanggal()+"");
        holder.tanggal.setText("Bimbingan ke - " + listcatatan.get(position).getBimbingan()+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditCatatanActivity.class);
                mIntent.putExtra("bim", listcatatan.get(position).getBimbingan());
                mIntent.putExtra("cat", listcatatan.get(position).getCatatan());
                mIntent.putExtra("dul", listcatatan.get(position).getJudul());
                mIntent.putExtra("id", listcatatan.get(position).getId());
                mIntent.putExtra("nim", listcatatan.get(position).getNim());
                mIntent.putExtra("tgl", listcatatan.get(position).getTanggal());
                view.getContext().startActivity(mIntent);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
//                Intent mIntent = new Intent(view.getContext(), UpdateCatatanActivity.class);
//                mIntent.putExtra("id", listcatatan.get(position).getId());
//                mIntent.putExtra("nim", listcatatan.get(position).getNim());
//                mIntent.putExtra("nama", listcatatan.get(position).getNama());
//                mIntent.putExtra("hp", listcatatan.get(position).getHp());
//                mIntent.putExtra("prodi", listcatatan.get(position).getProdi());
//                mIntent.putExtra("angkatan", listcatatan.get(position).getAngkatan());
//                view.getContext().startActivity(mIntent);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listcatatan.size();
    }

    public class CatatanViewHolder extends RecyclerView.ViewHolder{
        public TextView nama,jurusan,angkatan,tanggal,jmlbimbingan;

        public CatatanViewHolder(View view){
            super(view);
            nama = view.findViewById(R.id.tv_nama);
            jurusan = view.findViewById(R.id.tv_jurusan);
            angkatan = view.findViewById(R.id.tv_angkatan);
            tanggal = view.findViewById(R.id.tv_tanggal);
            jmlbimbingan = view.findViewById(R.id.tv_jumlahbimbingan);
        }
    }
}

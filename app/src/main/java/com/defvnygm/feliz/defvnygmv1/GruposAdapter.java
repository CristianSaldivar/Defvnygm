package com.defvnygm.feliz.defvnygmv1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by feliz on 21/07/2017.
 */

public class GruposAdapter extends RecyclerView.Adapter<GruposAdapter.GruposViewHolder> implements View.OnClickListener {

    ArrayList<GrupoVo> listaGrupo;
    private View.OnClickListener listener;

    public GruposAdapter(ArrayList<GrupoVo> listaGrupo) {
        this.listaGrupo = listaGrupo;
    }

    @Override
    public GruposViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        view.setOnClickListener(this);
        return new GruposViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GruposViewHolder holder, int position) {
        holder.txtNombre.setText(listaGrupo.get(position).getNombre());
        holder.txtInformacion.setText(listaGrupo.get(position).getInfo());
        holder.foto.setImageResource(listaGrupo.get(position).getImagenId());
    }

    @Override
    public int getItemCount() {
        return listaGrupo.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class GruposViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre,txtInformacion;
        ImageView foto;

        public GruposViewHolder(View itemView) {
            super(itemView);
            txtNombre = (TextView) itemView.findViewById(R.id.idNombre);
            txtInformacion = (TextView) itemView.findViewById(R.id.idInfo);
            foto = (ImageView) itemView.findViewById(R.id.idImagen);
        }
    }
}

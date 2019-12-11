package com.example.facultad_lab_soft_final.Helpers;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.facultad_lab_soft_final.R;
import com.example.facultad_lab_soft_final.data.model.Actividad;

import java.util.ArrayList;

import io.github.luizgrp.sectionedrecyclerviewadapter.Section;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;

public class ActivitiesSection extends Section {

    ArrayList<Actividad> actividades;
    String title;

    public ActivitiesSection(String title, ArrayList<Actividad> actividades) {
        super(SectionParameters.builder()
                .itemResourceId(R.layout.activity_item)
                .headerResourceId(R.layout.activity_header)
                .build());
        this.actividades = actividades;
        this.title = title;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        final View view;
        final TextView title;
        final TextView time;
        final TextView description;
        final TextView location;

        public ItemViewHolder(View view) {
            super(view);
            this.view = view;
            this.title = view.findViewById(R.id.title);
            this.time = view.findViewById(R.id.time);
            this.description = view.findViewById(R.id.description);
            this.location = view.findViewById(R.id.location);
        }
    }

    final class HeaderViewHolder extends RecyclerView.ViewHolder {

        final TextView title;

        HeaderViewHolder(View view) {
            super(view);
            this.title = view.findViewById(R.id.title);
        }
    }

    @Override
    public int getContentItemsTotal() {
        return actividades.size();
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;

        Actividad activity = actividades.get(i);
        itemViewHolder.title.setText(activity.getNombre());
        itemViewHolder.time.setText(activity.getHora());
        itemViewHolder.description.setText(activity.getDescripcion());
        itemViewHolder.location.setText(activity.getUbicacion().getDescripcion());
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(final RecyclerView.ViewHolder holder) {
        final HeaderViewHolder headerHolder = (HeaderViewHolder) holder;
        headerHolder.title.setText(title);
    }
}

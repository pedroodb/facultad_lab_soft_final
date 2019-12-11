package com.example.facultad_lab_soft_final.Helpers;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.facultad_lab_soft_final.R;
import com.example.facultad_lab_soft_final.data.model.Actividad;
import com.example.facultad_lab_soft_final.data.model.Notification;

import java.util.ArrayList;

import io.github.luizgrp.sectionedrecyclerviewadapter.Section;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;

public class NotificationsSection extends Section {

    ArrayList<Notification> notifications;
    String title;

    public NotificationsSection(String title, ArrayList<Notification> notifications) {
        super(SectionParameters.builder()
                .itemResourceId(R.layout.notification_item)
                .headerResourceId(R.layout.activity_header)
                .build());
        this.notifications = notifications;
        this.title = title;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        final View view;
        final TextView title;
        final TextView description;

        public ItemViewHolder(View view) {
            super(view);
            this.view = view;
            this.title = view.findViewById(R.id.title);
            this.description = view.findViewById(R.id.description);
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
        return notifications.size();
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;

        Notification notification = notifications.get(i);
        itemViewHolder.title.setText(notification.getTitulo());
        itemViewHolder.description.setText(notification.getDescripcion());
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

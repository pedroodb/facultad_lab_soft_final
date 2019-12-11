package com.example.facultad_lab_soft_final.data.model;

import java.util.ArrayList;

public class Notifications {

    ArrayList<Notification> notifications;

    public Notifications(ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }
}

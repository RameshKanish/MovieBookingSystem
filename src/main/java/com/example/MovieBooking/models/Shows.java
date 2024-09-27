package com.example.MovieBooking.models;

import java.sql.Time;
import java.sql.Timestamp;

public class Shows {
    private long id;
    private long movie_id;
    private String movie_name;
    private Time show_time;
    private boolean showIsActice;
    private boolean isDeleted ;
}
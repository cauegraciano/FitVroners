package com.fitvroners.www.fitvroners;

public class Workout {

    String id;
    private String title;
    private int duration;
    private double calories;
    private String user;
    private String treino;

    public Workout(String title, int duration, double calories, String user, String treino) {
        this.title = title;
        this.duration = duration;
        this.calories = calories;
        this.user = user;
        this.treino = treino;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTreino() {
        return treino;
    }

    public void setTreino(String treino) {
        this.treino = treino;
    }
}

package com.fitvroners.www.fitvroners;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class WorkoutService {

    private String baseUrl;
    private String repositoryName;
    private String fullUrl;
    private URL url;
    private HttpURLConnection connection;

    public WorkoutService(){
       this.baseUrl = "http://10.0.2.2:8080";
        //this.baseUrl = "http://192.168.4.180:8080";
        this.repositoryName = "workouts";
        this.fullUrl = this.baseUrl+"/"+this.repositoryName;
    }

    public List<Workout> getAll(){

        StringBuffer content = new StringBuffer();
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.url = new URL(this.fullUrl);
            this.connection = (HttpURLConnection) this.url.openConnection();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(this.connection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Workout> workouts = null;
        try {
            workouts = mapper.readValue(content.toString(), new TypeReference<List<Workout>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }


        return workouts;

    }

    public Workout getById(String id){

        String url = this.baseUrl+"/"+this.repositoryName+"/"+id;

        System.out.println(url);

        StringBuffer content = new StringBuffer();
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.url = new URL(url);
            this.connection = (HttpURLConnection) this.url.openConnection();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(this.connection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Workout workout = null;
        try {
            workout = mapper.readValue(content.toString(), new TypeReference<Workout>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(workout);

        return workout;

    }

    public void deleteWorkout(String id) {

        String url = this.baseUrl+"/"+this.repositoryName+"/"+id;

        try {
            HttpService http = new HttpService();
            String response = http.delete(url);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
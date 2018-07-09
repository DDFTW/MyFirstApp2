package com.example.myfirstapp;

import java.util.ArrayList;
import java.util.List;

public class ScheduleObject {

    private List<Integer> times;
    protected String schedule;

    public ScheduleObject(){
        times = new ArrayList<>();
    }

    public ScheduleObject(int numberOfSections){
        times = new ArrayList<>(numberOfSections*2);
    }

    public void addSection(int timeStart, int timeEnd){
        times.add(timeStart);
        times.add(timeEnd);
    }

    public String getStringSchedule(){
        return schedule;
    }

    public void findEarliestTimeinList(){
        int minimum = times.get(0);
        int minIndex = 0;
        for(int i = 0; i < times.size(); i++){
            if(times.get(i) < minimum){
                minimum = times.get(i);
                minIndex = i;
            }

        }
    }

    public boolean hasOverlaps(){
        return true;
    }

    public String convertToStringTime(Integer toBeConverted){
        String time = "";
        String hours = ((Integer)(toBeConverted/60)).toString();
        String minutes = ((Integer)(toBeConverted%60)).toString();
        if(Integer.parseInt(minutes )< 10){
            minutes = "0"+minutes;
        }

        time = hours + ":" + minutes;
        return time;
    }

    public List<Integer> getList(){
        return times;
    }

    public int getElement(int element){
        return times.get(element);
    }

    public String convertToStringTime(List<Integer> toConvert){
        String all = "";
        int counter = 1;
        for(int i = 0; i < toConvert.size(); i++){
            if( i % 2 == 0){
                String temp = "Start Section " + (counter) + ": " + convertToStringTime(toConvert.get(i)) + " ";
                all += temp;
            }else {
                String temp = "End Section " + (counter) + ": " + convertToStringTime(toConvert.get(i)) + "\n ";
                all += temp;
                counter++;
            }
        }
        System.out.println(all);
        schedule = all;
        return all;

    }

    public static int toMinutes(String fromEditText){
        String hours = fromEditText.substring(0, fromEditText.indexOf(":"));
        String minutes = fromEditText.substring(fromEditText.indexOf(":")+1);
        int hour = Integer.parseInt(hours);
        int minute = Integer.parseInt(minutes);
        int totalMinutes = hour*60 + minute;
        return totalMinutes;
    }



}

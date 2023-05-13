package com.driver;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Meeting {
    private LocalTime startTime;
    private LocalTime endTime;

    public Meeting(LocalTime startTime, LocalTime endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    // public void setStartTime(LocalTime startTime) {
    //      this.startTime = startTime;
    //  }

    public LocalTime getEndTime() {
        return endTime;
    }

    //public void setEndTime(LocalTime endTime) {
    //   this.endTime = endTime;
//}
}
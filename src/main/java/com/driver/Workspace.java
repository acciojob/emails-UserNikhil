package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId, Integer.MAX_VALUE);
        calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am;
        ArrayList<Meeting> m = new ArrayList<>();
        LocalTime time_limit ;
        // Sorting of meeting according to
        // their finish time.

        // sorting using compartor class and without (compartor or comparable class)
        //  mycomparator mc = new mycomparator();
        //  Collections.sort(calendar,mc);
        Collections.sort(calendar,(m1,m2)->{
            return m1.getEndTime().compareTo(m2.getEndTime());
        });

        // Initially select first meeting.
        Meeting meet = calendar.get(0);
        m.add(meet);
        // time_limit to check whether new
        // meeting can be conducted or not.
        time_limit = calendar.get(0).getEndTime();

        // Check for all meeting whether it
        // can be selected or not.
        for (int i = 1; i < calendar.size(); i++) {
            if (calendar.get(i).getStartTime().compareTo(time_limit)>0) {

                // Add selected meeting to arraylist
                m.add(calendar.get(i));

                // Update time limit
                time_limit = calendar.get(i).getEndTime();
            }
        }

        return m.size();
    }
    class mycomparator implements Comparator<Meeting> {
        @Override public int compare(Meeting m1, Meeting m2)
        {
            if (m1.getEndTime().compareTo(m2.getEndTime())<0) {

                // Return -1 if second object is
                // bigger than first
                return -1;
            }
            else if (m1.getEndTime().compareTo(m2.getEndTime())>0) {

                // Return 1 if second object is
                // smaller than first
                return 1;
            }
            return 0;
 }
}

}
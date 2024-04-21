package activities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TrainSession implements Serializable{
    private LocalDate date;
    private List<Activity> activitiesList;


    //Constructors
    public TrainSession() {
        this.activitiesList = new ArrayList<>();
    }
    
    public TrainSession(List<Activity> activities, LocalDate date) {
        this.activitiesList = activities.stream()
                             .map(a->a.clone()).toList();
        this.date = date;
    }

    //Getters & Setters
    public LocalDate getDate() {
        return this.date;
    }

    public void setSessionDate(LocalDate date) {
        this.date = date;
    }

    public List<Activity> getActivitiesList() {
        return this.activitiesList.stream()
                .map(a->a.clone()).toList();
    }

    public void setActivitiesList(List<Activity> activities) {
        this.activitiesList.clear();
    
        this.activitiesList.addAll(activities.stream()
                .map(a->a.clone()).toList());
    }

    //Other methods
    //add a activity
    public void addActivity(Activity activity) {
        this.activitiesList.add(activity.clone());
    }

    //remove activity
    public void removeActivity(Activity activity) {
        if (activity != null) {
            int index = activitiesList.indexOf(activity);
            if (index != -1) {
                activitiesList.remove(index);
            }
        }
    }

    //Get number of activities
    public int getActivitiesCount() {
        return this.activitiesList.size();
    }

    //Calculate calories of a train session
    public double CalcSessionCalories() {
        return this.activitiesList.stream()
                         .mapToDouble(a->a.calculateCalories())
                         .sum();
    } 
    
    //ToString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 1; 

        sb.append("Train Session Date: ").append(this.date).append("\n");
        sb.append("All Activities of the Train Session:\n");
        
        for (Activity a : this.activitiesList) {
            sb.append(i).append(". "); 
            sb.append(a.toString()).append("\n"); 
            i++; 
        }
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrainSession)) return false;
        TrainSession t = (TrainSession) o;
        return this.date.equals(t.getDate()) &&
               this.activitiesList.equals(t.getActivitiesList());
    }

    //Clone
    public TrainSession clone() {
        TrainSession trainSession = new TrainSession();

        trainSession.activitiesList = this.activitiesList.stream()
                                      .map(a->a.clone()).toList();
        
        return trainSession;
    }
}
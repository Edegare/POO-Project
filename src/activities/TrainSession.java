package activities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainSession implements Serializable{
    private LocalDate date;
    private List<Activity> activitiesList;


    //Constructors
    public TrainSession() {
        this.date = LocalDate.now();
        this.activitiesList = new ArrayList<>();
    }
    
    public TrainSession(List<Activity> activities, LocalDate date) {
        this.activitiesList = activities.stream()
                             .map(a->a.clone()).collect(Collectors.toList());
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
                .map(a->a.clone()).collect(Collectors.toList());
    }

    public void setActivitiesList(List<Activity> activities) {
        this.activitiesList.clear();
    
        this.activitiesList.addAll(activities.stream()
                .map(a->a.clone()).collect(Collectors.toList()));
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

    // Get activity with index i 
    public Activity getActivity(int i) {
        if (i >= 0 && i < this.activitiesList.size()) {
            return this.activitiesList.get(i).clone();
        }
        else return null;
    }

    //Get number of activities
    public int getActivitiesCount() {
        return this.activitiesList.size();
    }

    //Calculate calories of a train session
    public double calcSessionCalories() {
        return this.activitiesList.stream()
                         .mapToDouble(a->a.calculateCalories())
                         .sum();
    } 
    
    //Calculate calories of an activity of index i
    public double getActivityCaloriesFactor(int i) {
        if (i<0 || i>=this.getActivitiesCount()) return -1;

        Activity activity = this.getActivity(i);
        double activityFactor = activity.calculateCalories();

        return activityFactor;
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
        trainSession.date=this.date; 
        trainSession.activitiesList = this.activitiesList.stream()
                                      .map(a->a.clone()).collect(Collectors.toList());
        
        return trainSession;
    }
}
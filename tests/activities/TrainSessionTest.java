package tests.activities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import activities.Activity;
import activities.BenchPress;
import activities.Canoe;
import activities.LegExtension;
import activities.MountainBike;
import activities.PushUps;
import activities.SitUps;
import activities.TrackRun;
import activities.TrailRun;
import activities.TrainSession;

public class TrainSessionTest {

    Activity a1;
    Activity a2;
    Activity a3;
    Activity a4;
    Activity a5;
    Activity a6;
    Activity a7;
    Activity a8;
    TrainSession session;

    @BeforeEach
    public void setUp () {
        a1 = new BenchPress(0.5, 10, 5, 15);
        a2 = new LegExtension(0.25, 10, 3, 10);
        a3 = new MountainBike(1, 4, 0.1);
        a4 = new TrackRun(1.5, 8);
        a5 = new TrailRun(1, 3.5, 0.1);
        a6 = new PushUps(0.25, 10, 4);
        a7 = new SitUps(0.25, 15, 3);
        a8 = new Canoe(2, 10);

        session = new TrainSession();
    }

    @Test
    @DisplayName("Test Calculate Session Calories")
    void testCalcSessionCalories() {
        session.addActivity(a1);
        session.addActivity(a2);
        session.addActivity(a3);
        assertEquals(9.27,session.calcSessionCalories(), 0.0001);
    }

    @Test
    @DisplayName("Test Get Activities Count")
    void testGetActivitiesCount() {
        session.addActivity(a6);
        session.addActivity(a7);
        assertEquals(2,session.getActivitiesCount());
    }
    
}

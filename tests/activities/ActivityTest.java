package tests.activities;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

public class ActivityTest {
    
    Activity a1;
    Activity a2;
    Activity a3;
    Activity a4;
    Activity a5;
    Activity a6;
    Activity a7;
    Activity a8;


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
    }

    @Test
    @DisplayName("Test Calculate Calories of LegExtension")
    void testCalculateCalories() {
        double standartCaloriesFactor= a2.calculateCalories(); 
        assertEquals(0.6,standartCaloriesFactor, 0.001);
    }

    @Test
    @DisplayName("Test Is Distance Activity False")
    void testFalseIsDistanceActivity() {
        assertFalse(a1.isDistanceActivity());
    }

    @Test
    @DisplayName("Test Is Distance Activity True")
    void testTrueIsDistanceActivity() {
        assertTrue(a4.isDistanceActivity());
    }

    @Test
    @DisplayName("Test Is Hard Activity True")
    void testTrueIsHard() {
        assertTrue(a5.isHard());
    }

    @Test
    @DisplayName("Test Is Hard Activity False")
    void testFalseIsHard() {
        assertFalse(a8.isHard());
    }

}

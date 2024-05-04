package tests.users;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import activities.*;
import users.ProfessionalUser;
import users.User;

public class UserTest {

    Activity a1;
    Activity a2;
    Activity a3;
    Activity a4;
    Activity a5;
    Activity a6;
    Activity a7;
    Activity a8;
    TrainSession session1;
    TrainSession session2;
    List <TrainSession> ts;
    User user1;

    @BeforeEach
    public void setUp () {
        a1 = new BenchPress(0.5, 10, 5, 15); // 0.005
        a2 = new LegExtension(0.25, 10, 3, 10); // 0.002
        a3 = new MountainBike(1, 4, 0.1); // 1.2
        a4 = new TrackRun(1.5, 8); // 1
        a5 = new TrailRun(1, 3.5, 0.1); //1.3
        a6 = new PushUps(0.25, 10, 4); // 0.1
        a7 = new SitUps(0.25, 15, 3); // 0.09
        a8 = new Canoe(2, 10); // 0.9

        session1 = new TrainSession();
        session2 = new TrainSession();

        session1.addActivity(a1);
        session1.addActivity(a2);
        
        session2.addActivity(a3);
        session2.addActivity(a2);
        session2.addActivity(a6);

        ts = new ArrayList<>();
        user1 = new ProfessionalUser("1", "José", "rua 1", "jo@gmail.com", 80, 65, ts);

        user1.addSession(session1);
        user1.addSession(session2);
    }

    @Test
    @DisplayName("Test Calculate User Activity Calories")
    void testCalcActivityCalories() {
        assertEquals(409, user1.calcActivityCalories(session1,0));
    }

    @Test
    @DisplayName("Test Calculate User Session Calories")
    void testCalcSessionCalories() {
        assertEquals(475, user1.calcSessionCalories(0));
    }

    @Test
    @DisplayName("Test Calculate User Total Calories")
    void testCalcUserTotalCalories() {
        assertEquals(1514, user1.calcUserTotalCalories(LocalDate.now()));
    }

    @Test
    @DisplayName("Test Count Sessions of user1")
    void testCountSessions() {
        assertEquals(2, user1.countSessions());
    }

    @Test
    @DisplayName("Test Count Total Activities of user1")
    void testCountTotalActivities() {
        assertEquals(5, user1.countTotalActivities(LocalDate.now()));
    }

    @Test
    @DisplayName("Test Get Name Most Practiced Activity of user1")
    void testGetNameMostPracticedActivity() {
        assertEquals("Leg Extension", user1.getNameMostPracticedActivity(LocalDate.now()));
    }

    @Test
    @DisplayName("Test Get Total Distance")
    void testGetTotalDistance() {
        assertEquals(4.1, user1.getTotalDistance(LocalDate.now()), 0.001);
    }

    @Test
    @DisplayName("Test Get Total Height Meters")
    void testGetTotalHeightMeters() {
        assertEquals(100, user1.getTotalHeightMeters(LocalDate.now()), 0.001);
    }
    
}

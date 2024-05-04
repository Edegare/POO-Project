package tests.users;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import users.AmateurUser;
import users.ProfessionalUser;
import users.User;
import users.UserManager;

public class UserManagerTest {

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
    TrainSession session3;
    List <TrainSession> ts;
    User user1;
    User user2;
    UserManager userManager;

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
        session3 = new TrainSession();

        session1.addActivity(a1);
        session1.addActivity(a2);
        
        session2.addActivity(a3);
        session2.addActivity(a2);
        session2.addActivity(a6);

        session3.addActivity(a8);

        ts = new ArrayList<>();
        user1 = new ProfessionalUser("1", "José", "rua 1", "jo@gmail.com", 80, 65, ts);
        user2 = new AmateurUser("2", "Ana", "rua2", "ana@sapo.pt", 90, 70, ts);
        
        user1.addSession(session1);
        user1.addSession(session2);

        user2.addSession(session1);
        user2.addSession(session3);

        userManager = new UserManager();

        userManager.addUser(user1);
        userManager.addUser(user2);

    }

    @Test
    @DisplayName("Test Contains User")
    void testContainsUser() {
        assertTrue(userManager.containsUser("1"));
    }

    @Test
    @DisplayName("Test Get Most Demanding Training Plan")
    void testGetMostDemandingTrainingPlan() {
        assertTrue(session2.equals(userManager.getMostDemandingTrainingPlan()));
    }

    @Test
    @DisplayName("Test Get Most Practiced Activity")
    void testGetMostPracticedActivity() {
        assertEquals("Leg Extension", userManager.getMostPracticedActivity());
    }

    @Test
    @DisplayName("Test Get User With Most Activities")
    void testGetUserWithMostActivities() {
        assertTrue(user1.equals(userManager.getUserWithMostActivities(LocalDate.now())));
    }

    @Test
    @DisplayName("Test Most Calories User")
    void testMostCaloriesUser() {
        assertTrue(user1.equals(userManager.mostCaloriesUser(LocalDate.now())));
    }
    
}

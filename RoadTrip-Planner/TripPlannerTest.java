import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class TripPlannerTest {

    @Test
    public void distance() {
        TripPlanner test = new TripPlanner();
        test.buildMap("uscities_final.csv", 300);
        int ny = test.getDictionary().get("New York NY");
        int la = test.getDictionary().get("Los Angeles CA");
        Node c1 = test.getCity(ny);
        Node c2 = test.getCity(la);
        double dist = test.distance(c1.getLat(), c2.getLat(), c1.getLng(), c2.getLng());
        assertEquals(2475, dist, 50);
    }

    @Test
    public void testDistance() {
        TripPlanner d = new TripPlanner();
        double answer = d.distance(40.6943, 34.1141, -73.9249, -118.4068);

        assertEquals(2457, Math.round(answer));
    }

    @Test
    public void buildMap() {
        TripPlanner test = new TripPlanner();
        test.buildMap("uscities_final.csv", 300);
        assertEquals(498 , test.getDictionary().size());
        int index = test.getDictionary().get("New York NY");
        assertEquals(1, index);
    }

    @Test
    public void shortestPath() {
        TripPlanner test = new TripPlanner();
        test.buildMap("uscities_final.csv", 300);
        test.shortestPath("New York NY", "Chicago IL");
    }

    @Test
    public void getDistances() {
    }

    @Test
    public void testPopularity() {
        TripPlanner tp = new TripPlanner();
        List<Integer> l = tp.planTrip("Lorain OH","random",5,4);
        System.out.print(tp.printCities(l));

    }


    @Test
    public void test1() {
        TripPlanner tp = new TripPlanner();
        tp.buildMap("uscities_final.csv",250);
        List<Integer> sp = tp.shortestPath("New York NY","Los Angeles CA");

        System.out.print(sp.size());


    }

    @Test
    public void test2() {
        TripPlanner tp = new TripPlanner();
        tp.buildMap("uscities_final.csv",500);
        List<Integer> sp = tp.shortestPath("Boston MA","Atlanta GA");

        System.out.print(sp.size());

        System.out.print("\t");

        System.out.print( tp.getCity(sp.get(0)).getCity() + " -> " + tp.getCity(sp.get(1)).getCity() +
                " -> " + tp.getCity(sp.get(2)).getCity());

    }

    @Test
    public void testPrint() {
        TripPlanner tp = new TripPlanner();
        tp.buildMap("uscities_final.csv",600);
        List<Integer> sp = tp.shortestPath("New York NY","Seattle WA");
        System.out.print(tp.printCities(sp));
    }

    @Test
    public void testPopularity3() {
        TripPlanner tp = new TripPlanner();
        List<Integer> l = tp.planTrip("Lorain OH","Atlanta GA",5,2);
        System.out.print(tp.printCities(l));

    }

    @Test
    public void testPopularity1() {
        TripPlanner tp = new TripPlanner();
        List<Integer> l = tp.planTrip("New York NY","Los Angeles CA",5,2);
        System.out.print(tp.printCities(l));

    }

    @Test
    public void testPlanTrip() {
        TripPlanner tp = new TripPlanner();
        List<Integer> l = tp.planTrip("Philadelphia PA","New York NY",5,2);
        System.out.print(tp.printCities(l));

    }












}
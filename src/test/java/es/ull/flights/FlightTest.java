package es.ull.flights;

import es.ull.passengers.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Flight Testing")
public class FlightTest {

    private Flight flight;
    private Passenger passenger;
    private final String flightNumber = "BA2490";

    @BeforeEach
    void setUp() {
        flight = new Flight(flightNumber, 1);
        passenger = new Passenger("1", "Javier", "ES");
    }

    @Test
    @DisplayName("Class Getters")
    public void testFlightGetters() {
        assertAll("Verify all attributes are set correctly",
                () -> assertEquals(flightNumber, flight.getFlightNumber()),
                () -> assertTrue(flight.addPassenger(passenger)),
                () -> assertEquals(1, flight.getNumberOfPassengers())
        );
    }

    @Test
    @DisplayName("Adding passengers")
    public void testAddingPassengers() {
        Passenger noSeatForHim = new Passenger("2", "Pedro", "ES");
        assertAll("Verify we can add passengers if there are available seats",
                () -> assertTrue(flight.addPassenger(passenger)),
                () -> assertThrows(RuntimeException.class, ()-> flight.addPassenger(noSeatForHim))
        );
    }

    @Test
    @DisplayName("Removing passengers")
    public void testRemovingPassengers() {
        assertAll("Verify we can remove passengers",
                () -> assertTrue(flight.addPassenger(passenger)),
                () -> assertTrue(flight.removePassenger(passenger)),
                () -> assertEquals(0, flight.getNumberOfPassengers())
        );
    }
}

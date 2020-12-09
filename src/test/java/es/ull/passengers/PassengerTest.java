package es.ull.passengers;

import es.ull.flights.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Passengers Testing")
public class PassengerTest {

    private Passenger passenger;

    @BeforeEach
    void setUp() {
        String countryCode = "ES";
        passenger = new Passenger("1", "Javier", countryCode);
    }

    @Test
    @DisplayName("Class Getters")
    public void testFlightGetters() {
        assertAll("Verify all attributes are set correctly",
                () -> assertEquals("1", passenger.getIdentifier()),
                () -> assertEquals("Javier", passenger.getName()),
                () -> assertEquals("ES", passenger.getCountryCode())
        );
    }

    @Test
    @DisplayName("Joining a flight")
    public void testJoiningFlight() {
        Flight flight = new Flight("BA2490", 1);
        assertAll("Verify we can join a flight",
                () -> assertDoesNotThrow(()-> passenger.joinFlight(flight)),
                () -> assertEquals(flight, passenger.getFlight())
        );
    }
}

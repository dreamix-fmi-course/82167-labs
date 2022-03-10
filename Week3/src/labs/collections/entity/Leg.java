package labs.collections.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Leg {
    private final String fromAirport;
    private final String toAirport;
    private final LocalDate date;

    public Leg(String fromAirport, String toAirport, LocalDate date) {
        this.fromAirport = Objects.requireNonNull(fromAirport, "Param cannot be null.");
        this.toAirport = Objects.requireNonNull(toAirport, "Param cannot be null.");
        this.date = Objects.requireNonNull(date, "Param cannot be null.");
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leg leg = (Leg) o;
        return fromAirport.equals(leg.fromAirport) && toAirport.equals(leg.toAirport) && date.equals(leg.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromAirport, toAirport, date);
    }
}
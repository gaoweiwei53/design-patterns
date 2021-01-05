package creationalPatterns.builder.builders;

import creationalPatterns.builder.cars.CarType;
import creationalPatterns.builder.components.Engine;
import creationalPatterns.builder.components.GPSNavigator;
import creationalPatterns.builder.components.Transmission;
import creationalPatterns.builder.components.TripComputer;

/**
 * Builder interface defines all possible ways to configure a product.
 */
public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}

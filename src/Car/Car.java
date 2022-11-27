package Car;

import java.util.Objects;

public abstract class Car {

    private String brand;
    private String model;
    private float engineVolume;

    public Car(String brand, String model, float engineVolume) {
        this();
        this.brand = validateLines(brand);
        this.model = validateLines(model);
        this.engineVolume = validateVolume(engineVolume);
    }

    public Car() {
        brand = "Марка не определена";
        model = "Модель не определена";
        engineVolume = 1.5f;

    }

    public void startMovement() {
        System.out.println("Начать движение!");
    }

    public void finishMovement() {
        System.out.println("Закончить движение!");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = validateLines(brand);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = validateLines(model);
    }

    public float getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(float engineVolume) {
        this.engineVolume = validateVolume(engineVolume);
    }

    public String validateLines(String value) {
        return value == null || value.isBlank() || value.isEmpty() ? "Данные не указаны" : value;
    }

    public float validateVolume(float value) {
        String comment;
        if (value == 0) {
            comment = "Данные не указаны";
        } else if (value < 0) {
            this.engineVolume = Math.abs(value);
        } else {
            this.engineVolume = value;
        }
        return this.engineVolume;
    }

    @Override
    public String toString() {
        return "Марка транспортного средства - " + brand +
                ", Модель - " + model +
                ", Объём двигателя - " + engineVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Float.compare(car.engineVolume, engineVolume) == 0 && brand.equals(car.brand) && model.equals(car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume);
    }
}

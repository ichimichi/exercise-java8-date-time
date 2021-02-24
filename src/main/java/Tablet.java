import java.time.LocalDate;

public class Tablet {
    private String name;
    private String manufacturer;
    private LocalDate manufactureDate;
    private LocalDate expiryDate;

    public Tablet(String name, String manufacturer, LocalDate manufactureDate, LocalDate expiryDate) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}

package dev.carlos.demo.models;

public class Device {
    private String name;
    private String brand;
    private Boolean wifi;
    private String macAdress;

    public Device(){}

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public void setMacAdress(String macAdress) {
        this.macAdress = macAdress;
    }

    //getters

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public String getMacAddress() {
        return macAdress;
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", wifi=" + wifi +
                ", macAdress='" + macAdress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Device dev = (Device) obj;
        return this.getMacAddress().equalsIgnoreCase(dev.getMacAddress());
    }


}

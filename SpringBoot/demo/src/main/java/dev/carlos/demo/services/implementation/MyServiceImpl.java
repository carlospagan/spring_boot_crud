package dev.carlos.demo.services.implementation;

import dev.carlos.demo.models.Device;
import dev.carlos.demo.services.MyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MyServiceImpl implements MyService {

    //MOCK, CAUSE WE DON'T HAVE DATABASE CONNECTION...

    private List<Device> myDevices = new ArrayList<>();

    @Override
    public Device save(Device device) {
        boolean contains = myDevices.contains(device);
        if(!contains) myDevices.add(device);
        return device;
    }

    @Override
    public Device getDeviceByMac(String macAddress) {
        Optional<Device> first = myDevices.stream().filter(device -> device.getMacAddress().equalsIgnoreCase(macAddress)).findFirst();
        Device device = first.get();
        return device;
    }

    @Override
    public List<Device> getAllDevices() {
        return myDevices;
    }

    @Override
    public List<Device> delete(String macAddress) {
        Device device = getDeviceByMac(macAddress);
        myDevices.remove(device);
        return myDevices;
    }

}

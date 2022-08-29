package dev.carlos.demo.controller;

import dev.carlos.demo.models.Device;
import dev.carlos.demo.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")

public class MyEndpoint
{
    @Autowired
    private MyService myService;

    @GetMapping //http://localhost:8080/test
    public List<Device> myFirstGet(){
        return myService.getAllDevices();
    }

    /*
        endpointWithParameter MUDANÇAS -->
    */

    @GetMapping("/{macAddress}") //http://localhost:8080/test/<id>
    public Device endpointWithParameter(@PathVariable String macAddress){
        return myService.getDeviceByMac(macAddress);
    }

    @GetMapping("/v1") //http://localhost:8080/test/v1?value=<value>
    public String endpointWithQuery (@RequestParam Integer value){
        System.out.println(value);
        return "Hello World" + " " + value;
    }

    @PostMapping //http://localhost:8080/test
    public Device myFirstPost(@RequestBody Device device){
        return myService.save(device);
    }

    @PutMapping("/{macAddress}")
    public Device myFirstPut(@RequestBody Device device, @PathVariable String macAddress){
      myService.getDeviceByMac(macAddress).setBrand(device.getBrand());
      myService.getDeviceByMac(macAddress).setName(device.getName());
      myService.getDeviceByMac(macAddress).setWifi(device.getWifi());
      return myService.getDeviceByMac(macAddress);
    }

    @DeleteMapping("/{macAddress}") // http://localhost:8080/test
    public void myFirstDelete(@PathVariable String macAddress){
        Device device = myService.getDeviceByMac(macAddress);
        myService.delete(macAddress);
    }

}

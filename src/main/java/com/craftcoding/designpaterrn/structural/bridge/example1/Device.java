package com.craftcoding.designpaterrn.structural.bridge.example1;

public interface Device {

    void on();
    void off();
    void volumeUp();
    void volumeDown();
}

class Tv implements Device{

    @Override
    public void on() {
        System.out.println("[TV is on]");
    }

    @Override
    public void off() {
        System.out.println("[TV is off]");

    }

    @Override
    public void volumeUp() {
        System.out.println("[TV is volume increased ]");
    }

    @Override
    public void volumeDown() {
        System.out.println("[TV is volume decreased ]");

    }
}


class Radio implements Device{

    @Override
    public void on() {
        System.out.println("[Radio is on]");
    }

    @Override
    public void off() {
        System.out.println("[Radio is off]");

    }

    @Override
    public void volumeUp() {
        System.out.println("[Radio is volume increased ]");
    }

    @Override
    public void volumeDown() {
        System.out.println("[Radio is volume decreased ]");

    }
}

abstract class UniversalRemote {
    protected Device device;
    public UniversalRemote(Device device){
        this.device = device;
    }
    abstract public void off();
    abstract public void on();
}

class BasicRemoteControllerDevice extends UniversalRemote {

    public BasicRemoteControllerDevice(Device device){
        super(device);
    }
    @Override
    public void off() {
        device.off();
    }

    @Override
    public void on() {
        device.on();
    }
}
class DriverClass{
    public static void main(String[] args) {
        Tv tv = new Tv();
        Radio radio = new Radio();

        BasicRemoteControllerDevice basicRemoteControllerDevice = new BasicRemoteControllerDevice(tv);
        basicRemoteControllerDevice.on();
        basicRemoteControllerDevice.off();


        basicRemoteControllerDevice = new BasicRemoteControllerDevice(radio);
        basicRemoteControllerDevice.on();
        basicRemoteControllerDevice.off();

    }
}


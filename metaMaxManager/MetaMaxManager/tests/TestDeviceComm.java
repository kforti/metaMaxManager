package tests;

import org.micromanager.metamaxmanager.controller.DeviceController;
import org.micromanager.metamaxmanager.model.Model;

public class TestDeviceComm {
    DeviceController controller;

    public void TestDeviceComm() {
        //this.controller = new DeviceController(new Model());

    }

    public void run() {
        controller = new DeviceController(new Model());
        try {
            System.out.println(controller.isConnected());
        } catch (Exception e) {
            System.out.println(String.format("error: %s", e.getStackTrace()));
        }
    }
}

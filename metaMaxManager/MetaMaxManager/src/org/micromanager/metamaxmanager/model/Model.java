package org.micromanager.metamaxmanager.model;

public class Model {

    String base_url = "https://api.particle.io/v1/devices/";
    String access_token = "b0b4abf352e4813771428d70189ad7b128a5fba3";
    String device_id = "4b001c001851373237343331";
    String led_state;

    Device device;

    public void Model(){
        this.led_state = "off";
    }

    public String ledState(){
        return led_state;
    }

    public void flipLedState(){
        if (led_state.equalsIgnoreCase("on")) {
            led_state = "off";
        }
        else if (led_state.equalsIgnoreCase("off")){
            led_state = "on";
        }
    }

    public String generateFunctionURL(String function) {
        String url = base_url + device_id + "/" + function + "?" + "access_token=" + access_token;
        return url;
    }
    public String generateDeviceURL() {
        String url = base_url + device_id + "/?" + "access_token=" + access_token;
        return url;
    }

    public void setDevice(Device d) {
        device = d;
        return;
    }

}

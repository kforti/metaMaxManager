package org.micromanager.metamaxmanager.model;

public class Device {
    private String id;
    private String name;
    private String last_ip_address;
    private String last_heard;
    private String product_id;
    private String connected;

    public Device(String connected, String id, String name, String last_ip_address, String last_heard, String product_id ) {
        this.connected = connected;
        this.id = id;
        this.name = name;
        this.last_ip_address = last_ip_address;
        this.last_heard = last_heard;
        this.product_id = product_id;
    };

    public String isConnected() {
        return connected;
    }

    public String getId(){ return id;}



}

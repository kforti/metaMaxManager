package org.micromanager.metamaxmanager.image_acquisition;

import mmcorej.CMMCore;

import java.util.Queue;

public class ImageAcquisitionRunnable implements Runnable{
    CMMCore core_;
    Queue imageQueue;
    volatile boolean exit = false;
    boolean capture = true;

    public ImageAcquisitionRunnable(CMMCore core, Queue iq) {
        this.core_ = core;
        this.imageQueue = iq;
    }

    @Override
    public void run() {
        try {
            this.core_.snapImage();
            short image[] = (short[]) this.core_.getImage();
            imageQueue.add(image);


        } catch (Exception e) {

        }
    }

    public void stop(){
        exit = true;
    }

    public void stopCapture() {
        capture = false;
    }

    public void startCapture() {
        capture = true;
    }

    public int numImages() {
        return imageQueue.size();
    }
}

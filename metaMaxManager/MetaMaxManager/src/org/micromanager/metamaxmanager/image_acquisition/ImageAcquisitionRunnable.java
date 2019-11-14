package org.micromanager.metamaxmanager.image_acquisition;

import mmcorej.CMMCore;

import java.util.Queue;

public class ImageAcquisitionRunnable implements Runnable{
    CMMCore core_;
    Queue imageQueue;

    public ImageAcquisitionRunnable(CMMCore core, Queue iq) {
        this.core_ = core;
        this.imageQueue = iq;
    }

    @Override
    public void run() {
        try {
            this.core_.snapImage();
            double image[] = (double[]) this.core_.getImage();
            imageQueue.add(image);
        } catch (Exception e){

        }
    }
}

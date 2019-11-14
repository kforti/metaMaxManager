package org.micromanager.metamaxmanager.managers;


import mmcorej.CMMCore;
import org.micromanager.metamaxmanager.image_acquisition.ImageAcquisitionRunnable;
import org.micromanager.metamaxmanager.model.Model;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class ManualCalibrationManager {
    Queue<double[]> imageQueue = new LinkedList<>();
    Thread imageAcquisitionThread;
    Thread imageProcessingThread;

    Model model_;
    CMMCore core_;

    public ManualCalibrationManager(Model model, CMMCore core) {
        this.model_ = model;
        this.core_ = core;
    }

    public void run() {
        imageAcquisitionThread = new Thread(new ImageAcquisitionRunnable(core_, imageQueue));
        imageAcquisitionThread.start();
        try {
            imageAcquisitionThread.wait();
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
        double[] img = imageQueue.remove();
        String s = "";
        for (double i: img) {
            s += Double.toString(i);
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/home/kevin/metaMaxManager/metaMaxManager/test_images_"));
            writer.write(s);
        } catch (Exception e) {

        }
    }




}

package org.micromanager.metamaxmanager.controller;

import ij.process.ByteProcessor;
import ij.process.ByteStatistics;
import mmcorej.CMMCore;
import org.micromanager.metamaxmanager.image_processing.ImageBatchManager;
import org.micromanager.metamaxmanager.image_processing.ImagePixelStatistics;
import org.micromanager.metamaxmanager.model.Model;
import org.micromanager.metamaxmanager.view.MetaMaxView;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

public class CalibrationController {
    CMMCore core;
    Model model;
    MetaMaxView view;
    public CalibrationController(CMMCore c, Model m, MetaMaxView v) {
        this.core = c;
        this.model = m;
        this.view = v;
    }

    public void process() {

        // set metamax intensity

        // check if calibration manager exists in model

        // init calibration manager

        // Start processing

        // Store data in cloud




//        try {
//            core.snapImage();
//            short image[] = (short[]) core.getImage();
//            StringBuilder sb = new StringBuilder();
//            view.setComm(String.format("Image Length: %d", image.length));
////            TimeUnit.SECONDS.sleep(5);
//            long tot = 0;
//            for (int i = 0; i < image.length; i++) {
//                tot += (long) (image[i]);
////                TimeUnit.SECONDS.sleep(5);
//            }
//            view.setComm(String.format("%d", tot/image.length));


//            if (core.getBytesPerPixel() == 1) {
//                byte image[] = (byte[]) core.getImage();
//            }
//            else if (core.getBytesPerPixel() == 2) {
//                short image[] = (short[]) core.getImage();
//                StringBuilder sb = new StringBuilder();
//                for (short b: image) {
//                    sb.append(String.format("%d ", b));
//                }
//                view.setComm(sb.toString());
//            }

//            long width = core.getImageWidth();
//            long height = core.getImageHeight();
//
//        } catch (Exception e) {
//            view.setComm(e.getMessage());
//        }


    }
}

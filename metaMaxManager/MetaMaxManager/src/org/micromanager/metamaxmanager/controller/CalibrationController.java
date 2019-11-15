package org.micromanager.metamaxmanager.controller;

import mmcorej.CMMCore;
import org.micromanager.metamaxmanager.managers.ManualCalibrationManager;
import org.micromanager.metamaxmanager.model.Model;
import org.micromanager.metamaxmanager.view.MetaMaxView;

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
        ManualCalibrationManager calibrationManager = new ManualCalibrationManager(model, core);
        calibrationManager.run();
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

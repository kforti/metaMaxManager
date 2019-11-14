package org.micromanager.metamaxmanager.image_processing;

import mmcorej.CMMCore;
import org.micromanager.metamaxmanager.controller.MetaMaxController;

import java.io.IOException;

public class ManualCalibrationManager implements Runnable {

    MetaMaxController mmController;
    int intensityValue;
    CMMCore core_;
    long image_size = 0;
    long image_height;
    long image_width;

    public ManualCalibrationManager(MetaMaxController mmc, int intensity, CMMCore core) {
        this.mmController = mmc;
        this.intensityValue = intensity;
        this.core_ = core;
    }

    @Override
    public void run() {
        try {
            mmController.setIntensity(intensityValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        image_height = core_.getImageHeight();
        image_width = core_.getImageWidth();
        image_size = image_height * image_width;

    }
}

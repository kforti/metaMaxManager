package org.micromanager.metamaxmanager.managers;


import mmcorej.CMMCore;
import org.micromanager.metamaxmanager.image_acquisition.ImageAcquisitionRunnable;
import org.micromanager.metamaxmanager.model.Model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Queue;

public class ManualCalibrationManager {
//    Queue<short[]> imageQueue = new LinkedList<>();
//    Thread imageAcquisitionThread;
//    Thread imageProcessingThread;
    int images;
    int[] summedImage;
    long[] squaredImage;
    int batchSize = 1000;

    Model model_;
    CMMCore core_;

    public ManualCalibrationManager(Model model, CMMCore core) {
        this.model_ = model;
        this.core_ = core;
    }

    public void run() {
        int numImages = 0;
        //ImageAcquisitionRunnable imgAcq= new ImageAcquisitionRunnable(core_, imageQueue);
//        imageAcquisitionThread = new Thread(imgAcq);
//        imageAcquisitionThread.start();
        int imageLength = 0;
        LocalTime start = LocalTime.now();
        while (images < batchSize) {

            try {
                this.core_.snapImage();
                short image[] = (short[]) this.core_.getImage();

                if (images == 0) {
                    imageLength = image.length;
                    summedImage = new int[imageLength];
                    squaredImage = new long[imageLength];
                }
                for (int i = 0; i < imageLength; ++i) {
                    summedImage[i] = (Math.max(0, summedImage[i]) + image[i]);
                    squaredImage[i] = (long) (squaredImage[i] + Math.pow(image[i], 2));

                }
                //System.out.println(summedImage[0]);

            } catch (Exception e) {

            }
            images += 1;
            if (images % 10000 == 0){
                System.out.println(images);
            }
        }
        System.out.println("Summed images: " + summedImage[0]);
        System.out.println("Summed images: " + squaredImage[0] + "\n");

        LocalTime finish = LocalTime.now();
        System.out.println("Number of Images Processed: " + batchSize);
        System.out.println("Started Processing: " + start);
        System.out.println("Finished Processing: " + finish);
        System.out.println(Duration.between(start, finish).getSeconds());
    }

}

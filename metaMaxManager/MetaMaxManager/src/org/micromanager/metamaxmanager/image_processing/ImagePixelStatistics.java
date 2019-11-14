package org.micromanager.metamaxmanager.image_processing;


import org.micromanager.metamaxmanager.model.Image;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Array;

public class ImagePixelStatistics {
    ImageBatchManager batch;
    short[] batch_totals;
    float[] batch_mean;

    public ImagePixelStatistics(ImageBatchManager batch) {
        this.batch = batch;
        batch_totals = new short[(int) batch.getImageSize()];
        batch_mean = new float[(int) batch.getImageSize()];
    }

    public float[] calculateBatchMean() {
        String s = "";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/home/kevin/metaMaxManager/metaMaxManager/test_images"));

            for (int i = 0; i < batch.batch_size; i++) {
                Image img = batch.getIndex(i);
                long imgSize = batch.getImageSize();
                for (int index = 0; index < imgSize; index++) {
                    short batchVal = Array.getShort(batch_totals, index);
                    Array.set(batch_totals, index, batchVal + img.getIndex(index));
                }
            }
//            for (int index = 0; index < batch.getImageSize(); index++) {
//                Array.set(batch_mean, index, (float) batch_totals[index] / batch.getImageSize());
//            }
            Boolean first_iter = true;
            for (short i: batch_totals) {
                if (!first_iter){
                    s += ",";
                } else {first_iter = false;}
                s += Short.toString(i);
            }

            writer.write(s);
            return batch_mean;
        } catch (Exception e) {

            return null;
        }
    }

}

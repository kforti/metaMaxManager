package org.micromanager.metamaxmanager.model;

import mmcorej.CMMCore;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Image {
    short[] pixels;
    int imgId;

    public Image(Object img, int id){
       this.pixels = (short[]) img;
       this.imgId = id;
    }

    public short getIndex(int i) {
        return pixels[i];
    }

    public String toString(){
        String img = "";
        for (int i = 0; i < pixels.length; i++) {
            if (i != 0) { img += ","; }
            img += Short.toString(pixels[i]);
        }
        return img;
    }

    public void writeToDisk(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/home/kevin/metaMaxManager/metaMaxManager/test_images_" + Integer.toString(imgId)));
            writer.write(toString());
        } catch (Exception e){

        }
    }
}

package tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;

public class ImageStats {
    File[] imgPaths = {new File("/home/kevin/metaMaxManager/metaMaxManager/test_images_0"),
                        new File("/home/kevin/metaMaxManager/metaMaxManager/test_images_1")};
    public void run() throws Exception{
        int[][] images =  new int[imgPaths.length][];
        int imageIndex = 0;
        int imgLength = 0;

        for (File file: imgPaths) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String[] img = br.readLine().split(",");
            int[] image = new int[img.length];
            int index = 0;
            for (String v: img){
                Array.set(image, index, Integer.parseInt(v));
                index += 1;
                if (imgLength == 0) {
                    imgLength = image.length;
                }
            }
            Array.set(images, imageIndex, image);
            imageIndex += 1;
        }
        for (int i = 0; i < imgLength; i++){
            System.out.println(images[0][i]);
            System.out.println(images[1][i]);
            System.out.println(images[0][i] + images[1][i]);
            System.out.println("\n");

        }


    }
}

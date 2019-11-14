package org.micromanager.metamaxmanager.image_processing;

import mmcorej.CMMCore;
import org.micromanager.metamaxmanager.model.Image;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImageBatchManager implements Iterable<Image>{
    private List<Image> images;
    long image_size = 0;
    long image_height;
    long image_width;
    int batch_size;

    public ImageBatchManager(int batch_size){
        this.batch_size = batch_size;
        this.images = new ArrayList<Image>(batch_size);
    }

    public void captureImages(CMMCore core){
        for (int i = 0; i < batch_size; i++) {
            try {
                core.snapImage();
                if (image_size == 0){
                    image_height = core.getImageHeight();
                    image_width = core.getImageWidth();
                    image_size = image_height * image_width;
                }
                Image img = new Image(core.getImage(), i);
                img.writeToDisk();
                images.set(i, img);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public Image getIndex(int index){
        return images.get(index);
    }

    public long getImageSize() {
        return image_size;
    }

    @Override
    public Iterator<Image> iterator() {
        return new Iterator<Image>() {
            private final Iterator<Image> iter = images.iterator();

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public Image next() {
                return iter.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("no changes allowed");
            }
        };
    }

}

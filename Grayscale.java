import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of class Grayscale here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grayscale {

    public void makegrayImages() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            String inImagename = inImage.getFileName();
            String FinalImagename = "gray-" + inImagename;
            ImageResource FnImage = makegray(inImage);
            FnImage.setFileName(FinalImagename);
            //System.out.println(inImage.getFileName());
            FnImage.draw();
            FnImage.save();
        }     
}

public ImageResource makegray(ImageResource inImage) {
    ImageResource Output = new ImageResource(inImage.getWidth(), inImage.getHeight());
    for (Pixel pixel : Output.pixels()) {
        Pixel inpixel = inImage.getPixel(pixel.getX(), pixel.getY());
        int average = (inpixel.getRed() + inpixel.getGreen() + inpixel.getBlue()) / 3;
        //System.out.println(average);
        pixel.setRed(average);
        pixel.setGreen(average);
        pixel.setBlue(average);
    }
    return Output;
}
}


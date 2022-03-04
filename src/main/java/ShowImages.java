import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import javax.swing.*;

public class ShowImages extends JFrame {
    static {nu.pattern.OpenCV.loadShared();
    System.out.println("Version: " + Core.VERSION);}

    public static void main(String[] args) {
        // Создаём контейнер для изображения.
        JLabel screen = new JLabel();
        ImageConversion ic = new ImageConversion();
        String filename = "src/main/resources/sh1.jpg";
        ic.addImageToJLabel(filename, screen, ".jpg");
        ic.createWindowWithImg("Window: ", screen);
        ImageSize is = new ImageSize(filename);
        JLabel screenFHD = new JLabel();
        ic.addImageToJLabel(is.getFHD(), screenFHD, ".jpg");
        ic.createWindowWithImg("FHD: ", screenFHD);
    }

}

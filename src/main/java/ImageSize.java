import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import static org.opencv.imgproc.Imgproc.*;

public class ImageSize {
    String imgName;
    ImageSize(String ImageName){
        imgName = ImageName;
    }
    public Mat getFHD(){
        ImageConversion ic = new ImageConversion();
        Mat img = Imgcodecs.imread(imgName);
        System.out.println(img.size());
        Mat resizeImg = new Mat();
        Size scaleSize = new Size(1920,1080);
        resize(img, resizeImg, scaleSize, 0,0, INTER_NEAREST);
        return resizeImg;
    }
}

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import javax.swing.*;

public class ShowImages extends JFrame {
    static {nu.pattern.OpenCV.loadShared();
    System.out.println("Version: " + Core.VERSION);}

    public static void main(String[] args) {
        // Создаём окно для просмотра изображения.
        JFrame window = new JFrame("Window:");
        // Создаём контейнер для изображения.
        JLabel screen = new JLabel();
        // Установлимаем операцию закрытия по умолчанию.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Делаем окно отображения контента видимым.
        window.setVisible(true);
        addImageToJLabel("resources\\lol.png", screen);
        // Привязываем контейнер к окну отображения.
        window.getContentPane().add(screen);
        window.pack();
    }

    private static JLabel addImageToJLabel(String filename, JLabel screen){
        Mat img = Imgcodecs.imread(filename);
        /* Преобразуем изображение в матрицу байтов с целью
           получить массив байтов (пикселей). */
        MatOfByte buf = new MatOfByte();
        Imgcodecs.imencode(".png", img, buf);
        /* Преобразуем массив пикселей в ImageIcon,
           изображение которое будет отображатся. */
        ImageIcon ic = new ImageIcon(buf.toArray());
        // Привязываем изображение к контейнеру.
        screen.setIcon(ic);
        return screen;
    }
}

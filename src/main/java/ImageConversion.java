import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import javax.swing.*;

public class ImageConversion {
    public JLabel addImageToJLabel(String filename, JLabel screen, String ext){
        Mat img = Imgcodecs.imread(filename);
        /* Преобразуем изображение в матрицу байтов с целью
           получить массив байтов (пикселей). */
        MatOfByte buf = new MatOfByte();
        Imgcodecs.imencode(ext, img, buf);
        /* Преобразуем массив пикселей в ImageIcon,
           изображение которое будет отображатся. */
        ImageIcon ic = new ImageIcon(buf.toArray());
        // Привязываем изображение к контейнеру.
        screen.setIcon(ic);
        return screen;
    }
    public JLabel addImageToJLabel(Mat img, JLabel screen, String ext){
        /* Преобразуем изображение в матрицу байтов с целью
           получить массив байтов (пикселей). */
        MatOfByte buf = new MatOfByte();
        Imgcodecs.imencode(ext, img, buf);
        /* Преобразуем массив пикселей в ImageIcon,
           изображение которое будет отображатся. */
        ImageIcon ic = new ImageIcon(buf.toArray());
        // Привязываем изображение к контейнеру.
        screen.setIcon(ic);
        return screen;
    }
    public JFrame createWindowWithImg(String label, JLabel screen){
        // Создаём окно для просмотра изображения.
        JFrame window = new JFrame(label);
        // Установлимаем операцию закрытия по умолчанию.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Делаем окно отображения контента видимым.
        window.setVisible(true);
        window.getContentPane().add(screen);
        window.pack();
        return window;
    }
}

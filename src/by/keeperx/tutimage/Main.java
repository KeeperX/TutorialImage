package by.keeperx.tutimage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Admin on 18.08.2016.
 */
public class Main {



    private static MainWindowForm mWindow = new MainWindowForm(600,480);
    private static BufferedImage image;

    public static void main(String[] args) {

    }
    public static void setImage(URL url){

        try {
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void setImage(File file){
        try {
        image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void saveImage(File file, String formatName){
        try {
            File file2 = new File(file.getAbsolutePath()+"."+formatName);
            ImageIO.write(image,formatName,file2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void setmWindow(MainWindowForm mWindow) {
        Main.mWindow = mWindow;
    }

    public static void setImage(BufferedImage image) {
        Main.image = image;
    }

    public static MainWindowForm getmWindow() {

        return mWindow;
    }

    public static BufferedImage getImage() {
        return image;
    }


}

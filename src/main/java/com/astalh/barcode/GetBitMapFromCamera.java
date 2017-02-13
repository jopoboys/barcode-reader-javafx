package com.astalh.barcode;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;


public class GetBitMapFromCamera {

    public static void main(String[] args) throws IOException {
        Webcam webcam = Webcam.getWebcams().get(0);
        webcam.open();
        ImageIO.write(webcam.getImage(), "JPG", new File(System.currentTimeMillis() + ".jpg"));
        webcam.close();
    }
}

package com.codepulse.QR;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class QRCodeReader {
    public static void main(String[] args) throws Exception {
        File qrCodeImage = new File("qrcode.png");
        BufferedImage bufferedImage = ImageIO.read(qrCodeImage);
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        try {
            Result result = new MultiFormatReader().decode(bitmap);
            System.out.println("QR Code content: " + result.getText());
        } catch (NotFoundException e) {
            System.out.println("QR Code not found.");
        }
    }
}

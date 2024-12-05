package com.codepulse.QR;

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {
    public static void main(String[] args) throws Exception {
        String data = "https://example.com";
        String path = "qrcode.png";
        
        // Set QR code parameters
        int width = 300;
        int height = 300;
        String charset = "UTF-8";
        
        // Generate QR code
        BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, width, height);
        
        // Write to file
        Path filePath = FileSystems.getDefault().getPath(path);
        MatrixToImageWriter.writeToPath(matrix, "PNG", filePath);
        
        System.out.println("QR code generated at " + path);
    }
}

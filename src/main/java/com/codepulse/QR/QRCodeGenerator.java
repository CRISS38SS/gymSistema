package com.codepulse.QR;

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class QRCodeGenerator {

    public QRCodeGenerator(String nombre, String lastname, String numero, String infos) throws Exception {

        // Obtener ruta del escritorio
        String desktopPath = Paths.get(System.getProperty("user.home"), "Desktop").toString();

        // Crear la carpeta si no existe
        File outputDir = new File(desktopPath);
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        // Construir ruta completa del archivo
        String filePath = String.format("%s%s%s%s%s.png", 
                                        desktopPath, 
                                        File.separator, 
                                        nombre, 
                                        lastname, 
                                        numero);

        // Configuración del QR
        int width = 300;
        int height = 300;
        String charset = "UTF-8";

        // Generar código QR
        BitMatrix matrix = new MultiFormatWriter().encode(infos, BarcodeFormat.QR_CODE, width, height);

        // Guardar imagen en la ruta
        Path filePaths = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(matrix, "PNG", filePaths);

        System.out.println("Código QR generado en: " + filePath);
    }

    public static void main(String[] args) throws Exception {
        // Crear un QR de prueba
        QRCodeGenerator qrcode = new QRCodeGenerator("John", "Doe", "1234", "Contenido del QR");
    }
}

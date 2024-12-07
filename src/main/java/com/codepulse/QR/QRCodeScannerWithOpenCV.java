package com.codepulse.QR;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class QRCodeScannerWithOpenCV {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME); // Cargar la librería de OpenCV
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Escáner de QR con OpenCV");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        frame.setVisible(true);

        VideoCapture capture = new VideoCapture(0); // Inicializar cámara
        if (!capture.isOpened()) {
            System.out.println("No se pudo abrir la cámara.");
            return;
        }

        JLabel videoLabel = new JLabel();
        frame.add(videoLabel, BorderLayout.CENTER);

        // Configuración del lector de códigos QR de ZXing
        MultiFormatReader reader = new MultiFormatReader();

        // Bucle para capturar el video y escanear los códigos QR
        Mat frameMat = new Mat();
        while (true) {
            capture.read(frameMat); // Capturar un nuevo frame
            if (frameMat.empty()) {
                System.out.println("Error al capturar el frame.");
                break;
            }

            // Convertir la imagen de OpenCV a BufferedImage
            BufferedImage img = matToBufferedImage(frameMat);

            // Intentar detectar el QR
            try {
                Result result = scanQRCode(img, reader);
                if (result != null) {

                    QrEncontrado qrEncontrado=new QrEncontrado("Encontrado");
                    qrEncontrado.setVisible(true);
                    break; // Detener al detectar un código QR
                }
                else {
                    QrEncontrado qrEncontrado=new QrEncontrado("NO");
                    qrEncontrado.setVisible(true);
                    break;
                }
            } catch (NotFoundException e) {
                // No se encontró ningún QR, seguimos escaneando
            }

            // Mostrar la imagen en el JLabel
            videoLabel.setIcon(new ImageIcon(img));
            frame.repaint();

            try {
                Thread.sleep(30); // Pausar un poco para mejorar el rendimiento
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Cerrar la cámara
        capture.release();
    }

    public static BufferedImage matToBufferedImage(Mat mat) {
        int width = mat.width();
        int height = mat.height();
        int channels = mat.channels();

        byte[] sourcePixels = new byte[width * height * channels];
        mat.get(0, 0, sourcePixels);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(sourcePixels, 0, targetPixels, 0, sourcePixels.length);

        return image;
    }

    public static Result scanQRCode(BufferedImage image, MultiFormatReader reader) throws NotFoundException {
        LuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        return reader.decode(bitmap);
    }
}

package com.codepulse.QR;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import com.codepulse.Principal;
import com.codepulse.sqlite;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class QRCodeScannerWithOpenCV extends JFrame{

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME); // Cargar la librería de OpenCV
    }

    public QRCodeScannerWithOpenCV(int id){
        setTitle("Scannear");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(640, 480);
        setLayout(new BorderLayout());

        JLabel videoLabel = new JLabel();
        JLabel statusLabel = new JLabel("Esperando QR...", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        statusLabel.setForeground(Color.BLUE);

        add(videoLabel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        setVisible(true);

        VideoCapture capture = new VideoCapture(0); // Inicializar cámara
        if (!capture.isOpened()) {
            JOptionPane.showMessageDialog(this, "No se pudo abrir la cámara.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        new Thread(() -> {
            Mat frameMat = new Mat();
            MultiFormatReader reader = new MultiFormatReader();

            while (true) {
                capture.read(frameMat); // Capturar un nuevo frame
                if (frameMat.empty()) {
                    statusLabel.setText("Error al capturar el frame.");
                    break;
                }

                BufferedImage img = matToBufferedImage(frameMat);

                try {
                    Result result = scanQRCode(img, reader);
                    if (result != null) {
                        String qrContenido=result.getText();
                        statusLabel.setText("QR Detectado: " + qrContenido);
                        statusLabel.setForeground(Color.GREEN);

                        // Verificar en la base de datos
                        if (sqlite.verificaQRCodeEnDatabase(qrContenido)==true) {
                            JOptionPane.showMessageDialog(this, "QR válido. Acceso permitido.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                            Principal principal=new Principal(id);
                            principal.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "QR no válido. Acceso denegado.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break; // Detener al detectar un código QR
                    } else {
                        statusLabel.setText("No se encontró ningún QR.");
                        statusLabel.setForeground(Color.RED);
                    }
                } catch (NotFoundException e) {
                    // No se encontró ningún QR
                    statusLabel.setText("Escaneando...");
                    statusLabel.setForeground(Color.BLUE);
                }

                videoLabel.setIcon(new ImageIcon(img));
                repaint();

                try {
                    Thread.sleep(30); // Pausar un poco para mejorar el rendimiento
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            capture.release();
        }).start();
    }

    public static void main(String[] args) {
        QRCodeScannerWithOpenCV c=new QRCodeScannerWithOpenCV(1);
        
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

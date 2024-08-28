package com.project.portfolio.core.utilities;

import com.project.portfolio.service.ImageRules;

import java.util.Base64;
import java.util.Arrays;


public class ImageUtils {

    // Resmin Base64 formatında dönüştürülmesi
    public static String encodeImageToBase64(byte[] image, String mimeType) {
        ImageRules.validateImage(image); // Hata kontrolü
        ImageRules.validateMimeType(mimeType); // Hata kontrolü

        return "data:" + mimeType + ";base64," + Base64.getEncoder().encodeToString(image);
    }

    // Resmin MIME tipini belirlemek için yöntem
    public static String getImageMimeType(byte[] image) {
        ImageRules.validateImage(image); // Hata kontrolü

        // MIME tiplerini belirlemek için kontrol
        if (isPng(image)) {
            return "image/png";
        } else if (isJpeg(image)) {
            return "image/jpeg";
        } else if (isGif(image)) {
            return "image/gif";
        }
        return "application/octet-stream"; // Bilinmeyen format
    }

    private static boolean isPng(byte[] image) {
        return image.length > 8 &&
                image[0] == (byte) 137 &&
                image[1] == (byte) 80 &&
                image[2] == (byte) 78 &&
                image[3] == (byte) 71 &&
                image[4] == (byte) 13 &&
                image[5] == (byte) 10 &&
                image[6] == (byte) 26 &&
                image[7] == (byte) 10;
    }

    private static boolean isJpeg(byte[] image) {
        return image.length > 2 &&
                image[0] == (byte) 0xFF &&
                image[1] == (byte) 0xD8 &&
                (image[image.length - 2] == (byte) 0xFF &&
                        image[image.length - 1] == (byte) 0xD9);
    }

    private static boolean isGif(byte[] image) {
        return image.length > 6 &&
                (new String(Arrays.copyOfRange(image, 0, 6)).equals("GIF87a") ||
                        new String(Arrays.copyOfRange(image, 0, 6)).equals("GIF89a"));
    }
}

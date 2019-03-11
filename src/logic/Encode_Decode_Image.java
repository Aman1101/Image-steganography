package logic;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Encode_Decode_Image {

    int pixels[][];
    BufferedImage image;
    int width, height;

    public Encode_Decode_Image(BufferedImage image) {
        this.image = image;
        initPixels();
    }

    public String decodeData_Image(ArrayList<Integer> x, ArrayList<Integer> y) {
        String txt = "";

        Message_Binary_Bridge mbb = new Message_Binary_Bridge();
        GreyCode_Binary_Bridge gbb = new GreyCode_Binary_Bridge();

        for (int i = 0; i < x.size(); i++) {
            int xCoord = x.get(i);
            int yCoord = y.get(i);
            int pixel = pixels[xCoord][yCoord];
            System.out.println("PIXEL: " + pixel);
            int rgb = image.getRGB(xCoord, yCoord);
            int red = (pixel >> 16) & 0x000000FF;
            int green = (pixel >> 8) & 0x000000FF;
            int blue = (pixel) & 0x000000FF;
            System.out.println("BLUE: " + blue);
            String grey_binary = String.format("%8s", Integer.toBinaryString(blue)).replace(' ', '0');
            System.out.println("GB: " + grey_binary);
            String message_binary = gbb.greyToBinary(grey_binary);
            System.out.println("MB: " + message_binary);
            int intEq = Integer.parseInt(message_binary, 2);
            System.out.println("INT EQ: " + intEq);
            char charEq = (char) intEq;
            System.out.println("CHAR: " + charEq);
            txt += charEq;
        }
        System.out.println("Output: " + txt);
        return txt;
    }

    public BufferedImage encodeData_Image(String grey, ArrayList<Integer> x, ArrayList<Integer> y) {
        String tempMsg[] = grey.split("\\s");
        int counter = 0;
        BufferedImage output = image;
        for (String string : tempMsg) {
            for (int i = 0; i < string.length(); i += 8) {
                String subStr = string.substring(i, i + 8);
                System.out.println("GREY SUB STR: " + subStr);
                int val = Integer.parseInt(subStr, 2);
                System.out.println("GREY VAL: " + val);
                int xCoord = x.get(counter);
                int yCoord = y.get(counter);
                int pixel = pixels[xCoord][yCoord];
                int rgb = image.getRGB(xCoord, yCoord);
                int red = (pixel >> 16) & 0x000000FF;
                int green = (pixel >> 8) & 0x000000FF;
                System.out.print("Output Init Pixel " + output.getRGB(xCoord, yCoord));
                int col = (red << 16) | (green << 8) | val;
                output.setRGB(xCoord, yCoord, col);
                System.out.println("Initial Pixel: " + pixel + ",Output Pixel" + output.getRGB(xCoord, yCoord));
                counter++;
            }
        }
        return output;
    }

    public int makePixel(int r, int g, int b) {
        int pixel = new Color(r, g, b).getRGB();
        System.out.println(pixel);
        return pixel;
    }

    private void initPixels() {
        width = image.getWidth();
        height = image.getHeight();
        System.out.println("Image Dimension: Height-" + height + ", Width-" + width);
        System.out.println("Total Pixels: " + (height * width));
        pixels = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                pixels[i][j] = image.getRGB(i, j);
//                System.out.print(getRGBPixelData(pixels[i][j]));
//                System.out.println(" Pixel Location(" + i + "," + j + ")- ["+pixels[i][j]+ "]");
            }
        }
    }

    public static Image getImageFromArray(int[] pixels, int width, int height) {
        try {
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            image.getWritableTile(0, 0).setDataElements(0, 0, width, height, pixels);
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getRGBPixelData(int pixel) {
        String pixelRGBData = "";

        /**
         * Shift all pixels 16 bits to the right. Do a logical and with
         * 0x000000FF i.e. 0000 0000 0000 0000 0000 0000 1111 1111 You will get
         * the red value for the pixel
         */
        int red = (pixel >> 16) & 0x000000FF;

        /**
         * Shift all pixels 8 bits to the right. Do a logical and with
         * 0x000000FF i.e. 0000 0000 0000 0000 0000 0000 1111 1111 You will get
         * the green value for the pixel
         */
        int green = (pixel >> 8) & 0x000000FF;

        /**
         * Dont do any shift. Do a logical and with 0x000000FF i.e. 0000 0000
         * 0000 0000 0000 0000 1111 1111 You will get the blue value for the
         * pixel
         */
        int blue = (pixel) & 0x000000FF;

        pixelRGBData = "Red: " + red + ", " + "Green: " + green + ", " + "Blue: " + blue;

        return pixelRGBData;
    }

}
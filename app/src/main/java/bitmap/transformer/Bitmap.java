package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

public class Bitmap {
  private Color[][] pixels;
  private int width;
  private int height;

  public Bitmap(Path filePath) throws IOException {
    BufferedImage image = ImageIO.read(filePath.toFile());
    this.width = image.getWidth();
    this.height = image.getHeight();
    this.pixels = new Color[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int rgb = image.getRGB(x, y);
        this.pixels[y][x] = new Color(rgb, true);
      }
    }
  }

  public Color getPixel(int x, int y) {
    return pixels[y][x];
  }
// above and below are methods to use in the transformer methods to do the things.
  public void setPixel(int x, int y, Color color) {
    pixels[y][x] = color;
  }

  // Above is taking the image and converting it to a BufferedImage, and converts that
  // into Color[][] array, then below this line write the grayscale, invert, and sepia
  // methods to manipulate the array.
  public void invertColors() {
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Color color = getPixel(x, y);
        int newRed = 255 - color.getRed();
        int newGreen = 255 - color.getGreen();
        int newBlue = 255 - color.getBlue();
        Color invertedColor = new Color(newRed, newGreen, newBlue);
        setPixel(x, y, invertedColor);
      }
    }
  }

  public void grayscaleColors() {
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Color color = getPixel(x, y);
        int average = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
        Color grayscaleColor = new Color(average, average, average);
        setPixel(x, y, grayscaleColor);
      }
    }
  }

  public void sepiaFilter() {
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Color color = getPixel(x, y);
        int newRed = (int) Math.min(255, 0.393 * color.getRed() + 0.769 * color.getGreen() + 0.189 * color.getBlue());
        int newGreen = (int) Math.min(255, 0.349 * color.getRed() + 0.686 * color.getGreen() + 0.168 * color.getBlue());
        int newBlue = (int) Math.min(255, 0.272 * color.getRed() + 0.534 * color.getGreen() + 0.131 * color.getBlue());
        Color sepiaColor = new Color(newRed, newGreen, newBlue);
        setPixel(x, y, sepiaColor);
      }
    }
  }

  // Below writes the array back into a file.
  public void writeToFile(Path filePath) throws IOException {
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        image.setRGB(x, y, pixels[y][x].getRGB());
      }
    }

    System.out.println("Attempting to write to file: " + filePath.toAbsolutePath());

    ImageIO.write(image, "png", filePath.toFile());

    if (filePath.toFile().exists()) {
      System.out.println("File has been written successfully!");
    } else {
      System.out.println("Failed to write the file.");
    }
  }



}


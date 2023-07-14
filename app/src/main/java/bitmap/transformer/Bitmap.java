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


  // Below writes the array back into a file.
  public void writeToFile(Path filePath) throws IOException {
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        image.setRGB(x, y, pixels[y][x].getRGB());
      }
    }

    ImageIO.write(image, "bmp", filePath.toFile());
  }
}


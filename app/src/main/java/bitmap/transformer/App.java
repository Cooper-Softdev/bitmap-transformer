/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

public class App {
  public static void main(String[] args) {
    if (args.length != 3) {
      System.out.println("No, that's not right: App <input-file-path> <output-file-path> <transform-name>");
      return;
    }

    String inputFilePath = args[0];
    String outputFilePath = args[1];
    String transformName = args[2];

    Bitmap bitmap = new Bitmap(inputFilePath);

    // types of transforms to choose using a switch case, there's got to be an easier way.
    switch (transformName) {
      case "invert":
        bitmap.invertColors();
        break;
      // Add the others here, Grayscale and Sepia?
      default:
        System.out.println("Unknown transformation: " + transformName);
        return;
    }

    // instead of return it do a file
    bitmap.writeToFile(outputFilePath);

    System.out.println("Image has been BAKED... HAHA YEAH BRO!");
  }
}
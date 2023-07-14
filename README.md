# Bitmap Transformer App

This is a Java application that allows you to apply certain color transformations to bitmap images. It is capable of inverting colors, applying a grayscale filter, and applying a sepia filter to bitmap images one at a time. The transformed bitmap is then written back into a new file at a path specified by the user.

## Features

1. **Invert Colors**: This feature inverts all the colors in the bitmap image.
2. **Grayscale Filter**: This feature applies a grayscale filter to the bitmap image.
3. **Sepia Filter**: This feature applies a sepia filter to the bitmap image.

## Prerequisites

- Java JDK (Version 11 or higher recommended)
- Gradle (Version 5.0 or higher recommended)

## How to Run

1. Compile the project using Gradle by running the following command in the terminal:

```bash
gradle build
```

2. Navigate to the `root` directory which is bitmap-transformer.

3. Run the application using the following command:

```bash
./gradlew run --args=" <input-file-path> <output-file-path> <transform-name> "
```

- `<input-file-path>`: Replace this with the path of the bitmap file that you want to transform.
- `<output-file-path>`: Replace this with the path where you want to save the transformed bitmap file.
- `<transform-name>`: Replace this with the name of the transformation you want to apply. The options are "invert", "grayscale", or "sepia".

For example:app/src/main/resources/baldy-8bit.bmp

```bash
./gradlew run --args='./app/src/main/resources/baldy-8bit.bmp ./app/src/main/resources/baldy-8bit-inverted.bmp invert'
```

This command will apply the invert color transformation to the `baldy-8bit.bmp` file and save the result as `baldy-8bit-inverted.bmp`.

## Error Handling

If the application encounters any errors during the transformation process, it will display a descriptive error message and terminate the process. For instance, if you specify an invalid transform name, the application will let you know and terminate the process. 

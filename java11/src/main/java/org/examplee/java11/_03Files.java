package org.examplee.java11;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class _03Files {
    public static void main(String[] args) {
        try {
            final Path filePath = Paths.get(
                    Paths.get(".").toAbsolutePath().normalize().toString(), "test.txt");

            //Write content to file
            Files.writeString(filePath, "Hallo Deutschland!!!", StandardOpenOption.CREATE);

            //Verify file content
            String content = Files.readString(filePath);

            System.out.println(content);

            Files.delete(filePath);
        } catch (Exception e)  {
            e.printStackTrace();
        }

    }
}

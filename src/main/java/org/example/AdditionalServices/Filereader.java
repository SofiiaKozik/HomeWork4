package org.example.AdditionalServices;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Filereader {
    public String readQwery(String fileAddress) throws FileNotFoundException {
        StringBuilder builder = new StringBuilder();
        File sql_file = new File(fileAddress);
        if (sql_file.exists()) {
            try (InputStream fis = new FileInputStream(sql_file)) {
                Scanner scanner = new Scanner(fis);
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    builder.append(line);
                    builder.append("\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return builder.toString();
    }
}




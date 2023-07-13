package org.example;

import org.example.AdditionalServices.Filereader;
import org.example.AdditionalServices.QweryService;

import java.io.FileNotFoundException;

public class DatabaseInitService {
    public static void main(String[] args) throws FileNotFoundException {
        QweryService qweryService = new QweryService();
        Filereader filereader = new Filereader();
        String initialScript = "C:\\Users\\skozi\\DataGripProjects\\Test1\\init_db.sql";
        qweryService.executeComand(filereader.readQwery(initialScript));
    }
}


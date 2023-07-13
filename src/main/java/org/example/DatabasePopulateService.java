package org.example;

import org.example.AdditionalServices.Filereader;
import org.example.AdditionalServices.QweryService;

import java.io.FileNotFoundException;

public class DatabasePopulateService {
    public static void main(String[] args) throws FileNotFoundException {
        QweryService qweryService = new QweryService();
        Filereader filereader = new Filereader();
        String populateSkript = "C:\\Users\\skozi\\DataGripProjects\\Test1\\populate_db.sql";
        qweryService.executeQueryUpdate(filereader.readQwery(populateSkript));
    }

}

package org.example;

import org.example.AdditionalServices.Database;

import java.sql.Connection;

public class Main {
     public static void main(String[] args) {
            Connection conn = Database.getInstance().getConnection();
    }
}
package com.cc.utils;

import com.microsoft.azure.management.Azure;
import com.microsoft.azure.management.resources.fluentcore.arm.Region;
import com.microsoft.azure.management.resources.fluentcore.utils.SdkContext;
import com.microsoft.azure.management.sql.SqlDatabase;
import com.microsoft.azure.management.sql.SqlServer;
import com.microsoft.rest.LogLevel;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Karla on 10-Jan-18.
 */
public class VirtualMachineProject {



    public static void main(String args[])
    {
        // create the db using the management libraries
        try {
//            final File credFile = new File(System.getenv("AZURE_AUTH_LOCATION"));
//            Azure azure = Azure.configure()
//                    .withLogLevel(LogLevel.BASIC)
//                    .authenticate(credFile)
//                    .withDefaultSubscription();

            // assemble the connection string to the database

            String url = "jdbc:sqlserver://proiectcubaietii.database.windows.net:1433;" +
                    "database=projectdb;" +
                    "user=yakumoto100@proiectcubaietii;" +
                    "password=PentruEugen!;" +
                    "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

            // connect to the database, create a table and insert a entry into it
            Connection conn = DriverManager.getConnection(url);

            //String createTable = "CREATE TABLE Users ( name varchar(255), id bigint);";
//            String insertValues = "INSERT INTO Users (name, id ) VALUES ('Azure', 1);";
            String selectValues = "Drop TABLE Users";
//            Statement createStatement = conn.createStatement();
//            createStatement.execute(createTable);
//            Statement insertStatement = conn.createStatement();
//            insertStatement.execute(insertValues);
            Statement selectStatement = conn.createStatement();
            ResultSet rst = selectStatement.executeQuery(selectValues);

            while (rst.next()) {
                System.out.println(rst.getString(1) + " "
                        + rst.getString(2));
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace().toString());
        }
    }

}

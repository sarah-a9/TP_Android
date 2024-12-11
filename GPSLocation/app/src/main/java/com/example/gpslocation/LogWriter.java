package com.example.gpslocation;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogWriter {

    private Context context;

    public LogWriter(Context context) {
        this.context = context;
    }

    public void writeLog(String timestamp, double latitude, double longitude, double altitude, int signalStrength, int batteryLevel) {
        try {
            File logFile = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "LogTracking.csv");
            if (!logFile.exists()) {
                logFile.createNewFile();  // Crée le fichier si non existant
            }

            FileWriter writer = new FileWriter(logFile, true);
            String logEntry = String.format("%s; %f; %f; %f; %d; %d\n", timestamp, latitude, longitude, altitude, signalStrength, batteryLevel);
            writer.append(logEntry);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

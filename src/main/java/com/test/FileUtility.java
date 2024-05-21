package com.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class FileUtility {

    public static List<int[]> readInputMusicFromFile(String filePath) throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<List<int[]>>() {}.getType();
            return gson.fromJson(reader, listType);
        }
    }

    public static void writeTransposedMusicToFile(List<int[]> notes, String filePath) throws IOException {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(notes, writer);
        }
    }
}

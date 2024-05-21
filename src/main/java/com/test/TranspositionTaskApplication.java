package com.test;

import java.util.List;

public class TranspositionTaskApplication {

    public static final int[] FIRST_NOTE = {-3, 10};
    public static final int[] LAST_NOTE = {5, 1};

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Please run with 3 params in this format: java -jar task.jar <inputJSONFilePath> <transposeSemitone> <outputJSONFilePath>");
            System.exit(1);
        }

        String inputFile = args[0];

        int transposeSemitone;
        try {
            transposeSemitone = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Semitone must be an integer.");
            System.exit(1);
            return;
        }

        String outputFile = args[2];

        try {
            List<int[]> inputMusic = FileUtility.readInputMusicFromFile(inputFile);
            List<int[]> transposedMusic = TransposeUtility.transposeMusic(inputMusic, transposeSemitone, FIRST_NOTE, LAST_NOTE);
            FileUtility.writeTransposedMusicToFile(transposedMusic, outputFile);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }


}

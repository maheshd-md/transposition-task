package com.test;

import java.util.List;

public class TransposeUtility {
    public static List<int[]> transposeMusic(List<int[]> music, int transpositionInterval, int[] firstNote, int[] lastNote) throws Exception {
        if(null == firstNote || null == lastNote || 2 != firstNote.length || 2 != lastNote.length) {
            throw new Exception("Invalid first or last note.");
        }
        int firstIndex = (firstNote[0] * 12) + firstNote[1];
        int lastIndex = (lastNote[0] * 12) + lastNote[1];
        for (int[] note : music) {
            int octaveNumber = note[0];
            int noteNumber = note[1];

            int currentSemitoneIndex = octaveNumber * 12 + noteNumber;
            int newSemitoneIndex = currentSemitoneIndex + transpositionInterval;

            if (newSemitoneIndex < firstIndex || newSemitoneIndex > lastIndex) {
                throw new Exception("Error: Transposed note " + newSemitoneIndex + " out of the keyboard range.");
            }

            int newOctaveNumber = newSemitoneIndex / 12;
            int newNoteNumber = (newSemitoneIndex % 12);

            note[0] = newOctaveNumber;
            note[1] = newNoteNumber;
        }
        return music;
    }
}

package utils;

import java.util.ArrayList;

public class BuiltCopyID {
    private String CopyID;

    public static ArrayList<String> GetBuiltCopyID(String BookNumber, int Amount) {
        ArrayList<String> CopyIDs = new ArrayList<>();
        for (int i = 0; i < Amount; i++) {
            String result = BookNumber + String.format("%04d", (i + 1));
            CopyIDs.add(result);
        }
        return CopyIDs;
    }
}

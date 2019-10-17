package utils;

import java.util.ArrayList;

public class BuiledCopyID {
    private String CopyID;
    public static ArrayList<String>  BuiledCopyID(String BookNumber, int Amount){
        double CopyID=Double.parseDouble(BookNumber);
        CopyID=CopyID*1000;
        ArrayList<String> CopyIDs = null;
        for(int i = 0; i<Amount+1; i++){
            CopyID++;
            CopyIDs.add(String.valueOf(CopyID));
        }
        return CopyIDs;
    }
}

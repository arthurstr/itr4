package com.arthur;

import java.util.Vector;
import com.jakewharton.fliptables.FlipTable;

public class Table {
    Vector names = new Vector();

    public void GenerationTable()
    {
        String[][] data = new String[names.size()][names.size() + 1];
        String[] header = new String[names.size() + 1];
        header[0] = "";
        for (int i = 0;i < names.size();i++) {
            header[i + 1] = (String) names.get(i);
            data[i][0] = (String) names.get(i);
        }
        for (int i = 0;i < names.size();i++) {
            for (int j = 1; j < names.size() + 1;j++) {
                if (j == i + 1) data[i][j] = "Draw";
                else
                if ((j > i + 1 && j < i + 1 + ( names.size() + 1)/2) || (j < i + 2 - ( names.size() + 1)/2) ) data[i][j] = "Win";
                else data[i][j] = "Lose";
            }
        }
        System.out.println(FlipTable.of(header, data));
    }
}

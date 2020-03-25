package br.com.flaviodiminuto.print;

import com.opencsv.CSVWriter;

import java.io.*;
import java.util.List;

public class ImprimimeTabelaOpenCSV {
    public static void gerarCSV(List<String[]> linhas, File file) throws IOException {
        Writer fileWriter = new FileWriter(file);
        CSVWriter writer = new CSVWriter(fileWriter);
        writer.writeAll(linhas);
        writer.close();
    }

    public static String get(List<String[]> linhas){
        Writer sw = new StringWriter();
        CSVWriter writer = new CSVWriter(sw);
        writer.writeAll(linhas);
        return sw.toString();
    }
}

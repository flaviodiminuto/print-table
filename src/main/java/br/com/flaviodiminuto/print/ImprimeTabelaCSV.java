package br.com.flaviodiminuto.print;

import br.com.flaviodiminuto.util.StringUtils;

import java.io.*;
import java.util.List;

public class ImprimeTabelaCSV {

    public static void gerarCSV(List<String[]> linhas, File file) throws IOException {
        Writer fileWriter = new FileWriter(file);
        String corpo = getCorpo(linhas);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        writer.write(corpo);
        writer.close();
    }

    public static String get(List<String[]> linhas) {
        return getCorpo(linhas);
    }

    private static String getCorpo(List<String[]> linhas) {
        if(linhas.isEmpty()) return "";
        StringBuilder builder = new StringBuilder();
        linhas.forEach(linha -> {
            StringBuilder aux = new StringBuilder();
            int i = 0;
            while (i < linha.length){
                aux.append(",\"")
                        .append(StringUtils.checkNull(linha[i++]))
                        .append("\"");
            }
            aux.deleteCharAt(0);    //remove a primeira virgula
            aux.append(",\n");      //quebra de linha
            builder.append(aux);
        });
        return builder.toString();
    }

}

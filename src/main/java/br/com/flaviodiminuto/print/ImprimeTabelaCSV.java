package br.com.flaviodiminuto.print;

import br.com.flaviodiminuto.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class ImprimeTabelaCSV {

    public static String gerarCSV(String[] cabecalho, List<String[]> linhas, String[] rodape){
        List<String[]> camposComCabecalho = getCamposComCabecalho(cabecalho, linhas,rodape);
        String corpo = getCorpo(camposComCabecalho);
         return "CSV format\n"+corpo;
    }

    private static List<String[]> getCamposComCabecalho(String[] cabecalho, List<String[]> linhas, String[] rodape) {
        List<String[]> list = new ArrayList<>();
        boolean semCabecalho = cabecalho == null || Stream.of(cabecalho).noneMatch(Objects::nonNull);
        boolean semCampos = linhas == null || linhas.get(0).length == 0;
        if(semCabecalho && semCampos)
            return list;
        else if (semCabecalho)
            return new ArrayList<>(linhas);
            else{
                list.add(cabecalho);
                if(!semCampos)
                    list.addAll(linhas);
        }
        return list;
    }

    private static String getCorpo(List<String[]> linhas) {
        if(linhas.isEmpty()) return "";
        StringBuilder builder = new StringBuilder();
        linhas.forEach(linha -> {
            StringBuilder aux = new StringBuilder();
            int i = 0;
            while (i < linha.length){
                aux.append(",\"") .
                    append(StringUtils.checkNull(linha[i++]))
                    .append("\"");
            }
            aux.deleteCharAt(0); //remove a primeira virgula
            aux.append(",\n");
            builder.append(aux);
        });
        return builder.toString();
    }

}

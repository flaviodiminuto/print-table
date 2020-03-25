package br.com.flaviodiminuto;

import br.com.flaviodiminuto.print.ImprimeTabelaCSV;
import br.com.flaviodiminuto.print.ImprimimeTabelaOpenCSV;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Path("/csv")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExampleResource {

    //Substitua pelo caminho do arquivo em seu computador para testar (/my-csv/file e /open-csv/file)
    File csvFile = new File("C:\\Projetos\\print-table\\src\\main\\java\\br\\com\\flaviodiminuto\\file\\csv\\teste.csv");
    File openCsvFile = new File("C:\\Projetos\\print-table\\src\\main\\java\\br\\com\\flaviodiminuto\\file\\opencsv\\teste.csv");

    @GET
    @Path("/my-csv/file")
    @Produces(MediaType.TEXT_PLAIN)
    public Response generateCSV() throws IOException {
        Instant inicio = Instant.now();
        List<String[]> linhas =  getLinhas();
        ImprimeTabelaCSV.gerarCSV(linhas, csvFile);
        Duration duracao = Duration.between(inicio,Instant.now());
        String retorno = String.format("Lilhas : %d%nTempo : %d milisegundos%n",linhas.size(),duracao.toMillis());

        return Response.ok().entity(retorno).build();
    }

    @GET
    @Path("/my-csv")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getCsvText() {
        Instant inicio = Instant.now();
        List<String[]> linhas =  getLinhas();
        String csv = ImprimeTabelaCSV.get(linhas);
        Duration duracao = Duration.between(inicio,Instant.now());
        String retorno = String.format("Lilhas : %d%nTempo : %d milisegundos%n%s",linhas.size(),duracao.toMillis(), csv);

        return Response.ok().entity(retorno).build();
    }

    @GET
    @Path("/open-csv/file")
    @Produces(MediaType.TEXT_PLAIN)
    public Response generateOpenCSV() throws IOException {
        Instant inicio = Instant.now();
        List<String[]> linhas =  getLinhas();
        ImprimimeTabelaOpenCSV.gerarCSV(linhas,openCsvFile);
        Duration duracao = Duration.between(inicio,Instant.now());
        String retorno = String.format("Lilhas : %d%nTempo : %d milisegundos%n",linhas.size(),duracao.toMillis());

        return Response.ok().entity(retorno).build();
    }

    @GET
    @Path("/open-csv")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getOpenCSVText() {
        Instant inicio = Instant.now();
        List<String[]> linhas =  getLinhas();
        String csv = ImprimimeTabelaOpenCSV.get(linhas);
        Duration duracao = Duration.between(inicio,Instant.now());
        String retorno = String.format("Lilhas : %d%nTempo : %d milisegundos%n%s",linhas.size(),duracao.toMillis(),csv);

        return Response.ok().entity(retorno).build();
    }

    //Gera as linhas para o testar a geração do CSV
    private List<String[]> getLinhas() {

        //Altere o valor para alterar a quantidade de linhas que o csv possuirá
        long repeticoes = 15;

        List<String[]> linhas = new ArrayList<>();

        //primeira linha do arquivo com os titulos das columas
        String[] cabecalho = {"cabecalho",null,"Arquivo",String.valueOf(System.currentTimeMillis()),null};
        linhas.add(cabecalho);

        int i = 0;
        while (i++ < repeticoes) {
            String[] linha1 = {"campo", "campo", "campo","campo", "campo", "campo",  null};
            String[] linha2 = {"campo", "campo", "campo", "campo", null, "campo", "campo"};
            linhas.add(linha1);
            linhas.add(linha2);
        }
        return linhas;
    }


}
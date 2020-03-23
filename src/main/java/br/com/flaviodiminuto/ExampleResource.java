package br.com.flaviodiminuto;

import br.com.flaviodiminuto.print.ImprimeTabelaCSV;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExampleResource {

    @GET
    @Path("/csv")
    @Produces(MediaType.TEXT_PLAIN)
    public Response generateCSV(){
        Instant inicio = Instant.now();
        List<String[]> linhas = new ArrayList<>();
        String[] cabecalho = {"cabecalho",null,null,"cabecalho","cabecalho","cabecalho"};
        int i = 0;
        while (i++ < 300000) {
            String[] linha1 = {"campo", "campo", "campo","campo", "campo", "campo",  null};
            String[] linha2 = {"campo", "campo", "campo", "campo", null, "campo", "campo"};
            linhas.add(linha1);
            linhas.add(linha2);
        }
        String csv = ImprimeTabelaCSV.gerarCSV(cabecalho,linhas,new String[1]);
        Duration duracao = Duration.between(inicio,Instant.now());
        String retorno = "Linhas : "+linhas.size() +"\n" +
                "Tempo : "+ duracao.toMillis()+" milisegundos\n"+
                csv;

        return Response.ok().entity(retorno).build();
    }


}
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        //ContentExtractor extract = new ExtractImdb();
        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";

        String url = "https://api.nasa.gov/planetary/apod?api_key=TB1B23omnnyGDEpXI2za8OR9E2HF0ONlnVTsPe5u&start_date=2022-06-01&end_date=2022-06-30";
        ContentExtractor extract = new ExtractNasa();

        //String url = "https://raw.githubusercontent.com/fzsdev/api_request_fzs/main/top-250-imdb.json";

        var http = new ClientHttp();
        String json = http.buscaDados(url);


        List<Content> contents = extract.extractorContent(json);

        var gerador = new Stickers();

        for (int i = 0; i < 5; i++) {
            Content content = contents.get(i);

            InputStream inputStream = new URL(content.getUrlImagem()).openStream();
            String nomeArquivo = "saida/NASA/" + content.getTitulo() + ".png"; //trocar pasta de saida NASA/IMDB
            gerador.createSticker(inputStream, nomeArquivo);

            System.out.println(content.getTitulo());

            System.out.println();
        }
    }
}
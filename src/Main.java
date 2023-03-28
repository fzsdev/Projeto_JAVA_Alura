import java.net.http.HttpClient;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String urlIMDB = "https://imdb-api.com/en/API/Top250Movies/k_7p1qwqhj";
        var client = HttpClient.newHttpClient();

    }
}
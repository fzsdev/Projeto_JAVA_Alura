import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractNasa implements ContentExtractor {
    public List<Content> extractorContent(String json) {
        var parser = new JsonParser();
        List<Map<String, String>> listAtribute = parser.parse(json);

        List<Content> contentList = new ArrayList<>();
        for (Map<String, String> atribute : listAtribute) {
            String titulo = atribute.get("title");
            String urlImagem = atribute.get("url");
            var content = new Content(titulo, urlImagem);

            contentList.add(content);
        }
        return contentList;
    }
}

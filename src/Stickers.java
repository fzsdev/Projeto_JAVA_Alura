import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class Stickers {

    public void createSticker(InputStream inputStream, String nomeArquivo ) throws Exception {
       /* InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@.jpg")
                .openStream();*/
        //BufferedImage imagemOriginal = ImageIO.read(new URL("https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@.jpg"));
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);
        var fonte = new Font(Font.SERIF, Font.BOLD, 72);
        graphics.setColor(Color.magenta);
        graphics.setFont(fonte);
        graphics.drawString("I JUST WANNA DIE", 300, novaAltura - 80);
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }

   /* public static void main(String[] args) throws Exception {
        var gerador = new Stickers();
        gerador.createSticker();
        //// teste
    }*/
}

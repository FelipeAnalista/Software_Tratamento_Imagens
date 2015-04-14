package br.com.trima.filtros;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Filtro {

       public static BufferedImage negativo(BufferedImage image, int width, int height) {

              int r = 0;
              int g = 0;
              int b = 0;
              int rgb;

              for (int i = 0; i < width; i++) {
                     for (int j = 0; j < height; j++) {
                            rgb = image.getRGB(i, j);

                            //a cor inversa é dado por 255 menos o valor da cor                 
                            r = 255 - (int) ((rgb & 0x00FF0000) >>> 16);
                            g = 255 - (int) ((rgb & 0x0000FF00) >>> 8);
                            b = 255 - (int) (rgb & 0x000000FF);

                            Color color = new Color(r, g, b);

                            image.setRGB(i, j, color.getRGB());

                     }
              }

              return image;
       }

       public static BufferedImage threshold(BufferedImage image, int limiar) {
              int width = image.getWidth();
              int height = image.getHeight();

              for (int i = 0; i < width; i++) {
                     for (int j = 0; j < height; j++) {

                            int rgb = image.getRGB(i, j);
                            int r = (int) ((rgb & 0x00FF0000) >>> 16);
                            int g = (int) ((rgb & 0x0000FF00) >>> 8);
                            int b = (int) (rgb & 0x000000FF);

                            int media = (r + g + b) / 3;

                            Color white = new Color(255, 255, 255);
                            Color black = new Color(0, 0, 0);

                            //como explicado no artigo, no threshold definimos um limiar,
                            //que é um valor "divisor de águas"
                            //pixels com valor ABAIXO do limiar viram pixels PRETOS,
                            //pixels com valor ACIMA do limiar viram pixels BRANCOS
                            if (media < limiar) {
                                   image.setRGB(i, j, black.getRGB());
                            } else {
                                   image.setRGB(i, j, white.getRGB());
                            }
                     }
              }
              return image;
       }

       public static BufferedImage cinza(BufferedImage imagem, int width, int height) throws IOException {

              //Percorrendo os pixel da imagem
        /*
               (Red + Green + blue) / 3 = para transformar em cinza
               */
              Color c = null;
              for (int a = 0; a < width; a++) {
                     for (int b = 0; b < height; b++) {

                            c = new Color(imagem.getRGB(a, b));

                            int tomCinza = (c.getRed() + c.getGreen() + c.getBlue()) / 3; // Calculo para o tom de cinza

                            c = new Color(tomCinza, tomCinza, tomCinza);
                            imagem.setRGB(a, b, c.getRGB());

                     }
              }

              return imagem;

       }

}

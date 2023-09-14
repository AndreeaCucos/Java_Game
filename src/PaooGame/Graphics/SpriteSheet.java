package PaooGame.Graphics;
import java.awt.image.BufferedImage;

/*! \class SpriteSheet
    \brief Clasa retine o referinta catre o imagine formata din dale (sprite sheet)

    Metoda crop() returneaza o dala de dimensiuni fixe (o subimagine) din sprite sheet
    de la adresa (x * latimeDala, y * inaltimeDala)
 */
public class SpriteSheet
{
    private final BufferedImage spriteSheet; /*!< Referinta catre obiectul BufferedImage ce contine sprite sheet-ul.*/

    /*! \fn public SpriteSheet(BufferedImage sheet)
        \brief Constructor, initializeaza spriteSheet.

        \param buffImg Un obiect BufferedImage valid.
     */
    public SpriteSheet(BufferedImage buffImg)
    {
        spriteSheet = buffImg;
    }


    /*! \fn public BufferedImage crop(int x, int y)
       \brief Returneaza un obiect BufferedImage ce contine o subimage (dala).

       Subimaginea este localizata avand ca referinta punctul din stanga sus.

       \param x numarul dalei din sprite sheet pe axa x.
       \param y numarul dalei din sprite sheet pe axa y.
       \param width latimea dalei dorite.
       \param height inaltimea dalei dorite.
    */
    public BufferedImage crop(int x, int y, int width, int height)
    {
        /// Subimaginea (dala) este regasita in sprite sheet specificad coltul stanga sus
        /// al imaginii si apoi latimea si inaltimea (totul in pixeli).
        return spriteSheet.getSubimage(x , y , width, height);
    }
}

package PaooGame.Items;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import java.awt.*;
import java.awt.image.BufferedImage;


/*!
    \class MainTree
    \brief Implementeaza ideea de copac in joc.
 */
public class MainTree extends Item
{
    private final BufferedImage image;  /*!< Referinta catre imaginea cu copacul.*/

    /*!
        \fn public MainTree(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al unui copac.

        \param  reflink Referinte "shortcut" catre alte referinte
        \param  x   Pozitia pe axa X a "tablei" de joc a imaginii entitatii.
        \param  y   Pozitia pe axa Y a "tablei" de joc a imaginii entitatii.
     */
    public MainTree(RefLinks refLink, float x, float y)
    {
        /// Apel al constructorului clasei de baza.
        super(refLink, x, y, 78, 90);
        /// image este initializat cu imaginea care prezinta copacul.
        image = Assets.tree;
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza copacul pe harta.
        \param g Contextul grafic in care trebuie efectuata desenarea copacului.
     */
    public void Draw(Graphics g)
    {
        g.drawImage(image, (int)x, (int)y, width, height, null);
    }


    /*!
       \fn public void Update()
       \brief Actualizeaza starea curenta a copacului.
     */
    public void Update()
    {

    }

}

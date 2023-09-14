package PaooGame.Items;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import java.awt.*;
import java.awt.image.BufferedImage;


/*!
    \class Diamond
    \brief Implementeaza idea de diamant : element care poate fi strans de pe harta daca se doreste.
 */

public class Diamond extends Item
{
    private BufferedImage image;        /*!<Referinta catre imaginea curenta cu diamant.*/
    private final Animation diamond;    /*!<Referinta catre animatia diamantului.*/


    /*!
        \fn public Diamond(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a diamantului.
        \param y Pozitia initiala pe axa Y a diamantului.
     */
    public Diamond(RefLinks refLink, float x, float y)
    {
        ///Apel al constructorului clasei de baza
        super(refLink, x, y, Item.DEFAULT_OBJECT_WIDTH, Item.DEFAULT_OBJECT_HEIGHT);
        ///Seteaza imaginea de start a diamantului
        image = Assets.diamond;
        /// Initializeaza animatia diamantului : seteaza vectorul de imagini si viteza cu care acestea se modifica.
        diamond = new Animation(Assets.diamondFlip, 100);

    }


    /*!
         \fn public void Draw(Graphics g)
         \brief Randeaza/deseneaza diamantul.
         \param g Contextul grafic in care trebuie efectuata desenarea diamantului.
   */
    @Override
    public void Draw(Graphics g)
    {
        /// image este imaginea curenta cu diamantul obtinuta dupa metoda Update()
        g.drawImage(image, (int)x, (int)y, width, height, null);
    }

    /*!
        \fn public void Update()
        \brief Actualizeaza imaginea diamantului.
     */
    @Override
    public void Update()
    {
        /// Apelam metoda Update() din clasa Animation care trece la imaginea urmatoare cu diamantul.
        diamond.Update(System.currentTimeMillis());
        /// In image, cu ajutorul metodei getImage(), se salveaza imaginea cu pozitita diamantului in momentul curent.
        image = diamond.getImage();
    }

    /*!
        \fn public boolean IsDiamond()
        \brief Intoarce true deoarece obiectul este de tip Diamond.
     */
    public boolean IsDiamond(){return true;}
}

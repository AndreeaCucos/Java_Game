package PaooGame.Items;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import java.awt.*;
import java.awt.image.BufferedImage;

/*!
    \class Coin
    \brief Implementeaza idea de moneda : element pe care eroul trebuie in mod obligatoriu sa il stranga de pe harta.
 */

public class Coin extends Item
{
    private BufferedImage image;  /*!<Referinta catre imaginea curenta cu moneda.*/
    private final Animation coin; /*!<Referinta catre animatia monedei.*/

    /*!
        \fn public Coin(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei.
        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a monedei.
        \param y Pozitia initiala pe axa Y a monedei.
     */
    public Coin(RefLinks refLink, float x, float y)
    {
        ///Apel al constructorului clasei de baza
        super(refLink, x, y, Item.DEFAULT_OBJECT_WIDTH, Item.DEFAULT_OBJECT_HEIGHT);
        ///Seteaza imaginea de start a monedei
        image = Assets.coin;
        /// Initializeaza animatia monedei : seteaza vectorul de imagini si viteza cu care acestea se modifica.
        coin = new Animation(Assets.coinFlip,100);

    }


    /*!
        \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza moneda.
        \param g Contextul grafic in care trebuie efectuata desenarea monedei.
    */
    @Override
    public void Draw(Graphics g)
    {
        /// image este imaginea curenta cu moneda obtinuta dupa metoda Update().
        g.drawImage(image, (int)x, (int)y, width, height, null);
    }

    /*!
        \fn public void Update()
        \brief Actualizeaza imaginea monedei.
     */
    @Override
    public void Update()
    {
        /// Apelam metoda Update() din clasa Animation care trece la imaginea urmatoare cu moneda
        coin.Update(System.currentTimeMillis());
        /// In image, cu ajutorul metodei getImage(), se salveaza imaginea cu pozitita monedei in momentul curent.
        image = coin.getImage();
    }

    /*!
        \fn public boolean IsDiamond()
        \brief Intoarce false deoarcere obiectul curent nu este de tip Diamond.
     */
    public boolean IsDiamond(){return false;}
}

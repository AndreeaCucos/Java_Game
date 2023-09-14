package PaooGame.Items;
import PaooGame.RefLinks;
import java.awt.*;

/*!
    \class Item
    \brief Implementeaza notiunea abstracta de entitate activa din joc, "element cu care se poate interactiona: monstru, turn etc.".
 */
public abstract class Item
{
    ///asa cum s-a mai precizat, coordonatele x si y sunt de tip float pentru a se elimina erorile de rotunjire
    ///ce pot sa apara in urma calculelor, urmand a se converti la intreg doar in momentul desenarii.
    protected float x;                                 /*!< Pozitia pe axa X a "tablei" de joc a imaginii entitatii.*/
    protected float y;                                 /*!< Pozitia pe axa Y a "tablei" de joc a imaginii entitatii.*/
    protected int width, height;                       /*!< Latimea si inaltimea imaginii entitatii.*/
    protected Rectangle bounds;                        /*!< Dreptunghiul curent de coliziune.*/
    protected Rectangle normalbounds;                  /*!< Dreptunghiul de coliziune aferent starii obisnuite(spatiul ocupat de entitate in mod normal), poate fi mai mic sau mai mare decat dimensiunea imaginii sale.*/
    protected RefLinks refLink;                        /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    public static final int DEFAULT_OBJECT_WIDTH = 20; /*!< Latimea implicita a imaginii caracterului.*/
    public static final int DEFAULT_OBJECT_HEIGHT = 20;/*!< Lungimea implicita a imaginii caracterului.*/


    /*!
        \fn public Item(RefLinks refLink, float x, float y, int width, int height)
        \brief Constructor de initializare al clasei

        \param  reflink Referinte "shortcut" catre alte referinte
        \param  x   Pozitia pe axa X a "tablei" de joc a imaginii entitatii.
        \param  y   Pozitia pe axa Y a "tablei" de joc a imaginii entitatii.
        \param  width   Latimea imaginii entitatii.
        \param  height  Inaltimea imaginii entitatii.
     */
    public Item(RefLinks refLink, float x, float y, int width, int height)
    {
        this.x = x;            /*!< Retine coordonata pe axa X.*/
        this.y = y;            /*!< Retine coordonata pe axa Y.*/
        this.width = width;    /*!< Retine latimea imaginii.*/
        this.height = height;  /*!< Retine inaltimea imaginii.*/
        this.refLink = refLink;/*!< Retine the "shortcut".*/
        ///Creaza dreptunghi de coliziune pentru modul normal, aici a fost stabilit la dimensiunea imaginii dar poate fi orice alta dimensiune
        normalbounds = new Rectangle(0,0,width,height);
        ///Dreptunghiul de coliziune implicit este setat ca fiind cel normal
        bounds = normalbounds;
    }

    /*!
        \fn public abstract void Update()
        \brief Metoda abstracta destinata actualizarii starii curente.

     */
    public abstract void Update();

    /*!
       \fn public abstract void Draw(Graphics g)
       \brief Metoda abstracta destinata desenarii starii curente.
       \param g Contextul grafic in care trebuie efectuata desenarea eroului.

    */
    public abstract void Draw(Graphics g);

    /*!
        \fn public float GetX()
        \brief Intoarce coordonata pe axa X.
     */
    public float GetX()
    {
        return x;
    }

    /*! \fn public float GetY()
        \brief Intoarce coordonata pe axa Y.
     */
    public float GetY()
    {
        return y;
    }


    /*! \fn public float SetX()
        \brief Seteaza coordonata pe axa X.
        \param Valoarea coordonatei pe axa X.
     */
    public void SetX(float x)
    {
        this.x = x;
    }

    /*! \fn public float SetY()
        \brief Seteaza coordonata pe axa Y.
        \param Valoarea coordonatei pe axa Y.
     */
    public void SetY(float y)
    {
        this.y = y;
    }

    /*!
        \fn public boolean IsDiamond()
        \brief Functie care intoarce true daca elementul curent este diamant si false daca este moneda.
     */
    public boolean IsDiamond(){return false;}

}

package PaooGame.Items;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*!
    \class Animation

    \brief Implementeaza ideea de animatie a miscarii unui obiect(jucataor, inamic, moneda si diamant).
 */
public class Animation
{
    private final ArrayList<BufferedImage> item;/*!< Lista ce contine imaginile cu miscarea unui obiect.*/
    private int thisFrame; /*!< Referinta la iamginea din momentul curent.*/
    private final int speed;/*!< Referinta la viteza cu care se schimba imaginile. */
    private long previousTime;/*!< Referinta la iamginea din momentul anterior.*/

    /*!
        \fn public Animation(ArrayList<BufferedImage> sprites, int s)
        \brief Constructorul clasei Animation.
        \param sprites Lista care contine elemente de tip BufferedImage(fiecare imagine prezinta o noua pozitie a obiectului pe care dorim sa il animam).
        \param s Viteza cu care se schimba imaginile.
     */
    public Animation(ArrayList<BufferedImage> sprites, int s)
    {
        this.item = sprites;
        this.speed = s;
        thisFrame = 0;
        previousTime = 0;
    }

    /*!
        \fn public BufferedImage getImage()
        \brief Intoarce imaginea cu obiectul in momentul de timp curent.
     */
    public BufferedImage getImage()
    {
        return item.get(thisFrame);
    }

    /*!
        \fn public void Update(long time)
        \brief Actualizeaza imaginea in functie de timpul curent.
     */
    public void Update(long time)
    {
        if(time - previousTime >= speed)
        {
                /// Daca am ajuns la utlima imagine din lista setam indexul pe 0 pentru a parcurge lista de la inceput.
             if(thisFrame == item.size() - 1 )
             {
                 thisFrame = 0;
             }
             else
             {
                    /// In caz contrar mergem la imaginea urmatoare din lista.
                 thisFrame ++;
             }
             previousTime = time;
        }
    }
}

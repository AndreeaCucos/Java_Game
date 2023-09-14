package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

/*!
    \class Flower
    \brief Abstractizeaza notiunea de dala de tip iarba cu flori.
 */
public class Flower extends Tile
{
    /*!
        \fn public Flower(int id)
        \brief Constructorul de initializare al clasei.
        \param id Id-ul dalei util in desenarea hartii.
     */
    public Flower(int id)
    {
        super(Assets.flower, id);
    }

    /*!
        \fn public boolean IsSolid()
        \brief Suprascrie metoda IsSolid() din clasa de baza in sensul ca va fi luat in calcul in caz de coliziune.
    */
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}

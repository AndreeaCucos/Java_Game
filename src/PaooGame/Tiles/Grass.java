package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

/*!
    \class Grass
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class Grass extends Tile
{
    /*!
        \fn public Grass(int id)
        \brief Constructorul de initializare al clasei.
        \param id Id-ul dalei util in desenarea hartii.
     */
    public Grass(int id){
        super(Assets.grass, id);
    }

    /*!
        \fn public boolean IsSolid()
        \brief Suprascrie metoda IsSolid() din clasa de baza in sensul ca va fi luat in calcul in caz de coliziune.
     */
    @Override
    public boolean IsSolid(){
        return true;
    }
}

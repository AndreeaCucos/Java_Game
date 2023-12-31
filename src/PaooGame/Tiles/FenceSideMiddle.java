package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

/*!
    \class FenceSideMiddle
    \brief Abstractizeaza notiunea de gard.
 */

public class FenceSideMiddle extends Tile
{
    /*!
       \fn public FenceSideMiddle(int id)
       \brief Constructorul de initializare al clasei.
       \param id Id-ul dalei util in desenarea hartii.
    */
    public FenceSideMiddle(int id){
        super(Assets.fenceSideMiddle, id);
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

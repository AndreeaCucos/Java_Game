package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

/*!
    \class FenceMiddleRight
    \brief Abstractizeaza notiunea de gard.
 */
public class FenceMiddleRight extends Tile
{
    /*!
       \fn public FenceMiddleRight(int id)
       \brief Constructorul de initializare al clasei.
       \param id Id-ul dalei util in desenarea hartii.
    */
    public FenceMiddleRight(int id){
        super(Assets.fenceRight, id);
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

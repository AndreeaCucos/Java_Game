package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

/*!
    \class FenceMiddle
    \brief Abstractizeaza notiunea de gard.
 */
public class FenceMiddle extends Tile
{
    /*!
        \fn public FenceMiddle(int id)
        \brief Constructorul de initializare al clasei
        \param id Id-ul dalei util in desenarea hartii.
    */
    public FenceMiddle(int id){
        super(Assets.fenceMiddle, id);
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

package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

/*!
    \class FenceBottomMiddle
    \brief Abstractizeaza notiunea de dala de tip gard.
 */
public class FenceBottomMiddle extends Tile
{
    /*!
       \fn public FenceBottomMiddle(int id)
       \brief Constructorul de initializare al clasei.
       \param id Id-ul dalei util in desenarea hartii.
    */
    public FenceBottomMiddle(int id){
        super(Assets.fenceBottomMiddle, id);
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

package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

/*!
    \class FenceSideEnd
    \brief Abstractizeaza notiunea de gard.
 */
public class FenceSideEnd extends Tile
{
    /*!
       \fn public FenceSideEnd(int id)
       \brief Constructorul de initializare al clasei.
       \param id Id-ul dalei util in desenarea hartii.
    */
    public FenceSideEnd(int id){
        super(Assets.fenceSideEnd, id);
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

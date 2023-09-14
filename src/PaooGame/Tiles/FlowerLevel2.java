package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

/*!
    \class FlowerLevel2
    \brief Abstractizeaza notiunea de floare utilizata la nivelul.
 */
public class FlowerLevel2 extends Tile
{
    /*!
       \fn public FlowerLevel2(int id)
       \brief Constructorul de initializare al clasei.
       \param id Id-ul dalei util in desenarea hartii.
    */
    public FlowerLevel2(int id){
        super(Assets.flowerLevel2, id);
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

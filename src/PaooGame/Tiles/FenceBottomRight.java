package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*!
    \class FenceBottomRight
    \brief Abstractizeaza notiunea de gard.
 */
public class FenceBottomRight extends Tile
{
    /*!
        \fn public FenceBottomRight(int id)
        \brief Constructorul de initializare al clasei
        \param id Id-ul dalei util in desenarea hartii.
    */
    public FenceBottomRight(int id){
        super(Assets.fenceBottomRight, id);
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

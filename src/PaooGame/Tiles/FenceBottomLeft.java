package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*!
    \class FenceBottomLeft
    \brief Abstractizeaza notiunea de dala de tip gard.
 */
public class FenceBottomLeft extends Tile
{
    /*!
        \fn public FenceBottomLeft(int id)
        \brief Constructorul de initializare al clasei.
        \param id Id-ul dalei util in desenarea hartii.
    */
    public FenceBottomLeft(int id){
        super(Assets.fenceBottomLeft, id);
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

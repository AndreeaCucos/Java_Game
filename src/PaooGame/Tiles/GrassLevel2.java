package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

/*!
    \class GrassLevel2
    \brief Abstractizeaza notiunea de iarba utilizata in cadrul nivelului 2.
 */
public class GrassLevel2 extends Tile
{
    /*!
        \fn public Grass(int id)
        \brief Constructorul de initializare al clasei.
        \param id Id-ul dalei util in desenarea hartii.
     */
    public GrassLevel2(int id){
        super(Assets.grassLevel2, id);
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

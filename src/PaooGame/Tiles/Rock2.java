package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

/*!
    \class Rock2
    \brief Abstractizeaza notiunea de dala de tip piatra utilizata la nivelul 2(cararea pe care merg personajele).
 */
public class Rock2 extends Tile
{
    /*!
       \fn public Rock2(int id)
       \brief Constructorul de initializare al clasei.
       \param id Id-ul dalei util in desenarea hartii.
    */
    public Rock2(int id){
        super(Assets.pathLevel2, id);
    }
}

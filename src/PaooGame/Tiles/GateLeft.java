package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

/*!
    \class GateLeft
    \brief Abstractizeaza notiunea de poarta(realizeaza trecerea la nivelul urmator).
 */
public class GateLeft extends Tile
{
    /*!
       \fn public GateLeft(int id)
       \brief Constructorul de initializare al clasei.
       \param id Id-ul dalei util in desenarea hartii.
    */
    public GateLeft(int id)
    {
        super(Assets.gateLeft, id);
    }
}

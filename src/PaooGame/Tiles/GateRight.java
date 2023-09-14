package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

/*!
    \class GateRight
    \brief Abstractizeaza notiunea de poarta(realizeaza trecerea la nivelul urmator).
 */
public class GateRight extends Tile
{
    /*!
       \fn public GateRight(int id)
       \brief Constructorul de initializare al clasei.
       \param id Id-ul dalei util in desenarea hartii.
    */
    public GateRight(int id)
    {
        super(Assets.gateRight, id);
    }
}

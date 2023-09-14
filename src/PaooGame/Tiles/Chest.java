package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

/*!
    \class Chest
    \brief Abstractizeaza notiunea de dala de tip cufar.
 */
public class Chest extends Tile
{
    /*!
        \fn public Chest(int id)
        \brief Constructorul de initializare al clasei.
        \param id Id-ul dalei util in desenarea hartii.
    */
    public Chest(int id)
    {
        super(Assets.chest, id);
    }
}

package PaooGame.Tiles;
import PaooGame.Graphics.Assets;

/*!
    \class Rock
    \brief Abstractizeaza notiunea de dala de tip piatra(cararea pe care merg personajele).
 */
public class Rock extends Tile
{
    /*!
        \fn public Rock(int id)
        \brief Constructorul de initializare al clasei.
        \param id Id-ul dalei util in desenarea hartii.
     */
    public Rock(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.rock, id);
    }
}

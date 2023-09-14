package PaooGame.Maps;
import PaooGame.RefLinks;


/*!
    \class MapFactory
    \brief Utilizeaza sablonul de proiectare factory.
           In functie de ce nivel selectam returneaza harta corespunzatoare.
 */
public class MapFactory
{

    /*!
        \fn public MapFactory()
        \brief Constructor de initializare al clasei.
     */
    public MapFactory()
    {

    }

    /*!
        \fn public Map getMap(RefLinks refLink, String level)
        \brief Returneaza harta corespunzatoare nivelului ales sau null in cazul in care alegem o optiune invalida.
        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param level String ce contine numele nivelului pe care dorim sa il obtinem din factory(Level1 sau Level2).
     */
    public Map getMap(RefLinks refLink, String level)
    {
        if(level.equals("Level1"))
            return new Map(refLink, "res/maps/map1.txt");
        else if (level.equals("Level2"))
            return new Map(refLink, "res/maps/map2.txt");
        return null;
    }
}

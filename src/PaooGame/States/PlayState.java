package PaooGame.States;
import PaooGame.RefLinks;
import java.awt.*;

/*!
    \class PlayState
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State
{
    private final Level1 level1; /*<!Referinta la starea de tip Level1*/

    /*!
        \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei
               Initializeaza si starea Level1.
        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink)
    {
            /// Apel  al constructorului clasei de baza.
        super(refLink);
        level1 = new Level1(refLink);
    }

    /*!
        \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update()
    {
        level1.Update();
    }


    /*!
        \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.
        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
    */
    @Override
    public void Draw(Graphics g)
    {
        level1.Draw(g);
    }
}

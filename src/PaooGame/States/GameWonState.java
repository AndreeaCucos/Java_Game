package PaooGame.States;
import PaooGame.RefLinks;
import java.awt.*;

/*!
    \class GameWonState

    \brief Implementeaza starea de joc castigat. Atunci cand jucatorul a adunat toate monedele si a ajuns la cufar, jocul trece
    din starea curenta in starea GameWonState.
 */
public class GameWonState extends State
{
    public Rectangle quitButton = new Rectangle(400,350,177,72); /*<!Butonul de quit game.*/
    public Rectangle backButton = new Rectangle(400,200,177,72); /*<!Butonul care realizeaza intoarcerea la menuState.*/

    /*!
       \fn public GameWonState(RefLinks refLink)
       \brief Constructorul de initializare al clasei.
       \param  reflink Referinte "shortcut" catre alte referinte.
    */
    public GameWonState(RefLinks refLink)
    {
        super(refLink);
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta.
     */
    @Override
    public void Update()
    {

    }

    /*!
       \fn public void Draw(Graphics g)
       \brief Deseneaza in fereastra butoanele si mesajul " Game Won".
       \param g Contextul grafic in care trebuie efectuata desenarea starii curente.
    */
    @Override
    public void Draw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(image, 0, 0, refLink.GetGame().GetWidth(),refLink.GetGame().GetHeight(),null);
        Font f = new Font("Garamond",Font.ITALIC+Font.BOLD,70);
        g.setFont(f);
        g.setColor(Color.white);
        g.drawString("Game won!!",320, 100);
        Font f0 = new Font("arial",Font.ITALIC+Font.BOLD,30);
        g.setFont(f0);
        g.drawString("BACK", backButton.x+40, backButton.y+45);
        g2d.draw(backButton);
        g.drawString("QUIT", quitButton.x+40, quitButton.y+45);
        g2d.draw(quitButton);
    }
}

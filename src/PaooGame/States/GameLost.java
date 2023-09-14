package PaooGame.States;
import PaooGame.RefLinks;
import java.awt.*;

/*!
    \class GameLost
    \brief Implementeaza starea de joc pierdut. Atunci cand jucatorul a pierdut toate vietile, jocul trece
    din starea curenta in starea GameLost.
 */
public class GameLost extends State
{
    public Rectangle quitButton = new Rectangle(400,350,177,72);  /*<!Butonul de quit game.*/
    public Rectangle backButton = new Rectangle(400,200,177,72);  /*<!Butonul care realizeaza intoarcerea la menuState.*/

    /*!
        \fn public GameLost(RefLinks refLink)
        \brief Constructorul de initializare al clasei.
        \param  reflink Referinte "shortcut" catre alte referinte.
     */
    public GameLost(RefLinks refLink)
    {
        super(refLink);
    }

    /*!
        \fn public void Update()
        \brief Actualizeaza starea curenta.
     */
    @Override
    public void Update()
    {

    }

    /*!
        \fn public void Draw(Graphics g)
        \brief Deseneaza in fereastra butoanele si mesajul " Game Lost".
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
        g.drawString("Game lost",340, 100);
        Font f0 = new Font("arial",Font.ITALIC+Font.BOLD,30);
        g.setFont(f0);
        g.drawString("BACK", backButton.x+40, backButton.y+45);
        g2d.draw(backButton);
        g.drawString("QUIT", quitButton.x+40, quitButton.y+45);
        g2d.draw(quitButton);

    }
}

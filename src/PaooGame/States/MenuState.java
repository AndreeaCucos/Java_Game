package PaooGame.States;
import PaooGame.Input.MusicManager;
import PaooGame.RefLinks;
import java.awt.*;

/*!
    \class MenuState
    \brief Implementeaza notiunea de meniu pentru joc.
 */
public class MenuState extends State
{
    private final Rectangle playButton = new Rectangle(390,200,183,78);    /*<!Butonul de start game.*/
    private final Rectangle rulesButton = new Rectangle(290,300,183,78);   /*<!Butonul care realizeaza trecerea la rulesState.*/
    private final Rectangle settingsButton = new Rectangle(490,300,183,78);/*<!Butonul de quit game. */
    private final Rectangle quitButton = new Rectangle(390,400,183,78);    /*<!Butonul care realizeaza trecerea la settingsState. */


    /*!
        \fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.
        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public MenuState(RefLinks refLink)
    {
        ///Apel al constructorului clasei de baza.
        super(refLink);
        /// Initializam obiectul de tip MusicManager si apelam metoda play() pentru a reda fisierul.
        music = MusicManager.getMusicManager();
        State.setClip(music.play());
        setMusic(music);
    }


    /*!
        \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */
    @Override
    public void Update()
    {
    }

    /*!
        \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.
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
        g.drawString("Elvyn's big adventure",150, 100);
        Font f0 = new Font("arial",Font.ITALIC+Font.BOLD,30);
        g.setFont(f0);
        g.drawString("START", playButton.x+28, playButton.y+50);
        g2d.draw(playButton);
        g.drawString("RULES", rulesButton.x+35, rulesButton.y+50);
        g2d.draw(rulesButton);
        g.drawString("SETTINGS", settingsButton.x+20, settingsButton.y+50);
        g2d.draw(settingsButton);
        g.drawString("QUIT", quitButton.x+45, quitButton.y+50);
        g2d.draw(quitButton);
    }
}

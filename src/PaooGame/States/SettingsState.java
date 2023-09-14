package PaooGame.States;
import PaooGame.Graphics.ImageLoader;
import PaooGame.RefLinks;
import java.awt.*;
import java.awt.image.BufferedImage;

/*!
    \class SettingsState
    \brief Implementeaza starea pentru setari.
 */
public class SettingsState  extends State
{

    public Rectangle muteButton = new Rectangle(300,200,177,72);  /*<!Butonul care opreste muzica.*/
    public Rectangle backButton = new Rectangle(500,200,177,72);  /*<!Butonul care realizeaza trecerea la meniu.*/

    /*!
        \fn public SettingsState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.
        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public SettingsState(RefLinks refLink)
    {
        ///Apel catre constructorul clasei de baza.
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
        \fn  public void Draw(Graphics g)
        \brief Metoda abstracta destinata desenarii starii curente.
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
        g.drawString("Settings",380, 100);
        Font f0 = new Font("arial",Font.ITALIC+Font.BOLD,30);
        g.setFont(f0);
        g.drawString("MUTE", muteButton.x+40, muteButton.y+45);
        g2d.draw(muteButton);
        g.drawString("BACK", backButton.x+40, backButton.y+45);
        g2d.draw(backButton);
    }
}

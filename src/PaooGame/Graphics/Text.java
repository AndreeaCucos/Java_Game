package PaooGame.Graphics;
import PaooGame.RefLinks;
import java.awt.*;
import java.sql.*;

/*!
    \class Text
    \brief Clasa ce contine o metoda pentru afisarea cantitatii de obiecte stransa si a numarului de vieti pe ecran.
 */
public class Text
{
    private final RefLinks refLink; /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/

    /*!
        \fn public Text(RefLinks refLink)
        \brief Constructorul de intializare al clasei.
        \param refLink Referinta catre obiectul shortcut (care retine alte referinte utile/necesare in joc).
     */
    public Text(RefLinks refLink)
    {
        this.refLink = refLink;
    }

    /*!
        \fn public void printText(Graphics g)
        \brief Afiseaza in fereastra de joc cantitatea de obiecte curenta, numarul de vieti ramase si butonul care face trecerea la meniu.
        \param g Contextul grafic in care trebuie efectuata desenarea textului pe ecran.

     */
    public void printText(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g.setColor(Color.green);
        g.fillRect(0,0,130,20);
        g2.drawImage(Assets.heart,10, 0,20,20,null);
        g2.drawImage(Assets.coins,70, -1,20,20,null);

        g2.drawImage(Assets.xButton,940, 0,20,20,null);
        g2.drawImage(Assets.pauseButton,900, 0,20,20,null);
        g2.drawImage(Assets.startButton,920, 0,20,20,null);
        g.setColor(Color.black);
        Font f = new Font("arial",Font.BOLD,13);
        g.setFont(f);

        Connection c = null;
        Statement stmt = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:res/database/inventoryGame.db");
            stmt = c.createStatement();

            ResultSet res = stmt.executeQuery("SELECT MAX(Coins) FROM inventory;");
            int val = res.getInt(1);
            g.drawString("  : "+val,90,15);
            res.close();
            stmt.close();
            c.close();

        }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + " : " + e.getMessage() );
            System.exit(0);
        }
        g.drawString("  : "+ refLink.GetHero().GetLife(),35,15);
    }

}

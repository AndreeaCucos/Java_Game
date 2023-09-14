package PaooGame.States;
import java.sql.*;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import java.awt.*;

/*!
    \class RulesState
    \brief Implementeaza starea de joc in care sunt prezentate regulile jocului.
    Regulile sunt preluate dintr-o baza de date si apoi sunt desenate pe ecran.
 */

public class RulesState extends State
{
    public Rectangle backButton = new Rectangle(400,400,177,72);  /*<!Butonul care realizeaza intoarcerea la menuState.*/

    /*!
        \fn  public RulesState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.
        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public RulesState(RefLinks refLink) {
        super(refLink);
    }

    /*!
        \fn public void Update()
        \brief Actualizeaza starea curenta.
     */
    @Override
    public void Update() {

    }

    /*!
        \fn public void Draw(Graphics g)
        \brief Metoda abstracta destinata desenarii starii curente.
        \param g Contextul grafic in care trebuie efectuata desenarea starii curente.
     */
    @Override
    public void Draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(image, 0, 0, refLink.GetGame().GetWidth(),refLink.GetGame().GetHeight(),null);
        Font f = new Font("Garamond",Font.ITALIC+Font.BOLD,70);
        g.setFont(f);
        g.setColor(Color.white);
        g.drawString("Rules",400, 90);
        f = new Font("Garamond",Font.ITALIC+Font.BOLD,25);
        g.setFont(f);
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:res/database/rulesDatabase.db");
            stmt = c.createStatement();
            String sql;
            sql = "SELECT Rules FROM rules WHERE ID=?;";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1,1);
            ResultSet rs = pst.executeQuery();
            g.drawString(rs.getString(1), 15, 170);
            g2d.drawImage(Assets.arrowKeys,250, 115,100,100,null);
            pst.setInt(1,2);
            rs = pst.executeQuery();
            g.drawString(rs.getString(1), 15, 230);
            pst.setInt(1,3);
            rs = pst.executeQuery();
            g.drawString(rs.getString(1), 15, 260);
            pst.setInt(1,4);
            rs = pst.executeQuery();
            g.drawString(rs.getString(1), 15, 290);
            pst.setInt(1,5);
            rs = pst.executeQuery();
            g.drawString(rs.getString(1), 15, 320);
            pst.setInt(1,6);
            rs = pst.executeQuery();
            g.drawString(rs.getString(1), 15, 350);
            pst.setInt(1,7);
            rs = pst.executeQuery();
            g.drawString(rs.getString(1), 15, 380);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + " : " + e.getMessage() );
            System.exit(0);
        }
        Font f0 = new Font("arial",Font.ITALIC+Font.BOLD,30);
        g.setFont(f0);
        g.drawString("BACK", backButton.x+45, backButton.y+50);
        g2d.draw(backButton);
    }
}

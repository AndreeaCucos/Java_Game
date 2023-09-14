package PaooGame.Database;
import java.sql.*;

/*!
    \class Database
    \brief Implementeaza functiile de insert si delete care ajuta la lucrul cu baza de date.
 */
public class Database
{
    /*!
       \fn public Database()
       \brief Constructorul de initializare al clasei.
     */
    public Database()
    {

    }

    /*!
        \fn public void insert(int value)
        \brief Insereaza o valoare in baza de date.
        \param value Valoarea care trebuie inserata in tabel.
     */
    public void insert(int value)
    {
        Connection c = null;
        Statement stmt = null;
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:res/database/inventoryGame.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "INSERT INTO inventory (Coins) "+
                    "VALUES("+value+");";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /*!
        \fn public void delete()
        \brief Sterge toate valorile din tabel.
     */
    public void delete()
    {
        Connection c = null;
        Statement stmt = null;
        try
        {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:res/database/inventoryGame.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "DELETE from inventory where Coins;";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

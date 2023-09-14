package PaooGame.Items;
import java.awt.*;
import java.util.ArrayList;

/*!
    \class Enemies
    \brief Implementeaza ideea de inamici in joc.
 */
public class Enemies
{
    private final ArrayList<Enemy> enemies; /*!< Lista ce contine elemente de tip Enemy.*/

    /*!
        \fn public Enemies()
        \brief Constructorul de initializare al clasei Enemies.
     */
    public Enemies()
    {
        /// Initializam lista de inamici.
        enemies = new ArrayList<Enemy>();
    }

    /*!
        \fn public void Update()

        \brief Se parcurge lista de inimici si pentru fiecare in parte se apeleaza metoda Update()
     pentru a le modifica pozitia si imaginea.

     */
    public void Update()
    {
        for (Enemy enemy : enemies) {
            enemy.Update();
        }
    }

    /*!
        \fn public void addEnemy(Enemy e)
        \brief Adauga un nou inamic in lista de inamici.
        \param e Obiectul de tip Enemy care trebuie adaugat in lista.
     */
    public void addEnemy(Enemy e)
    {
        enemies.add(e);
    }

    /*!
        \fn public void Draw(Graphics g)
        \brief Parcurge lista de inamici si pentru fiecare se apeleaza metoda Draw(g)
        \param g Contextul grafic in care trebuie efectuata desenarea inamicilor.
     */
    public void Draw(Graphics g)
    {
        for (Enemy enemy : enemies) {
            enemy.Draw(g);
        }
    }

    /*!
        \fn public Enemy GetEnemy(int i)
        \brief Returneaza un inamic din lista de inamici.
        \param i Indexul elementului pe care dorim sa il preluam din lista.
     */
    public Enemy GetEnemy(int i)
    {
        return enemies.get(i);
    }

    /*!
        \fn public int GetSize()
        \brief Intoarce dimensiunea listei de inamici.
     */
    public int GetSize()
    {
        return enemies.size();
    }

}

package PaooGame.Items;
import java.awt.*;
import java.util.ArrayList;

/*!
    \class Rewards
    \brief Implementeaza ideea de obiecte pe care eroul trebuie sa le stranga de pe harta.
 */
public class Rewards
{
    private final ArrayList<Item> items; /*!<Referinta la lista de obiecte.*/

    /*!
        \fn public Rewards()
        \brief Constructor de intializare al clasei Rewards.
     */
    public Rewards()
    {
        items = new ArrayList<>();
    }

    /*!
        \fn public void addItem(Item o)
        \brief Adaugam un nou element in lista de obiecte.
        \param o Obiectul care trebuie adaugat in lista.
     */
    public void addItem(Item o)
    {
        items.add(o);
    }

    /*!
        \fn public Item GetObject(int i)
        \brief Returneaza obiectul de la pozitia i din lista de obiecte.
        \param i Indexul obiectului pe care dorim sa il preluam din lista.
     */
    public Item GetObject(int i)
    {
        return items.get(i);
    }

    /*!
        \fn public void removeItem(int i)
        \brief Sterge sin lista elementul de la pozitia i.
        \param i Indexul obiectului pe care dorim sa il stergem din lista.
     */
    public void removeItem(int i)
    {
        items.remove(i);
    }

    /*!
        \fn public void Update()
        \brief Parcurge lista de obiecte si pentru fiecare in parte apeleaza metoda Update().
     */
    public void Update()
    {
        for (Item item : items)
        {
            item.Update();
        }
    }

    /*!
        \fn  public void Draw(Graphics g)

        \brief Parcurge lista de obiecte si pentru fiecare in parte apeleaza metoda Draw(g).
        \param g Contextul grafic in care trebuie efectuata desenarea obiectelor.
     */
    public void Draw(Graphics g)
    {
        for( Item item : items)
        {
            item.Draw(g);
        }
    }

    /*!
        \fn public int GetSize()
        \brief Intoarce dimensiunea listei de obiecte.
     */
    public int GetSize()
    {
        return items.size();
    }

    /*!
        \fn public public ArrayList<Item> cloneRewards()
        \brief Intoarce o copie a listei de obiecte.
     */
    public ArrayList<Item> cloneRewards()
    {
        return new ArrayList<>(items);
    }

    /*!
        \fn public void setRewards(ArrayList<Item> lista)
        \brief Setter pentru lista de obiecte.
     */
    public void setRewards(ArrayList<Item> lista)
    {
        /// Atunci cand eroul este atins de un inamic resetam nivelul, obiectele stranse de el pana in momentul respectiv
        /// se intorc in pozitiile lor initiale.
        // Ne asiguram ca lista este goala.
        items.clear();
        items.addAll(lista);
    }

    /*!
        \fn public ArrayList<Item> getList()
        \brief Intoarce lista de obiecte.
     */
    public ArrayList<Item> getList()
    {
        return items;
    }


}

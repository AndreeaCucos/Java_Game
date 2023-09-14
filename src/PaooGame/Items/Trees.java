package PaooGame.Items;
import PaooGame.RefLinks;
import java.awt.*;
import java.util.ArrayList;

/*!
    \class Trees
    \brief Implementeaza ideea de copaci in joc.
 */
public class Trees extends Item
{
    private final ArrayList<MainTree> trees; /*!<Lista de copaci.*/

    /*!
        \fn public Trees(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Trees.
        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param  x   Pozitia pe axa X a "tablei" de joc a imaginii entitatii.
        \param  y   Pozitia pe axa Y a "tablei" de joc a imaginii entitatii.

     */
    public Trees(RefLinks refLink, float x, float y)
    {
        ///Apel al constructorului clasei de baza
        super(refLink, x, y, 64, 64);
        trees = new ArrayList<MainTree>();
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza copacii pe harta.
        \param g Contextul grafic in care trebuie efectuata desenarea copacilor.
     */
    public void Draw(Graphics g)
    {
        /// Parcurgem lista si pentru fiecare element de tip MainTree se apeleaza metoda Draw(g).
        for (MainTree tree : this.trees)
        {
            tree.Draw(g);
        }
    }

    /*!
        \fn public void Update()
        \brief Actualizeaza starea curenta a copacilor.
     */
    public void Update()
    {

    }

    /*!
        \fn public void addTrees()
        \brief Geneream valori random pentru pozitiile x si y ale unui copac si inainte sa adaugam respectivul copac in lista
      verificam daca acesta se afla pe cararea pe care merg personajele si daca se suprapune cu imaginea unui alt copac deja existent in lista.
               In caz afirmativ, acest copac nu se mai adauga in lista.
     */
    public void addTrees()
    {
        for(int i = 0; i < 1500 ; i++)
        {
            // Generam cele 2 valori random
            float x = (float)(Math.random() * (900 + 1) + 0 );
            float y = (float)(Math.random() * (550 + 1) + 0 );
            // Intializam copacul t
            MainTree t = new MainTree(refLink, x, y);

            // Daca valorile x si y obtinute anterior nu se afla pe o dala cu piatra(cararea pe care o urmeaza personajele)
            if( (refLink.GetMap().GetTile((int)(x/32), (int)(y/32)).GetId() != 1 && refLink.GetMap().GetTile((int)((x+64)/32),(int)(y/32)).GetId() != 1 && refLink.GetMap().GetTile((int)(x/32),(int)((y+64)/32)).GetId() != 1 && refLink.GetMap().GetTile((int)((x+64)/32), (int)((y+64)/32)).GetId() != 1) && (refLink.GetMap().GetTile((int)(x/32), (int)(y/32)).GetId() != 2 && refLink.GetMap().GetTile((int)((x+64)/32),(int)(y/32)).GetId() != 2 && refLink.GetMap().GetTile((int)(x/32),(int)((y+64)/32)).GetId() != 2 && refLink.GetMap().GetTile((int)((x+64)/32), (int)((y+64)/32)).GetId() != 2))
            {
                t.SetX(x);
                t.SetY(y);
                int check = 1;
                if(trees.size() != 0) {
                    // se verifica suprapunerea imaginilor
                    // daca imaginile se suprapun check devine 0 iar copacul nu se mai adauga in lista
                    for (MainTree tree : trees) {
                        if (t.GetX() < (tree.GetX() + 64) && ((t.GetX() + 64) > (tree.GetX())) && (t.GetY() < (tree.GetY() + 64)) && ((t.GetY() + 64) > tree.GetY())) {
                            check = 0;
                        }
                    }
                }

                // daca in urma verificarilor check ramane 1 copacul se afla intr-o pozitie convenabila si se adauga in lista.
                if(check == 1){this.trees.add(t);}
            }
        }
    }

}

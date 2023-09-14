package PaooGame.Items;
import PaooGame.Database.Database;
import PaooGame.RefLinks;
import PaooGame.States.Level2;
import PaooGame.States.State;
import PaooGame.Tiles.Tile;

/*! \class Character
    \brief Defineste notiunea abstracta de caracter/individ/fiinta din joc.

    Notiunea este definita doar de viata, viteza de deplasare si distanta cu care trebuie sa se
    miste/deplaseze in urma calculelor.
 */
public abstract class Character extends Item
{
    public static final int DEFAULT_LIFE = 3;               /*!< Valoarea implicita a vietii unui caracter.*/
    public static final float DEFAULT_SPEED = 3.0f;         /*!< Viteza implicita a unu caracter.*/
    public static final int DEFAULT_CREATURE_WIDTH = 50;    /*!< Latimea implicita a imaginii caracterului.*/
    public static final int DEFAULT_CREATURE_HEIGHT = 50;   /*!< Inaltimea implicita a imaginii caracterului.*/

    protected int life;         /*!< Retine viata caracterului.*/
    protected int itemCount;    /*!< Numarul de obiecte pe care le-a strans eroul de pe harta.*/
    protected int coinCount;    /*!< Numarul de monede pe care le-a strans eroul de pe harta.*/

    /*!
        \param speed Retine viteza de deplasare a caracterului.
        \param xMove Retine noua pozitie a caracterului pe axa X.
        \param yMove Retine noua pozitie a caracterului pe axa Y.
     */
    protected float speed, xMove, yMove;
    public final Database db; /*!< Referinta catre baza de date.*/

    /*!
         \fn public Character(RefLinks refLink, float x, float y, int width, int height)
         \brief Constructor de initializare al clasei Character

         \param refLink Referinta catre obiectul shortcut (care retine alte referinte utile/necesare in joc).
         \param x Pozitia de start pa axa X a caracterului.
         \param y Pozitia de start pa axa Y a caracterului.
         \param width Latimea imaginii caracterului.
         \param height Inaltimea imaginii caracterului.
    */
    public Character(RefLinks refLink, float x, float y, int width, int height)
    {
        ///Apel constructor la clasei de baza
        super(refLink, x, y, width, height);
        ///Seteaza pe valorile implicite pentru viata, viteza, cantitatea de obiecte, cantitatea de monede si distantele de deplasare
        life = DEFAULT_LIFE;
        itemCount = 0;
        coinCount = 0;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
        db = new Database();
    }


    /*!
        \fn public boolean collision(int x, int y)
        \brief Implementeaza coliziunea eroului cu dalele.
         Daca dala este una din cele 2 dale care reprezinta usa(elementul care realizeaza trecerea la celalalt nivel) si avem numarul necesar de monede setam itemCount pe 0, coinCount pe 0, life pe 3 si trecem din starea curenta in starea pentru nivelul 2.
         Daca dala reprezinta cufarul, daca avem numarul necesar de monede atunci jocul este castigat si se trece din starea curenta in GameWonState.
         In cazul in care cele doua conditii de mai sus nu sunt indeplinite returneaza true daca dala este solida.
     */
    public boolean collision(int x, int y)
    {
        if(refLink.GetMap().GetTile(x, y).GetId() == 19 || refLink.GetMap().GetTile(x, y).GetId() == 18)
        {
            if(coinCount == 2)
            {
                itemCount = 0;
                coinCount = 0;
                life = 3;
                db.delete();
                refLink.GetGame().level2 = new Level2(refLink);
                State.SetState(refLink.GetGame().level2);
                State.getMusic().play();
            }
            return true;
        }
        else if(refLink.GetMap().GetTile(x, y).GetId() == 3)
        {
            if(coinCount == 2)
            {
                db.delete();
                State.SetState(refLink.GetGame().gameWon);
                refLink.GetHero().resetHeroPosition();
            }
            return true;
        }
        else{
            return refLink.GetMap().GetTile(x, y).IsSolid();
        }
    }

        // functii care se ocupa de modificarea pozitie personajului pe harta
    /*!
        \fn public void MoveX()
        \brief Modifica pozitia caracterului pe axa X.
     */
    public void MoveX()
    {
        /// Aflam coordonata x pentru coltul din stanga sus al dreptunghiului de coliziune daca ne miscam la stanga.
        //Se aduna xMove pentru ca dorim sa aflam coordonatele pozitiei la care urmeaza sa se miste pe axa OX.
        int coltStangaSus = (int)(x + xMove + bounds.x) / Tile.TILE_WIDTH; // se imparte la TILE_WIDTH pentru ca OX este latura de sus si de jos
        /// Aflam coordonata x pentru coltul din dreapta sus a dreptunghiului de coliziune daca ne miscam la dreapta.
        int coltDreaptaSus = (int)( x + xMove + bounds.x + bounds.width ) / Tile.TILE_WIDTH;

        // se imparte la TILE_HEIGHT pentru ca OY este latura din stanga si din dreapta
        int coltSusY = (int)( y + bounds.y) / Tile.TILE_HEIGHT; // y - coordonata de pe axa OY a personajului ; bounds.y - coordonatele coltului cutiei pe axa OY
        int coltJosY = (int)( y + bounds.y + bounds.height) / Tile.TILE_HEIGHT; // se aduna height pentru a afla coordonatele coltului de jos
        if( xMove < 0 )  // daca mergem la stanga
        {
            if( (!collision(coltStangaSus, coltSusY) ) && ( !collision(coltStangaSus, coltJosY)) ) /// Daca nu avem coliziune ne putem misca.
            {
                x += xMove;
            }
            /// Daca avem coliziune nu face nimic : personajul sta pe loc.
        }
        if( xMove > 0 ) // daca mergem la dreapta
        {
            if( (!collision(coltDreaptaSus, coltSusY)) && ( !collision(coltDreaptaSus, coltJosY)) )
            {
                x += xMove;
            }
        }

    }


    /*!
        \fn public void MoveY()
        \brief Modifica pozitia caracterului pe axa Y.
    */
    public void MoveY()
    {
        int coltStangaSus = (int)(x + bounds.x) / Tile.TILE_WIDTH;
        int coltDreaptaSus = (int)( x + bounds.x + bounds.width ) / Tile.TILE_WIDTH;

        // Se aduna yMove pentru ca dorim sa aflam coordonatele pozitiei la care urmeaza sa se miste pe axa OY
        int coltSusY = (int)( y + yMove + bounds.y) / Tile.TILE_HEIGHT; // y - coordonata de pe axa OY a personajului ; bounds.y - coordonatele coltului cutiei pe axa OY
        int coltJosY = (int)( y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT; // se aduna height pentru a afla coordonatele coltului de jos

        if( yMove > 0 ) // daca mergem in jos
        {
            if( (!collision(coltStangaSus, coltJosY)) && ( !collision(coltDreaptaSus, coltJosY)))
            {
                y += yMove;
            }
        }

        if( yMove < 0)
        {
            if( (!collision(coltStangaSus, coltSusY)) && (!collision(coltDreaptaSus, coltSusY)))
            {
                 y += yMove;
            }
        }

    }

    /*!
        \fn public void Move()
        \brief Modifica pozitia caracterului
     */
    public void Move()
    {
        ///Modifica pozitia caracterului pe axa X.
        ///Modifica pozitia caracterului pe axa Y.
        MoveX();
        MoveY();
    }

    /*!
        \fn public int GetLife()
        \brief Returneaza numarul de vieti ale personajului.
     */
    public int GetLife(){return life;}


    /*!
        \fn public void SetLife(int life)
        \brief Seteaza numarul de vieti ale personajului.
     */
    public void SetLife(int life){this.life = life;}

    /*!
        \fn public void SetItemCount(int itemCount)
        \brief Seteaza cantitatea de obiecte stranse de erou.
     */
    public void SetItemCount(int itemCount){this.itemCount = itemCount;}

}

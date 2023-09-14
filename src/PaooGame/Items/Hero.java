package PaooGame.Items;
import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;
import PaooGame.States.State;
import java.awt.*;
import java.awt.image.BufferedImage;

/*!
    \class Hero
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
public class Hero extends Character
{
    private static Hero hero = null;           /*!< Referinta la erou. */
    private BufferedImage image;               /*!< Referinta catre imaginea curenta a eroului.*/
    private final Animation heroMovingRight;   /*!< Referinta la animatia miscarii eroului la dreapta.*/
    private final Animation heroMovingLeft;    /*!< Referinta la animatia miscarii eroului la stanga.*/
    private final Animation heroMovingUp;      /*!< Referinta la animatia miscarii eroului in sus.*/
    private final Animation heroMovingDown;    /*!< Referinta la animatia miscarii eroului in jos.*/
    private float xInitial;                    /*!< Memoreaza pozitia initiala a eroului pe axa OX.*/
    private float yInitial;                    /*!< Memoreaza pozitia initiala a eroului pe axa OY.*/



    /*!
        \fn private Hero(RefLinks refLink, float x, float y)
        \brief Constructorul privat de initializare al clasei Hero.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */
    private Hero(RefLinks refLink, float x, float y)
    {
        ///Apel al constructorului clasei de baza
        super(refLink, x, y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
        ///Seteaza imaginea de start a eroului
        image = Assets.heroDown;

        xInitial = 300;
        yInitial = 0;

        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalbounds.x = 16;
        normalbounds.y = 16;
        normalbounds.width = 16;
        normalbounds.height = 32;

        itemCount = 0;
        coinCount = 0;

        /// Initializam animatiile pentru miscarea eroului in directiile : sus, jos, stanga, dreapta.
        heroMovingRight = new Animation(Assets.heroRightMovement, 150);
        heroMovingLeft = new Animation(Assets.heroLeftMovement, 150);
        heroMovingUp = new Animation(Assets.heroUpMovement, 150);
        heroMovingDown = new Animation(Assets.heroDownMovement, 150);
    }

    /*!
        \fn public void setxInitial(float xInitial)
        \brief Seteaza pozitia initiala a eroului pe axa OX.
     */
    public void setxInitial(float xInitial) {
        this.xInitial = xInitial;
    }

    /*!
        \fn public float getxInitial()
        \brief Intoarce pozitia initiala a eroului pe axa OX.
     */
    public float getxInitial() {
        return xInitial;
    }

    /*!
        \fn public void setyInitial(float yInitial)
        \brief Intoarce pozitia initiala a eroului pe axa OY.
     */
    public float getyInitial() {
        return yInitial;
    }

    /*!
        \fn public void setyInitial()
        \brief Seteaza pozitia initiala a eroului pe axa OY.
     */
    public void setyInitial(float yInitial) {
        this.yInitial = yInitial;
    }

    /*!
         \fn public static Hero getHero(RefLinks refLink)
         \brief Functie ce returneaza o instanta a eroului nostru daca aceasta nu a fost creata deja.
          Daca acesta a fost instantiat, functia va returna acelasi erou la fiecare apel.
         \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).

      */
    public static Hero getHero(RefLinks refLink)
    {
        if( hero == null )
        {
            hero = new Hero(refLink,300,0);
        }
        return hero;
    }

    /*!
        \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
     */
    private void GetInput()
    {
        ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;
        ///Verificare apasare tasta "sus"
        if(refLink.GetKeyManager().up)
        {
            yMove = -speed;
        }
        ///Verificare apasare tasta "jos"
        if(refLink.GetKeyManager().down)
        {
            yMove = speed;
        }
        ///Verificare apasare tasta "stanga"
        if(refLink.GetKeyManager().left)
        {
            xMove = -speed;
        }
        ///Verificare apasare tasta "dreapta"
        if(refLink.GetKeyManager().right)
        {
            xMove = speed;
        }
    }


    /*!
        \fn public void Update()
        \brief Actualizeaza pozitia si imaginea eroului.
     */
    public void Update()
    {
            /// Apel la metoda Update(long t) din clasa Animation care actualizeaza imaginea cu miscarea eroului.
        heroMovingRight.Update(System.currentTimeMillis());
        heroMovingLeft.Update(System.currentTimeMillis());
        heroMovingUp.Update(System.currentTimeMillis());
        heroMovingDown.Update(System.currentTimeMillis());
            ///Verifica daca a fost apasata o tasta.
        GetInput();
            /// Actualizeaza pozitia eroului.
        Move();
            /// Actualizeaza imaginea
        /// In functie de tasta apasata parametrul image este setat la imaginea curenta cu pozitia eroului.
        if(refLink.GetKeyManager().left)
        {
            image = heroMovingLeft.getImage();
        }
        if(refLink.GetKeyManager().right)
        {
            image = heroMovingRight.getImage();
        }

        if(refLink.GetKeyManager().up)
        {
            image= heroMovingUp.getImage();
        }
        if(refLink.GetKeyManager().down)
        {
            image = heroMovingDown.getImage();
        }
    }


    /*!
        \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \param g Contextul grafi in care trebuie efectuata desenarea eroului.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(image, (int)x, (int)y,width, height, null);

    }

    /*!
        \fm public void PickItem(Rewards objects)
        \brief Se parcurge lista de obiecte pe care personajul trebuie sa le stranga de pe harta
     si se verifica daca aceste imagini se suprapun cu imaginea eroului. In caz de suprapunere, elementul respectiv este eliminat
     din lista.
     */
    public void PickItem()
    {
        for(int i = 0 ; i < refLink.GetRewards().GetSize() ; i++)
        {
            if(((x + bounds.x )< (refLink.GetRewards().GetObject(i).x + 20)) && ((x + bounds.x + bounds.width)>refLink.GetRewards().GetObject(i).x) &&((y + bounds.y )< (refLink.GetRewards().GetObject(i).y + 20)) && ((y + bounds.y + bounds.height) > refLink.GetRewards().GetObject(i).y))
            {
                /// Daca obiectul cu care se suprapune imaginea eroului este de tip Diamond se aduna 3 la valoarea lui itemCount.
                if(refLink.GetRewards().GetObject(i).IsDiamond())
                {
                    itemCount+=3;
                }
                /// Daca obiectul cu care se suprapune imaginea eroului este de tip Coin se aduna 1 la coinCount si la itemCount.
                else if(!refLink.GetRewards().GetObject(i).IsDiamond())
                {
                    coinCount++;
                    itemCount++;
                }
                SetItemCount(itemCount);
                /// Inseram valoarea curenta din itemCount in baza de date.
                db.insert(itemCount);
                /// In final eliminam obiectul care a fost strans de pe harta din lista de obiecte.
                refLink.GetRewards().removeItem(i);
            }
        }
    }


    /*!
        \fn public void EnemyCollision(Enemies enemies, Rewards objectsI, Rewards objects)
        \brief Verificam coliziunea inamicilor cu eroul.
        \param objectsI Obiectele in pozitia lor initiala pe harta.
     */
    public void EnemyCollision(Rewards objectsI)
    {
            // Parcurgem lista de inamici si verificam daca imaginea inamicului curent se suprapune cu imaginea eroului.
        for( int i = 0 ; i < refLink.GetEnemies().GetSize(); i++)
        {
            if( ( (x+bounds.x) < (refLink.GetEnemies().GetEnemy(i).x + refLink.GetEnemies().GetEnemy(i).bounds.x+ refLink.GetEnemies().GetEnemy(i).normalbounds.width)) && ( ( x + bounds.x + bounds.width) > (refLink.GetEnemies().GetEnemy(i).x + refLink.GetEnemies().GetEnemy(i).bounds.x)) && ( (y+bounds.y) < (refLink.GetEnemies().GetEnemy(i).y + refLink.GetEnemies().GetEnemy(i).bounds.y) + refLink.GetEnemies().GetEnemy(i).normalbounds.height) && ( (y+bounds.y+ bounds.height) > (refLink.GetEnemies().GetEnemy(i).y + refLink.GetEnemies().GetEnemy(i).bounds.y)))
            {
                    /// In caz de suprapunere, se scade 1 din viata eroului si setam valorile pentru itemCount si coinCount pe 0.
                life -= 1;
                itemCount = 0;
                coinCount = 0;
                SetItemCount(itemCount);
                    /// Stergem valorile salvate in baza de date.
                db.delete();
                SetLife(life);
                    /// Mutam eroul in pozitia initiala.
                SetX(getxInitial());
                    /// Resetam pozitia obiectelor care trebuie stranse de pe harta.
                refLink.GetRewards().setRewards(objectsI.getList());
                SetY(getyInitial());
                    /// Daca numarul de vieti a ajuns la 0 nivelul este pierdut.
                if(life == 0)
                {
                    State.SetState(refLink.GetGame().gameLost);
                    hero = getHero(refLink);
                    hero.resetHeroPosition();
                    life = 3;
                    SetLife(3);
                }
            }
        }
    }

    /*!
        \fn public void resetHeroPosition()
        \brief Seteaza coordonatele si imaginea eroului la cele initiale, cele utilizate la nivelul 1.
     */
    public void resetHeroPosition()
    {
        hero.SetX((float)300);
        hero.SetY((float)0);
        hero.setxInitial((float)300);
        hero.setyInitial((float)0);
        image = Assets.heroDown;
        coinCount = 0;
    }
}

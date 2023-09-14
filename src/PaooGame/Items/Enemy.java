package PaooGame.Items;
import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;
import java.awt.*;
import java.awt.image.BufferedImage;

/*!
    \class Enemy
    \brief Implementeaza ideea de inamic in joc.
 */
public class Enemy extends Character
{
    private BufferedImage image;             /*!< Referinta la imaginea cu inamicul.*/
    private final Animation enemyMoveLeft;   /*!< Referinta la animatia miscarii inamicului la stanga.*/
    private final Animation enemyMoveRight;  /*!< Referinta la animatia miscarii inamicului la dreapta.*/
    private final double speedE;             /*<!Viteza cu care se deplaseaza inamicii.*/
    /*!
        \fn public Enemy(RefLinks refLink, float x, float y)

        \brief Constructor de initializare al clasei Enemy.
        \param refLink Referinta catre obiectul shortcut (care retine alte referinte utile/necesare in joc).
        \param x Pozitia de start pa axa X a inamicului.
        \param y Pozitia de start pa axa Y a inamicului.
        \param speedE Viteza cu care se deplaseaza inamicul.
     */
    public Enemy(RefLinks refLink, float x, float y, double speedE)
    {
            // Apel la constructorul clasei de baza.
        super(refLink, x, y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
            /// Seteaza imaginea initiala a inamicului si viteza cu care se deplaseaza
        image = Assets.enemyRight;
        this.speedE = speedE;

        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalbounds.x  = 16;
        normalbounds.y = 16;
        normalbounds.width = 16;
        normalbounds.height = 32;
        xMove = 1;

        /// Initializam animatiile pentru miscarea inamicului in directiile : stanga, dreapta.
        enemyMoveLeft = new Animation(Assets.enemyLeftMovement,150);
        enemyMoveRight = new Animation(Assets.enemyRightMovement,150);

    }

    /*!
      \fn public void Update()

      \brief Se apeleaza metoda Update(long t) din clasa Animation pentru a modifica imaginea curenta a inamicului.
             Se verifica daca exista coliziune cu dalele cu iarba( miscarea inamicului este doar de la stanga la dreapta).

   */
    public void Update()
    {
            /// Actualizarea imaginii cu inamicul pentru miscarea la stanga si pentru miscarea la dreapta
        enemyMoveLeft.Update(System.currentTimeMillis());
        enemyMoveRight.Update(System.currentTimeMillis());
            // aflam coordonata x pentru coltul din stanga sus a cutiei daca inamicul se misca la stanga
        int coltStangaSus = (int)(x + xMove + bounds.x) / Tile.TILE_WIDTH;
        // aflam coordonata x pentru coltul din dreapta sus a cutiei daca inamicul se misca la dreapta
        int coltDreaptaSus = (int)( x + xMove + bounds.x + bounds.width ) / Tile.TILE_WIDTH;
        int coltSusY = (int)( y + bounds.y) / Tile.TILE_HEIGHT;
        int coltJosY = (int)( y + bounds.y + bounds.height) / Tile.TILE_HEIGHT;

        // Daca acesta se misca la stanga
        if( xMove > 0 )
        {
            /// Daca avem coliziune cu dalele cu iarba se schimba imaginea si directia inamicului
            // merge la dreapta
            if( (collision(coltDreaptaSus, coltSusY)) && ( collision(coltDreaptaSus, coltJosY)) )
            {
                xMove = -speed;
                image = enemyMoveLeft.getImage();
            }
            else
            {
                /// Daca nu avem coliziune mergem mai departe
                image = enemyMoveRight.getImage();
                xMove = speed;
            }
        }
        else
        {
            // Daca merge la dreapta
            if(xMove < 0)
            {
                // daca avem coliziune se schimba imaginea si directia inamicului : merge la stanga
                if( (collision(coltStangaSus, coltSusY) ) && ( collision(coltStangaSus, coltJosY)) ) // daca nu avem colisiune ne putem misca
                {
                    image = enemyMoveRight.getImage();
                    xMove = speed;
                }
                else
                {
                    // daca nu exista coliziune isi continua miscarea.
                    image = enemyMoveLeft.getImage();
                    xMove = -speed;
                }
            }
        }

        /// Se modifica pozitia inamicului pe harta.
       x += speedE*xMove;
    }

    /*!
       \fn public void Draw(Graphics g)
       \brief Deseneaza inamicul pe harta.
       \param g Contextul grafic in care trebuie efectuata desenarea inamicului.
    */
    public void Draw(Graphics g)
    {
        g.drawImage(image, (int)x, (int)y, width, height, null);
    }
}

package PaooGame.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


/*!
    \class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
    /// Referinte catre elementele grafice (dale) utilizate in joc.
    public static BufferedImage grass;/*<! Referinta catre dala de tip iarba(nivel 1)*/
    public static BufferedImage rock; /*<! Referinta catre dala de tip piatra(nivel 1)*/
    public static BufferedImage tree; /*<! Referinta catre dala de tip copac(nivel 1)*/
    public static BufferedImage chest; /*<! Referinta catre dala de tip cufar(nivel 2)*/
    public static BufferedImage flower;/*<! Referinta catre dala de tip floare(nivel 1)*/

    // hero
    public static BufferedImage heroLeft; /*<! Referinta catre imagine erou( indreptat spre stanga)*/
    public static BufferedImage heroRight;/*<! Referinta catre imagine erou(indreptat spre dreapta)*/
    public static BufferedImage heroUp; /*<! Referinta catre imagine erou(indreptat in jos)*/
    public static BufferedImage heroDown; /*<! Referinta catre imagine erou(indreptat in sus)*/

    public static BufferedImage grassLevel2;/*<! Referinta catre dala de tip iarba(nivel 2)*/
    public static BufferedImage flowerLevel2;/*<! Referinta catre dala de tip floare(nivel 2)*/
    public static BufferedImage pathLevel2; /*<! Referinta catre dala de tip piatra(nivel 2)*/
    public static BufferedImage fenceMiddle; /*<! Referinta catre dala de tip gard*/
    public static BufferedImage fenceLeft; /*<! Referinta catre dala de tip gard*/
    public static BufferedImage fenceRight; /*<! Referinta catre dala de tip gard*/
    public static BufferedImage fenceBottomLeft; /*<! Referinta catre dala de tip gard*/
    public static BufferedImage fenceBottomMiddle; /*<! Referinta catre dala de tip gard*/
    public static BufferedImage fenceBottomRight; /*<! Referinta catre dala de tip gard*/
    public static BufferedImage fenceSideMiddle; /*<! Referinta catre dala de tip gard*/
    public static BufferedImage fenceSideEnd; /*<! Referinta catre dala de tip gard*/

    // Referinte catre imaginile cu inima, cantitatea de monede stransa si butoanele utile
    public static BufferedImage heart; /*<! Referinta catre imaginea cu inima*/
    public static BufferedImage coins; /*<! Referinta catre imaginea cu monedele */
    public static BufferedImage xButton; /*<! Referinta catre imaginea cu butonul X*/
    public static BufferedImage pauseButton; /*<! Referinta catre imaginea cu butonul de pauza*/
    public static BufferedImage startButton; /*<! Referinta catre imaginea cu butnoul de play*/
    public static BufferedImage arrowKeys; /*<! Referinta catre imaginea cu tastele cu sageti*/


    // lista pentru animatie erou
    public static ArrayList<BufferedImage> heroRightMovement; /*<! Referinta catre lista ce contine imaginile cu miscarea eroului la dreapta */
    public static ArrayList<BufferedImage> heroLeftMovement; /*<! Referinta catre lista ce contine imaginile cu miscarea eroului la stanga */
    public static ArrayList<BufferedImage> heroUpMovement; /*<! Referinta catre lista ce contine imaginile cu miscarea eroului in sus */
    public static ArrayList<BufferedImage> heroDownMovement; /*<! Referinta catre lista ce contine imaginile cu miscarea eroului in jos */

    // enemy
    public static BufferedImage enemyRight; /*<! Referinta catre imaginea inamicului(indreptat spre dreapta)*/
    public static BufferedImage enemyLeft; /*<! Referinta catre imaginea inamicului(indreptat spre stanga)*/

    // lista pentru animatia inamicului
    public static ArrayList<BufferedImage> enemyRightMovement; /*<! Referinta catre lista ce contine imaginile cu miscarea inamicului la dreapta */
    public static ArrayList<BufferedImage> enemyLeftMovement; /*<! Referinta catre lista ce contine imaginile cu miscarea inamicului la stanga*/

    // lista pentru animatia monedei
    public static ArrayList<BufferedImage> coinFlip;/*<! Referinta catre lista ce contine imaginile cu miscarea monedei*/

    //lista pentru animatia diamantului
    public static ArrayList<BufferedImage> diamondFlip; /*<! Referinta catre lista ce contine imaginile cu miscarea diamantului*/

    // object
    public static BufferedImage coin;  /*<! Referinta catre imaginea cu moneda*/
    public static BufferedImage diamond;  /*<! Referinta catre imaginea cu diamantul*/

    //usa care realizeaza trecerea intre nivele
    public static BufferedImage gateLeft;  /*<! Referinta catre imaginea cu usa(jumatatea din stanga)*/
    public static BufferedImage gateRight;  /*<! Referinta catre imaginea cu usa(jumatatea din dreapta)*/

    /*!
        \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
        /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/sprites.png"));
        SpriteSheet sheet1 = new SpriteSheet(ImageLoader.LoadImage("/textures/Heart.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.LoadImage("/textures/coins.png"));
        SpriteSheet sheet3 = new SpriteSheet(ImageLoader.LoadImage("/textures/ezgif.com-gif-maker (7).png"));
        SpriteSheet sheet4 = new SpriteSheet(ImageLoader.LoadImage("/textures/gate.png"));
        SpriteSheet sheet5 = new SpriteSheet(ImageLoader.LoadImage("/textures/ezgif.com-gif-maker (9).png"));
        SpriteSheet sheet6 = new SpriteSheet(ImageLoader.LoadImage("/textures/xbutton-removebg-preview.png"));
        SpriteSheet sheet7 = new SpriteSheet(ImageLoader.LoadImage("/textures/pauseButtonspritesheet.png"));
        SpriteSheet sheet8 = new SpriteSheet(ImageLoader.LoadImage("/textures/arrow-button-on-keyboard-icon-260nw-339331691-removebg-preview.png"));

        heart = sheet1.crop(0,0,235,206);
        coins = sheet2.crop(0,0,626,345);
        xButton = sheet6.crop(0,0,500,500);
        pauseButton = sheet7.crop(0,0,257,256);
        startButton = sheet7.crop(257,0,257,256);
        arrowKeys = sheet8.crop(0,0,260,280);

        gateLeft = sheet4.crop(32,0,32,32);
        gateRight = sheet4.crop(0,0,32,32);

        /// Se obtin subimaginile corespunzatoare elementelor necesare.
        grass =sheet.crop(0,0,32,32);
        rock = sheet.crop(32,0,32,32);
        tree = sheet3.crop(0,0,64,74);
        chest = sheet.crop(480,0,32,32);
        flower = sheet.crop(96,0,32,32);

        grassLevel2 = sheet.crop(128,0,32,32);
        flowerLevel2 = sheet.crop(256,0,32,32);
        pathLevel2 = sheet.crop(288,0,32,32);
        fenceMiddle = sheet.crop(160,0,32,32);
        fenceLeft = sheet.crop(192,0,32,32);
        fenceRight = sheet.crop(416,0,32,32);
        fenceBottomRight = sheet.crop(384,0,32,32);
        fenceBottomLeft = sheet.crop(224,0,32,32);
        fenceBottomMiddle = sheet.crop(352,0,32,32);
        fenceSideMiddle = sheet5.crop(0,0,32,32);
        fenceSideEnd = sheet.crop(448,0,32,32);

        heroLeft =sheet.crop(800,64,64,64);
        heroRight =sheet.crop(800,192,64,64);
        heroUp = sheet.crop(800,0,64,64);
        heroDown = sheet.crop(800,128,64,64);

        enemyLeft =sheet.crop(1376,64,64,64);
        enemyRight =sheet.crop(1376,192,64,64);

        enemyLeftMovement = new ArrayList<BufferedImage>();
        enemyLeftMovement.add(sheet.crop(1376,64,64,64));
        enemyLeftMovement.add(sheet.crop(1440,64,64,64));
        enemyLeftMovement.add(sheet.crop(1504,64,64,64));
        enemyLeftMovement.add(sheet.crop(1568,64,64,64));
        enemyLeftMovement.add(sheet.crop(1632,64,64,64));
        enemyLeftMovement.add(sheet.crop(1696,64,64,64));
        enemyLeftMovement.add(sheet.crop(1760,64,64,64));
        enemyLeftMovement.add(sheet.crop(1824,64,64,64));
        enemyLeftMovement.add(sheet.crop(1888,64,64,64));

        enemyRightMovement = new ArrayList<BufferedImage>();
        enemyRightMovement.add(sheet.crop(1376,192,64,64));
        enemyRightMovement.add(sheet.crop(1440,192,64,64));
        enemyRightMovement.add(sheet.crop(1504,192,64,64));
        enemyRightMovement.add(sheet.crop(1568,192,64,64));
        enemyRightMovement.add(sheet.crop(1632,192,64,64));
        enemyRightMovement.add(sheet.crop(1696,192,64,64));
        enemyRightMovement.add(sheet.crop(1760,192,64,64));
        enemyRightMovement.add(sheet.crop(1824,192,64,64));
        enemyRightMovement.add(sheet.crop(1888,192,64,64));

        coin = sheet.crop(576,0,32,32);
        diamond = sheet.crop(672,0,32,32);

        coinFlip = new ArrayList<>();
        coinFlip.add(sheet.crop(576,0,32,32));
        coinFlip.add(sheet.crop(608,0,32,32));
        coinFlip.add(sheet.crop(640,0,32,32));
        coinFlip.add(sheet.crop(576,32,32,32));
        coinFlip.add(sheet.crop(608,32,32,32));
        coinFlip.add(sheet.crop(640,32,32,32));

        diamondFlip = new ArrayList<>();
        diamondFlip.add(sheet.crop(672,0,32,32));
        diamondFlip.add(sheet.crop(704,0,32,32));
        diamondFlip.add(sheet.crop(736,0,32,32));
        diamondFlip.add(sheet.crop(768,0,32,32));

        heroRightMovement = new ArrayList<BufferedImage>();
        heroRightMovement.add(sheet.crop(800,192,64,64));
        heroRightMovement.add(sheet.crop(864,192,64,64));
        heroRightMovement.add(sheet.crop(928,192,64,64));
        heroRightMovement.add(sheet.crop(992,192,64,64));
        heroRightMovement.add(sheet.crop(1056,192,64,64));
        heroRightMovement.add(sheet.crop(1120,192,64,64));
        heroRightMovement.add(sheet.crop(1184,192,64,64));
        heroRightMovement.add(sheet.crop(1248,192,64,64));
        heroRightMovement.add(sheet.crop(1312,192,64,64));

        heroLeftMovement = new ArrayList<BufferedImage>();
        heroLeftMovement.add(sheet.crop(800,64,64,64));
        heroLeftMovement.add(sheet.crop(864,64,64,64));
        heroLeftMovement.add(sheet.crop(928,64,64,64));
        heroLeftMovement.add(sheet.crop(992,64,64,64));
        heroLeftMovement.add(sheet.crop(1056,64,64,64));
        heroLeftMovement.add(sheet.crop(1120,64,64,64));
        heroLeftMovement.add(sheet.crop(1184,64,64,64));
        heroLeftMovement.add(sheet.crop(1248,64,64,64));
        heroLeftMovement.add(sheet.crop(1312,64,64,64));

        heroUpMovement = new ArrayList<BufferedImage>();
        heroUpMovement.add(sheet.crop(800,0,64,64));
        heroUpMovement.add(sheet.crop(864,0,64,64));
        heroUpMovement.add(sheet.crop(928,0,64,64));
        heroUpMovement.add(sheet.crop(992,0,64,64));
        heroUpMovement.add(sheet.crop(1056,0,64,64));
        heroUpMovement.add(sheet.crop(1120,0,64,64));
        heroUpMovement.add(sheet.crop(1184,0,64,64));
        heroUpMovement.add(sheet.crop(1248,0,64,64));
        heroUpMovement.add(sheet.crop(1312,0,64,64));

        heroDownMovement = new ArrayList<BufferedImage>();
        heroDownMovement.add(sheet.crop(800,128,64,64));
        heroDownMovement.add(sheet.crop(864,128,64,64));
        heroDownMovement.add(sheet.crop(928,128,64,64));
        heroDownMovement.add(sheet.crop(992,128,64,64));
        heroDownMovement.add(sheet.crop(1056,128,64,64));
        heroDownMovement.add(sheet.crop(1120,128,64,64));
        heroDownMovement.add(sheet.crop(1184,128,64,64));
        heroDownMovement.add(sheet.crop(1248,128,64,64));
        heroDownMovement.add(sheet.crop(1312,128,64,64));
    }
}

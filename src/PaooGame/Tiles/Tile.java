package PaooGame.Tiles;
import java.awt.*;
import java.awt.image.BufferedImage;

/*!
    \class Tile
    \brief Retine toate dalele intr-un vector si ofera posibilitatea regasirii dupa un id.
 */
public class Tile
{
    private static final int NO_TILES = 32;
    public static Tile[] tiles = new Tile[NO_TILES];                    /*!< Vector de referinte de tipuri de dale.*/
    public static final int TILE_WIDTH = 32;                            /*!< Latimea unei dale.*/
    public static final int TILE_HEIGHT = 32;                           /*!< Inaltimea unei dale.*/
    protected BufferedImage img;                                        /*!< Imaginea aferenta tipului de dala.*/
    protected final int id;                                             /*!< Id-ul unic aferent tipului de dala.*/

    public static Tile grass = new Grass(0);                        /*!< Dala de tip iarba*/
    public static Tile rock = new Rock(1);                          /*!< Dala de tip piatra*/
    public static Tile chest = new Chest(3);                        /*!< Dala de tip cufar*/
    public static Tile flower = new Flower(4);                      /*!< Dala de tip floare*/
    public static Tile rock2 = new Rock2(2);                        /*!< Dala de tip piatra(nivel 2)*/
    public static Tile grass2 = new GrassLevel2(14);                /*!< Dala de tip flori(nivel 2)*/
    public static Tile flowerLvl2 = new FlowerLevel2(15);           /*!< Dala de tip gard(nivel 2)*/
    public static Tile fenceLeft = new FenceMiddleLeft(6);             /*!< Dala de tip gard(nivel 2)*/
    public static Tile fenceMiddle = new FenceMiddle(7);               /*!< Dala de tip gard(nivel 2)*/
    public static Tile fenceRight = new FenceMiddleRight(17);          /*!< Dala de tip gard(nivel 2)*/
    public static Tile fenceBottomLeft = new FenceBottomLeft(9);    /*!< Dala de tip gard(nivel 2)*/
    public static Tile fenceBottomMiddle = new FenceBottomMiddle(10);  /*!< Dala de tip gard(nivel 2)*/
    public static Tile fenceBottomRight = new FenceBottomRight(16); /*!< Dala de tip gard(nivel 2)*/
    public static Tile fenceSideView = new FenceSideMiddle(12);        /*!< Dala de tip gard(nivel 2)*/
    public static Tile fenceSideViewEnd = new FenceSideEnd(13);        /*!< Dala de tip gard(nivel 2)*/
    public static Tile gateLeft = new GateLeft(18);                 /*!< Dala de tip poarta*/
    public static Tile gateRight = new GateRight(19);               /*!< Dala de tip poarta*/

    /*!
       \fn public Tile(BufferedImage texture, int id)
       \brief Constructorul aferent clasei.
       \param image Imaginea corespunzatoare dalei.
       \param id Id-ul dalei.
    */
    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id =idd;
        tiles[id] = this;
    }

    /*!
        \fn public void Update()
        \brief Actualizeaza proprietatile dalei.
    */
    public void Update()
    {

    }

    /*!
        \fn public void Draw(Graphics g, int x, int y)
        \brief Deseneaza in fereastra dala.
        \param g Contextul grafic in care sa se realizeze desenarea
        \param x Coordonata x in cadrul ferestrei unde sa fie desenata dala
        \param y Coordonata y in cadrul ferestrei unde sa fie desenata dala
     */
    public void Draw(Graphics g,int x, int y){
        g.drawImage(img , x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    /*!
        \fn public boolean IsSolid()
        \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
     */
    public boolean IsSolid(){ return false;} // returneaza proprietate de dala solida pentru coliziuni

    /*!
        \fn public int GetId()
        \brief Intoarce id-ul dalei.
    */
    public int GetId(){ return id;}
}

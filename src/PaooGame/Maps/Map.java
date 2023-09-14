package PaooGame.Maps;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/*!
    \class Map
    \brief Implementeaza notiunea de harta a jocului.
 */
public class Map
{
    private final RefLinks refLink;  /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    public int width, height;        /*!< Latimea si inaltimea hartii in numar de dale.*/
    private int [][] tiles;          /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/


    /*!
        \fn public Map(RefLinks refLink)
        \brief Constructorul de initializare al clasei.
        \param refLink O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
        \param path Calea catre fisierul in care se afla matricea pentru harta.
     */
    public Map(RefLinks refLink, String path)
    {
        /// Retine referinta "shortcut".
        this.refLink = refLink;
        ///Incarca harta de start. Functia poate primi ca argument id-ul hartii ce poate fi incarcat.
        LoadWorld(path);
    }


    /*!
        \fn public  void Update()
        \brief Actualizarea hartii in functie de evenimente (un copac a fost taiat)
     */
    public void Update(){}


    /*!
        \fn public Tile GetTile(int x, int y)
        \brief Intoarce o referinta catre dala aferenta codului din matrice de dale.

        In situatia in care dala nu este gasita datorita unei erori ce tine de cod dala, coordonate gresite etc se
        intoarce o dala de tip grass.
     */
    public Tile GetTile(int x,int y)
    {
            /// In cazul in care se afla in afara hartii presupunem ca se afla pe o dala cu iarba.
        if(x<0 || y<0 || x>= width || y>= height)
        {
            return Tile.grass;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
        {
            return Tile.grass;
        }
        return t;
    }

    /*!
        \fn public void Draw(Graphics g)
        \brief Functia de desenare a hartii.
        \param g Contextul grafic in care se realizeaza desenarea.
    */
    public void Draw(Graphics g)
    {
        ///Se parcurge matricea de dale (codurile aferente) si se deseneaza harta respectiva
        for(int y = 0; y < refLink.GetGame().GetHeight()/Tile.TILE_HEIGHT; y++)
        {
            for(int x = 0; x < refLink.GetGame().GetWidth()/Tile.TILE_WIDTH; x++)
            {
                GetTile(x, y).Draw(g, (int)x * Tile.TILE_HEIGHT, (int)y * Tile.TILE_WIDTH);
            }
        }
    }

    /*!
        \fn private int[][] ReadFromFile()
        \brief Citeste matricea din fisier.
        \param path Calea catre fisierul in care se afla matricea pentru harta.
     */

    private int[][] ReadFromFile(String path)
    {
        List<int[]> list = new ArrayList<>();
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            // se citeste linie cu linie
            while ((line = br.readLine()) != null) {
                //se numara cate spatii se afla pe o linie
                int space = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == 32) {
                        space = space + 1;
                    }
                }
                // se aloca memorie pentru un vector a care contine doar cifrele de pe o linie
                int[] a = new int[line.length() - space];
                int j = 0;
                int i = 0;
                while (i < line.length()-1) {
                    if (line.charAt(i) != 32)
                    { // daca nu este spatiu se tranforma in Integer si se pune in vectorul a
                       if(line.charAt(i+1) !=32)
                       {
                            String sir = "";
                            sir += String.valueOf(line.charAt(i));
                            sir += String.valueOf(line.charAt(i+1));
                            i = i+1;
                            a[j] = Integer.parseInt(sir);
                       }
                        else{
                            a[j] = Integer.parseInt(String.valueOf(line.charAt(i)));
                       }
                        j = j+1;
                    }
                    i = i + 1;
                }
                // se adauga toti vectorii a astfel obtinuti in lista
                list.add(a);
            }
            fr.close();
            // se face conversie de la lista la Array si valoarea returnata se utilizeaza in PalaceMap drept harta
        }
        catch(IOException e)
        {
            System.out.println("Harta nu a putut fi incarcata.");
            e.printStackTrace();
        }
        // se face conversie de la lista la Array si valoarea returnata se utilizeaza in ElvynMap drept harta
        return list.toArray(int[][]::new);
    }

    /*! \fn private int ElvynMap(int x ,int y)
        \brief O harta incarcata static.

        \param x Linia pe care se afla codul dalei de interes.
        \param y Coloana pe care se afla codul dalei de interes.
        \param path Calea catre fisierul in care se afla matricea pentru harta.
     */
    private int ElvynMap(int x, int y, String path) {
        int[][] map = new int[0][];
        map = ReadFromFile(path);
        return map[x][y];
    }


    /*!
       \fn private void LoadWorld()
       \brief Functie de incarcare a hartii jocului.
              Aici se poate genera sau incarca din fisier harta. Momentan este incarcata static.
       \param path Calea catre fisierul in care se afla matricea pentru harta.
    */
    public void LoadWorld(String path)
    {
        //atentie latimea si inaltimea trebuiesc corelate cu dimensiunile ferestrei sau
        //se poate implementa notiunea de camera/cadru de vizualizare al hartii
        ///Se stabileste latimea hartii in numar de dale.
        width = 30;
        ///Se stabileste inaltimea hartii in numar de dale
        height = 21;
        ///Se construieste matricea de coduri de dale
        tiles = new int[width][height];
        //Se incarca matricea cu coduri
        for(int y=0;y< height;y++){
            for(int x=0; x< width;x++)
            {
                tiles[x][y] = ElvynMap(y, x, path);
            }
        }
    }
}

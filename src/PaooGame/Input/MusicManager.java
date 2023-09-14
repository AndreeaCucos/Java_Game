package PaooGame.Input;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/*!
    \class MusicManager
    \brief Gestioneaza muzica.
           Constructorul clasei primeste drept parametru numele fisierului de tip .wav pe care il deschide si prin intermediul
    metodei play il porneste.
 */

public class MusicManager {
    private static MusicManager music = null; /*<!Referinta la obiectul de tip MusicManager.*/
    private final Clip clip;                  /*<! Referinta la obiectul de tip Clip.*/
    private static int frame;                 /*<! Parametru care retine cadrul muzical curent.*/

    /*!
        \fn public MusicManager(String fileName)
        \brief Constructor de initializare al clasei.
        \param filename Contine numele fisierului de tip .wav.
     */
    private MusicManager(String fileName)
    {
        try {
            File file = new File(fileName);
            if (file.exists()) {
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(sound);
            }
            else
            {
                throw new RuntimeException("Fisierul nu a fost gasit !");
            }
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            throw new RuntimeException("Fisierul nu a putut fi deschis: " + e);
        }
    }

    /*!
        \fn public static MusicManager getMusicManager()
        \brief Intoarce o instanta a clasei de tip MusicManager daca aceasta nu a fost create deja.
               Daca aceasta a fost instantiata, functia intoarce acelasi obiect la fiecare apel.
     */
    public static MusicManager getMusicManager()
    {
        if(music == null)
        {
            music = new MusicManager("res/music/Lobo Loco - Joint Life (ID 1240) (online-audio-converter.com).wav");
        }
        return music;
    }

    /*!
        \fn public Clip play()
        \brief Prin metoda start() porneste muzica de la inceput sau din punctul in care a fost oprita.
     */
    public Clip play()
    {
        clip.setFramePosition(getFrame());
        clip.start();
        return clip;
    }

    /*!
        \fn public static void setFrame(int thisFrame)
        \brief Seteaza cadrul muzical curent.
        \param thisFrame Contine cadrul muzical curent( 0 daca fisierul nu a fost deschis sau o valoare
        intreaga care reprezinta cadrul muzical in momentul in care apelam metoda stop()).
     */
    public static void setFrame(int thisFrame)
    {
        frame = thisFrame;
    }

    /*!
        \fn public static int getFrame()
        \brief Intoarce cadrul muzical curent.
     */
    public static int getFrame()
    {
        return frame;
    }
}



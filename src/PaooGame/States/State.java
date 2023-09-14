package PaooGame.States;
import java.awt.*;
import java.awt.image.BufferedImage;
import PaooGame.Graphics.ImageLoader;
import PaooGame.Input.MusicManager;
import PaooGame.RefLinks;
import javax.sound.sampled.Clip;

/*!
    \class State
    \brief Implementeaza notiunea abstracta de stare a jocului/programului.
    Un joc odata ce este lansat in executie nu trebuie "sa arunce jucatorul direct in lupta", este nevoie de
    un meniu care sa contine optiuni: New Game, Load Game, Settings, About etc. Toate aceste optiuni nu sunt altceva
    decat stari ale programului (jocului) ce trebuiesc incarcate si afisate functie de starea curenta.
 */
public abstract class State
{
    ///Urmatoarele atribute sunt statice pentru a evita dealocarea spatiului de memorie la trecerea dintr-o stare in alta.
    private static State currentState   = null;     /*!< Referinta catre starea curenta a jocului: game, meniu, settings, about etc.*/
    protected RefLinks refLink;                     /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    public static MusicManager music;               /*<! Referinta catre obiectul de tip MusicManager.*/
    private static Clip thisClip;                   /*<! Referinta catre obiectul de tip Clip.*/
    protected final BufferedImage image = ImageLoader.LoadImage("/textures/forest.png");  /*<!Referinta catre imaginea de fundal.*/

    /*!
         \fn public State(RefLinks refLink)
         \brief Constructor de initializare al clasei Character
         \param refLink Referinta catre obiectul shortcut (care retine alte referinte utile/necesare in joc).
     */
    public State(RefLinks refLink)
    {
        this.refLink = refLink;
    }

    /*!
        \fn public static MusicManager getMusic()
        \brief Intoarce referinta la obiectul de tip MusicManager.
     */
    public static MusicManager getMusic() {
        return music;
    }

    /*!
       \fn public static void setMusic(MusicManager music)
       \brief Seteaza valoarea obiectului de tip MusicManager.
       \param music Obiectul de tip MusicManager.
    */
    public static void setMusic(MusicManager music) {
        State.music = music;
    }

    /*!
       \fn public static void setClip(Clip clip)
       \brief Seteaza valoarea obiectului de tip Clip.
       \param clip Referinta la biectul de tip Clip.
    */
    public static void setClip(Clip clip) {
        thisClip = clip;
    }

    /*!
       \fn  public static Clip getThisClip()
       \brief Intoarce referinta la obiectul de tip Clip.
    */
    public static Clip getThisClip() {
        return thisClip;
    }

    /*!
        \fn public static void SetState(State state)
        \brief Seteaza starea curenta a jocului.
        \param state Noua stare a programului (jocului).
    */
    public static void SetState(State state)
    {
        currentState = state;
    }

    /*!
        \fn public static State GetState()
        \brief Intoarce starea curenta a jocului.
     */
    public static State GetState()
    {
        return currentState;
    }

    /*!
        \fn public abstract void Update()
        \brief Metoda abstracta destinata actualizarii starii curente.
     */
    public abstract void Update();

     /*!
        \fn public abstract void Draw(Graphics g)
        \brief Metoda abstracta destinata desenarii starii curente.
        \param g Contextul grafic in care trebuie efectuata desenarea starii curente.
     */
    public abstract void Draw(Graphics g);

}

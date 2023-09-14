package PaooGame;
import PaooGame.Items.Enemies;
import PaooGame.Items.Hero;
import PaooGame.Items.Rewards;
import PaooGame.Maps.Map;
import PaooGame.Input.KeyManager;

/*!
    \class RefLinks
    \brief Clasa ce retine o serie de referinte ale unor elemente pentru a fi usor accesibile.
           Altfel ar trebui ca functiile respective sa aiba o serie intreaga de parametri si ar ingreuna programarea.
 */
public class RefLinks
{
    private Game game;          /*!< Referinta catre obiectul Game.*/
    private Map map;            /*!< Referinta catre harta curenta.*/
    private Rewards rewards;    /*!< Referinta la obiectele de tip moneda si diamant. */
    private Enemies enemies;    /*!< Referinta la inamici. */
    private Hero hero;          /*!< Referinta la erou. */

    /*!
        \fn public RefLinks(Game game)
        \brief Constructorul de initializare al clasei.
        \param game Referinta catre obiectul game.
    */
    public RefLinks(Game game)
    {
        this.game = game;
    }

    /*!
        \fn public KeyManager GetKeyManager()
        \brief Returneaza referinta catre managerul evenimentelor de tastatura.
     */
    public KeyManager GetKeyManager()
    {
        return game.GetKeyManager();
    }

    /*!
        \fn public Game GetGame()
        \brief Intoarce referinta catre obiectul Game.
     */
    public Game GetGame()
    {
        return game;
    }

    /*!
        \fn public Map GetMap()
        \brief Intoarce referinta catre harta curenta.
    */
    public Map GetMap()
    {
        return map;
    }

    /*!
        \fn public void SetMap(Map map)
        \brief Seteaza referinta catre harta curenta.
        \param map Referinta catre harta curenta.
    */
    public void SetMap(Map map)
    {
        this.map = map;
    }

    /*!
        \fn public void setRewards(Rewards rewards)
        \brief Seteaza referinta catre obiecte.
        \param rewards Referinta catre obiecte.
    */
    public void setRewards(Rewards rewards){this.rewards = rewards;}

    /*!
        \fn public void GetRewards()
        \brief Intoarce referinta catre obiectul de tip Rewards.
    */
    public Rewards GetRewards(){return this.rewards;}

    /*!
        \fn public void setEnemies(Enemies enemies)
        \brief Seteaza referinta catre inamici.
        \param enemies Referinta catre inamici.
    */
    public void setEnemies(Enemies enemies){this.enemies = enemies;}

    /*!
        \fn public void GetEnemies()
        \brief Intoarce referinta catre obiectul de tip Enemies.
    */
    public Enemies GetEnemies(){return this.enemies;}

    /*!
        \fn public void SetHero(Hero hero)
        \brief Seteaza referinta catre erou.
        \param hero Referinta catre erou.
    */
    public void SetHero(Hero hero)
    {
        this.hero = hero;
    }

    /*!
        \fn public void GetHero(Hero hero)
        \brief Intoarce referinta catre obiectul de tip Hero.
    */
    public Hero GetHero()
    {
        return this.hero;
    }
}

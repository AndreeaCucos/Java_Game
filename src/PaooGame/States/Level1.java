package PaooGame.States;
import PaooGame.Graphics.Text;
import PaooGame.Items.*;
import PaooGame.Maps.Map;
import PaooGame.Maps.MapFactory;
import PaooGame.RefLinks;
import java.awt.*;
/*!
    \class Level1
    \brief Implementeaza starea nivelului 1.
           Seteaza pozitia eroului, numarul de vieti si de obiecte initial si apeleaza MapFactory pentru a obtine harta corespunzatoare.
 */
public class Level1 extends State
{
    private final Map map;           /*!< Referinta catre harta curenta.*/
    private final Hero hero;         /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private final Enemies enemies;   /*!< Referinta catre inamici. */
    private final Rewards reward;    /*!< Referinta catre obiectele pe care trebuie sa le stranga eroul. */
    private final Rewards rewardsI;  /*!< Referinta catre obiectele pe care trebuie sa le stranga eroul aflate in pozitia iniaitala. */
    private final Trees T;           /*!< Referinta catre copaci. */
    private final Text text;         /*!< Referinta catre textul afisat pe ecran. */

    /*!
        \fn public Level1(RefLinks refLink)
        \brief Constructorul de initializare al clasei.
        \param  reflink Referinte "shortcut" catre alte referinte.
     */
    public Level1(RefLinks refLink) {
        super(refLink);
        MapFactory factory = new MapFactory();
        refLink.SetMap(null);
        /// Apel catre factory pentru a obtine harta pentru nivelul 1.
        map = factory.getMap(refLink,"Level1");
        refLink.SetMap(map);
        /// Apel catre clasa Hero pentru a obtine eroul
        hero = Hero.getHero(refLink);
        /// Setam pozitia initiala a eroului
        hero.setxInitial((float)300);
        hero.setyInitial((float)30);
        /// Setam numarul de obiecte stranse de pe harta la 0
        hero.SetItemCount(0);
        /// Numarul initial de vieti este 3
        hero.SetLife(3);
        refLink.SetHero(hero);
        enemies = new Enemies();
        enemies.addEnemy(new Enemy(refLink, 23, 200,0.7));
        enemies.addEnemy(new Enemy(refLink, 300, 320,0.7));
        enemies.addEnemy(new Enemy(refLink, 800, 140,0.7));
        enemies.addEnemy(new Enemy(refLink, 700,450,0.7));
        refLink.setEnemies(enemies);
        text = new Text(refLink);
        T = new Trees(refLink, 0, 0);
        T.addTrees();
        /// Cream obiecte de tip moneda si diamant.
        reward = new Rewards();
        reward.addItem(new Coin(refLink,50,50));
        reward.addItem(new Coin(refLink,200,500));
        reward.addItem(new Coin(refLink, 850, 440));
        reward.addItem(new Diamond(refLink,600, 50));
        refLink.setRewards(reward);
        /// Salvam pozitia initiala a acestor obiecte.
        rewardsI = new Rewards();
        rewardsI.setRewards(reward.cloneRewards());
    }

    /*!
        \fn public void Update()
        \brief Actualizeaza pozitia obiectelor pe harta.
     */
    @Override
    public void Update()
    {
        map.Update();
        hero.Update();
        enemies.Update();
        reward.Update();
        T.Update();
        hero.PickItem();
        hero.EnemyCollision(rewardsI);
    }

    /*!
        \fn public void Draw(Graphics g)
        \brief Metoda abstracta destinata desenarii starii curente.
        \param g Contextul grafic in care trebuie efectuata desenarea nivelului 1.
     */
    @Override
    public void Draw(Graphics g)
    {
        map.Draw(g);
        hero.Draw(g);
        enemies.Draw(g);
        reward.Draw(g);
        T.Draw(g);
        text.printText(g);
    }

}

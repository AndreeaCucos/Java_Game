package PaooGame.States;

import PaooGame.Graphics.Text;
import PaooGame.Input.MusicManager;
import PaooGame.Items.*;
import PaooGame.Maps.Map;
import PaooGame.Maps.MapFactory;
import PaooGame.RefLinks;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;

/*!
    \class Level2
    \brief Implementeaza starea nivelului 2.
           Seteaza pozitia eroului, numarul de vieti si de obiecte initial si apeleaza MapFactory pentru a obtine harta corespunzatoare.
 */
public class Level2 extends State
{
    private final Map map;          /*!< Referinta catre harta curenta.*/
    private final Hero hero;        /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private final Enemies enemies2; /*!< Referinta catre inamici. */
    private final Rewards reward;   /*!< Referinta catre obiectele pe care trebuie sa le stranga eroul. */
    private final Rewards rewardsI; /*!< Referinta catre pozitia iniaitala a obiectelor de strans. */
    private final Text text;        /*!< Referinta catre text. */

    /*!
       \fn public Level2(RefLinks refLink)
       \brief Constructorul de initializare al clasei.
       \param  reflink Referinte "shortcut" catre alte referinte.
    */
    public Level2(RefLinks refLink)
    {
        super(refLink);
        MapFactory factory = new MapFactory();
        /// Apel catre factory pentru a obtine harta pentru nivelul 2.
        map = factory.getMap(refLink,"Level2");
        refLink.SetMap(map);
        /// Apel catre clasa Hero pentru a obtine eroul.
        hero = Hero.getHero(refLink);
        refLink.SetHero(hero);
        /// Seteaza pozitia intiala specifica nivelului 2.
        hero.setxInitial((float)800);
        hero.setyInitial((float)30);
        /// Seteaza numarul de obiecte stranse la 0.
        hero.SetItemCount(0);
        /// Seteaza numarul de vieti la 3.
        hero.SetLife(3);
        enemies2 = new Enemies();
        enemies2.addEnemy(new Enemy(refLink, 700, 220,1.3));
        enemies2.addEnemy(new Enemy(refLink, 0, 290,1.3));
        enemies2.addEnemy(new Enemy(refLink, 700, 420,1.3));
        refLink.setEnemies(enemies2);
        text = new Text(refLink);
        reward = new Rewards();
        /// Cream obiecte de tip moneda si diamant.
        reward.addItem(new Coin(refLink,180,500));
        reward.addItem(new Coin(refLink, 870, 240));
        reward.addItem(new Diamond(refLink,870, 440));
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
        enemies2.Update();
        hero.Update();
        hero.PickItem();
        reward.Update();
        hero.EnemyCollision(rewardsI);
    }

    /*!
        \fn public void Draw(Graphics g)
        \brief Metoda abstracta destinata desenarii starii curente.
        \param g Contextul grafic in care trebuie efectuata desenarea nivelului 2.
     */
    @Override
    public void Draw(Graphics g)
    {
        map.Draw(g);
        enemies2.Draw(g);
        hero.Draw(g);
        reward.Draw(g);
        text.printText(g);
    }

}

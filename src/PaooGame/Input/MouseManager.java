package PaooGame.Input;
import PaooGame.RefLinks;
import PaooGame.States.PlayState;
import PaooGame.States.State;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


/*! \class MouseManager implements KeyListener
    \brief Gestioneaza intrarea (input-ul) de mouse.

    Clasa seteaza starea de joc in functie de zona in care se da click in fereastra.
 */
public class MouseManager implements MouseListener, MouseMotionListener
{
    protected RefLinks refLink;  /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/


    /*!
        \fn public MouseManager()
        \brief Constructorul de initializare al clasei.
     */
    public MouseManager()
    {
    }

    /*!
        \fn public void setRefLink(RefLinks refLink)
        \brief Functie care seteaza valoare lui refLink.
     */
    public void setRefLink(RefLinks refLink)
    {
        this.refLink = refLink;
    }


    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    /*!
        \fn public void mousePressed(MouseEvent e)
        \brief Functia seteaza starea de joc in functie de pozitia mouse-ului in fereastra.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        /// In functie de starea in care se afla jocul setam urmatoarele evenimente.
        // Daca suntem in menuState, starile in care putem trece sunt PlayState, RulesState, SettingsState sau Quit(parasirea jocului)
        if(State.GetState() == refLink.GetGame().menuState)
        {
            if (mouseX >= 390 && mouseX <= 573)
            {
                if (mouseY >= 200 && mouseY <= 278)
                {
                    refLink.GetHero().db.delete();
                    refLink.GetGame().playState = new PlayState(refLink);
                    State.SetState(refLink.GetGame().playState);

                }
            }

            if (mouseX >= 290 && mouseX <= 473)
            {
                if (mouseY >= 300 && mouseY <= 378)
                {
                    State.SetState(refLink.GetGame().rulesState);
                }
            }

            if (mouseX >= 490 && mouseX <= 673)
            {
                if (mouseY >= 300 && mouseY <= 378)
                {
                    State.SetState(refLink.GetGame().settingsState);
                }
            }

            if (mouseX >= 390 && mouseX <= 573) {
                if (mouseY >= 400 && mouseY <= 478) {
                    System.exit(1);
                }
            }
        }


        if(State.GetState() == refLink.GetGame().settingsState)
        {
            if(mouseX >= 300 && mouseX <= 477)
            {
                if(mouseY >= 200 && mouseY <= 272)
                {
                    State.getThisClip().stop();
                }
            }

            if(mouseX >= 500 && mouseX <= 677)
            {
                if(mouseY >= 200 && mouseY <= 272)
                {
                    State.SetState(refLink.GetGame().menuState);
                }
            }
        }

        if(State.GetState() == refLink.GetGame().gameLost)
        {
            if(mouseX >= 400 && mouseX <= 577)
            {
                if(mouseY >= 350 && mouseY <= 422)
                {
                    System.exit(1);
                }
            }
            if(mouseX >= 400 && mouseX <= 577)
            {
                if(mouseY >= 200 && mouseY <= 377)
                {
                    State.SetState(refLink.GetGame().menuState);
                }
            }
        }

        if(State.GetState() == refLink.GetGame().gameWon)
        {
            if(mouseX >= 400 && mouseX <= 577)
            {
                if(mouseY >= 350 && mouseY <= 422)
                {
                    System.exit(1);
                }
            }
            if(mouseX >= 400 && mouseX <= 577)
            {
                if(mouseY >= 200 && mouseY <= 377)
                {
                    State.SetState(refLink.GetGame().menuState);
                }
            }
        }

        if(State.GetState() == refLink.GetGame().rulesState)
        {
            if(mouseX >= 400 && mouseX <= 577)
            {
                if(mouseY >= 400 && mouseY <= 472)
                {
                    State.SetState(refLink.GetGame().menuState);
                }
            }
        }

        if(State.GetState() == refLink.GetGame().playState || State.GetState() == refLink.GetGame().level2)
        {
            if(mouseX >= 940 && mouseX <= 960)
            {
                if(mouseY >= 0 && mouseY <= 20)
                {
                    State.SetState(refLink.GetGame().menuState);
                    refLink.GetHero().resetHeroPosition();
                }
            }
            if(mouseX >= 900 && mouseX <= 920)
            {
                if(mouseY >= 0 && mouseY <= 20)
                {
                    MusicManager.setFrame(State.getThisClip().getFramePosition());
                    State.getThisClip().stop();
                }
            }
            if(mouseX >= 920 && mouseX <= 940)
            {
                if(mouseY >= 0 && mouseY <= 20)
                {
                    State.setClip(State.getMusic().play());
                }
            }
        }

        if(State.GetState() == refLink.GetGame().level2)
        {
            if(mouseX >= 940 && mouseX <= 960)
            {
                if(mouseY >= 0 && mouseY <= 20)
                {
                    State.SetState(refLink.GetGame().menuState);
                    refLink.GetHero().resetHeroPosition();
                }
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}

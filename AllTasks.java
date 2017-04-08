import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/*
*
 * Created by Marie Curie on 01/04/2017.
*/

public class AllTasks extends BasicGameState {
    public String mouse = "";
    public boolean addtask = false;
    public TextField taskname;
    public TextField duedate;
    public TextField setcategory;
    public boolean isFirstTimeTaskNameAT = true , isFirstTimeDueDateAT = true , isFirstTimeSetCategoryAT = true;

    public AllTasks(int alltasks) {
    }

    @Override
    public int getID() {
        return 4;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        isFirstTimeTaskNameAT = isFirstTimeDueDateAT = isFirstTimeSetCategoryAT = true;
        addtask = false;
        container.setShowFPS(false);

        taskname = new TextField(container, container.getDefaultFont(), 495, 375, 270, 27);
        duedate = new TextField(container, container.getDefaultFont(), 495, 409, 270, 27);
        setcategory = new TextField(container, container.getDefaultFont(), 495, 444, 270, 27);

        taskname.setBorderColor(Color.white);
        taskname.setBackgroundColor(Color.white);
        taskname.setTextColor(Color.gray);
        taskname.setCursorVisible(false);
        taskname.setFocus(false);
        taskname.setConsumeEvents(false);
        taskname.setAcceptingInput(true);
        taskname.setText("Write task name");

        duedate.setBorderColor(Color.white);
        duedate.setBackgroundColor(Color.white);
        duedate.setTextColor(Color.gray);
        duedate.setCursorVisible(false);
        duedate.setFocus(false);
        duedate.setConsumeEvents(false);
        duedate.setAcceptingInput(true);
        duedate.setText("Set due date");

        setcategory.setBorderColor(Color.white);
        setcategory.setBackgroundColor(Color.white);
        setcategory.setTextColor(Color.gray);
        setcategory.setCursorVisible(false);
        setcategory.setFocus(false);
        setcategory.setConsumeEvents(false);
        setcategory.setAcceptingInput(true);
        setcategory.setText("Set category");


    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        Image bg = new Image("res/Components/04 home/bg-main.png");
        Image leftpanel = new Image("res/Components/04 home/leftpanel.png");
        Image iconalltasks = new Image("res/Components/04 home/iconalltasks.png");
        Image icontoday = new Image("res/Components/04 home/icontoday.png");
        Image iconthisweek = new Image("res/Components/04 home/iconthisweek.png");
        Image iconcategory = new Image("res/Components/04 home/iconcategory.png");
        Image selectorview = new Image("res/Components/04 home/selectorview.png");
        Image empty = new Image("res/Components/04 home/empty.png");
        Image addnewcategory = new Image("res/Components/04 home/addnewcategory.png");
        Image fab = new Image("res/Components/04 home/fab.png");
        Image taskbox = new Image("res/Components/04 home/taskbox.png");
        Image newtaskwindow = new Image("res/Components/04 home/newtaskwindow.png");

        g.drawImage(bg,0,0);
        g.drawImage(leftpanel, 0,0);
        g.drawImage(selectorview,0,145);
        g.drawImage(iconalltasks,25, 155);
        g.drawImage(icontoday,25, 145+34+(34-24)/2);
        g.drawImage(iconthisweek,25,145+34*2+(34-24)/2);
        g.drawImage(iconcategory,25,280);
        g.drawImage(empty, 320, 110);
        if (!addtask) {
            g.drawImage(fab, 730, 460);
        }
        else{
            g.drawImage(newtaskwindow,460,325);
            taskname.render(container,g);
            duedate.render(container,g);
            setcategory.render(container,g);
        }

        g.drawImage(addnewcategory, 30,320);
        g.drawString(mouse, 50, 100);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        int xpos = Mouse.getX();
        int ypos = Mouse.getY();
        mouse = "x pos = "+xpos+"   y pos = "+ypos;

        Input input = container.getInput();	//keyboard and mouse input

        if((xpos>735 && xpos<781) && (ypos>28 && ypos<77) ){
            if (!addtask) {
                if(input.isMousePressed(0)){
                    addtask = true; //mugawas ang new task window
                }
            }
        }

        if((xpos>730 && xpos<766) && (ypos>46 && ypos<60) ){
            if (addtask) {
                if(input.isMousePressed(0)){
                    addtask = false; //mugawas ang new task window
                }
            }
        }

        if((xpos>0 && xpos<225) && (ypos>328 && ypos<356) ){
            if(input.isMouseButtonDown(0)){
                isFirstTimeTaskNameAT = isFirstTimeDueDateAT = isFirstTimeSetCategoryAT = true;
                game.enterState(5); //go to today view
            }
        }
        if((xpos>0 && xpos<225) && (ypos>294 && ypos<325) ){
            if(input.isMouseButtonDown(0)){
                isFirstTimeTaskNameAT = isFirstTimeDueDateAT = isFirstTimeSetCategoryAT = true;
                game.enterState(6); //go to week view
            }
        }
        if((xpos>0 && xpos<225) && (ypos>234 && ypos<261) ){
            if(input.isMouseButtonDown(0)){
                game.enterState(7); //go to category state
            }
        }

        if(isFirstTimeTaskNameAT && taskname.hasFocus() && addtask) {
            taskname.setText("");
            taskname.setTextColor(Color.black);
            isFirstTimeTaskNameAT = false;
        }

        if(isFirstTimeDueDateAT && duedate.hasFocus() && addtask) {
            duedate.setText("");
            duedate.setTextColor(Color.black);
            isFirstTimeDueDateAT = false;
        }
        if(isFirstTimeSetCategoryAT && setcategory.hasFocus() && addtask) {
            setcategory.setText("");
            setcategory.setTextColor(Color.black);
            isFirstTimeSetCategoryAT = false;
        }
        if (!taskname.hasFocus() && taskname.getText().equals("")){
            taskname.setTextColor(Color.gray);
            taskname.setText("Write task name");
            isFirstTimeTaskNameAT = true;
        }
        if (!duedate.hasFocus() && duedate.getText().equals("")){
            duedate.setTextColor(Color.gray);
            duedate.setText("Set due date");
            isFirstTimeDueDateAT = true;
        }
        if (!setcategory.hasFocus() && setcategory.getText().equals("")){
            setcategory.setTextColor(Color.gray);
            setcategory.setText("Current school");
            isFirstTimeSetCategoryAT = true;
        }

    }
}


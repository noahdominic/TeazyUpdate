import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Marie Curie on 01/04/2017.
 */
public class SignUp extends BasicGameState {
    public String mouse = "";
    public TextField firstname, lastname, username, password, retypepass, currentschool;
    boolean isFirstTimeUsername = true, isFirstTimePassword = true, isFirstTimeFirstName = true, isFirstTimeLastName = true, isFirstTimeRetypePass = true, isFirstTimeCurrentSchool = true;
    public SignUp(int signup) {
    }

    @Override
    public int getID() {
        return 2;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        container.setShowFPS(false);
        firstname = new TextField(container, container.getDefaultFont(), 291, 212, 126, 20);
        lastname = new TextField(container, container.getDefaultFont(), 425, 212, 90, 20);
        username = new TextField(container, container.getDefaultFont(), 291, 248, 224, 20);
        password = new TextField(container, container.getDefaultFont(), 291, 281, 224, 20);
        retypepass = new TextField(container, container.getDefaultFont(), 291, 315, 224, 20);
        currentschool  = new TextField(container, container.getDefaultFont(), 291, 349, 224, 20);
        initialize(firstname, lastname,username,password,retypepass,currentschool);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        Image bg = new Image("res/Components/img-bg01-03.png");
        Image signinform = new Image("res/Components/02 sign up/signinform.png");
        g.drawImage(bg,0,0);
        g.drawImage(signinform, 230,100);
        //g.drawString(mouse, 50, 100);
        firstname.render(container,g);
        lastname.render(container,g);
        username.render(container,g);
        password.render(container,g);
        retypepass.render(container,g);
        currentschool.render(container,g);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        int xpos = Mouse.getX();
        int ypos = Mouse.getY();
        mouse = "x pos = "+xpos+"   y pos = "+ypos;

        Input input = container.getInput();	//keyboard and mouse input
        if((xpos>296 && xpos<328) && (ypos>121 && ypos<134) ){
            if(input.isMouseButtonDown(0)){
                initialize(firstname, lastname,username,password,retypepass,currentschool);
                isFirstTimeFirstName = isFirstTimeLastName = isFirstTimeUsername = isFirstTimePassword = isFirstTimeRetypePass = isFirstTimeCurrentSchool = true;
                game.enterState(0); //go to landing state
            }
        }
        else if((xpos>487 && xpos<509) && (ypos>122 && ypos<135) ){
            if(input.isMouseButtonDown(0)){
                if(password.getText().equals(retypepass.getText())) {
                    initialize(firstname, lastname, username, password, retypepass, currentschool);
                    isFirstTimeFirstName = isFirstTimeLastName = isFirstTimeUsername = isFirstTimePassword = isFirstTimeRetypePass = isFirstTimeCurrentSchool = true;
                    game.enterState(3); //go to main user
                }
            }
        }

        if(isFirstTimeUsername && username.hasFocus()) {
            username.setText("");
            username.setTextColor(Color.black);
            isFirstTimeUsername = false;
        }

        if(isFirstTimePassword && password.hasFocus()) {
            password.setText("");
            password.setTextColor(Color.black);
            isFirstTimePassword = false;
        }
        if(isFirstTimeFirstName && firstname.hasFocus()) {
            firstname.setText("");
            firstname.setTextColor(Color.black);
            isFirstTimeFirstName = false;
        }

        if(isFirstTimeLastName && lastname.hasFocus()) {
            lastname.setText("");
            lastname.setTextColor(Color.black);
            isFirstTimeLastName = false;
        }
        if(isFirstTimeRetypePass && retypepass.hasFocus()) {
            retypepass.setText("");
            retypepass.setTextColor(Color.black);
            isFirstTimeRetypePass = false;
        }

        if(isFirstTimeCurrentSchool && currentschool.hasFocus()) {
            currentschool.setText("");
            currentschool.setTextColor(Color.black);
            isFirstTimeCurrentSchool = false;
        }

        if (!firstname.hasFocus() && firstname.getText().equals("")){
            firstname.setTextColor(Color.gray);
            firstname.setText("First Name");
            isFirstTimeFirstName = true;
        }
        if (!lastname.hasFocus() && lastname.getText().equals("")){
            lastname.setTextColor(Color.gray);
            lastname.setText("Last Name");
            isFirstTimeLastName = true;
        }
        if (!username.hasFocus() && username.getText().equals("")){
            username.setTextColor(Color.gray);
            username.setText("Username");
            isFirstTimeUsername = true;
        }
        if (!password.hasFocus() && password.getText().equals("")){
            password.setTextColor(Color.gray);
            password.setText("Password");
            isFirstTimePassword = true;
        }
        if (!retypepass.hasFocus() && retypepass.getText().equals("")){
            retypepass.setTextColor(Color.gray);
            retypepass.setText("Retype password");
            isFirstTimeRetypePass= true;
        }
        if (!currentschool.hasFocus() && currentschool.getText().equals("")){
            currentschool.setTextColor(Color.gray);
            currentschool.setText("Current school");
            isFirstTimeCurrentSchool = true;
        }
    }
    public static void initialize (TextField firstname, TextField lastname, TextField username, TextField password, TextField retypepass, TextField currentschool){
        firstname.setBorderColor(Color.white);
        firstname.setBackgroundColor(Color.white);
        firstname.setTextColor(Color.gray);
        firstname.setCursorVisible(false);
        firstname.setFocus(false);
        firstname.setConsumeEvents(true);
        firstname.setAcceptingInput(true);
        firstname.setText("First Name");

        lastname.setBorderColor(Color.white);
        lastname.setBackgroundColor(Color.white);
        lastname.setTextColor(Color.gray);
        lastname.setCursorVisible(false);
        lastname.setFocus(false);
        lastname.setConsumeEvents(true);
        lastname.setAcceptingInput(true);
        lastname.setText("Last Name");


        username.setBorderColor(Color.white);
        username.setBackgroundColor(Color.white);
        username.setTextColor(Color.gray);
        username.setCursorVisible(false);
        username.setFocus(false);
        username.setConsumeEvents(true);
        username.setAcceptingInput(true);
        username.setText("Username");

        password.setBorderColor(Color.white);
        password.setBackgroundColor(Color.white);
        password.setTextColor(Color.gray);
        password.setCursorVisible(false);
        password.setFocus(false);
        password.setConsumeEvents(true);
        password.setAcceptingInput(true);
        password.setText("Password");

        retypepass.setBorderColor(Color.white);
        retypepass.setBackgroundColor(Color.white);
        retypepass.setTextColor(Color.gray);
        retypepass.setCursorVisible(false);
        retypepass.setFocus(false);
        retypepass.setConsumeEvents(true);
        retypepass.setAcceptingInput(true);
        retypepass.setText("Retype password");

        currentschool.setBorderColor(Color.white);
        currentschool.setBackgroundColor(Color.white);
        currentschool.setTextColor(Color.gray);
        currentschool.setCursorVisible(false);
        currentschool.setFocus(false);
        currentschool.setConsumeEvents(true);
        currentschool.setAcceptingInput(true);
        currentschool.setText("Current school");
    }
}

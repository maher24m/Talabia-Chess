import Controller.Controller;
import Model.*;
import View.GameView;

public class Talabia {
    public static void main(String[] args) {
        Game model = new Game(); // model
        GameView view = new GameView(); // view 
        Controller controller = new Controller(view, model); // controller
     
        }
    }

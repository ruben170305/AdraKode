package listeners;

import views.*;
import model.*;

public class Listener {
    
    public Menu menu;
    public Home home;
    public Model mysql;

    public Listener() {}
    
    public Listener( Menu menu, Home home, Model mysql ) {
        this.menu = menu;
        this.home = home;
        this.mysql = mysql;
    }

}
package listeners;


import views.*;

public class Listener {
    
    public Menu menu;
    public Home home;

    public Listener() {}
    
    public Listener( Menu menu, Home home ) {
        this.menu = menu;
        this.home = home;
    }

}
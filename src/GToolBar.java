import javax.swing.*;

public class GToolBar extends JToolBar {
    private JRadioButton rectangleButton;
    private JRadioButton ovalButton;

    public GToolBar() {
        this.rectangleButton = new JRadioButton("Rectangle");
        this.add(rectangleButton);

        //this.ovalButton = new JRadioButton("Oval");
        //this.add(ovalButton);
    }
}

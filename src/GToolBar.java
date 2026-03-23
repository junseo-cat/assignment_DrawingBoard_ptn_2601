import javax.swing.*;

public class GToolBar extends JToolBar {
    private JRadioButton rectangleButton;
    private JRadioButton ovalButton;

    private GDrawingPanel drawingPanel;

    public GToolBar(GDrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;

        this.rectangleButton = new JRadioButton("Rectangle");
        this.add(rectangleButton);

        this.rectangleButton.addActionListener(e -> {
            if (this.rectangleButton.isSelected()) {
                this.drawingPanel.setCurrentShape("rectangle");
            } else {
                this.drawingPanel.setCurrentShape(null);
            }
        });

        //this.ovalButton = new JRadioButton("Oval");
        //this.add(ovalButton);
    }
}

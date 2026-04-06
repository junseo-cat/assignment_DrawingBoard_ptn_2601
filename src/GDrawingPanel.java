
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class GDrawingPanel extends JPanel {
    // constructors
    public GDrawingPanel() {
        this.setBackground(Color.WHITE);

        MouseHandler mouseHandler = new MouseHandler();
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
    }

    private int x0, y0;
    private int x1, y1;
    private BufferedImage bufferImage;
    private void startRectangularShape(int x, int y) {
        this.x0 = x;
        this.y0 = y;

        if (this.getWidth() <= 0 || this.getHeight() <= 0) {
            return;
        }

        if (this.bufferImage == null
                || this.bufferImage.getWidth() != this.getWidth()
                || this.bufferImage.getHeight() != this.getHeight()) {
            this.bufferImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D bufferGraphics = this.bufferImage.createGraphics();
            bufferGraphics.setColor(this.getBackground());
            bufferGraphics.fillRect(0, 0, this.getWidth(), this.getHeight());
            bufferGraphics.dispose();
        }

    }
    private void finishRectangularShape(int x, int y) {
        this.x1 = x;
        this.y1 = y;


        Graphics2D bufferGraphics = this.bufferImage.createGraphics();
        bufferGraphics.setColor(this.getBackground());
        bufferGraphics.fillRect(0, 0, this.getWidth(), this.getHeight());
        bufferGraphics.setColor(Color.BLACK);
        bufferGraphics.drawRect(this.x0, this.y0, this.x1 - this.x0, this.y1 - this.y0);
        bufferGraphics.dispose();

        Graphics2D panelGraphics = (Graphics2D) this.getGraphics();
        if (panelGraphics != null) {
            panelGraphics.drawImage(this.bufferImage, 0, 0, null);
            panelGraphics.dispose();
        }

    }

    // 한번 클릭후 그리기로 들어왔을때 한번 클릭을 무시시킬 변수
    private boolean isDrawing = false;
    private boolean isDrag = false;

    private class MouseHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
//			if ( e.getClickCount() == 1 && ! isDrawing ) {
//				isDrawing = true;
//				startRectangularShape(e.getX(), e.getY());
//			} else
//
            if ( e.getClickCount() == 2 && isDrawing ) {
                isDrawing = false;
                finishRectangularShape(e.getX(), e.getY());
            }
        }
        @Override
        public void mousePressed(MouseEvent e) {

            if ( !isDrawing ) {
                isDrawing = true;
                startRectangularShape(e.getX(), e.getY());
            }

        }
        @Override
        public void mouseDragged(MouseEvent e) {
            isDrag = true;
            isDrawing =false;
            finishRectangularShape(e.getX(), e.getY());
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            if ( isDrag ) {
                isDrag = false;
                finishRectangularShape(e.getX(), e.getY());
            }

        }
        @Override
        public void mouseMoved(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }

    }
}

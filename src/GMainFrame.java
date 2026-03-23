import javax.swing.*;
import java.awt.*; //

public class GMainFrame extends JFrame {
    //자식 이름 짖기  components
    private GMenuBar menuBar;
    private GToolBar toolBar;
    private GDrawingPanel drawingPanel;

    public GMainFrame() {
        //속성 세팅 (형용상) JFrame에서 제공한
        super("GMainFrame"); // 창 title
        this.setSize(800, 600); //size
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창 닫기 close function

        //자식 설정 creat aggregation
        this.menuBar = new GMenuBar();	//자식이름과 생성 클래스를 바인딩(연결)
        this.setJMenuBar(menuBar);	//등록

        this.toolBar = new GToolBar();
        this.add(toolBar);
        //this.add(toolBar, BorderLayout.NORTH);

        this.drawingPanel =new GDrawingPanel();
        this.add(drawingPanel);

    }

    //member function / methods 동사
}

import javax.swing.*;
import java.awt.*;

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

        //레이아웃
        //this.setLayout( new BorderLayout());
        // 기존 BorderLayout 대신 BoxLayout 설정 (Y_AXIS는 위에서 아래로 쌓기)
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        //자식 설정 creat aggregation
        this.menuBar = new GMenuBar();	//자식이름과 생성 클래스를 바인딩(연결)
        this.setJMenuBar(menuBar);	//등록

        this.drawingPanel =new GDrawingPanel();
        //this.add(drawingPanel, BorderLayout.CENTER);

        this.toolBar = new GToolBar(drawingPanel);  //드로잉 패널 넘겨줌
        //this.add(toolBar, BorderLayout.NORTH);

        // BoxLayout 설정 / 방향 지정 없이 등록된 순서대로 추가
        this.add(toolBar);
        this.add(drawingPanel);
    }

    //member function / methods 동사
}

import javax.swing.*;
import java.awt.*;

public class GDrawingPanel extends JPanel {
    //현재 도구
    private String currentShape;

    public GDrawingPanel() {
        super();
        this.setBackground(Color.CYAN);
        this.currentShape = null;   //처음에는 아무 도구 선택 안됨

        //네모 그리기
        // 마우스의 동작을 감지 리스너 추가
        this.addMouseListener(new java.awt.event.MouseAdapter() {

            // 시작점을 기억 변수
            int startX, startY;

            // 마우스를 '눌렀을 때' 실행되는 부분
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                // 현재 위치를
                startX = e.getX();
                startY = e.getY();
            }

            // 마우스를 '놓았을 때' 실행되는 부분
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                // 끝점 좌표 가져오기
                int endX = e.getX();
                int endY = e.getY();

                // 마우스를 오른쪽 아래가 아닌, 왼쪽 위로 역방향 드래그할 수도 있으므로
                // Math.min을 써서 항상 가장 작은 X, Y(즉, 왼쪽 위 모서리)를 찾기
                int x = Math.min(startX, endX);
                int y = Math.min(startY, endY);

                // Math.abs(절댓값) / 실제 길이를 구하기
                int width = Math.abs(startX - endX);
                int height = Math.abs(startY - endY);

                // 패널의 도화지(Graphics)
                java.awt.Graphics g = getGraphics();

                if (currentShape == null) {
                    return;
                } else if (currentShape.equals("rectangle")) {
                    g.drawRect(x, y, width, height);
                }
            }
        });
    }

    //외부에서 도구 변경하기
    public void setCurrentShape(String currentShape) {
        this.currentShape = currentShape;
    }
}

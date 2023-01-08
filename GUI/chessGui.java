package GUI;
import chess.*;
import javax.swing.*;

public class chessGui {

    chessGui() {
        JFrame frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }

    

    public static void main(String[] args) {
        new chessGui();
    }

    
    
}

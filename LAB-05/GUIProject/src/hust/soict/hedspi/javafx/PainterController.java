package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    boolean isEraserMode = false; // Biến kiểm tra chế độ tẩy hoặc vẽ
    
    @FXML
    private ToggleGroup identical; // Group cho các chế độ bút và tẩy
    
    @FXML
    private Pane drawingAreaPane; // Vùng vẽ
    
    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (event.getTarget() == drawingAreaPane) {
            Circle circle; 

            if (isEraserMode) {
                // Tạo hình tròn trắng để tẩy
                circle = new Circle(event.getX(), event.getY(), 10, Color.WHITE); // Tẩy với kích thước lớn
            } else {
                // Tạo hình tròn đen để vẽ
                circle = new Circle(event.getX(), event.getY(), 4, Color.BLACK); // Bút với kích thước nhỏ
            }
            
            drawingAreaPane.getChildren().add(circle); 
        }
    }

    @FXML
    void penMode(ActionEvent event) {
      
        isEraserMode = false;
    }

    @FXML
    void eraserMode(ActionEvent event) {
    
        isEraserMode = true;
    }
}

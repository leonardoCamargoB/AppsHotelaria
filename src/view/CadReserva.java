package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;
import view.components.PainelBotoes;
import view.components.SideBar;

public class CadReserva extends Application {
    @Override
    public void start(Stage janela) throws Exception {

        SideBar menu = new SideBar();
        PainelBotoes painel = new PainelBotoes();

        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu);

        Image imgReserva = new Image(getClass().getResourceAsStream("/view/resources/img/reserva-on-line.png"));

        Image imgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/imgHotel3.jpg"));

        ImageView viewImgReserva = new ImageView(imgReserva);
        viewImgReserva.setFitWidth(20);
        viewImgReserva.setFitHeight(20);

        Label lblTitulo = new Label("Cadastro de Reservas");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        lblTitulo.setTextFill(Color.BLACK);

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);

        Scene scene = new Scene(layout, 750, 500);
        janela.setTitle("golden cloud");
        janela.getIcons().add(imgIcon);
        janela.setScene(scene);
        janela.setResizable(false);
        janela.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}

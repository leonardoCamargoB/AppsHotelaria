package view;

import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import view.components.PainelBotoes;
import view.components.SideBar;

public class CadUsuario extends Application {

    @Override
    public void start(Stage janela) throws Exception {

        SideBar menu = new SideBar();

        PainelBotoes painel = new PainelBotoes();

        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu);

        Image imgUserBlack = new Image(getClass().getResourceAsStream("/view/resources/img/icons8-cliente-60.png"));
        Image imgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/imgHotel3.jpg"));

        ImageView viewImgUserBlack = new ImageView(imgUserBlack);
        viewImgUserBlack.setFitWidth(20);
        viewImgUserBlack.setFitHeight(20);


        Label lblTitulo = new Label("Cadastro de Funcionario");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        lblTitulo.setTextFill(Color.BLACK);


        HBox tituloBox = new HBox(viewImgUserBlack, lblTitulo);
        tituloBox.setPadding(new Insets(20, 20, 20, 20));
        tituloBox.setAlignment(Pos.CENTER);
        tituloBox.setStyle("-fx-background-color:  transparent;");


        Label lblNome = new Label("Nome: ");
        lblNome.setStyle("-fx-text-fill: #af9148 ");

        TextField txtNome = new TextField();
        txtNome.setPromptText("Digite o seu Nome");
        txtNome.setStyle("-fx-border-color: #D6C388FF; -fx-border-width: 2px; -fx-border-radius: 5px;");

        Label lblEmail = new Label("Email: ");
        lblEmail.setStyle("-fx-text-fill: #af9148 ");

        TextField txtEmail= new TextField();
        txtEmail.setPromptText("Digite o seu email ");
        txtEmail.setStyle("-fx-border-color: #D6C388FF; -fx-border-width: 2px; -fx-border-radius: 5px;");

        Label lblSenha = new Label("Senha: ");
        lblSenha.setStyle("-fx-text-fill: #af9148 ");

        TextField txtSenha = new TextField();
        txtSenha.setPromptText("Digite o sua Senha");
        txtSenha.setStyle("-fx-border-color: #D6C388FF; -fx-border-width: 2px; -fx-border-radius: 5px;");

        Label lblSetor = new Label("Setor: ");
        lblSetor.setStyle("-fx-text-fill: #af9148 ");

        TextField txtSetor = new TextField();
        txtSetor.setPromptText("Digite o seu Setor");
        txtSetor.setStyle("-fx-border-color: #D6C388FF; -fx-border-width: 2px; -fx-border-radius: 5px;");


        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com",
                "@hotmail.com", "icloud.com");
        boxEmail.setPromptText("Selecione");
        boxEmail.setStyle("-fx-background-color: #D6C388FF; -fx-border-width: 2px; -fx-border-radius: 5px;");

        ComboBox<String> boxSetor = new ComboBox<>();
        boxSetor.getItems().addAll("Limpeza", "Gerente", "hospedagem", "Restaurante", "Cozinha", "Serviço de Quarto");
        boxSetor.setPromptText("Selecione");
        boxSetor.setStyle("-fx-background-color: #D6C388FF; -fx-border-width: 2px; -fx-border-radius: 5px;");


        GridPane formGrid = new GridPane();
        formGrid.add(painel, 1, 4);
        formGrid.add(lblNome, 0, 0);
        formGrid.add(txtNome, 1, 0);
        formGrid.add(lblEmail, 0, 1);
        formGrid.add(txtEmail, 1, 1);
        formGrid.add(lblSenha, 0, 2);
        formGrid.add(txtSenha, 1, 2);
        formGrid.add(lblSetor, 0, 3);
        formGrid.add(txtSetor, 1, 3);
        formGrid.add(boxEmail, 2, 1);
        formGrid.add(boxSetor,  2, 3);
        formGrid.setPadding(new Insets(20, 20, 20, 20));
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        VBox layout = new VBox(10, tituloBox, formGrid);
        layout.setAlignment(Pos.CENTER);
      mainPane.setCenter(layout);

        Scene scene = new Scene(mainPane, 750, 500);
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


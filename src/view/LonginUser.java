package view;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LonginUser extends Application {

    public Button btnLogin = new Button("Logar");
    private boolean passwordVisible = false;
    private TextField visiblePasswordField = new TextField();
    private PasswordField hiddenPasswordField = new PasswordField();

    @Override
    public void start(Stage janela) throws Exception {

        Image imgUserBlack = new Image(getClass().getResourceAsStream("/view/resources/img/icons8-cliente-60.png"));
        Image imgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/imgHotel3.jpg"));
        Image iconLogar = new Image(getClass().getResourceAsStream("/view/resources/img/icons8-login-arredondado-à-direita-50.png"));
        Image imgHotel = new Image(getClass().getResourceAsStream("/view/resources/img/imgHotel2.jpg"));
        Image imgOlho = new Image(getClass().getResourceAsStream("/view/resources/img/olhoaberto.png"));
        Image imgOlho2 = new Image(getClass().getResourceAsStream("/view/resources/img/olhofechado.png"));

        // Configuração das imagens do olho com tamanho fixo
        int eyeIconSize = 20;
        ImageView eyeOpenView = new ImageView(imgOlho);
        eyeOpenView.setFitWidth(eyeIconSize);
        eyeOpenView.setFitHeight(eyeIconSize);

        ImageView eyeClosedView = new ImageView(imgOlho2);
        eyeClosedView.setFitWidth(eyeIconSize);
        eyeClosedView.setFitHeight(eyeIconSize);

        // Botão de alternância
        Button togglePasswordButton = new Button();
        togglePasswordButton.setGraphic(eyeOpenView);
        togglePasswordButton.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-cursor: hand;");
        togglePasswordButton.setPadding(new Insets(2, 5, 2, 5));

        ImageView viewImgHotel = new ImageView(imgHotel);
        viewImgHotel.setFitWidth(400);
        viewImgHotel.setFitHeight(500);
        viewImgHotel.setPreserveRatio(true);

        ImageView viewImgbtnLogar = new ImageView(iconLogar);
        viewImgbtnLogar.setFitWidth(20);
        viewImgbtnLogar.setFitHeight(20);

        ImageView viewImgUserBlack = new ImageView(imgUserBlack);
        viewImgUserBlack.setFitWidth(20);
        viewImgUserBlack.setFitHeight(20);

        Label lblTitulo = new Label("Login");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        lblTitulo.setTextFill(Color.BLACK);

        String styleButton = "-fx-background-color: transparent;" + "-fx-border-color: transparent;" +
                "-fx-graphic-text-gap: 10px;" + "-fx-aligment: center;" +
                "-fx-cursor: hand;";

        btnLogin.setGraphic(viewImgbtnLogar);
        btnLogin.setStyle(styleButton);

        btnLogin.setOnMouseEntered(e -> {
            btnLogin.setStyle("-fx-background-color: #af9148; -fx-text-fill: white; -fx-cursor: hand;");
            btnLogin.setScaleX(1.05);
            btnLogin.setScaleY(1.05);
        });

        btnLogin.setOnMouseExited(e -> {
            btnLogin.setStyle(styleButton);
            btnLogin.setScaleX(1.0);
            btnLogin.setScaleY(1.0);
        });

        btnLogin.setOnMousePressed(e -> btnLogin.setStyle("-fx-background-color: #8a6d2b;"));
        btnLogin.setOnMouseReleased(e -> btnLogin.setStyle("-fx-background-color: #af9148;"));

        VBox imgH = new VBox(viewImgHotel);
        imgH.setAlignment(Pos.CENTER_LEFT);

        HBox tituloBox = new HBox(viewImgUserBlack, lblTitulo);
        tituloBox.setPadding(new Insets(20, 20, 20, 20));
        tituloBox.setAlignment(Pos.CENTER);
        tituloBox.setStyle("-fx-background-color:  transparent;");

        Label lblEmail = new Label("Email:");
        lblEmail.setStyle("-fx-text-fill: #af9148 ");

        TextField txtEmail = new TextField();
        txtEmail.setPromptText("Digite o seu e-mail");
        txtEmail.setStyle("-fx-border-color: #D6C388FF; -fx-border-width: 2px; -fx-border-radius: 5px;");

        txtEmail.setStyle("-fx-border-color: #D6C388; -fx-border-width: 0 0 2 0; -fx-background-color: transparent; -fx-prompt-text-fill: #a0a0a0;");
        hiddenPasswordField.setStyle("-fx-border-color: #D6C388; -fx-border-width: 0 0 2 0; -fx-background-color: transparent; -fx-prompt-text-fill: #a0a0a0;");

        txtEmail.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) {


                if (txtEmail.getText().isEmpty() || !txtEmail.getText().contains("@")) {
                    txtEmail.setStyle("-fx-border-color: #ff6b6b; -fx-border-width: 0 0 2 0;");
                } else {
                    txtEmail.setStyle("-fx-border-color: #51cf66; -fx-border-width: 0 0 2 0;");
                }
            }
        });

        Label lblSenha = new Label("Senha:");
        lblSenha.setStyle("-fx-text-fill: #af9148 ");


        hiddenPasswordField.setPromptText("Digite a sua Senha");
        hiddenPasswordField.setStyle("-fx-border-color: #D6C388FF; -fx-border-width: 2px; -fx-border-radius: 5px;");

        visiblePasswordField.setPromptText("Digite a sua Senha");
        visiblePasswordField.setStyle("-fx-border-color: #D6C388FF; -fx-border-width: 2px; -fx-border-radius: 5px;");
        visiblePasswordField.setVisible(false);
        visiblePasswordField.setManaged(false);

        hiddenPasswordField.setStyle("-fx-border-color: #D6C388; " +
                "-fx-border-width: 0 0 2 0; " +
                "-fx-background-color: transparent; " +
                "-fx-prompt-text-fill: #a0a0a0;");


        visiblePasswordField.setStyle("-fx-border-color: #D6C388; " +
                "-fx-border-width: 0 0 2 0; " +
                "-fx-background-color: transparent; " +
                "-fx-prompt-text-fill: #a0a0a0;");

        hiddenPasswordField.textProperty().addListener((obs, oldValue, newValue) -> {
            visiblePasswordField.setText(newValue);
        });

        visiblePasswordField.textProperty().addListener((obs, oldValue, newValue) -> {
            hiddenPasswordField.setText(newValue);
        });

        togglePasswordButton.setOnAction(e -> {
            passwordVisible = !passwordVisible;

            if (passwordVisible) {
                togglePasswordButton.setGraphic(eyeClosedView);
                hiddenPasswordField.setVisible(false);
                hiddenPasswordField.setManaged(false);
                visiblePasswordField.setVisible(true);
                visiblePasswordField.setManaged(true);
            } else {
                togglePasswordButton.setGraphic(eyeOpenView);
                visiblePasswordField.setVisible(false);
                visiblePasswordField.setManaged(false);
                hiddenPasswordField.setVisible(true);
                hiddenPasswordField.setManaged(true);
            }
        });

        FadeTransition fadeOut = new FadeTransition(Duration.millis(200), hiddenPasswordField);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        FadeTransition fadeIn = new FadeTransition(Duration.millis(200), visiblePasswordField);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        Button btnForgot = new Button("Esqueci minha senha");
        btnForgot.setStyle("-fx-text-fill: #af9148; -fx-background-color: transparent; -fx-underline: true; -fx-cursor: hand;");

        GridPane formGrid = new GridPane();
        formGrid.add(btnLogin, 1, 3);
        formGrid.add(txtEmail, 1, 0);
        formGrid.add(lblEmail, 0, 0);
        formGrid.add(hiddenPasswordField, 1, 1);
        formGrid.add(visiblePasswordField, 1, 1);
        formGrid.add(togglePasswordButton, 2, 1);
        formGrid.add(lblSenha, 0, 1);
        formGrid.add(btnForgot, 1, 6);
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setMaxWidth(400);
        formGrid.setAlignment(Pos.CENTER);

        VBox loginBox = new VBox(10, tituloBox, formGrid);
        loginBox.setAlignment(Pos.CENTER);

        HBox layout = new HBox(90, imgH, loginBox);

        Scene scene = new Scene(layout, 750, 500);
        janela.setTitle("Golden Cloud  ✨");
        janela.getIcons().add(imgIcon);
        janela.setScene(scene);
        janela.setResizable(false);
        janela.show();
    }
}
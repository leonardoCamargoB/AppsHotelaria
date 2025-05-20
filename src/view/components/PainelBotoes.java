package view.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Objects;


public class PainelBotoes extends HBox {

    public Button btnCadastrar = new Button("Cadastrar");
    public Button btnAtulizar = new Button("Atualizar");
    public Button btnExcluir = new Button("Excluir");


    public PainelBotoes() {

        Font fontRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/Fonts/Cormorant-Regular.ttf"), 14);
        Font fontNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/Fonts/Cormorant-Bold.ttf"), 15);

        Image iconCadastrar = new Image(getClass().getResourceAsStream("/view/resources/img/icons8-mais-50.png"));
        Image iconAtualizar = new Image(getClass().getResourceAsStream("/view/resources/img/icons8-atualizar-96.png"));
        Image iconExcluir = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/view/resources/img/lixeira.png")));

        ImageView viewImgBtnCad = new ImageView(iconCadastrar);
        viewImgBtnCad.setFitWidth(20);
        viewImgBtnCad.setFitHeight(20);

        ImageView viewImgBtnUp = new ImageView(iconAtualizar);
        viewImgBtnUp.setFitWidth(20);
        viewImgBtnUp.setFitHeight(20);

        ImageView viewImgBtnDel = new ImageView(iconExcluir);
        viewImgBtnDel.setFitWidth(20);
        viewImgBtnDel.setFitHeight(20);


        String styleButton = "-fx-background-color: transparent;" + "-fx-border-color: transparent;" +
                "-fx-graphic-text-gap: 10px;" + "-fx-aligment: center;" +
                "-fx-cursor: hand;";


        btnCadastrar.setGraphic(viewImgBtnCad);
        btnAtulizar.setGraphic(viewImgBtnUp);
        btnExcluir.setGraphic(viewImgBtnDel);

        btnCadastrar.setStyle(styleButton);
        btnAtulizar.setStyle(styleButton);
        btnExcluir.setStyle(styleButton);


        btnCadastrar.setOnMouseEntered(Evento ->
                btnCadastrar.setStyle(styleButton.replace("transparent", "#A9A9A9")));
        btnCadastrar.setOnMouseExited(Evento -> btnCadastrar.setStyle(styleButton));

        btnAtulizar.setOnMouseEntered(Evento ->
                btnAtulizar.setStyle(styleButton.replace("transparent", "#A9A9A9")));
        btnAtulizar.setOnMouseExited(Evento -> btnAtulizar.setStyle(styleButton));

        btnExcluir.setOnMouseEntered(Evento ->
                btnExcluir.setStyle(styleButton.replace("transparent", "#A9A9A9")));
        btnExcluir.setOnMouseExited(Evento -> btnExcluir.setStyle(styleButton));


        getChildren().addAll(btnCadastrar, btnAtulizar, btnExcluir);

        btnExcluir.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Tem certeza que deseja excluir este cliente?");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {

                }
            });
        });


    }

}



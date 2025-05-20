package view.components;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class SideBar extends VBox {
    public Button btnCliente = new Button("Clientes");
    public Button btnFuncionario = new Button("Funcionarios");
    public Button btnQuarto = new Button("Quartos");
    public Button btnReserva = new Button("Reservas");
    public Button btnRelatorio = new Button("Relatorios");

    public SideBar() {
        Image iconCliente = new Image(getClass().getResourceAsStream("/view/resources/img/icon-cliente.png"));
        Image iconFuncionario = new Image(getClass().getResourceAsStream("/view/resources/img/icon-funcionario.png"));
        Image iconQuarto = new Image(getClass().getResourceAsStream("/view/resources/img/icon-quarto.png"));
        Image iconReserva = new Image(getClass().getResourceAsStream("/view/resources/img/icon-reserva.png"));
        Image iconRelatorio = new Image(getClass().getResourceAsStream("/view/resources/img/icon-relatorio.png"));

        Font fontRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/Fonts/Cormorant-Regular.ttf"), 14);
        Font fontNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/Fonts/Cormorant-Bold.ttf"), 15);



        ImageView viewiconCliente = new ImageView(iconCliente);
        viewiconCliente.setFitHeight(20);
        viewiconCliente.setFitWidth(20);

        ImageView viewIconFuncionario = new ImageView(iconFuncionario);
        viewIconFuncionario.setFitHeight(20);
        viewIconFuncionario.setFitWidth(20);

        ImageView viewIconQuarto = new ImageView(iconQuarto);
        viewIconQuarto.setFitHeight(20);
        viewIconQuarto.setFitWidth(20);

        ImageView viewIconReserva = new ImageView(iconReserva);
        viewIconReserva.setFitHeight(20);
        viewIconReserva.setFitWidth(20);

        ImageView viewIconRelatorio = new ImageView(iconRelatorio);
        viewIconRelatorio.setFitHeight(20);
        viewIconRelatorio.setFitWidth(20);

        btnCliente.setGraphic(viewiconCliente);
        btnFuncionario.setGraphic(viewIconFuncionario);
        btnQuarto.setGraphic(viewIconQuarto);
        btnReserva.setGraphic(viewIconReserva);
        btnRelatorio.setGraphic(viewIconRelatorio);


        Label lblMenu = new Label("Nox Hotel");
        lblMenu.setStyle("-fx-font--size: 18px;" + "-fx-text-fill: #a87e88" + ";" );

        lblMenu.setFont(Font.font(fontNegrito.getFamily(), 25));

        String styleButton = "-fx-background-color: transparent;" + "-fx-border-color: transparent;" +
                "-fx-graphic-text-gap: 10px;" + "-fx-alignment: center;" +
                "-fx-cursor: hand;";

        btnFuncionario.setStyle(styleButton);
        btnCliente.setStyle(styleButton);
        btnQuarto.setStyle(styleButton);
        btnReserva.setStyle(styleButton);
        btnRelatorio.setStyle(styleButton);

        btnCliente.setOnMouseEntered( Evento ->
                btnCliente.setStyle(styleButton.replace( "transparent", "#D6C388FF")));
        btnCliente.setOnMouseExited( Evento -> btnCliente.setStyle(styleButton));

        btnQuarto.setOnMouseEntered( Evento ->
                btnQuarto.setStyle(styleButton.replace( "transparent", "#D6C388FF")));
        btnQuarto.setOnMouseExited( Evento -> btnQuarto.setStyle(styleButton));

        btnFuncionario.setOnMouseEntered( Evento ->
                btnFuncionario.setStyle(styleButton.replace( "transparent", "#D6C388FF")));
        btnFuncionario.setOnMouseExited( Evento -> btnFuncionario.setStyle(styleButton));

        btnReserva.setOnMouseEntered( Evento ->
                btnReserva.setStyle(styleButton.replace( "transparent", "#D6C388FF")));
        btnReserva.setOnMouseExited( Evento -> btnReserva.setStyle(styleButton));

        btnRelatorio.setOnMouseEntered( Evento ->
                btnRelatorio.setStyle(styleButton.replace( "transparent", "#D6C388FF")));
        btnRelatorio.setOnMouseExited( Evento -> btnRelatorio.setStyle(styleButton));

        setMargin(lblMenu, new Insets(0, 0, 20, 0));

        setStyle("-fx-background-color: #ffffff ; -fx-padding: 40px");
        getChildren().addAll(lblMenu, btnCliente, btnFuncionario, btnQuarto,
                btnReserva, btnRelatorio);
  }
}
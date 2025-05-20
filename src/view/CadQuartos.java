package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
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

public class CadQuartos extends Application {
    @Override
    public void start(Stage janela) throws Exception {

        SideBar menu = new SideBar();
        PainelBotoes painel = new PainelBotoes();

        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu);

        Image imgCama = new Image(getClass().getResourceAsStream("/view/resources/img/cama.png"));

        Image imgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/imgHotel3.jpg"));

        ImageView viewImgCama = new ImageView(imgCama);
        viewImgCama.setFitWidth(20);
        viewImgCama.setFitHeight(20);

        Label lblTitulo = new Label("Cadastro de Quartos");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        lblTitulo.setTextFill(Color.BLACK);

        HBox tituloBox = new HBox(viewImgCama, lblTitulo);
        tituloBox.setPadding(new Insets(20, 20, 20, 20));
        tituloBox.setAlignment(Pos.CENTER);
        tituloBox.setStyle("-fx-background-color:  transparent;");

        Label lblNome = new Label("Nome: ");
        lblNome.setStyle("-fx-text-fill: #af9148 ");


        TextField txtNome = new TextField();
        txtNome.setPromptText("Digite o nome do quarto");
        txtNome.setStyle("-fx-border-color: #D6C388FF; -fx-border-width: 2px; -fx-border-radius: 5px;");



        Label lblNumero = new Label("Numero: ");
        lblNumero.setStyle("-fx-text-fill: #af9148 ");

        TextField txtNumero  = criarMascaraCampo("###");
        txtNumero.setPromptText("Digite o numero do quarto");
        txtNumero.setStyle("-fx-border-color: #D6C388FF; -fx-border-width: 2px; -fx-border-radius: 5px;");


        Label lblPreco = new Label("Preço: ");
        lblPreco.setStyle("-fx-text-fill: #af9148 ");

        TextField txtPreco  = criarMascaraCampo("R$ " + "###.###,##");
        txtPreco.setPromptText("Digite o valor da quarto");
        txtPreco.setStyle("-fx-border-color: #D6C388FF; -fx-border-width: 2px; -fx-border-radius: 5px;");

        Label lblDisponivel = new Label("Disponivel: ");
        lblDisponivel.setStyle("-fx-text-fill: #af9148 ");


        ComboBox<String> boxTipoQuarto = new ComboBox<>();
        boxTipoQuarto.getItems().addAll("Quarto duplo", "Quarto casal", "Quarto triplo", "Suite", "Suite dupla", "luxuoso",
                "Solteiro");
        boxTipoQuarto.setPromptText("Tipo de Quarto");
        boxTipoQuarto.setStyle("-fx-background-color: #D6C388FF; -fx-border-width: 2px; -fx-border-radius: 5px;");



        Label lblqtd_cama_casal = new Label("Cama Casal: ");
        lblqtd_cama_casal.setStyle("-fx-text-fill: #af9148 ");

        Spinner spinnerQuantidadeCasal = new Spinner(1,2,1);
        spinnerQuantidadeCasal.setStyle("-fx-background-color: #D6C388FF; -fx-border-width: 2px; -fx-border-radius: 5px;");;

        Label lblqtd_cama_solteiro = new Label("Cama Solteiro: ");
        lblqtd_cama_solteiro.setStyle("-fx-text-fill: #af9148 ");

        Spinner spinnerQuantidadeSolteiro = new Spinner(1,2,1);
        spinnerQuantidadeSolteiro.setStyle("-fx-background-color: #D6C388FF; -fx-border-width: 2px; -fx-border-radius: 5px;");;


        ComboBox<String> boxDisponivel = new ComboBox<>();
        boxDisponivel.getItems().addAll("Sim", "Não");
        boxDisponivel.setPromptText("Selecione");
        boxDisponivel.setStyle("-fx-background-color: #D6C388FF; -fx-border-width: 2px; -fx-border-radius: 5px;");


        GridPane formGrid = new GridPane();
        formGrid.add(painel, 1, 6);

        formGrid.add(lblNome, 0, 0);
        formGrid.add(txtNome, 1, 0);

        formGrid.add(lblNumero, 0, 1);
        formGrid.add(txtNumero, 1, 1);

        formGrid.add(lblPreco, 0, 2);
        formGrid.add(txtPreco, 1, 2);

        formGrid.add(lblqtd_cama_solteiro, 0, 3);
        formGrid.add(spinnerQuantidadeSolteiro, 1, 3);

        formGrid.add(lblqtd_cama_casal, 0, 4);
        formGrid.add(spinnerQuantidadeCasal, 1,4 );

        formGrid.add(boxTipoQuarto, 2, 0);

        formGrid.add(lblDisponivel, 0, 5);
        formGrid.add(boxDisponivel, 1, 5);




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

    private TextField criarMascaraCampo(String mascara) {
        TextField txtMascara = new TextField();
        txtMascara.textProperty().addListener((observable, oldValue, newValue) ->
        {
            String value = newValue.replaceAll("[^0-9]", "");
            StringBuilder formatacaoCampo = new StringBuilder();
            int index = 0;
            for (char caracter : mascara.toCharArray()) {
                if (caracter == '#') {
                    if (index < value.length()) {
                        formatacaoCampo.append(value.charAt(index));
                        index++;
                    }
                    else {
                        break;
                    }
                }
                else {
                    formatacaoCampo.append(caracter);
                }
            }
            txtMascara.setText(formatacaoCampo.toString());
        });
        return txtMascara;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
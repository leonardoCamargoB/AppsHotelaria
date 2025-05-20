package view; //Package view (classes que, quando executadas, interagem com o usuário)//

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import view.components.PainelBotoes;
import view.components.SideBar;

import java.util.Objects;

public class CadCliente extends Application {
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

        Label lblTitulo = new Label("Cadastro de Cliente");
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

        Label lblCPF = new Label("CPF: ");
        lblCPF.setStyle("-fx-text-fill: #af9148 ");

        TextField txtCPF = criarMascaraCampo("###.###.###.##");
        txtCPF.setPromptText("Digite o seu CPF");
        txtCPF.setStyle("-fx-border-color: #D6C388FF; -fx-border-width: 2px; -fx-border-radius: 5px;");

        Label lblEmail = new Label("E-mail: ");
        lblEmail.setStyle("-fx-text-fill: #af9148 ");

        TextField txtEmail = new TextField();
        txtEmail.setPromptText("Digite o seu e-mail");
        txtEmail.setStyle("-fx-border-color: #D6C388FF; -fx-border-width: 2px; -fx-border-radius: 5px;");


        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com",
                "@hotmail.com", "icloud.com");
        boxEmail.setPromptText("Selecione");
                boxEmail.setStyle("-fx-background-color: #D6C388FF; -fx-border-width: 2px; -fx-border-radius: 5px;");

        Label lblTel = new Label("Telefone: ");
        lblTel.setStyle("-fx-text-fill: #af9148 ");

        TextField txtTel = criarMascaraCampo("(##) #####-####");
         txtTel.setPromptText("Digite o seu Telefone");
        txtTel.setStyle("-fx-border-color: #D6C388FF; -fx-border-width: 2px; -fx-border-radius: 5px;");

        txtTel.setStyle("-fx-background-radius: 10; -fx-border-radius: 10; -fx-border-color: #af9148; -fx-padding: 5px;");
        txtEmail.setStyle("-fx-background-radius: 10; -fx-border-radius: 10; -fx-border-color: #af9148; -fx-padding: 5px;");
        txtNome.setStyle("-fx-background-radius: 10; -fx-border-radius: 10; -fx-border-color: #af9148; -fx-padding: 5px;");
        txtCPF.setStyle("-fx-background-radius: 10; -fx-border-radius: 10; -fx-border-color: #af9148; -fx-padding: 5px;");

        GridPane formGrid = new GridPane();
        formGrid.add(painel, 1, 4);
        formGrid.add(lblNome, 0, 0);
        formGrid.add(txtNome, 1, 0);
        formGrid.add(lblCPF, 0, 1);
        formGrid.add(txtCPF, 1, 1);
        formGrid.add(lblEmail, 0, 2);
        formGrid.add(txtEmail, 1, 2);
        formGrid.add(lblTel, 0, 3);
        formGrid.add(txtTel, 1, 3);
        formGrid.add(boxEmail, 2, 2);
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

    //Metodo para criar um campo de texto com mascara
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

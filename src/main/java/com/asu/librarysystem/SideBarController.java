package com.asu.librarysystem;


import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.EventObject;
import java.util.Objects;
import java.util.ResourceBundle;

public class SideBarController implements Initializable {
    private Stage primaryStage;
    private Scene scene;

    @FXML
    private  Label NoNotifications;

    @FXML
    private Pane MiddlePane;

    @FXML
    private VBox NotificationsVBox;

    @FXML
    private Label Welcome;

    @FXML
    private Label Logout;

    @FXML
    private Label ManageProfile;

    @FXML
    private Label Menu;

    @FXML
    private Label MenuBack;

    @FXML
    private Label MyBooks;

    @FXML
    private Label Shopping;

    @FXML
    private AnchorPane Slider;

    @FXML
    private Label Transactions;

    public void CheckNotifications()
    {
        NoNotifications.setVisible(false);
        NotificationsVBox.setVisible(true);
        for (int i = 0; i < BorrowerController.getCurrentBorrower().getBorrowerTransactions().size(); i++) {
            Label label = new Label("Your Borrowed Book \"" + BorrowerController.getCurrentBorrower().getBorrowerTransactions().get(i).getBookName() +"\" is due in " + ChronoUnit.DAYS.between(LocalDate.now(),BorrowerController.getCurrentBorrower().getBorrowerTransactions().get(i).getReturnDate())+" days");
            label.setFont(Font.font(30));
            label.setTextFill(Color.WHITE);
            label.setPrefWidth(1005);
            label.setBackground(new Background(new BackgroundFill(Color.valueOf("#0A4969"), CornerRadii.EMPTY, Insets.EMPTY)));
            label.setStyle("-fx-border-color: black;");
            Label empty = new Label();
            NotificationsVBox.getChildren().add(empty);
            NotificationsVBox.getChildren().add(label);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Welcome.setText("Welcome, "+BorrowerController.getCurrentBorrower().getUserName());
        Slider.setTranslateX(0);
        CheckNotifications();
        Menu.setOnMouseClicked(mouseEvent -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(Slider);
            slide.setToX(0);
            slide.play();
            Slider.setTranslateX(-300);
            slide.setOnFinished((ActionEvent e) -> {
                Menu.setVisible(false);
                MenuBack.setVisible(true);
            });
        });

        MenuBack.setOnMouseClicked(mouseEvent -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(Slider);
            slide.setToX(-300);
            slide.play();
            Slider.setTranslateX(0);
            slide.setOnFinished((ActionEvent e) -> {
                Menu.setVisible(true);
                MenuBack.setVisible(false);
            });
        });
        Transactions.setOnMouseClicked(mouseEvent -> {
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BorrowerTransactions.fxml")));
                primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();
                System.out.println(1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        MyBooks.setOnMouseClicked(mouseEvent -> {
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BorrowerTransactions.fxml")));
                primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();
                System.out.println(2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Shopping.setOnMouseClicked(mouseEvent -> {
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BorrowerTransactions.fxml")));
                primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();
                System.out.println(3);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        ManageProfile.setOnMouseClicked(mouseEvent -> {
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BorrowerTransactions.fxml")));
                primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();
                System.out.println(4);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Logout.setOnMouseClicked(mouseEvent -> {
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BorrowerTransactions.fxml")));
                primaryStage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();
                System.out.println(5);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

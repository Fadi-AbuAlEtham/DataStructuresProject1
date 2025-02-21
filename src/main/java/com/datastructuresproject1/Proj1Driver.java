package com.datastructuresproject1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Proj1Driver extends Application {
	private DistrictLinkedList districtList;
	private FileChooser fChooser;
	private MenuBar menuBar;
	private Menu menu1, menu2, disMenu, locMenu;
	private MenuItem openItem, item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, disInsert,
			disUpdate, disDelete, disNavigate, disTotCertainDate, disWrFile, locInsert, locUpdate, locDelete,
			locNavigate, locSearch, martInsert, martUpdate, martDelete, martSearch;
	private Image image;
	private ImageView imageView;
	private BorderPane bdPane;
	private VBox vBoxMain, vBoxInstDis, vBoxChoUpdDis, vBoxUpdDis, vBoxNavDis, vBoxInstLoc, vBoxUpdLoc, vBoxInstMart,
			vBoxNavLoc, vBoxSeaLoc, vBoxSeaMart, vBoxUpdMart, vBoxDelMart;
	private HBox hBoxInstDis, hBoxChoUpdDis, hBoxUpdDis, hBoxUpdDis2, hBoxNavDis, hBoxInstDisLoc, hBoxInstLoc,
			hBoxInstMart, hBox1, hBoxNavLoc, hBoxSeaDisLoc, hBoxSeaLoc;
	private GridPane gdPane, gdPane1, gdPaneMartSea, gdPaneMartUpd, gdPaneMartDel;
	private Label lblMainInst, lblMainInfo, lblDisInst, lblDisInstInfo, lblDisUpdChoInfo, lblDisUpdOld, lblDisUpdNew,
			lblDisUpdInfo, lblDisNavInfo, lblLocDisInst, lblLocInst, lblLocInstInfo, lblLocDisUpd, lblOldLocUpd,
			lblNewLocUpd, lblLocUpdInfo, lblMartInstInfo, lblMartName, lblMartDate, lblMartAge, lblMartLoc, lblMartDis,
			lblMartGender, lblLocDisNavInfo, lblLocNavInfo, lblLocDisSea, lblLocSea, lblLocSeaInfo, lblMartDisSea,
			lblMartLocSea, lblMartSea, lblMartSeaInfo, lblMartDisUpd, lblMartLocUpd, lblOldMartUpd, lblMartDateUpd,
			lblMartUpdInfo, lblMartDisDel, lblMartLocDel, lblMartDel, lblMartDateDel, lblMartDelInfo;
	private TextField txtFieldDisInst, txtDisUpdOld, txtDisUpdNew, txtLocDisInst, txtLocInst, txtLocDisUpd,
			txtOldLocUpd, txtNewLocUpd, txtMartName, txtMartDate, txtMartAge, txtMartLoc, txtMartDis, txtLocDisSea,
			txtLocSea, txtMartDisSea, txtMartLocSea, txtMartSea, txtMartDisUpd, txtMartLocUpd, txtOldMartUpd,
			txtMartDateUpd, txtMartDisDel, txtMartLocDel, txtMartDel, txtMartDateDel;
	private TextArea txtAreaMain, txtAreaDisNavigation, txtAreaLocSearch, txtAreaMartSearch, txtAreaMartDelete,
			txtAreaMartUpd;
	private Button btDisInst, btDisInstMain, btDisChoUpd, btDisChoRen, btDisUpd, btDisUpdMain, btDisNavNext,
			btDisNavPrev, btDisNavMain, btLocInst, btLocInstMain, btLocUpd, btLocUpdMain, btMartInst, btMartClear,
			btMartInstMain, btDisLocNavNext, btDisNavLocPrev, btLocNavNext, btLocNavMain, btLocSea, btLocSeaMain,
			btMartSea, btMartSeaMain, btMartUpd, btMartUpdMain, btMartCheckDel, btMartDel, btMartDelMain,
			btMartCheckUpd, btDisChoMain;
	private RadioButton rbMale, rbFemale, rbUnknown;
	private ToggleGroup group;
	private Scene sceneMain;
	private DistrictNode node;
	private LocationNode locNode;
	private File f;

	@Override
	public void start(Stage primaryStage) {
		districtList = new DistrictLinkedList();

		// Panes
		bdPane = new BorderPane();
		vBoxMain = new VBox(20);
		vBoxMain.setAlignment(Pos.CENTER);
		vBoxMain.setPadding(new Insets(10, 10, 10, 10));
		vBoxInstDis = new VBox(20);
		vBoxInstDis.setAlignment(Pos.CENTER);
		vBoxInstDis.setPadding(new Insets(10, 10, 10, 10));
		hBoxInstDis = new HBox(20);
		hBoxInstDis.setAlignment(Pos.CENTER);
		hBoxInstDis.setPadding(new Insets(10, 10, 10, 10));
		vBoxChoUpdDis = new VBox(20);
		vBoxChoUpdDis.setAlignment(Pos.CENTER);
		vBoxChoUpdDis.setPadding(new Insets(10, 10, 10, 10));
		hBoxChoUpdDis = new HBox(20);
		hBoxChoUpdDis.setAlignment(Pos.CENTER);
		hBoxChoUpdDis.setPadding(new Insets(10, 10, 10, 10));
		vBoxUpdDis = new VBox(20);
		vBoxUpdDis.setAlignment(Pos.CENTER);
		vBoxUpdDis.setPadding(new Insets(10, 10, 10, 10));
		hBoxUpdDis = new HBox(20);
		hBoxUpdDis.setAlignment(Pos.CENTER);
		hBoxUpdDis.setPadding(new Insets(10, 10, 10, 10));
		hBoxUpdDis2 = new HBox(20);
		hBoxUpdDis2.setAlignment(Pos.CENTER);
		hBoxUpdDis2.setPadding(new Insets(10, 10, 10, 10));
		vBoxNavDis = new VBox(20);
		vBoxNavDis.setAlignment(Pos.CENTER);
		vBoxNavDis.setPadding(new Insets(10, 10, 10, 10));
		hBoxNavDis = new HBox(20);
		hBoxNavDis.setAlignment(Pos.CENTER);
		hBoxNavDis.setPadding(new Insets(10, 10, 10, 10));
		vBoxInstLoc = new VBox(20);
		vBoxInstLoc.setAlignment(Pos.CENTER);
		vBoxInstLoc.setPadding(new Insets(10, 10, 10, 10));
		hBoxInstLoc = new HBox(20);
		hBoxInstLoc.setAlignment(Pos.CENTER);
		hBoxInstLoc.setPadding(new Insets(10, 10, 10, 10));
		hBoxInstDisLoc = new HBox(20);
		hBoxInstDisLoc.setAlignment(Pos.CENTER);
		hBoxInstDisLoc.setPadding(new Insets(10, 10, 10, 10));
		vBoxUpdLoc = new VBox(20);
		vBoxUpdLoc.setAlignment(Pos.CENTER);
		vBoxUpdLoc.setPadding(new Insets(10, 10, 10, 10));
		gdPane = new GridPane();
		gdPane.setAlignment(Pos.CENTER);
		gdPane.setPadding(new Insets(10, 10, 10, 10));
		gdPane.setVgap(10);
		gdPane.setHgap(10);
		gdPane1 = new GridPane();
		gdPane1.setPadding(new Insets(20, 20, 20, 20));
		gdPane1.setAlignment(Pos.CENTER);
		gdPane1.setHgap(10);
		gdPane1.setVgap(10);
		gdPaneMartSea = new GridPane();
		gdPaneMartSea.setPadding(new Insets(20, 20, 20, 20));
		gdPaneMartSea.setAlignment(Pos.CENTER);
		gdPaneMartSea.setHgap(10);
		gdPaneMartSea.setVgap(10);
		vBoxInstMart = new VBox(20);
		vBoxInstMart.setAlignment(Pos.CENTER);
		vBoxInstMart.setPadding(new Insets(10, 10, 10, 10));
		hBoxInstMart = new HBox(20);
		hBoxInstMart.setAlignment(Pos.CENTER);
		hBoxInstMart.setPadding(new Insets(10, 10, 10, 10));
		hBox1 = new HBox(30);
		hBox1.setAlignment(Pos.CENTER);
		vBoxNavLoc = new VBox(30);
		vBoxNavLoc.setAlignment(Pos.CENTER);
		vBoxNavLoc.setPadding(new Insets(10, 10, 10, 10));
		hBoxNavLoc = new HBox(20);
		hBoxNavLoc.setAlignment(Pos.CENTER);
		hBoxNavLoc.setPadding(new Insets(10, 10, 10, 10));
		hBoxSeaDisLoc = new HBox(20);
		hBoxSeaDisLoc.setAlignment(Pos.CENTER);
		hBoxSeaDisLoc.setPadding(new Insets(10, 10, 10, 10));
		hBoxSeaLoc = new HBox(20);
		hBoxSeaLoc.setAlignment(Pos.CENTER);
		hBoxSeaLoc.setPadding(new Insets(10, 10, 10, 10));
		vBoxSeaLoc = new VBox(20);
		vBoxSeaLoc.setAlignment(Pos.CENTER);
		vBoxSeaLoc.setPadding(new Insets(10, 10, 10, 10));
		vBoxSeaMart = new VBox(20);
		vBoxSeaMart.setAlignment(Pos.CENTER);
		vBoxSeaMart.setPadding(new Insets(10, 10, 10, 10));
		gdPaneMartUpd = new GridPane();
		gdPaneMartUpd.setPadding(new Insets(20, 20, 20, 20));
		gdPaneMartUpd.setAlignment(Pos.CENTER);
		gdPaneMartUpd.setHgap(10);
		gdPaneMartUpd.setVgap(10);
		vBoxUpdMart = new VBox(20);
		vBoxUpdMart.setAlignment(Pos.CENTER);
		vBoxUpdMart.setPadding(new Insets(10, 10, 10, 10));
		gdPaneMartDel = new GridPane();
		gdPaneMartDel.setPadding(new Insets(20, 20, 20, 20));
		gdPaneMartDel.setAlignment(Pos.CENTER);
		gdPaneMartDel.setHgap(10);
		gdPaneMartDel.setVgap(10);
		vBoxDelMart = new VBox(20);
		vBoxDelMart.setAlignment(Pos.CENTER);
		vBoxDelMart.setPadding(new Insets(10, 10, 10, 10));

		// Image
		image = new Image(getClass().getResource("pngfind.com-manila-folder-png-1353429.png").toExternalForm());
		imageView = new ImageView(image);
		imageView.setFitWidth(16);
		imageView.setFitHeight(16);

		// Menu
		menuBar = new MenuBar();
		menu1 = new Menu("File");
		menu2 = new Menu("Color");
		disMenu = new Menu("District");
		locMenu = new Menu("Location");
		disMenu.setVisible(false);
		locMenu.setVisible(false);

		// MenuItem
		openItem = new MenuItem("Open");
		openItem.setGraphic(imageView);
		item1 = new MenuItem("Light Green");
		item1.setOnAction(e -> bdPane.setStyle("-fx-background-color: lightgreen"));
		item2 = new MenuItem("Baby Blue");
		item2.setOnAction(e -> bdPane.setStyle("-fx-background-color: lightblue"));
		item3 = new MenuItem("Biege");
		item3.setOnAction(e -> bdPane.setStyle("-fx-background-color: Cornsilk"));
		item4 = new MenuItem("Plum");
		item4.setOnAction(e -> bdPane.setStyle("-fx-background-color: PLUM"));
		item5 = new MenuItem("Salmon");
		item5.setOnAction(e -> bdPane.setStyle("-fx-background-color: salmon"));
		item6 = new MenuItem("Pink");
		item6.setOnAction(e -> bdPane.setStyle("-fx-background-color: lightpink"));
		item7 = new MenuItem("White");
		item7.setOnAction(e -> bdPane.setStyle("-fx-background-color: white"));
		item8 = new MenuItem("Aquamarine");
		item8.setOnAction(e -> bdPane.setStyle("-fx-background-color: AQUAMARINE"));
		item9 = new MenuItem("Deep Sky Blue");
		item9.setOnAction(e -> bdPane.setStyle("-fx-background-color: DEEPSKYBLUE"));
		item10 = new MenuItem("Medium Sea Green");
		item10.setOnAction(e -> bdPane.setStyle("-fx-background-color: MEDIUMSEAGREEN"));
		item11 = new MenuItem("Original color");
		item11.setOnAction(e -> bdPane.setStyle("-fx-background-color: whitesmoke"));
		disInsert = new MenuItem("Insert a new district");
		disUpdate = new MenuItem("Update a district");
		disDelete = new MenuItem("Delete a district");
		disNavigate = new MenuItem("Navigate districts");
		disTotCertainDate = new MenuItem("Total number for certain date");
		disWrFile = new MenuItem("Write district details on a file");
		locInsert = new MenuItem("Insert a new location");
		locUpdate = new MenuItem("Update a location");
		locDelete = new MenuItem("Delete a location");
		locNavigate = new MenuItem("Navigate locations");
		locSearch = new MenuItem("Search and show stats for ceratin location");
		martInsert = new MenuItem("Insert a new martyr");
		martUpdate = new MenuItem("Update a martyr");
		martDelete = new MenuItem("Delete a martyr");
		martSearch = new MenuItem("Search for a martyr");
		menu1.getItems().addAll(openItem);
		disMenu.getItems().addAll(disInsert, disUpdate, disDelete, disNavigate, disTotCertainDate, disWrFile);
		locMenu.getItems().addAll(locInsert, locUpdate, locDelete, locNavigate, locSearch, martInsert, martUpdate,
				martDelete, martSearch);
		menu2.getItems().addAll(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11);
		menuBar.getMenus().addAll(menu1, disMenu, locMenu, menu2);

		// Labels
		lblMainInst = new Label("     Martyr's Data Program\n\nPlease open a file to continue");
		lblMainInst.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));
		lblMainInfo = new Label("Choose Operation from the menus");
		lblMainInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		lblMainInfo.setVisible(false);
		lblDisInst = new Label("District Name: ");
		lblDisInst.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblDisInstInfo = new Label();
		lblDisInstInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblDisInstInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: green; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 2;");
		lblDisUpdOld = new Label("Old District Name: ");
		lblDisInst.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblDisUpdNew = new Label("New District Name: ");
		lblDisInst.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblDisUpdInfo = new Label();
		lblDisUpdInfo.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblDisUpdInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: green; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 2;");
		lblDisNavInfo = new Label();
		lblDisNavInfo.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblDisNavInfo.setStyle(
				"-fx-font-size: 24px; -fx-text-fill: green; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 2;");
		lblLocDisInst = new Label("District Name: ");
		lblLocDisInst.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblLocInstInfo = new Label();
		lblLocInstInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblLocInstInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: green; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 2;");
		lblLocInst = new Label("Location Name: ");
		lblLocInst.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblLocDisUpd = new Label("District Name: ");
		lblLocDisUpd.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblOldLocUpd = new Label("Old Location Name: ");
		lblOldLocUpd.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblNewLocUpd = new Label("New Location Name: ");
		lblNewLocUpd.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblLocUpdInfo = new Label();
		lblLocUpdInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblLocUpdInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: green; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 2;");
		lblMartInstInfo = new Label();
		lblMartInstInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblMartInstInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: green; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 2;");
		lblMartName = new Label("Name: ");
		lblMartName.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartDate = new Label("Date: ");
		lblMartDate.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartAge = new Label("Age: ");
		lblMartAge.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartLoc = new Label("Location: ");
		lblMartLoc.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartDis = new Label("District: ");
		lblMartDis.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartGender = new Label("Gender: ");
		lblMartGender.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblLocDisNavInfo = new Label();
		lblLocDisNavInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblLocDisNavInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: red; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: green; -fx-border-width: 1;");
		lblLocNavInfo = new Label();
		lblLocNavInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblLocNavInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: blue; -fx-font-weight: bold; -fx-background-color: transparent;");
		lblLocDisSea = new Label("District: ");
		lblLocDisSea.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblLocSea = new Label("Location: ");
		lblLocSea.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblLocSeaInfo = new Label();
		lblLocSeaInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblLocSeaInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: red; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: green; -fx-border-width: 1;");
		lblMartDisSea = new Label("District: ");
		lblMartDisSea.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartLocSea = new Label("Location: ");
		lblMartLocSea.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartSea = new Label("Martyr Name: ");
		lblMartSea.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartSeaInfo = new Label();
		lblMartSeaInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblMartSeaInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: red; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: green; -fx-border-width: 1;");
		lblMartDisUpd = new Label("District: ");
		lblMartDisUpd.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartLocUpd = new Label("Location: ");
		lblMartLocUpd.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblOldMartUpd = new Label("Old Martyr Name: ");
		lblOldMartUpd.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartDateUpd = new Label("Date of Death: ");
		lblMartDateUpd.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartUpdInfo = new Label();
		lblMartUpdInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblMartUpdInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: red; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: green; -fx-border-width: 1;");
		lblMartDisDel = new Label("District: ");
		lblMartDisDel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartLocDel = new Label("Location: ");
		lblMartLocDel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartDel = new Label("Martyr Name: ");
		lblMartDel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartDateDel = new Label("Date of Death: ");
		lblMartDateDel.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		lblMartDelInfo = new Label();
		lblMartDelInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblMartDelInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: green; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 1;");
		lblDisUpdChoInfo = new Label("Choose whether you want to update or rename.");
		lblDisUpdChoInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		lblDisUpdChoInfo.setStyle(
				"-fx-font-size: 20px; -fx-text-fill: green; -fx-font-weight: bold; -fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 1;");

		// TextFields
		txtFieldDisInst = new TextField();
		txtFieldDisInst.setPromptText("e.g.: Al-Quds");
		txtDisUpdOld = new TextField();
		txtDisUpdOld.setPromptText("Old District Name");
		txtDisUpdNew = new TextField();
		txtDisUpdNew.setPromptText("New District Name");
		txtLocDisInst = new TextField();
		txtLocDisInst.setPromptText("e.g.: Al-Quds");
		txtLocInst = new TextField();
		txtLocInst.setPromptText("e.g.: a-Ram");
		txtLocDisUpd = new TextField();
		txtLocDisUpd.setPromptText("e.g.: Al-Quds");
		txtOldLocUpd = new TextField();
		txtOldLocUpd.setPromptText("Old Location Name");
		txtNewLocUpd = new TextField();
		txtNewLocUpd.setPromptText("New Location Name");
		txtMartName = new TextField();
		txtMartName.setPromptText("e.g.: Elias");
		txtMartDate = new TextField();
		txtMartDate.setPromptText("(MM/DD/YYYY)");
		txtMartAge = new TextField();
		txtMartAge.setPromptText("e.g.: 25");
		txtMartLoc = new TextField();
		txtMartLoc.setPromptText("e.g.: a-Ram");
		txtMartDis = new TextField();
		txtMartDis.setPromptText("e.g.: Al-Quds");
		txtLocDisSea = new TextField();
		txtLocDisSea.setPromptText("e.g.: Al-Quds");
		txtLocSea = new TextField();
		txtLocSea.setPromptText("e.g.: a-Ram");
		txtMartDisSea = new TextField();
		txtMartDisSea.setPromptText("e.g.: Al-Quds");
		txtMartLocSea = new TextField();
		txtMartLocSea.setPromptText("e.g.: a-Ram");
		txtMartSea = new TextField();
		txtMartSea.setPromptText("e.g.: Elias");
		txtMartDisUpd = new TextField();
		txtMartDisUpd.setPromptText("e.g.: Al-Quds");
		txtMartLocUpd = new TextField();
		txtMartLocUpd.setPromptText("e.g.: a-Ram");
		txtOldMartUpd = new TextField();
		txtOldMartUpd.setPromptText("e.g.: Elias");
		txtMartDateUpd = new TextField();
		txtMartDateUpd.setPromptText("e.g.: (MM/DD/YYYY)");
		txtMartDisDel = new TextField();
		txtMartDisDel.setPromptText("e.g.: Al-Quds");
		txtMartLocDel = new TextField();
		txtMartLocDel.setPromptText("e.g.: a-Ram");
		txtMartDel = new TextField();
		txtMartDel.setPromptText("e.g.: Elias");
		txtMartDateDel = new TextField();
		txtMartDateDel.setPromptText("(MM/DD/YYYY)");

		// Buttons
		btDisInst = new Button("Insert");
		btDisInstMain = new Button("Return To Main");
		btDisUpd = new Button("Update");
		btDisUpdMain = new Button("Return To Main");
		btDisNavNext = new Button("Next >");
		btDisNavPrev = new Button("< Previous");
		btDisNavMain = new Button("Return To Main");
		btLocInst = new Button("Insert");
		btLocInstMain = new Button("Return To Main");
		btLocUpd = new Button("Update");
		btLocUpdMain = new Button("Return To Main");
		btMartInst = new Button("Insert");
		btMartInstMain = new Button("Return To Main");
		btMartClear = new Button("Clear");
		btDisLocNavNext = new Button("Next District >");
		btDisNavLocPrev = new Button("< Previous District");
		btLocNavNext = new Button("Next Location >");
		btLocNavMain = new Button("Return To Main");
		btLocSea = new Button("Search");
		btLocSeaMain = new Button("Return To Main");
		btMartSea = new Button("Search");
		btMartSeaMain = new Button("Return To Main");
		btMartUpd = new Button("Update");
		btMartCheckUpd = new Button("Check");
		btMartUpdMain = new Button("Return To Main");
		btMartCheckDel = new Button("Check");
		btMartDel = new Button("Delete");
		btMartDelMain = new Button("Return To Main");
		btDisChoUpd = new Button("Update");
		btDisChoRen = new Button("Rename");
		btDisChoMain = new Button("Return To Main");

		// TextArea
		txtAreaMain = new TextArea();
		txtAreaMain.setPrefHeight(350);
		txtAreaMain.setMaxWidth(700);
		txtAreaMain.setVisible(false);
		txtAreaMain.setEditable(false);
		txtAreaMain.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 17));
		txtAreaDisNavigation = new TextArea();
		txtAreaDisNavigation.setPrefHeight(350);
		txtAreaDisNavigation.setMaxWidth(700);
		txtAreaDisNavigation.setEditable(false);
		txtAreaDisNavigation.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		txtAreaLocSearch = new TextArea();
		txtAreaLocSearch.setPrefHeight(350);
		txtAreaLocSearch.setMaxWidth(700);
		txtAreaLocSearch.setEditable(false);
		txtAreaLocSearch.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		txtAreaMartSearch = new TextArea();
		txtAreaMartSearch.setPrefHeight(350);
		txtAreaMartSearch.setMaxWidth(700);
		txtAreaMartSearch.setEditable(false);
		txtAreaMartSearch.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		txtAreaMartDelete = new TextArea();
		txtAreaMartDelete.setPrefHeight(350);
		txtAreaMartDelete.setMaxWidth(700);
		txtAreaMartDelete.setEditable(false);
		txtAreaMartDelete.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		txtAreaMartUpd = new TextArea();
		txtAreaMartUpd.setPrefHeight(350);
		txtAreaMartUpd.setMaxWidth(700);
		txtAreaMartUpd.setEditable(false);
		txtAreaMartUpd.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));

		// FileChooser
		fChooser = new FileChooser();

		// RadioButtons
		group = new ToggleGroup();
		rbMale = new RadioButton("Male");
		rbFemale = new RadioButton("Female");
		rbMale.setToggleGroup(group);
		rbFemale.setToggleGroup(group);
		rbUnknown = new RadioButton("Unknown");
		rbUnknown.setToggleGroup(group);

		// Event handler for the MenuItems
		openItem.setOnAction(e -> readFile(primaryStage));
		disInsert.setOnAction(e -> insertDisScene(primaryStage));
		disUpdate.setOnAction(e -> updateDisScene(primaryStage));
		disDelete.setOnAction(e -> deleteDisScene(primaryStage));
		disNavigate.setOnAction(e -> navigateDisScene(primaryStage));
		disTotCertainDate.setOnAction(e -> searchDateDisScene(primaryStage));
		disWrFile.setOnAction(e -> writeFileDisScene(primaryStage));
		locInsert.setOnAction(e -> insertLocScene(primaryStage));
		locUpdate.setOnAction(e -> updateLocScene(primaryStage));
		locDelete.setOnAction(e -> deleteLocScene(primaryStage));
		locNavigate.setOnAction(e -> navigateLocScene(primaryStage));
		locSearch.setOnAction(e -> searchLocScene(primaryStage));
		martInsert.setOnAction(e -> insertMartScene(primaryStage));
		martUpdate.setOnAction(e -> updateMartScene(primaryStage));
		martDelete.setOnAction(e -> deleteMartScene(primaryStage));
		martSearch.setOnAction(e -> searchMartScene(primaryStage));

		// Main scene
		vBoxMain.getChildren().addAll(lblMainInst, txtAreaMain, lblMainInfo);
		bdPane.setTop(menuBar);
		bdPane.setCenter(vBoxMain);
		// Adding the panes on the scenes
		sceneMain = new Scene(bdPane, 1000, 800);
		primaryStage.setTitle("Main Screen Window");
		primaryStage.setScene(sceneMain);
		primaryStage.show();

		// InsertDisScene and DeleteDisScene and NumberOfMartyrsByDateScene
		hBoxInstDis.getChildren().addAll(lblDisInst, txtFieldDisInst);
		vBoxInstDis.getChildren().addAll(hBoxInstDis, lblDisInstInfo, btDisInst, btDisInstMain);

		// ChooseUpdDisScene
		hBoxChoUpdDis.getChildren().addAll(btDisChoUpd, btDisChoRen);
		vBoxChoUpdDis.getChildren().addAll(lblDisUpdChoInfo, hBoxChoUpdDis, btDisChoMain);

		// UpdateDisScene
		hBoxUpdDis.getChildren().addAll(lblDisUpdOld, txtDisUpdOld);
		hBoxUpdDis2.getChildren().addAll(lblDisUpdNew, txtDisUpdNew);
		vBoxUpdDis.getChildren().addAll(hBoxUpdDis, hBoxUpdDis2, lblDisUpdInfo, btDisUpd, btDisUpdMain);

		// District Navigation Scene
		hBoxNavDis.getChildren().addAll(btDisNavPrev, btDisNavNext);
		vBoxNavDis.getChildren().addAll(lblDisNavInfo, txtAreaDisNavigation, hBoxNavDis, btDisNavMain);

		// LocationInstScene
		hBoxInstDisLoc.getChildren().addAll(lblLocDisInst, txtLocDisInst);
		hBoxInstLoc.getChildren().addAll(lblLocInst, txtLocInst);
		vBoxInstLoc.getChildren().addAll(hBoxInstDisLoc, hBoxInstLoc, lblLocInstInfo, btLocInst, btLocInstMain);

		// UpdateLocScene
		gdPane.add(lblLocDisUpd, 0, 0);
		gdPane.add(txtLocDisUpd, 1, 0);
		gdPane.add(lblOldLocUpd, 0, 1);
		gdPane.add(txtOldLocUpd, 1, 1);
		gdPane.add(lblNewLocUpd, 0, 2);
		gdPane.add(txtNewLocUpd, 1, 2);
		vBoxUpdLoc.getChildren().addAll(gdPane, lblLocUpdInfo, btLocUpd, btLocUpdMain);

		// NavigateLocScene
		hBoxNavLoc.getChildren().addAll(btDisNavLocPrev, btDisLocNavNext);
		vBoxNavLoc.getChildren().addAll(lblLocDisNavInfo, lblLocNavInfo, btLocNavNext, hBoxNavLoc, btLocNavMain);

		// SearchLocationScene
		hBoxSeaDisLoc.getChildren().addAll(lblLocDisSea, txtLocDisSea);
		hBoxSeaLoc.getChildren().addAll(lblLocSea, txtLocSea, btLocSea);
		vBoxSeaLoc.getChildren().addAll(hBoxSeaDisLoc, hBoxSeaLoc, lblLocSeaInfo, txtAreaLocSearch, btLocSeaMain);

		// InsertMartScene
		hBoxInstMart.getChildren().addAll(btMartInst, btMartClear);
		hBox1.getChildren().addAll(rbMale, rbFemale, rbUnknown);
		gdPane1.add(lblMartName, 0, 0);
		gdPane1.add(txtMartName, 1, 0);
		gdPane1.add(lblMartDate, 0, 1);
		gdPane1.add(txtMartDate, 1, 1);
		gdPane1.add(lblMartAge, 0, 2);
		gdPane1.add(txtMartAge, 1, 2);
		gdPane1.add(lblMartLoc, 0, 3);
		gdPane1.add(txtMartLoc, 1, 3);
		gdPane1.add(lblMartDis, 0, 4);
		gdPane1.add(txtMartDis, 1, 4);
		gdPane1.add(lblMartGender, 0, 5);
		gdPane1.add(hBox1, 1, 5);
		vBoxInstMart.getChildren().addAll(gdPane1, lblMartInstInfo, hBoxInstMart, btMartInstMain);

		// UpdateMartScene
		gdPaneMartUpd.add(lblMartDisUpd, 0, 0);
		gdPaneMartUpd.add(txtMartDisUpd, 1, 0);
		gdPaneMartUpd.add(lblMartLocUpd, 0, 1);
		gdPaneMartUpd.add(txtMartLocUpd, 1, 1);
		gdPaneMartUpd.add(lblOldMartUpd, 0, 2);
		gdPaneMartUpd.add(txtOldMartUpd, 1, 2);
		gdPaneMartUpd.add(lblMartDateUpd, 0, 3);
		gdPaneMartUpd.add(txtMartDateUpd, 1, 3);
		gdPaneMartUpd.add(btMartUpd, 3, 2);
		gdPaneMartUpd.add(btMartCheckUpd, 2, 2);
		vBoxUpdMart.getChildren().addAll(gdPaneMartUpd, lblMartUpdInfo, txtAreaMartUpd, btMartUpdMain);

		// DeleteMartScene
		gdPaneMartDel.add(lblMartDisDel, 0, 0);
		gdPaneMartDel.add(txtMartDisDel, 1, 0);
		gdPaneMartDel.add(lblMartLocDel, 0, 1);
		gdPaneMartDel.add(txtMartLocDel, 1, 1);
		gdPaneMartDel.add(lblMartDel, 0, 2);
		gdPaneMartDel.add(txtMartDel, 1, 2);
		gdPaneMartDel.add(lblMartDateDel, 0, 3);
		gdPaneMartDel.add(txtMartDateDel, 1, 3);
		gdPaneMartDel.add(btMartDel, 3, 2);
		gdPaneMartDel.add(btMartCheckDel, 2, 2);
		vBoxDelMart.getChildren().addAll(gdPaneMartDel, lblMartDelInfo, txtAreaMartDelete, btMartDelMain);

		// SearchMartScene
		gdPaneMartSea.add(lblMartDisSea, 0, 0);
		gdPaneMartSea.add(txtMartDisSea, 1, 0);
		gdPaneMartSea.add(lblMartLocSea, 0, 1);
		gdPaneMartSea.add(txtMartLocSea, 1, 1);
		gdPaneMartSea.add(lblMartSea, 0, 2);
		gdPaneMartSea.add(txtMartSea, 1, 2);
		gdPaneMartSea.add(btMartSea, 2, 2);
		vBoxSeaMart.getChildren().addAll(gdPaneMartSea, lblMartSeaInfo, txtAreaMartSearch, btMartSeaMain);

	}

	// Method to read from a file
	private void readFile(Stage stage) {
		f = fChooser.showOpenDialog(stage);
		txtAreaMain.setText("");
		// Checks if the file was null
		if (f != null) {
			// Informing the user of the file name that was chosen and any error while
			// reading
			lblMainInst.setText("You opened this file: " + f.getName() + "\nReading from file warnings:");
			disMenu.setVisible(true);
			locMenu.setVisible(true);
			txtAreaMain.setVisible(true);
			lblMainInfo.setVisible(true);

			// try-catch block to handle any possible exception that might occurs
			try (Scanner read = new Scanner(f)) {
				// Skip the first line
				read.nextLine();
				// Keep reading from the file while it has content
				while (read.hasNextLine()) {
					String s = read.nextLine();
					// Split the line by ","
					String[] line = s.split(",");
					try {
						// If the format of the line was wrong
						if (line.length != 6)
							throw new IndexOutOfBoundsException("Incorrect inputs check the format!\n");
						// The first entry represents the name
						String name = line[0];

						// The second entry represents the event
						String event = line[1];
						byte age;

						// The third entry represents the age
						if (line[2].isEmpty()) {
							age = -1;
							txtAreaMain.appendText(name + " doesn't have an age.\n");
						} else {
							// Checks if the age was a digit or not
							if (isNumeric(line[2]))
								age = Byte.parseByte(line[2]);
							else {
								age = -1;
								txtAreaMain.appendText(name + " has an invalid age.\n");
							}
						}
						// The forth entry represents the location
						String location = line[3];
						// The fifth entry represents the district
						String district = line[4];
						if (!CorrectDate(event, lblLocInstInfo)) {
							txtAreaMain.appendText(name + " has invalid date of death\n");
						}
						char gender = '?';

						// The sixth entry represents the gender
						if (line[5].equals("NA") || line[5].isEmpty())
							gender = 'N';
						else
							gender = line[5].charAt(0);

						if (gender != 'm' && gender != 'M' && gender != 'F' && gender != 'f' && gender != 'N')
							throw new InputMismatchException(name + ": Gender must only be M/m/F/f\n");

						// Insert district
						District dis = new District(district);
						DistrictNode districtNode = districtList.findNode(dis);
						if (districtNode == null) {
							districtNode = new DistrictNode(dis);
							districtList.insertDistrictSorted(districtNode, lblDisInstInfo);
						}
						// Get the reference to the locationList of the district
						LocationLinkedList locationList = (LocationLinkedList) districtNode.getHead();

						// Insert location
						Location loc = new Location(location);
						LocationNode locationNode = locationList.findNode(loc);
						if (locationNode == null) {
							locationNode = new LocationNode(loc);
							locationList.insertLocationSorted(locationNode, lblDisInstInfo);
						}

						// Insert martyr
						Martyr martyr = new Martyr(name, event, age, location, district, gender);
						MartyrNode martyrNode = new MartyrNode(martyr);
						// Get the reference to the martyrList of the location
						MartyrLinkedList martyrList = locationNode.getHead();
						martyrList.insertMartyrSorted(martyrNode, txtAreaMain, lblLocUpdInfo);

					}
					// Catch blocks to handle exceptions
					catch (InputMismatchException e1) {
						txtAreaMain.appendText(e1.getMessage());
					} catch (IndexOutOfBoundsException e1) {
						txtAreaMain.appendText(e1.getMessage());
					} catch (NumberFormatException e1) {
						txtAreaMain.appendText(e1.getMessage());
					} catch (Exception e1) {
						txtAreaMain.appendText(e1.getMessage());
					}
				}
			}
			// Catch blocks to handle exceptions and organize nodes
			catch (FileNotFoundException e1) {
				lblMainInst.setText(e1.getMessage());
				txtAreaMain.setVisible(false);
				lblMainInfo.setVisible(false);
			} catch (NoSuchElementException e1) {
				lblMainInst.setText(e1.getMessage());
				txtAreaMain.setVisible(false);
				lblMainInfo.setVisible(false);
			} catch (Exception e1) {
				lblMainInst.setText(e1.getMessage());
				txtAreaMain.setVisible(false);
				lblMainInfo.setVisible(false);
			}
		}
	}

	// Method that inserts a district to the list
	private void insertDisScene(Stage primaryStage) {
		if(bdPane.getCenter() != vBoxInstDis)
			bdPane.setCenter(vBoxInstDis);
		
		// Organize the nodes on the scene
		lblDisInst.setText("District Name: ");
		lblDisInstInfo.setText("");
		txtFieldDisInst.clear();
		txtFieldDisInst.setPromptText("e.g.: Al-Quds");
		btDisInst.setText("Insert");
		lblDisInstInfo.setVisible(false);

		// Event handler for btDisInstMain button
		btDisInstMain.setOnAction(e -> returnMain(primaryStage));

		// Event handler for btDisInst button
		btDisInst.setOnAction(e -> {
			// Check if the textField is empty or not
			if (!txtFieldDisInst.getText().isEmpty()) {
				// Insert district
				District dis = new District(txtFieldDisInst.getText());
				// Check the existence of the district
				DistrictNode districtNode = districtList.findNode(dis);
				if (districtNode == null) {
					districtNode = new DistrictNode(dis);
					lblDisInstInfo.setVisible(true);
					districtList.insertDistrictSorted(districtNode, lblDisInstInfo);
				} else { // Notify the user that district exist from before
					lblDisInstInfo.setVisible(true);
					lblDisInstInfo.setText("Error: " + txtFieldDisInst.getText() + " district already exists!");
				}
			} else { // Notify the user that the district is empty
				lblDisInstInfo.setVisible(true);
				lblDisInstInfo.setText("Error: Enter a district name first!");
			}

		});

		primaryStage.setTitle("Insert District");
		primaryStage.show();
	}

	// Method that updates a district
	private void updateDisScene(Stage primaryStage) {
		if(bdPane.getCenter() != vBoxChoUpdDis)
			bdPane.setCenter(vBoxChoUpdDis);
		
		// Organize the nodes on the scene
		lblDisUpdInfo.setText("");
		txtDisUpdOld.clear();
		txtDisUpdNew.clear();
		lblDisUpdInfo.setVisible(false);
		btDisUpdMain.setOnAction(e -> returnMain(primaryStage));
		btDisChoMain.setOnAction(e -> returnMain(primaryStage));

		// Event handler for btDisChoUpd button
		btDisChoUpd.setOnAction(e -> {
			primaryStage.setTitle("Update District");
			if(bdPane.getCenter() != vBoxUpdDis)
				bdPane.setCenter(vBoxUpdDis);
			primaryStage.show();
			btDisUpd.setText("Update");

			// Event handler for btDisUpd button
			btDisUpd.setOnAction(e1 -> {
				lblDisUpdInfo.setVisible(true);
				districtList.updateDistrict(txtDisUpdOld.getText(), txtDisUpdNew.getText(), lblDisUpdInfo);
			});

		});

		// Event handler for btDisChoRen button
		btDisChoRen.setOnAction(e -> {
			primaryStage.setTitle("Rename District");
			if(bdPane.getCenter() != vBoxUpdDis)
				bdPane.setCenter(vBoxUpdDis);
			primaryStage.show();
			btDisUpd.setText("Rename");

			// Event handler for btDisUpd button
			btDisUpd.setOnAction(e1 -> {
				lblDisUpdInfo.setVisible(true);
				districtList.renameDistrict(txtDisUpdOld.getText(), txtDisUpdNew.getText(), lblDisUpdInfo);
			});

		});

		primaryStage.setTitle("Update District");
		primaryStage.show();
	}

	// Method to delete a district from the list
	private void deleteDisScene(Stage primaryStage) {
		// Organize the nodes on the scene
		lblDisInstInfo.setText("");
		txtFieldDisInst.clear();
		lblDisInst.setText("District Name: ");
		btDisInst.setText("Delete");
		lblDisInstInfo.setVisible(false);
		
		if(bdPane.getCenter() != vBoxInstDis)
			bdPane.setCenter(vBoxInstDis);
		
		btDisInstMain.setOnAction(e -> returnMain(primaryStage));

		// Event handler for btDisUpd button
		btDisInst.setOnAction(e -> {
			// Check if the textField is empty or not
			if (!txtFieldDisInst.getText().isEmpty()) {
				lblDisInstInfo.setVisible(true);
				districtList.deleteDistrict(txtFieldDisInst.getText(), lblDisInstInfo);
			} else { // Notify the user that the textFiled is empty
				lblDisInstInfo.setVisible(true);
				lblDisInstInfo.setText("Error: Enter a district name first!");
			}

		});

		primaryStage.setTitle("Delete District");
		primaryStage.show();
	}

	// Method that navigates throw the districts
	private void navigateDisScene(Stage primaryStage) {
		// Organize the nodes on the scene
		txtAreaDisNavigation.setText("");
		txtAreaDisNavigation.setVisible(true);
		lblDisNavInfo.setText("");
		btDisNavMain.setOnAction(e -> returnMain(primaryStage));
		lblDisNavInfo.setVisible(false);

		if(bdPane.getCenter() != vBoxNavDis)
			bdPane.setCenter(vBoxNavDis);
		
		// Start navigating from the first district in the list
		node = districtList.getFront();

		// Check the existence of the district
		if (node != null) {
			lblDisNavInfo.setVisible(true);
			districtList.showStatistics(node, txtAreaDisNavigation, lblDisNavInfo);
		}

		// Event handler for btDisNavPrev button
		btDisNavPrev.setOnAction(e -> {
			if (node != null && node.getPrev() != null) {
				lblDisNavInfo.setVisible(true);
				txtAreaDisNavigation.setText("");
				lblDisNavInfo.setText("");
				// Update node to previous node
				node = node.getPrev();
				districtList.showStatistics(node, txtAreaDisNavigation, lblDisNavInfo);
			} else {
				// If the navigation reached the first district in the list
				lblDisNavInfo.setVisible(true);
				lblDisNavInfo.setText("This is the first district!");
			}
		});

		// Event handler for btDisNavNext button
		btDisNavNext.setOnAction(e -> {
			if (node != null && node.getNext() != null) {
				lblDisNavInfo.setVisible(true);
				txtAreaDisNavigation.setText("");
				lblDisNavInfo.setText("");
				// Update node to next node
				node = node.getNext();
				districtList.showStatistics(node, txtAreaDisNavigation, lblDisNavInfo);
			} else {
				// If the navigation reached the last district in the list
				lblDisNavInfo.setVisible(true);
				lblDisNavInfo.setText("This is the last district!");
			}
		});

		primaryStage.setTitle("Navigate District");
		primaryStage.show();
	}

	// Method that returns the number of martyrs with a certain date
	private void searchDateDisScene(Stage primaryStage) {
		// Organize the nodes on the scene
		lblDisInst.setText("Date: ");
		txtFieldDisInst.setPromptText("(MM/DD/YYYY)");
		lblDisInstInfo.setText("");
		txtFieldDisInst.clear();
		btDisInst.setText("Search");
		lblDisInstInfo.setVisible(false);
		btDisInstMain.setOnAction(e -> returnMain(primaryStage));

		if(bdPane.getCenter() != vBoxInstDis)
			bdPane.setCenter(vBoxInstDis);
		
		// Event handler for btDisInst button
		btDisInst.setOnAction(e -> {
			// Check if the textField is empty
			if (!txtFieldDisInst.getText().isEmpty()) {
				lblDisInstInfo.setVisible(true);
				if (CorrectDate(txtFieldDisInst.getText(), lblDisInstInfo)) {
					int num = districtList.displayNumberDate(txtFieldDisInst.getText());
					lblDisInstInfo.setText("The total number of martyrs with this date: " + num);
				} else { // Notify the user if the date was wrong
					lblDisInstInfo.setText("Check the date formart it should be (MM/DD/YYYY)");
				}
			} else { // Notify the user if the textField was empty
				lblDisInstInfo.setVisible(true);
				lblDisInstInfo.setText("Error: Enter a date first!");
			}

		});

		primaryStage.setTitle("Delete District");
		primaryStage.show();
	}

	// Method that writes the district information on a file
	private void writeFileDisScene(Stage primaryStage) {
		// Organize the nodes on the scene
		lblDisInst.setText("District Name: ");
		lblDisInstInfo.setText("");
		txtFieldDisInst.clear();
		txtFieldDisInst.setPromptText("e.g.: Al-Quds");
		btDisInst.setText("Write On File");
		lblDisInstInfo.setVisible(false);
		btDisInstMain.setOnAction(e -> returnMain(primaryStage));

		if(bdPane.getCenter() != vBoxInstDis)
			bdPane.setCenter(vBoxInstDis);
		
		// Event handler for btDisInst button
		btDisInst.setOnAction(e -> {
			// Check if the textField is empty or not
			if (!txtFieldDisInst.getText().isEmpty()) {
				// Insert district
				District dis = new District(txtFieldDisInst.getText());

				// Check the existence of the district
				DistrictNode districtNode = districtList.findNode(dis);
				if (districtNode == null) {
					lblDisInstInfo.setVisible(true);
					// Notify the user that the district doesn't exist
					lblDisInstInfo.setText(txtFieldDisInst.getText() + " district doesn't exist!");
				} else {
					lblDisInstInfo.setVisible(true);
					districtList.writeOnFile(districtNode, lblDisInstInfo);
				}
			} else { // Notify the user that the textField is empty
				lblDisInstInfo.setVisible(true);
				lblDisInstInfo.setText("Error: Enter a district name first!");
			}

		});

		primaryStage.setTitle("Write District On File");
		primaryStage.show();
	}

	// Method that inserts a location
	private void insertLocScene(Stage primaryStage) {
		// Organize the nodes on the scene
		lblLocDisInst.setText("District Name: ");
		txtLocDisInst.clear();
		txtLocDisInst.setPromptText("e.g.: al-Quds");
		lblLocInst.setText("Location Name: ");
		lblLocInstInfo.setText("");
		txtLocInst.clear();
		txtLocInst.setPromptText("e.g.: a-Ram");
		btLocInst.setText("Insert");
		lblLocInstInfo.setVisible(false);
		btLocInstMain.setOnAction(e -> returnMain(primaryStage));

		if(bdPane.getCenter() != vBoxInstLoc)
			bdPane.setCenter(vBoxInstLoc);
		
		// Event handler for btLocInst button
		btLocInst.setOnAction(e -> {
			if (!txtLocDisInst.getText().isEmpty()) {
				// Insert district
				District dis = new District(txtLocDisInst.getText());

				// Check the existence of the district
				DistrictNode districtNode = districtList.findNode(dis);
				if (districtNode == null) {
					districtNode = new DistrictNode(dis);
					lblLocInstInfo.setVisible(true);
					lblLocInstInfo.setText("This '" + txtLocDisInst.getText() + "' district doesn't exist!");
					return;
				}
				// Get the reference to the locationList of the district
				LocationLinkedList locationList = (LocationLinkedList) districtNode.getHead();

				// Check if the textField is empty or not
				if (!txtLocInst.getText().isEmpty()) {
					// Insert location
					Location loc = new Location(txtLocInst.getText());

					// Check the existence of the location
					LocationNode locationNode = locationList.findNode(loc);
					if (locationNode == null) {
						locationNode = new LocationNode(loc);
						lblLocInstInfo.setVisible(true);
						locationList.insertLocationSorted(locationNode, lblLocInstInfo);
					} else { // Notify the user that the location already exist
						lblLocInstInfo.setVisible(true);
						lblLocInstInfo.setText("Error! This location already exist in this district!");
						return;
					}
				} else { // Notify the user that the textField is empty
					lblLocInstInfo.setVisible(true);
					lblLocInstInfo.setText("Error: Enter a location name!");
				}

			} else { // Notify the user that the textField is empty
				lblLocInstInfo.setVisible(true);
				lblLocInstInfo.setText("Error: Enter a district name first!");
			}

		});

		primaryStage.setTitle("Insert Location");
		primaryStage.show();
	}

	// Method that updates a location
	private void updateLocScene(Stage primaryStage) {
		// Organize the nodes on the scene
		lblLocDisUpd.setText("District Name: ");
		txtLocDisUpd.clear();
		txtLocDisUpd.setPromptText("e.g.: al-Quds");
		lblOldLocUpd.setText("Old Location Name: ");
		txtOldLocUpd.clear();
		txtOldLocUpd.setPromptText("e.g.: a-Ram");
		lblNewLocUpd.setText("New Location Name: ");
		txtNewLocUpd.clear();
		txtNewLocUpd.setPromptText("e.g.: Bidu");
		lblLocUpdInfo.setText("");
		btLocUpd.setText("Update");
		lblLocUpdInfo.setVisible(false);
		btLocUpdMain.setOnAction(e -> returnMain(primaryStage));
		btDisChoMain.setOnAction(e -> returnMain(primaryStage));

		if(bdPane.getCenter() != vBoxChoUpdDis)
			bdPane.setCenter(vBoxChoUpdDis);
		
		// Event handler for btDisChoUpd button
		btDisChoUpd.setOnAction(e -> {
			primaryStage.setTitle("Update Location");
			primaryStage.show();
			btLocUpd.setText("Update");
			
			if(bdPane.getCenter() != vBoxUpdLoc)
				bdPane.setCenter(vBoxUpdLoc);

			// Event handler for btLocUpd button
			btLocUpd.setOnAction(e1 -> {
				lblLocUpdInfo.setVisible(true);
				districtList.updateLocation(txtLocDisUpd.getText(), txtOldLocUpd.getText(), txtNewLocUpd.getText(),
						lblLocUpdInfo);
			});

		});

		// Event handler for btDisChoRen button
		btDisChoRen.setOnAction(e -> {
			primaryStage.setTitle("Rename Location");
			primaryStage.show();
			btLocUpd.setText("Rename");

			if(bdPane.getCenter() != vBoxUpdLoc)
				bdPane.setCenter(vBoxUpdLoc);
			
			// Event handler for btLocUpd button
			btLocUpd.setOnAction(e1 -> {
				lblLocUpdInfo.setVisible(true);
				districtList.renameLocation(txtLocDisUpd.getText(), txtOldLocUpd.getText(), txtNewLocUpd.getText(),
						lblLocUpdInfo);
			});

		});

		primaryStage.setTitle("Update Location");
		primaryStage.show();
	}

	// Method that deletes a location
	private void deleteLocScene(Stage primaryStage) {
		// Organize the nodes on the scene
		lblLocDisInst.setText("District Name: ");
		txtLocDisInst.clear();
		txtLocDisInst.setPromptText("e.g.: al-Quds");
		lblLocInst.setText("Location Name: ");
		lblLocInstInfo.setText("");
		txtLocInst.clear();
		txtLocInst.setPromptText("e.g.: a-Ram");
		btLocInst.setText("Delete");
		lblLocInstInfo.setVisible(false);
		btLocInstMain.setOnAction(e -> returnMain(primaryStage));
		
		if(bdPane.getCenter() != vBoxInstLoc)
			bdPane.setCenter(vBoxInstLoc);

		// Event handler for btLocInst button
		btLocInst.setOnAction(e -> {
			// Check if the textField is empty
			if (!txtLocDisInst.getText().isEmpty()) {
				if (!txtLocInst.getText().isEmpty()) {
					lblLocInstInfo.setVisible(true);
					districtList.deleteLocation(txtLocDisInst.getText(), txtLocInst.getText(), lblLocInstInfo);
				} else { // Notify the user that the textField is empty
					lblLocInstInfo.setVisible(true);
					lblLocInstInfo.setText("Error: Enter a location name!");
				}

			} else { // Notify the user that the textField is empty
				lblLocInstInfo.setVisible(true);
				lblLocInstInfo.setText("Error: Enter a district name first!");
			}

		});

		primaryStage.setTitle("Delete Location");
		primaryStage.show();
	}

	// Method that navigates the locations in the list
	private void navigateLocScene(Stage primaryStage) {
		btLocNavMain.setOnAction(e -> returnMain(primaryStage));

		if(bdPane.getCenter() != vBoxNavLoc)
			bdPane.setCenter(vBoxNavLoc);
		
		// Start from the first district
		node = districtList.getFront();
		// Start from the first location in the first district
		locNode = node.getHead().getFront();

		// Check the existence of the district and the location
		if (node != null) {
			lblLocDisNavInfo.setText("District: " + ((District) node.getElement()).getName());
			lblLocNavInfo.setText("Location: " + ((Location) locNode.getElement()).getName());
		}

		// Event handler for btDisNavLocPrev button
		btDisNavLocPrev.setOnAction(e -> {
			if (node != null && node.getPrev() != null) {
				// Update node to previous node
				node = node.getPrev();
				locNode = node.getHead().getFront();
				lblLocDisNavInfo.setText("District: " + ((District) node.getElement()).getName());
				lblLocNavInfo.setText("Location: " + ((Location) locNode.getElement()).getName());
			} else {
				lblLocDisNavInfo.setText("This is the first district!");
			}
		});

		// Event handler for btDisLocNavNext button
		btDisLocNavNext.setOnAction(e -> {
			if (node != null && node.getNext() != null) {
				// Update node to next node
				node = node.getNext();
				locNode = node.getHead().getFront();
				lblLocDisNavInfo.setText("District: " +((District) node.getElement()).getName());
				lblLocNavInfo.setText("Location: " + ((Location) locNode.getElement()).getName());
			} else {
				lblLocDisNavInfo.setText("This is the last district!");
			}
		});

		// Event handler for btLocNavNext button
		btLocNavNext.setOnAction(e -> {
			if (locNode != null && locNode.getNext() != null) {
				locNode = locNode.getNext();
				lblLocNavInfo.setText("Location: " + ((Location) locNode.getElement()).getName());
			} else if (locNode != null && locNode.getNext() == null) {
				locNode = node.getHead().getFront();
				lblLocNavInfo.setText("Location: " + ((Location) locNode.getElement()).getName());
			}
		});

		primaryStage.setTitle("Navigate Locations");
		primaryStage.show();
	}

	// Method that searches for a location
	private void searchLocScene(Stage primaryStage) {
		btLocSeaMain.setOnAction(e -> returnMain(primaryStage));

		// Organize the nodes on the scene
		txtLocDisSea.setText("");
		txtLocSea.setText("");
		lblLocSeaInfo.setVisible(false);
		txtAreaLocSearch.setVisible(false);
		
		if(bdPane.getCenter() != vBoxSeaLoc)
			bdPane.setCenter(vBoxSeaLoc);

		// Event handler for btLocSea button
		btLocSea.setOnAction(e -> {
			lblLocSeaInfo.setText("");
			txtAreaLocSearch.setText("");
			districtList.showCertainLocStat(txtLocDisSea.getText(), txtLocSea.getText(), txtAreaLocSearch,
					lblLocSeaInfo);
		});

		primaryStage.setTitle("Search Location");
		primaryStage.show();
	}

	// Method to insert a new martyr to the list
	private void insertMartScene(Stage primaryStage) {
		// Organize the nodes on the scene
		clear();
		btMartInst.setText("Insert");

		btMartInstMain.setOnAction(e -> returnMain(primaryStage));

		if(bdPane.getCenter() != vBoxInstMart)
			bdPane.setCenter(vBoxInstMart);
		
		btMartInst.setOnAction(e -> {
			// try-catch block to handle any exception that might occurs
			try {
				String name, date, location, district;
				// If all fields were empty it will inform the user
				if (txtMartName.getText().trim().isEmpty() && txtMartAge.getText().isEmpty()
						&& txtMartLoc.getText().isEmpty() && txtMartDis.getText().isEmpty()
						&& txtMartDate.getText().isEmpty()) {
					lblMartInstInfo.setVisible(true);
					lblMartInstInfo.setText("Fileds are empty");
					return;
				}
				// If the name was empty it will inform the user
				if (txtMartName.getText().trim().isEmpty()) {
					lblMartInstInfo.setVisible(true);
					lblMartInstInfo.setText("Name is empty");
					return;
				} else {
					name = txtMartName.getText();
				}

				date = txtMartDate.getText();
				// If the date was empty it will inform the user
				if (date.isEmpty()) {
					lblMartInstInfo.setVisible(true);
					lblMartInstInfo.setText("Date is empty");
					return;
				}
				// Checks if the date was in the correct format
				else if (!CorrectDate(date, lblMartInstInfo)) {
					lblMartInstInfo.setVisible(true);
					return;
				}

				byte age;
				// If the age was empty it will inform the user
				if (txtMartAge.getText().trim().isEmpty()) {
					age = -1;
					lblMartInstInfo.setVisible(true);
					lblMartInstInfo.setText("Warning: Age is empty!");
				} else {
					age = Byte.parseByte(txtMartAge.getText());
					if (age < 0) {
						lblMartInstInfo.setVisible(true);
						lblMartInstInfo.setText("Age must be greater or equal to zero!");
						return;
					}
				}
				// If the location was empty it will inform the user
				if (txtMartLoc.getText().trim().isEmpty()) {
					lblMartInstInfo.setVisible(true);
					lblMartInstInfo.setText("Location is empty");
					return;
				} else {
					location = txtMartLoc.getText();
				}

				// If the location was empty it will inform the user
				if (txtMartDis.getText().trim().isEmpty()) {
					lblMartInstInfo.setVisible(true);
					lblMartInstInfo.setText("District is empty");
					return;
				} else {
					district = txtMartDis.getText();
				}

				char gender = '?';

				if (rbMale.isSelected())
					gender = 'M';
				else if (rbFemale.isSelected())
					gender = 'F';
				else if (rbUnknown.isSelected())
					gender = 'N';

				// If all fields were entered correctly it will add the new martyr
				if (!name.isEmpty() && (age >= 0 || age == -1) && !location.isEmpty() && !district.isEmpty()
						&& !date.isEmpty()) {
					// If no gender was selected it will throw an exception
					if (gender != 'M' && gender != 'F' && gender != 'N') {
						lblMartInstInfo.setVisible(true);
						lblMartInstInfo.setText("Choose a gender!");
						return;
					}

					// Insert district
					District dis = new District(district);
					DistrictNode districtNode = districtList.findNode(dis);
					if (districtNode == null) {
						districtNode = new DistrictNode(dis);
						lblMartInstInfo.setVisible(true);
						districtList.insertDistrictSorted(districtNode, lblDisInstInfo);
					}
					// Get the reference to the locationList of the district
					LocationLinkedList locationList = (LocationLinkedList) districtNode.getHead();

					// Insert location
					Location loc = new Location(location);
					LocationNode locationNode = locationList.findNode(loc);
					if (locationNode == null) {
						lblMartInstInfo.setVisible(true);
						locationNode = new LocationNode(loc);
						locationList.insertLocationSorted(locationNode, lblMartInstInfo);
					}
					Martyr martyr = new Martyr(name, date, age, location, district, gender);
					if (!districtList.searchMartyr(martyr, lblMartInstInfo)) {
						// Insert martyr
						MartyrNode martyrNode = new MartyrNode(martyr);
						// Get the reference to the martyrList of the location
						MartyrLinkedList martyrList = locationNode.getHead();
						lblMartInstInfo.setVisible(true);
						martyrList.insertMartyrSorted(martyrNode, txtAreaMain, lblMartInstInfo);
					}
				}
				// If any field was empty it will notify the user
				else {
					lblMartInstInfo.setVisible(true);
					if (name.isEmpty()) {
						lblMartInstInfo.setText("Name is empty");
						return;
					}
					if (location.isEmpty()) {
						lblMartInstInfo.setText("Location is empty");
						return;
					}
					if (district.isEmpty()) {
						lblMartInstInfo.setText("District is empty");
						return;
					}
					if (date.isEmpty()) {
						lblMartInstInfo.setText("Date is empty");
						return;
					}
					if (gender == '?') {
						lblMartInstInfo.setText("Gender is not chosen");
						return;
					}
				}
			}
			// Catch blocks to handle exceptions
			catch (InputMismatchException e1) {
				lblMartInstInfo.setVisible(true);
				lblMartInstInfo.setText(e1.getMessage());
			} catch (NumberFormatException e1) {
				lblMartInstInfo.setVisible(true);
				lblMartInstInfo.setText("Please an integer for the age not a string!");
			} catch (Exception e1) {
				lblMartInstInfo.setVisible(true);
				lblMartInstInfo.setText(e1.getMessage());
			}
		});

		btMartClear.setOnAction(e -> clear());

		primaryStage.setTitle("Insert Martyr");
		primaryStage.show();
	}

	// Method that updates a martyr information
	private void updateMartScene(Stage primaryStage) {
		// Organize the nodes on the scene
		lblMartUpdInfo.setText("");
		txtMartDisUpd.clear();
		txtMartLocUpd.clear();
		txtOldMartUpd.clear();
		txtMartDateUpd.clear();
		txtAreaDisNavigation.setText("");
		txtAreaMartUpd.setText("");
		lblMartDateUpd.setVisible(false);
		txtMartDateUpd.setVisible(false);
		txtAreaMartUpd.setVisible(false);
		lblMartUpdInfo.setVisible(false);
		btMartUpd.setVisible(false);

		btMartUpdMain.setOnAction(e -> returnMain(primaryStage));
		
		if(bdPane.getCenter() != vBoxUpdMart)
			bdPane.setCenter(vBoxUpdMart);

		// Event handler for btMartCheckUpd button
		btMartCheckUpd.setOnAction(e -> {
			txtAreaMartUpd.setText("");
			lblMartUpdInfo.setVisible(true);

			// Check if the textFields are empty and notify the user
			if (txtMartDisUpd.getText().isEmpty()) {
				lblMartUpdInfo.setText("Please enter a district!");
				return;
			} else if (txtMartLocUpd.getText().isEmpty()) {
				lblMartUpdInfo.setText("Please enter a location!");
				return;
			} else if (txtOldMartUpd.getText().isEmpty()) {
				lblMartUpdInfo.setText("Please enter a martyr name to update!");
				return;
			}

			// Check the existence of the district
			DistrictNode districtNode = districtList.findNode(new District(txtMartDisUpd.getText()));
			if (districtNode == null) {
				lblMartUpdInfo.setText("The district is wrong!");
				return;
			}
			LocationLinkedList locationList = districtNode.getHead();

			// Check the existence of the location
			LocationNode locationNode = locationList.findNode(new Location(txtMartLocUpd.getText()));
			if (locationNode == null) {
				lblMartUpdInfo.setText("The location is wrong!");
				return;
			}
			MartyrLinkedList martyrList = locationNode.getHead();

			// Check the existence of the martyr with the count of them
			int result = martyrList.check(txtOldMartUpd.getText(), txtAreaMartUpd, lblMartUpdInfo);
			// If the check method returned 1 it will inform the user the the martyr has
			// been found and can be deleted
			if (result == 1) {
				lblMartUpdInfo.setText(txtOldMartUpd.getText() + " has been found press update to update him/her");
				// Organize the nodes on the scene
				lblMartUpdInfo.setVisible(true);
				txtAreaMartUpd.setVisible(false);
				btMartUpd.setVisible(true);
				btMartUpd.setOnAction(e1 -> {
					districtList.returnMartyr(martyrList, txtOldMartUpd.getText(), txtMartName, txtMartDate, txtMartAge,
							txtMartLoc, txtMartDis, rbMale, rbFemale, rbUnknown);
					lblMartUpdInfo.setVisible(true);
					// If the name was empty it will inform the user
					if (txtOldMartUpd.getText().isEmpty()) {
						lblMartUpdInfo.setText("Name is empty!");
					} else
						// If the name wasn't empty it will be updated
						lblMartUpdInfo.setVisible(true);
					MartUpdButton(primaryStage, martyrList, districtNode);
				});
			}
			// If the check method returned a number greater than 1 it will inform the user
			// that there's more than one martyr with the same name
			else if (result > 1) {
				// Organize the nodes on the scene
				btMartUpd.setVisible(true);
				lblMartDateUpd.setVisible(true);
				txtMartDateUpd.setVisible(true);
				btMartUpd.setOnAction(e1 -> {
					districtList.returnMartyr(martyrList, txtOldMartUpd.getText(), txtMartName, txtMartDate, txtMartAge,
							txtMartLoc, txtMartDis, rbMale, rbFemale, rbUnknown);
					lblMartUpdInfo.setVisible(true);
					// Check if the textFields are empty
					if (!txtOldMartUpd.getText().isEmpty() && !txtMartDateUpd.getText().isEmpty()) {
						MartUpdButton(primaryStage, martyrList, districtNode);
					} else { // Notify the user that the textFields are empty
						if (txtOldMartUpd.getText().isEmpty()) {
							lblMartUpdInfo.setText("Name is empty!");
						} else if (txtMartDateUpd.getText().isEmpty()) {
							lblMartUpdInfo.setText("You didn't enter the date of death!");
						}
					}
				});
			}
			// If the check method returned zero this means that there is no martyrs with
			// the same name in the list
			else if (result == 0) {
				txtAreaMartUpd.setVisible(false);
				lblMartUpdInfo.setVisible(true);
				btMartUpd.setVisible(false);
				lblMartUpdInfo.setText(txtOldMartUpd.getText() + " wasn't found!");
			}
		});

		primaryStage.setTitle("Update Martyr");
		primaryStage.show();
	}

	// Method that deletes a martyr
	private void deleteMartScene(Stage primaryStage) {
		// Organize the nodes on the scene
		txtMartDisDel.clear();
		txtMartLocDel.clear();
		txtMartDel.clear();
		txtMartDateDel.clear();
		lblMartDelInfo.setText("");
		lblMartDelInfo.setVisible(false);
		lblMartDateDel.setVisible(false);
		txtMartDateDel.setVisible(false);
		btMartDel.setVisible(false);
		txtAreaMartDelete.setVisible(false);

		btMartDelMain.setOnAction(e -> returnMain(primaryStage));

		if(bdPane.getCenter() != vBoxDelMart)
			bdPane.setCenter(vBoxDelMart);
		
		// Event handler for the check button in the delete scene to check the existence
		// of the martyr using Check method
		btMartCheckDel.setOnAction(e -> {
			txtAreaMartDelete.setText("");
			txtAreaMartDelete.setVisible(false);
			lblMartDateDel.setVisible(false);
			txtMartDateDel.setVisible(false);

			if (txtMartDisDel.getText().isEmpty()) {
				lblMartDelInfo.setVisible(true);
				lblMartDelInfo.setText("Enter a district first!");
				return;
			} else if (txtMartLocDel.getText().isEmpty()) {
				lblMartDelInfo.setVisible(true);
				lblMartDelInfo.setText("Enter a location first!");
				return;
			}
			// If the name is empty it will inform the user
			else if (txtMartDel.getText().isEmpty()) {
				lblMartDelInfo.setVisible(true);
				lblMartDelInfo.setText("Enter a name first!");
				return;
			}

			// Check the existence of the district
			DistrictNode districtNode = districtList.findNode(new District(txtMartDisDel.getText()));
			if (districtNode == null) {
				lblMartDelInfo.setText("The district is wrong!");
				return;
			}
			LocationLinkedList locationList = districtNode.getHead();

			// Check the existence of the location
			LocationNode locationNode = locationList.findNode(new Location(txtMartLocDel.getText()));
			if (locationNode == null) {
				lblMartDelInfo.setText("The location is wrong!");
				return;
			}
			MartyrLinkedList martyrList = locationNode.getHead();

			int result = martyrList.check(txtMartDel.getText(), txtAreaMartDelete, lblMartDelInfo);

			// If the check method returned 1 (one martyr) it will inform the user the the
			// martyr has been found and can be deleted
			if (result == 1) {
				lblMartDelInfo.setText(txtMartDel.getText() + " has been found press delete to delete him/her");
				lblMartDelInfo.setVisible(true);
				txtAreaMartDelete.setVisible(false);
				btMartDel.setVisible(true);
				btMartDel.setOnAction(e1 -> {
					lblMartDelInfo.setVisible(true);
					// If the name was empty it will inform the user
					if (txtMartDel.getText().isEmpty()) {
						lblMartDelInfo.setText("Name is empty!");
					} else {
						// If the name wasn't empty it will be deleted
						martyrList.deleteMartyr1(txtMartDel.getText(), lblMartDelInfo);
						btMartDel.setVisible(false);
						lblMartDateDel.setVisible(false);
						txtMartDateDel.setVisible(false);
					}
				});
			}
			// If the check method returned a number greater than 1 (more than one martyr)
			// it will inform the user that there's more than one martyr with the same name
			else if (result > 1) {
				// Organize the nodes on the scene
				txtAreaMartDelete.setVisible(true);
				btMartDel.setVisible(true);
				lblMartDateDel.setVisible(true);
				txtMartDateDel.setVisible(true);

				// Event handler for the btMartDel button
				btMartDel.setOnAction(e1 -> {
					lblMartDelInfo.setVisible(true);
					// Check if the textFields are empty
					if (!txtMartDel.getText().isEmpty() && !txtMartDateDel.getText().isEmpty()) {
						martyrList.deleteMartyrWithDate(txtMartDel.getText(), txtMartDateDel.getText(), lblMartDelInfo);

						// Organize the nodes on the scene
						btMartDel.setVisible(false);
						lblMartDateDel.setVisible(false);
						txtMartDateDel.setVisible(false);
						txtAreaMartDelete.setVisible(false);
					} else {
						if (txtMartDel.getText().isEmpty()) {
							lblMartDelInfo.setText("Name is empty!");
						} else if (txtMartDateDel.getText().isEmpty()) {
							lblMartDelInfo.setText("You didn't enter the date of death!");
						}
					}
				});
			}
			// If the check method returned zero this means that there is no martyrs with
			// the same name in the list
			else if (result == 0) {
				// Organize the nodes on the scene
				txtAreaMartDelete.setVisible(false);
				lblMartDelInfo.setVisible(true);
				lblMartDateDel.setVisible(false);
				txtMartDateDel.setVisible(false);
				btMartDel.setVisible(false);
				martyrList.deleteMartyr0(txtMartDel.getText(), lblMartDelInfo);
			}
		});

		primaryStage.setTitle("Delete Martyr");
		primaryStage.show();
	}

	// Method that searches for martyr
	private void searchMartScene(Stage primaryStage) {
		// Organize the nodes on the scene
		txtMartDisSea.setText("");
		txtMartLocSea.setText("");
		txtMartSea.setText("");
		btMartSeaMain.setOnAction(e -> returnMain(primaryStage));
		lblMartSeaInfo.setVisible(false);
		txtAreaMartSearch.setVisible(false);

		if(bdPane.getCenter() != vBoxSeaMart)
			bdPane.setCenter(vBoxSeaMart);
		
		// Event handler for the btMartSea button
		btMartSea.setOnAction(e -> {
			lblMartSeaInfo.setText("");
			txtAreaMartSearch.setText("");
			districtList.searchMartyrByName(txtMartDisSea.getText(), txtMartLocSea.getText(), txtMartSea.getText(),
					txtAreaMartSearch, lblMartSeaInfo);
		});

		primaryStage.setTitle("Search Martyr");
		primaryStage.show();
	}

	// Method that checks if the date is in the correct format and valid
	private boolean CorrectDate(String date, Label lbl) {
		// If the date contains "-" and doesn't contain "/" it will return false
		if (date.contains("-") || !date.contains("/")) {
			lbl.setText("Check the date format it should be written (MM/DD/YYYY)");
			return false;
		}

		// If the date didn't contain 3 parts it will return false
		String[] d = date.split("/");
		if (d.length != 3) {
			lbl.setText("Check the date format it should be written (MM/DD/YYYY)");
			return false;
		}

		int year, month, day;
		try {
			day = Integer.parseInt(d[1]);
			month = Integer.parseInt(d[0]);
			year = Integer.parseInt(d[2]);
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			return false;
		} catch (Exception e) {
			return false;
		}

		// If the moth was anything except the numbers form 1-12 it will return false
		if (month < 1 || month > 12) {
			lbl.setText("The date is invalid, check the date format (MM/DD/YYYY)");
			return false;
		}

		int daysInMonth;
		// February
		if (month == 2) {
			if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
				// Leap year
				daysInMonth = 29;
			} else {
				// Non-leap year
				daysInMonth = 28;
			}
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			// April, June, September, November
			daysInMonth = 30;
		} else {
			// All other months
			daysInMonth = 31;
		}

		// If the day was between 1 and 31 it will return true
		if (day >= 1 && day <= daysInMonth) {
			return true;
		} else {
			lbl.setText("The date is invalid, check the date format (MM/DD/YYYY)");
			return false;
		}

	}

	// Method that switch the case to the main window
	private void returnMain(Stage stage) {
		stage.setScene(sceneMain);
		if(bdPane.getCenter() != vBoxMain)
			bdPane.setCenter(vBoxMain);
		stage.setTitle("Main Window");
		stage.show();
	}

	// Method that clears all the textFields and organize the nodes
	private void clear() {
		txtMartName.clear();
		txtMartAge.clear();
		txtMartDis.clear();
		txtMartLoc.clear();
		txtMartDate.clear();
		rbMale.setSelected(false);
		rbFemale.setSelected(false);
		rbUnknown.setSelected(false);
		lblMartInstInfo.setText("");
		lblMartInstInfo.setVisible(false);
	}

	// Method that checks if the string was a digit or not
	private boolean isNumeric(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i)))
				return false;
		}
		return true;
	}

	private void MartUpdButton(Stage primaryStage, MartyrLinkedList martyrList, DistrictNode districtNode) {
		// Organize the nodes on the scene
		if(bdPane.getCenter() != vBoxInstMart)
			bdPane.setCenter(vBoxInstMart);
		primaryStage.show();
		lblMartInstInfo.setText("");
		lblMartInstInfo.setVisible(false);
		btMartUpd.setVisible(true);
		btMartInst.setText("Update");

		btMartInstMain.setOnAction(e -> returnMain(primaryStage));

		btMartClear.setOnAction(e -> clear());

		btMartInst.setOnAction(e2 -> {
			String name, date, location, district;
			// If all fields were empty it will inform the user
			if (txtMartName.getText().trim().isEmpty() && txtMartAge.getText().isEmpty()
					&& txtMartLoc.getText().isEmpty() && txtMartDis.getText().isEmpty()
					&& txtMartDate.getText().isEmpty()) {
				lblMartInstInfo.setVisible(true);
				lblMartInstInfo.setText("Fileds are empty");
				return;
			}
			// If the name was empty it will inform the user
			if (txtMartName.getText().trim().isEmpty()) {
				lblMartInstInfo.setVisible(true);
				lblMartInstInfo.setText("Name is empty");
				return;
			} else {
				name = txtMartName.getText();
			}

			date = txtMartDate.getText();
			// If the date was empty it will inform the user
			if (date.isEmpty()) {
				lblMartInstInfo.setVisible(true);
				lblMartInstInfo.setText("Date is empty");
				return;
			}
			// Checks if the date was in the correct format
			else if (!CorrectDate(date, lblMartInstInfo)) {
				lblMartInstInfo.setVisible(true);
				return;
			}

			byte age = -2;
			try {
				// If the age was empty it will inform the user
				if (txtMartAge.getText().trim().isEmpty()) {
					age = -1;
					lblMartInstInfo.setVisible(true);
					lblMartInstInfo.setText("Warning: Age is empty!");
				} else {
					age = Byte.parseByte(txtMartAge.getText());
					if (age < 0) {
						lblMartInstInfo.setVisible(true);
						lblMartInstInfo.setText("Age must be greater or equal to zero!");
						return;
					}
				}
			} catch (NumberFormatException e1) {
				lblMartInstInfo.setVisible(true);
				lblMartInstInfo.setText("Please an integer for the age not a string!");
				return;
			}
			// If the location was empty it will inform the user
			if (txtMartLoc.getText().trim().isEmpty()) {
				lblMartInstInfo.setVisible(true);
				lblMartInstInfo.setText("Event Location is empty");
				return;
			} else {
				location = txtMartLoc.getText();
			}

			// If the location was empty it will inform the user
			if (txtMartDis.getText().trim().isEmpty()) {
				lblMartInstInfo.setVisible(true);
				lblMartInstInfo.setText("Event Location is empty");
				return;
			} else {
				district = txtMartDis.getText();
			}

			char gender = '?';

			if (rbMale.isSelected())
				gender = 'M';
			else if (rbFemale.isSelected())
				gender = 'F';
			else if (rbUnknown.isSelected())
				gender = 'N';

			// If all fields were entered correctly it will add the new martyr
			if (!name.isEmpty() && (age >= 0 || age == -1) && !location.isEmpty() && !district.isEmpty()
					&& !date.isEmpty()) {
				// If no gender was selected it will throw an exception
				if (gender != 'M' && gender != 'F' && gender != 'N') {
					lblMartInstInfo.setVisible(true);
					lblMartInstInfo.setText("Choose a gender!");
					return;
				}
			}
			// If the martyr wasn't found in any other district, update it
			if (!districtList.searchMartyr(new Martyr(name, date, age, location, district, gender), lblMartInstInfo)) {
				lblMartInstInfo.setVisible(true);
				districtList.updateMartyr(districtNode, martyrList, txtMartDisUpd.getText(), txtMartLocUpd.getText(),
						txtOldMartUpd.getText(), new Martyr(name, date, age, location, district, gender),
						txtAreaDisNavigation, lblMartInstInfo);
			} else { // Notify the user that the martyr already exist
				lblMartInstInfo.setVisible(true);
				lblMartInstInfo.setText(name + " already exist!");
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}

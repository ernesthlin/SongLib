package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SongLib extends Application
{
	private Stage window;
	private BorderPane mainLayout;
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		window = primaryStage;
		window.setTitle("My Song Library");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(SongLib.class.getResource("/view/SongLib.fxml"));
		mainLayout = (BorderPane) loader.load();
		Scene scene = new Scene(mainLayout);
		window.setScene(scene);
		window.setOnCloseRequest(e ->
		{
			//insert save code here
		});
		window.show();
		window.setResizable(false);
	}
	public static void main(String args[])
	{
		launch(args);
	}
}

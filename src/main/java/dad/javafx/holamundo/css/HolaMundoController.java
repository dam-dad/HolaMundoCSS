package dad.javafx.holamundo.css;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * Controlador de la aplicación HolaMundo
 * @author fvarrui
 */
public class HolaMundoController implements Initializable {
	
	// model
	
	private StringProperty nombre = new SimpleStringProperty();
	private StringProperty saludo = new SimpleStringProperty();
	
	// view
	
    @FXML
    private VBox view;

    @FXML
    private TextField nombreText;

    @FXML
    private Button saludarButton;

    @FXML
    private Button despedirButton;

    @FXML
    private Label saludoLabel;
    
    @FXML
    private ImageView animacionImage;
    
    /**
     * Constructor del controlador HolaMundo
     * @throws IOException Error cuando no se encuentra el FXML o hat errores en el documento
     */
    public HolaMundoController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HolaMundoView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		nombre.bind(nombreText.textProperty());
		saludoLabel.textProperty().bind(saludo);
		
//		animacionImage.setImage(new Image("/images/rabbit-cat-sd.gif"));
		
	}

	public VBox getView() {
		return view;
	}
	
	/**
	 * Acción que se realiza al pulsar el botón despedir 
	 * @param event Información sobre el evento
	 */
    @FXML
    void onDespedirAction(ActionEvent event) {
    	saludo.set(("¡Adiós " + nombre.get()).trim() + "!");
    }

    @FXML
    void onSaludarAction(ActionEvent event) {
    	saludo.set(("¡Hola " + nombre.get()).trim() + "!");
    }
    
}

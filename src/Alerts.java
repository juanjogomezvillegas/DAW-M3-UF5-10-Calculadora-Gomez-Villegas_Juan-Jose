
/*
MIT License

Copyright (c) 2022 Juan José Gómez Villegas

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

*/

//Importa les llibreries de la classe
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Alerts: Model que gestionara els alerts de la calculadora
 * Licència MIT
 * 
 * @author Juan José Gómez Villegas
 * @version 1.0
 * 
 **/
public class Alerts {
    
    /**
     * setError: metode que mostrara un alert amb el missatge indicat per parametre
     * 
     * @param missatge missatge a mostrar en el alert
     **/
    public void setError(String missatge) {
        //Instancia un missatge d'error
        Alert alert = new Alert(AlertType.ERROR);
        //Li assigna el titol, i el contingut (i la capçalera la posa a null)
        alert.setTitle("Hi ha hagut algún Error");
        alert.setHeaderText(null);
        alert.setContentText("Error: "+missatge+" !!!");
        //I li canvia la icona al missatge per la imatge "error.png"
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("img/error.png").toString()));

        //Mostra el missatge
        alert.showAndWait();
    }
    
    /**
     * setError666: metode que mostrara un alert informant que hi ha un error 666 (Numero del Dimoni)
     **/
    public void setError666() {
        //Instancia un missatge d'error
        Alert alert = new Alert(AlertType.ERROR);
        //Li assigna el titol (i la capçalera la posa a null)
        alert.setTitle("Error 666");
        alert.setHeaderText(null);
        //I li canvia la icona al missatge per la imatge "error.png"
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("img/error.png").toString()));
        //I li afageix la imatge "dimoni.png"
        Image image = new Image("img/dimoni.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        //I la posiciona en el cos del missatge on l'indiquem
        imageView.setFitWidth(150);
        imageView.setFitHeight(150);
        imageView.setTranslateX(50);
        imageView.setTranslateY(10);
        alert.setGraphic(imageView);

        //Mostra el missatge
        alert.showAndWait();
    }
    
}

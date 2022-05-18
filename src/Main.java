
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
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

/**
 * Main: Classe Principal de la Calculadora
 * Licència MIT
 * 
 * @author Juan José Gómez Villegas
 * @version 1.0
 * 
 * @see Application
 **/
public class Main extends Application {
    
    /**
     * start: metode que inicia l'escanari de la calculadora
     * 
     * @param stage escenari de la calculadora
     **/
    @Override
    public void start(Stage stage) throws Exception {
        //Afageix la vista amb format .fxml
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        //Afagueix el full d'estils style.css
        root.getStylesheets().add(getClass().getResource("css/style.css").toExternalForm());
        //Instancia l'escena
        Scene scene = new Scene(root);
        
        //Impedeix que es pugui redimensionar la finestra (escenari)
        stage.setResizable(false);
        //Estableix una icona i un titol per a la finestra (escenari)
        stage.getIcons().add(new Image("img/icona.png"));
        stage.setTitle("Calculadora de Juan José Gómez Villegas");
        //Afagueix l'escenari a l'escena principal
        stage.setScene(scene);
        //Mostra l'escenari
        stage.show();
    }

    /**
     * main; metode principal que executara la calculadora
     * 
     * @param args Els Arguments de la línia d'ordres 
     */
    public static void main(String[] args) {
        //Executa l'escenari principal de la caluladora
        launch(args);
    }
    
}

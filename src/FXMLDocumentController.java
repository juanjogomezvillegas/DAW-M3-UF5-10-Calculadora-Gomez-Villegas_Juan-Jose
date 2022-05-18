
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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXMLDocumentController: Controlador que gestionara les accions de la calculadora com escriure, esborrar o calcular
 * Licència MIT
 * 
 * @author Juan José Gómez Villegas
 * @version 1.0
 * 
 * @see Initializable
 **/
public class FXMLDocumentController implements Initializable {
    
    //Crea les variables que corresponen a cada un dels components (Button i TextField) de la calculadora
    @FXML
    private TextField txtOperacio;
    
    @FXML
    private TextField txtResultat;
    
    @FXML
    private Button btn0;
    
    @FXML
    private Button btn1;
    
    @FXML
    private Button btn2;
    
    @FXML
    private Button btn3;
    
    @FXML
    private Button btn4;
    
    @FXML
    private Button btn5;
    
    @FXML
    private Button btn6;
    
    @FXML
    private Button btn7;
    
    @FXML
    private Button btn8;
    
    @FXML
    private Button btn9;
    
    @FXML
    private Button btnPunt;
    
    @FXML
    private Button btnSuma;
    
    @FXML
    private Button btnResta;
    
    @FXML
    private Button btnMultiplicacio;
    
    @FXML
    private Button btnDivisio;
    
    @FXML
    private Button btnModul;
    
    @FXML
    private Button btnIgual;
    
    @FXML
    private Button btnClear;
    
    @FXML
    private Button btnDelete;
    
    //Instancia els Models (Alerts, FXMLDocumentModel i Validar)
    private final Alerts Alerts = new Alerts();
    private final FXMLDocumentModel Model = new FXMLDocumentModel(Alerts);
    private final Validar Validar = new Validar(Model, Alerts);
    
    /**
     * BorrarPantallaAction: metode que esborrara l'input del resultat i/o l'input de l'operació
     * 
     * @param event event registrat a la calculadora (quin boto a cliquat l'usuari)
     **/
    @FXML
    void BorrarPantallaAction(ActionEvent event) {
        //Crea un button a partir de l'event
        Button button = (Button) event.getSource();
        
        //I depén del text del button:
        if (button.getText().equals("AC")) {
            //Esborrar els inputs d'operació i resultat
            txtOperacio.setText("");
            txtResultat.setText("");
            //I Reiniciar els numeros i l'operació
            Model.setNumero1(0f);
            Model.setNumero2(0f);
            Model.setOperacio(-1);
        } else if (button.getText().equals("DEL")) {
            //O Coprovara si l'input d'operació no es buit
            if (!txtOperacio.getText().equals("")) {
                //Si no es buit eliminara l'ultim caracter de l'input d'operació
                txtOperacio.setText(txtOperacio.getText().substring(0, txtOperacio.getText().length()-1));
            } else {
                Alerts.setError("El camp ja es buit");
            }
        }
    }
    
    /**
     * EscriuPantallaAction: metode que escriura a l'input de l'operació
     * 
     * @param event event registrat a la calculadora (quin boto a cliquat l'usuari)
     **/
    @FXML
    void EscriuPantallaAction(ActionEvent event) {
        //Crea un button a partir de l'event
        Button button = (Button) event.getSource();
        
        //I depén del text del button:
        //Fara el calcul
        if (button.getText().equals(btnIgual.getText())) {
            Validar.setValidarIgual(txtOperacio, txtResultat);
            
            //Assignara la operació indicada (+, -, *, / o %)
        } else if (button.getText().equals(btnSuma.getText())) {
            Validar.setValidarOperacio(txtOperacio, txtResultat, 1);
        } else if (button.getText().equals(btnResta.getText())) {
            Validar.setValidarOperacio(txtOperacio, txtResultat, 2);
        } else if (button.getText().equals(btnMultiplicacio.getText())) {
            Validar.setValidarOperacio(txtOperacio, txtResultat, 3);
        } else if (button.getText().equals(btnDivisio.getText())) {
            Validar.setValidarOperacio(txtOperacio, txtResultat, 4);
        } else if (button.getText().equals(btnModul.getText())) {
            Validar.setValidarOperacio(txtOperacio, txtResultat, 5);
            
            //O Escriura el numero a calcular (1, 2, 3, 4, 5, 6, 7, 8, 9, 0) o un Punt que indica els decimals
        } else if (button.getText().equals(btn0.getText())) {
            setNumero(btn0.getText());
        } else if (button.getText().equals(btn1.getText())) {
            setNumero(btn1.getText());
        } else if (button.getText().equals(btn2.getText())) {
            setNumero(btn2.getText());
        } else if (button.getText().equals(btn3.getText())) {
            setNumero(btn3.getText());
        } else if (button.getText().equals(btn4.getText())) {
            setNumero(btn4.getText());
        } else if (button.getText().equals(btn5.getText())) {
            setNumero(btn5.getText());
        } else if (button.getText().equals(btn6.getText())) {
            setNumero(btn6.getText());
        } else if (button.getText().equals(btn7.getText())) {
            setNumero(btn7.getText());
        } else if (button.getText().equals(btn8.getText())) {
            setNumero(btn8.getText());
        } else if (button.getText().equals(btn9.getText())) {
            setNumero(btn9.getText());
        } else if (button.getText().equals(btnPunt.getText())) {
            if (!(txtOperacio.getText().contains("."))) {
                setNumero(btnPunt.getText());
            }
        }
    }
    
    /**
     * keyEvent: metode permet a la calculadora funcionar per teclat
     * 
     * @param event event registrat a la calculadora (quina tecla a cliquat l'usuari)
     **/
    @FXML
    void keyEvent(KeyEvent event) {
        //Si el codi del event per teclat no es null
        //Selecciona la tecla premuda
        if (null != event.getCode()) switch (event.getCode()) {
            //Si es enter, Fara el calcul
            case ENTER:
                Validar.setValidarIgual(txtOperacio, txtResultat);
                break;
            //Si es delete
            case DELETE:
                //Esborrara els inputs d'operació i resultat
                txtOperacio.setText("");
                txtResultat.setText("");
                //I Reiniciara els numeros i l'operació
                Model.setNumero1(0f);
                Model.setNumero2(0f);
                Model.setOperacio(-1);
                break;
            //S es back_space
            case BACK_SPACE:
                //Coprovara si l'input d'operació no es buit
                if (!txtOperacio.getText().equals("")) {
                    //Si no es buit eliminara l'ultim caracter de l'input d'operació
                    txtOperacio.setText(txtOperacio.getText().substring(0, txtOperacio.getText().length()-1));
                } else {
                    Alerts.setError("El camp ja es buit");
                }
                break;
            //Si no es cap dels anteriors no fara res
            default:
                break;
        }
    }
    
    /**
     * initialize: metode que s'executara en executar la calculadora
     * 
     * @param url La ubicació utilitzada per resoldre camins relatius per a l'objecte arrel
     * @param rb Els recursos utilitzats per localitzar l'objecte arrel
     **/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Buidara els inputs de l'operació i el resultat
        txtOperacio.setText("");
        txtResultat.setText("");
        
        //Canvia el Cursor als elements de la calculadora
        txtOperacio.setCursor(Cursor.TEXT);
        txtResultat.setCursor(Cursor.TEXT);
        btn0.setCursor(Cursor.HAND);
        btn1.setCursor(Cursor.HAND);
        btn2.setCursor(Cursor.HAND);
        btn3.setCursor(Cursor.HAND);
        btn4.setCursor(Cursor.HAND);
        btn5.setCursor(Cursor.HAND);
        btn6.setCursor(Cursor.HAND);
        btn7.setCursor(Cursor.HAND);
        btn8.setCursor(Cursor.HAND);
        btn9.setCursor(Cursor.HAND);
        btnPunt.setCursor(Cursor.HAND);
        btnSuma.setCursor(Cursor.HAND);
        btnResta.setCursor(Cursor.HAND);
        btnMultiplicacio.setCursor(Cursor.HAND);
        btnDivisio.setCursor(Cursor.HAND);
        btnModul.setCursor(Cursor.HAND);
        btnIgual.setCursor(Cursor.HAND);
        btnClear.setCursor(Cursor.HAND);
        btnDelete.setCursor(Cursor.HAND);
    }
    
    /**
     * setNumero: metode que escriura el numero escollit per l'usuari a l'input operació de la calculadora
     * 
     * @param text numero escollit per l'usuari
     **/
    private void setNumero(String text) {
        //Escriu el numero indicat per parametre en el input d'operació
        txtOperacio.setText(txtOperacio.getText() + text);
    }
    
}

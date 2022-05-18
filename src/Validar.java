
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
import javafx.scene.control.TextField;

/**
 * Validar: Model que gestionara la validació del resultat i l'operacio de la calculadora
 * Licència MIT
 * 
 * @author Juan José Gómez Villegas
 * @version 1.0
 * 
 **/
public class Validar {
    
    //Crea les variables
    private FXMLDocumentModel Model;
    private Alerts Alerts;
    
    /**
     * Metode Constructor de la classe Validar
     * 
     * @param Model Model principal
     * @param Alerts Model de alerts
     **/
    public Validar(FXMLDocumentModel Model, Alerts Alerts) {
        //Assigna valor a les variables
        this.Model = Model;
        this.Alerts = Alerts;
    }
    
    /**
     * getValidar: metode que validara el camp de l'operacio i si no es correcte retornara un missatge d'error, 
     * si es correcte retornara buit ""
     * 
     * @param txtOperacio camp on està l'operació
     * @return buit ("") si es correcte o un missatge d'error si no ho es
     **/
    private String getValidar(TextField txtOperacio) {
        //Comprova si l'input d'operació es correcte
        if (!txtOperacio.getText().trim().equals("") && !txtOperacio.getText().trim().equals(".") && !txtOperacio.getText().trim().startsWith(".") && !txtOperacio.getText().trim().endsWith(".")) {
            //Si ho es, retorna buit
            return "";
        } else {
            //Si no ho es, el buida i retorna un missatge
            txtOperacio.setText("");
            return "Falta un Numero o S'ha Trobat un Caràcter erròni";
        }
    }
    
    /**
     * setValidarOperacio: metode que validara els camps de l'operacio i el resultat
     * i establira l'operació a calcular
     * 
     * @param txtOperacio camp on està l'operació
     * @param txtResultat camp on està el Resultat
     * @param operacio operacio a calcular
     **/
    public void setValidarOperacio(TextField txtOperacio, TextField txtResultat, int operacio) {
        //Valida l'input amb el metode getValidar
        String validar = getValidar(txtOperacio);
        if (validar.equals("")) {
            //Si retorna una cadena buida, assigna el numero1 i l'operació
            Model.setNumero1(Float.parseFloat(txtOperacio.getText()));
            Model.setOperacio(operacio);
            //I Fa els Canvis en els inputs d'operació i resultat
            txtResultat.setText(txtOperacio.getText());
            txtOperacio.setText("");
        } else {
            //Si retorna un missatge fa saltar un missatge d'error
            Alerts.setError(validar);
        }
    }
    
    /**
     * setValidarIgual: metode que validara els camps de l'operacio i el resultat
     * i executara el metode getResultat per obtenir el resultat
     * i comprovara si el resultat es 666 (Numero del Dimoni)
     * 
     * @param txtOperacio camp on està l'operació
     * @param txtResultat camp on està el Resultat
     **/
    public void setValidarIgual(TextField txtOperacio, TextField txtResultat) {
        //Valida l'input amb el metode getValidar
        String validar = getValidar(txtOperacio);
        if (validar.equals("")) {
            //Si retorna una cadena buida, assigna el numero2
            Model.setNumero2(Float.parseFloat(txtOperacio.getText()));
              
            //Amb el metode getResultat, obté el resultat de l'operació
            float resultat = Model.getResultat();
            
            //I Fa els Canvis en els inputs d'operació i resultat
            txtOperacio.setText(String.valueOf(resultat));
            txtResultat.setText(String.valueOf(resultat));
            //I es Guarda el resultat com a numero1 (Per futures ocacions)
            Model.setNumero1(resultat);          
            
            //Ii amb el metode setDimoni, comprova si el resultat es 666
            Model.setDimoni(txtOperacio, txtResultat);
        } else {
            //Si retorna un missatge fa saltar un missatge d'error
            Alerts.setError(validar);
        }
    }
    
}

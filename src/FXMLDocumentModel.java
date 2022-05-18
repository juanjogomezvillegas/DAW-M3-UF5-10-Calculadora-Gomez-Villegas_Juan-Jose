
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
 * FXMLDocumentModel: Model que gestionara els numeros que calculara i l'operació que fara la calculadora, 
 * i comprovara si el resultat de la calculadora es 666
 * Licència MIT
 * 
 * @author Juan José Gómez Villegas
 * @version 1.0
 * 
 **/
public class FXMLDocumentModel {
    
    //Crea les variables
    private Alerts Alerts;
    private float numero1;
    private float numero2;
    private int operacio;
    
    /**
     * Metode Constructor de la classe FXMLDocumentModel
     * 
     * @param Alerts Model de alerts
     **/
    public FXMLDocumentModel(Alerts Alerts) {
        //Assigna valor a les variables
        this.Alerts = Alerts;
        numero1 = 0f;
        numero2 = 0f;
        operacio = -1;
    }
    
    /**
     * setNumero1: metode que estableix el Primer numero a calcular
     * 
     * @param numero1 Primer numero a calcular
     **/
    public void setNumero1(float numero1) {
        this.numero1 = numero1;
    }
     
    /**
     * setNumero2: metode que estableix el Segon numero a calcular
     * 
     * @param numero2 Segon numero a calcular
     **/
    public void setNumero2(float numero2) {
        this.numero2 = numero2;
    }
    
    /**
     * setOperacio: metode que estableix l'operació a Calcular
     * 
     * @param operacio Operació a Calcular
     **/
    public void setOperacio(int operacio) {
        this.operacio = operacio;
    }
    
    /**
     * getResultat: metode que fa l'operació indicada entre el numero1 i el numero2
     * 
     * @return el resultat de l'operacio (operacio) entre el numero1 i el numero2
     **/
    public float getResultat() {
        //Crea la variable resultat
        float resultat = 0f;
        
        //Selecciona l'operació a calcular
        switch (operacio) {
            //Si es 1, Suma
            case 1:
                resultat = numero1 + numero2;
                break;
            //Si es 2, Resta
            case 2:
                resultat = numero1 - numero2;
                break;
            //Si es 3, Multiplica
            case 3:
                resultat = numero1 * numero2;
                break;
            //Si es 4, Divideix
            case 4:
                resultat = numero1 / numero2;
                break;
            //Si es 5, fa el módul de la divisió (el residu)
            case 5:
                resultat = numero1 % numero2;
                break;
            //Si no es cap dels amteriors, retornara el numero1
            default:
                resultat = numero1;
                break;
        }
        
        //Retorna el resultat
        return resultat;
    }
    
    /**
     * setDimoni: metode que comprova si l'input de l'operació i/o el resultat es 666
     * 
     * @param txtOperacio camp on està l'operació
     * @param txtResultat camp on està el Resultat
     **/
    public void setDimoni(TextField txtOperacio, TextField txtResultat) {
        //Comprova si els inputs contenen decimals
        if (txtOperacio.getText().contains(".") && txtResultat.getText().contains(".")) {
            //Si es compleix extreu des de 0 fins a l'Ultim "." per comprovar si el resultat es 666
            if (txtOperacio.getText().substring(0, txtOperacio.getText().lastIndexOf(".")).equals("666") || txtResultat.getText().substring(0, txtResultat.getText().lastIndexOf(".")).equals("666")) {
                //Si el resultat es 666, fa saltar un missatge d'error
                Alerts.setError666();
                
                //Buida els inputs
                txtOperacio.setText("");
                txtResultat.setText("");
            }
        } else {
            //Si no es compleix extreu des de 0 fins al final per comprovar si el resultat es 666
            if (txtOperacio.getText().substring(0, txtOperacio.getText().length()).equals("666") || txtResultat.getText().substring(0, txtResultat.getText().length()).equals("666")) {
                //Si el resultat es 666, fa saltar un missatge d'error
                Alerts.setError666();
                
                //Buida els inputs
                txtOperacio.setText("");
                txtResultat.setText("");
            }
        }
    }
    
}

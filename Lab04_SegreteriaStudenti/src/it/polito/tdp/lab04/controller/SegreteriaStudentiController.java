package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class SegreteriaStudentiController {
	
	private Model model;
	
    @FXML
    private Button btnCompleta;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> cmbCorsi;

    @FXML
    private Button btnCercaIscrittiCorso;

    @FXML
    private TextField txtMatricola;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	List<Corso> temp=model.getCorsiStud(txtMatricola.getText());
    	if (temp==null){
    		txtResult.appendText("matricola inesistente o studente non iscritto a nessun corso\n");
    	}
//    	else if (){
//    		txtResult.appendText("studente non iscritto a nessun corso");
//    	}
    	else{
	    	for (Corso c:temp){
	    		txtResult.appendText(c.toString()+"\n");
	    	}
    	}
    }
    
    @FXML
    void doCompleta(ActionEvent event) {
    	int a=0;
    	
    	try{
    	a=Integer.parseInt(txtMatricola.getText());
    	}catch(NumberFormatException e){
    		a=0;
    	}
    	
    	if (a>0 && a<=999999){
	    	List<String> temp=model.getStud(txtMatricola.getText());
	    	if (temp!=null){
	    		txtCognome.setText(temp.get(0));
	    		txtNome.setText(temp.get(1));
	    	}
	    	else
	    		txtResult.appendText("studente inesistente\n");
    	}
    	else
    		txtResult.appendText("caratteri errati nella matricola\n");
    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {
    	List<Studente> temp=model.getIscritti(cmbCorsi.getValue());
    	for (Studente s:temp){
    		txtResult.appendText(s.toString()+"\n");
    	}
    }

    @FXML
    void doIscrivi(ActionEvent event) {
    	boolean temp = model.iscrivi(txtMatricola.getText(),cmbCorsi.getValue());
    	if (temp==true)
    		txtResult.appendText("iscrizione avvenuta con successo\n");
    	else
    		txtResult.appendText("impossibile effettuare l'iscrizione\n");
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.setText("");
    	txtMatricola.setText("");
    	txtNome.setText("");
    	txtCognome.setText("");
    }

    public void setModel(Model model) {
    	this.model=model;
    	cmbCorsi.getItems().addAll(model.getCorsi());
    }
    
    @FXML
    void initialize() {
        assert cmbCorsi != null : "fx:id=\"cmbCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
    }
}



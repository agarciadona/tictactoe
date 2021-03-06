package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.util.*;

public class Controller {
    @FXML Button tecla1,tecla2, tecla3,tecla4, tecla5,tecla6,tecla7,tecla8,tecla9;
    @FXML RadioButton PvP,PvE,EvE;
    @FXML Text j1,j2;
    @FXML TextField nombre1, nombre2;
    @FXML Button start;
    boolean turn = false;
    List<Button> tablero = new ArrayList<Button>(){{
        for (Button button : Arrays.asList(tecla1, tecla2, tecla3, tecla4, tecla5, tecla6, tecla7, tecla8, tecla9)) {
            add(button);
        }
    }};
    //clicar las teclas del tablero
    public void clicarBoton(ActionEvent actionEvent){
        if(PvP.isSelected()){
            Button select = (Button) actionEvent.getSource();
            System.out.println(select.getId());
            if(!turn){
                select.setText("X");
                select.setDisable(true);
                turn = true;
            }else{
                select.setText("0");
                select.setDisable(true);
                turn = false;
            }
            ganar();
        }
    }

    public void cerrar(ActionEvent actionEvent) {

    }

    //modos de juego
    public void PvP(){
        if (PvP.isSelected()){
            limpiador();
            j1.setVisible(true);
            nombre1.setVisible(true);
            j2.setVisible(true);
            nombre2.setVisible(true);
            start.setVisible(true);
        }
    }

    public void PvE(){
        if(PvE.isSelected()){
            limpiador();
            j1.setVisible(true);
            nombre1.setVisible(true);
            start.setVisible(true);
        }
    }

    public void EvE(){
        limpiador();
        start.setVisible(true);
    }
    //-----------------------------------------------------------


    //rincon del caos
    //-----------------------------------------------------------
    public void darleStart(){
        activartablero();
        limpiarTablero();
    }

    public void limpiador(){
        j1.setVisible(false);
        nombre1.setVisible(false);
        j2.setVisible(false);
        nombre2.setVisible(false);
        start.setVisible(false);
    }

    public void ocultarModos(){
        PvP.setVisible(false);
        PvE.setVisible(false);
        EvE.setVisible(false);
    }

    public void limpiarTablero(){
        for (Button button : Arrays.asList(tecla1, tecla2, tecla3, tecla4, tecla5, tecla6, tecla7, tecla8, tecla9)) {
            button.setText("?");
        }
    }

    //para cuando empieza o termina la partida
    public void activartablero(){
        for (Button button : Arrays.asList(tecla1, tecla2, tecla3, tecla4, tecla5, tecla6, tecla7, tecla8, tecla9)) {
            button.setDisable(false);
        }
    }

    public void desactivartablero(){
        for (Button button : Arrays.asList(tecla1, tecla2, tecla3, tecla4, tecla5, tecla6, tecla7, tecla8, tecla9)) {
            button.setDisable(true);
        }
    }
    //----------------------------------
    public boolean ganar(){
        if(ganaX()){
            System.out.println("Guanya en"+ nombre1.getText()+"!!");
            desactivartablero();
            PvP.setVisible(true);
            PvE.setVisible(true);
            EvE.setVisible(true);
            return true;
        }
        if(gana0()){
            System.out.println("Guanya en"+ nombre2.getText()+"!!");
            desactivartablero();
            PvP.setVisible(true);
            PvE.setVisible(true);
            EvE.setVisible(true);
            return true;
        }
        return false;
    }
//checks de victorias de los jugadores
    public boolean gana0() {
        if ((tecla1.getText().equals("0") && tecla2.getText().equals("0") && tecla3.getText().equals("0")) ||
                (tecla1.getText().equals("0") && tecla4.getText().equals("0") && tecla7.getText().equals("0")) ||
                (tecla1.getText().equals("0") && tecla5.getText().equals("0") && tecla9.getText().equals("0")) ||
                (tecla2.getText().equals("0") && tecla5.getText().equals("0") && tecla8.getText().equals("0")) ||
                (tecla3.getText().equals("0") && tecla6.getText().equals("0") && tecla9.getText().equals("0")) ||
                (tecla3.getText().equals("0") && tecla5.getText().equals("0") && tecla7.getText().equals("0")) ||
                (tecla4.getText().equals("0") && tecla5.getText().equals("0") && tecla6.getText().equals("0")) ||
                (tecla7.getText().equals("0") && tecla8.getText().equals("0") && tecla9.getText().equals("0"))) {
            return true;
        }else{return false;}

        }

    public boolean ganaX() {
        if ((tecla1.getText().equals("X") && tecla2.getText().equals("X") && tecla3.getText().equals("X")) ||
                (tecla1.getText().equals("X") && tecla4.getText().equals("X") && tecla7.getText().equals("X")) ||
                (tecla1.getText().equals("X") && tecla5.getText().equals("X") && tecla9.getText().equals("X")) ||
                (tecla2.getText().equals("X") && tecla5.getText().equals("X") && tecla8.getText().equals("X")) ||
                (tecla3.getText().equals("X") && tecla6.getText().equals("X") && tecla9.getText().equals("X")) ||
                (tecla3.getText().equals("X") && tecla5.getText().equals("X") && tecla7.getText().equals("X")) ||
                (tecla4.getText().equals("X") && tecla5.getText().equals("X") && tecla6.getText().equals("X")) ||
                (tecla7.getText().equals("X") && tecla8.getText().equals("X") && tecla9.getText().equals("X"))) {
            return true;
        }else{return false;}

    }
//-----------------------------------------------------------

    }


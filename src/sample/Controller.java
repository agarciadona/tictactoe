package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    int maxTurn = 9;
    int contador = 0;
    Random random = new Random();
    List<Button> tablero = new ArrayList<Button>(){{
        for (Button button : Arrays.asList(tecla1, tecla2, tecla3, tecla4, tecla5, tecla6, tecla7, tecla8, tecla9)) {
            add(button);
        }
    }};

    List<Button> tableroCPU = new ArrayList<>();

    //clicar las teclas del tabler
    public void clicarBoton(ActionEvent actionEvent){
        if(PvP.isSelected()){
            ocultarModos();
            Button select = (Button) actionEvent.getSource();
            if(!turn){
                System.out.println(select.getText());
                select.setText("X");
                select.setDisable(true);
                turn = true;
                contador++;
            }else{
                select.setText("0");
                select.setDisable(true);
                turn = false;
                contador++;
            }
            ganar();
        }

        if(PvE.isSelected()){
            ocultarModos();
            Button select = (Button) actionEvent.getSource();
            if(!turn);
            turn = true;
            select.setDisable(true);
            contador++;
            if(select.getId().equals("tecla1")){
                tableroCPU.remove(tecla1);
            }
            if(select.getId().equals("tecla2")){
                tableroCPU.remove(tecla2);
            }
            if(select.getId().equals("tecla3")){
                tableroCPU.remove(tecla3);
            }
            if(select.getId().equals("tecla4")){
                tableroCPU.remove(tecla4);
            }
            if(select.getId().equals("tecla5")){
                tableroCPU.remove(tecla5);
            }
            if(select.getId().equals("tecla6")){
                tableroCPU.remove(tecla6);
            }
            if(select.getId().equals("tecla7")){
                tableroCPU.remove(tecla7);
            }
            if(select.getId().equals("tecla8")){
                tableroCPU.remove(tecla8);
            }
            if(select.getId().equals("tecla9")){
                tableroCPU.remove(tecla9);
            }
            maxTurn--;
        }else{
            if(turn){
                int i = random.nextInt(maxTurn);
                tableroCPU.get(i).setText("0");
                turn = false;
                tableroCPU.remove(i);
                maxTurn--;
            }
        }
        ganar();
    }

    //modos de juego
    public void PvP(){
        if (PvP.isSelected()){
            limpiarTablero();
            limpiador();
            j1.setVisible(true);
            nombre1.setVisible(true);
            j2.setVisible(true);
            nombre2.setVisible(true);
            start.setVisible(true);
        }
    }

    public void PvE(){
         contador = 0;
        if(PvE.isSelected()){
            limpiador();
            j1.setVisible(true);
            nombre1.setVisible(true);
            start.setVisible(true);
        }
    }

    public void EvE(){
        contador = 0;
        limpiador();
        start.setVisible(true);
    }
    //-----------------------------------------------------------


    //rincon del caos
    //-----------------------------------------------------------
    public void ocultarModos(){
        PvP.setVisible(false);
        PvE.setVisible(false);
        EvE.setVisible(false);
        j1.setVisible(false);
        j2.setVisible(false);
    }
    public void revelarModos(){
        PvP.setVisible(true);
        PvE.setVisible(true);
        EvE.setVisible(true);
    }

    public void contadorEvE(){
        if(EvE.isSelected()) {
            for (int i = 0; i < 9; i++) {
                UnTurnoCPUs();
                contador++;
                if (ganar()) {
                    break;
                }
            }
            turn = false;
            maxTurn = 9;
        }
    }

    private void UnTurnoCPUs() {
        boolean valido =  false;
            int i = random.nextInt(maxTurn);
            if (!turn) {
                System.out.println(i);
                tableroCPU.get(i).setText("X");
                tableroCPU.remove(i);
                turn = true;


            } else {
                System.out.println(i);
            tableroCPU.get(i).setText("0");
                tableroCPU.remove(i);
                turn = false;
            }
            maxTurn--;
    }

    public void darleStart(){
        activartablero();
        limpiarTablero();

        if(EvE.isSelected()){
            creartableroCPU();
            limpiarTablero();
            contadorEvE();
        }
        if(PvE.isSelected());
        creartableroCPU();
        limpiarTablero();
    }

    public void limpiador(){
        j1.setVisible(false);
        nombre1.setVisible(false);
        j2.setVisible(false);
        nombre2.setVisible(false);
        start.setVisible(false);
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
            desactivartablero();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Partida acabada");
            alert.setHeaderText(null);
            alert.setContentText("Ha guanyat "+ nombre1.getText());
            alert.showAndWait();
            revelarModos();
            return true;
        }
        if(gana0()){
            desactivartablero();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Partida acabada");
            alert.setHeaderText(null);
            alert.setContentText("Ha guanyat "+ nombre2.getText());
            alert.showAndWait();
            revelarModos();
            return true;
        }
        if(contador == 9 && gana0() == false && ganaX() == false){
            desactivartablero();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Partida acabada");
            alert.setHeaderText(null);
            alert.setContentText("Hi ha hagut un empat");
            alert.showAndWait();
            revelarModos();
            return false;
        }
        else{
            return false;
        }
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

    public void creartableroCPU(){
        for (Button button : Arrays.asList(tecla1, tecla2, tecla3, tecla4, tecla5, tecla6, tecla7, tecla8, tecla9)) {
            tableroCPU.add(button);
        }
    }

//-----------------------------------------------------------

    }


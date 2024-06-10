import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.fxml.FXML;

public class HorasTrabalhadasController {
    @FXML
    private TextField textFieldHoraEntrada;
    @FXML
    private TextField textFieldHoraSaida;
    @FXML
    private Label labelResultado;

    private HorasTrabalhadasView horasTrabalhadasView;
    private Stage stage;

    public HorasTrabalhadasController() {
        this.stage = new Stage();
        this.horasTrabalhadasView = new HorasTrabalhadasView();
        this.horasTrabalhadasView.setController(this);
    }

    public void iniciar() throws Exception {
        this.horasTrabalhadasView.start(this.stage);
        this.stage.show();
    }
    
    @FXML
    public void botaoCalcularClicado(ActionEvent e) {
    try {
        String[] entrada = textFieldHoraEntrada.getText().split(":");
        String[] saida = textFieldHoraSaida.getText().split(":");
        int horaEntrada = Integer.parseInt(entrada[0]);
        int minutoEntrada = Integer.parseInt(entrada[1]);
        int horaSaida = Integer.parseInt(saida[0]);
        int minutoSaida = Integer.parseInt(saida[1]);
        HorasTrabalhadas horasTrabalhadas = new HorasTrabalhadas(horaEntrada, minutoEntrada, horaSaida, minutoSaida);
        double totalHoras = horasTrabalhadas.calcularHoras();
        this.labelResultado.setText(String.format("Total de horas trabalhadas: %.2f", totalHoras));
    } catch (NumberFormatException | ArrayIndexOutOfBoundsException exception) {
        labelResultado.setText("Dados de entrada incompletos ou inválidos");
    }
    }

    @FXML
    public void botaoLimparClicado(ActionEvent e) {
        textFieldHoraEntrada.setText("");
        textFieldHoraSaida.setText("");
        labelResultado.setText("");
    }
}
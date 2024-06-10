import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;

public class HorasTrabalhadasView extends Application {
    private FXMLLoader loader;
    private URL url;

    public HorasTrabalhadasView() {
        this.loader = new FXMLLoader();
        try {
            this.url = new File("horas_trabalhadas.fxml").toURI().toURL();
        } catch (Exception e) {
            System.out.println("Erro na carga do FXML: " + e);
        }
        this.loader.setLocation(this.url);
    }

    public void setController(HorasTrabalhadasController controller) {
        this.loader.setController(controller);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = loader.load();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculadora de Horas Trabalhadas");
        primaryStage.show();
    }
}
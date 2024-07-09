package Application;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Drivers extends Application {

    private TableView<DriverResult> table;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Driver Results");

        ComboBox<String> yearComboBox = new ComboBox<>();
        yearComboBox.getItems().addAll("2016", "2017", "2018", "2019", "2020");
        yearComboBox.setOnAction(event -> loadData(yearComboBox.getValue()));

        table = new TableView<>();
        table.setEditable(false);

        TableColumn<DriverResult, String> nameColumn = new TableColumn<>("Driver Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<DriverResult, Integer> winsColumn = new TableColumn<>("Wins");
        winsColumn.setCellValueFactory(new PropertyValueFactory<>("wins"));

        TableColumn<DriverResult, Integer> pointsColumn = new TableColumn<>("Total Points");
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));

        TableColumn<DriverResult, Integer> rankColumn = new TableColumn<>("Rank");
        rankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));

        table.getColumns().addAll(nameColumn, winsColumn, pointsColumn, rankColumn);

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        vbox.getChildren().addAll(yearComboBox, table);

        Scene scene = new Scene(vbox, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadData(String year) {
        ObservableList<DriverResult> data = getDataForYear(year);
        table.setItems(data);
    }

    private ObservableList<DriverResult> getDataForYear(String year) {
        ObservableList<DriverResult> data = FXCollections.observableArrayList();
        switch (year) {
            case "2016":
                data.addAll(new DriverResult("Driver A", 5, 250, 1),
                        new DriverResult("Driver B", 3, 220, 2),
                        new DriverResult("Driver C", 2, 180, 3));
                break;
            case "2017":
                data.addAll(new DriverResult("Driver D", 6, 260, 1),
                        new DriverResult("Driver E", 4, 230, 2),
                        new DriverResult("Driver F", 3, 200, 3));
                break;
            case "2018":
                data.addAll(new DriverResult("Driver G", 7, 270, 1),
                        new DriverResult("Driver H", 5, 240, 2),
                        new DriverResult("Driver I", 4, 210, 3));
                break;
            case "2019":
                data.addAll(new DriverResult("Driver J", 8, 280, 1),
                        new DriverResult("Driver K", 6, 250, 2),
                        new DriverResult("Driver L", 5, 220, 3));
                break;
            case "2020":
                data.addAll(new DriverResult("Driver M", 9, 290, 1),
                        new DriverResult("Driver N", 7, 260, 2),
                        new DriverResult("Driver O", 6, 230, 3));
                break;
        }
        return data;
    }

    public static class DriverResult {
        private final String name;
        private final int wins;
        private final int points;
        private final int rank;

        public DriverResult(String name, int wins, int points, int rank) {
            this.name = name;
            this.wins = wins;
            this.points = points;
            this.rank = rank;
        }

        public String getName() {
            return name;
        }

        public int getWins() {
            return wins;
        }

        public int getPoints() {
            return points;
        }

        public int getRank() {
            return rank;
        }
    }
}

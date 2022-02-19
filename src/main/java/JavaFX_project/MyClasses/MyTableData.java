package JavaFX_project.MyClasses;

import JavaFX_project.Database.TableCodecs;
import JavaFX_project.Database.TableDaoCodecs;
import JavaFX_project.Database.TableDaoParameterDescription;
import JavaFX_project.Database.TableParameterDescription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class MyTableData {

    private TableDaoParameterDescription parameterDescriptionDao = new TableDaoParameterDescription();
    private List<TableParameterDescription> parameterDescriptionList = parameterDescriptionDao.getAll();
    private ObservableList<TableParameterDescription> parameterDescriptionData =
            FXCollections.observableArrayList(parameterDescriptionList);
    private String strParamDesc = "\n";

    private TableView<TableCodecs> codecsTableView;
    private TableDaoCodecs codecsTableDao = new TableDaoCodecs();
    private List<TableCodecs> codecsTableList = codecsTableDao.getAll();
    private ObservableList<TableCodecs> codecsTableData = FXCollections.observableArrayList(codecsTableList);

    //private TableColumn codec_idColl = new TableColumn("id_kodeka");
    private TableColumn codec_nameColl = new TableColumn();
    private TableColumn frequency_rangeColl = new TableColumn();
    private TableColumn max_kbps_bitrateColl = new TableColumn();
    private TableColumn frame_msColl = new TableColumn();
    private TableColumn max_bits_per_frameColl = new TableColumn();
    private TableColumn algorithmic_delay_msColl = new TableColumn();
    private TableColumn codec_categoryColl = new TableColumn();
    private TableColumn compression_familyColl = new TableColumn();
    private TableColumn compression_variantColl = new TableColumn();
    private TableColumn mipsColl = new TableColumn();
    private TableColumn mosColl = new TableColumn();

    public MyTableData() {
        //codec_idColl.setMinWidth(50);
        //codec_idColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>("codec_id"));
        codec_nameColl.setMinWidth(100);
        codec_nameColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>("codec_name"));
        frequency_rangeColl.setMinWidth(130);
        frequency_rangeColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>("frequency_range"));
        max_kbps_bitrateColl.setMinWidth(150);
        max_kbps_bitrateColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>("max_kbps_bitrate"));
        frame_msColl.setMinWidth(75);
        frame_msColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>("frame_ms"));
        max_bits_per_frameColl.setMinWidth(150);
        max_bits_per_frameColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>("max_bits_per_frame"));
        algorithmic_delay_msColl.setMinWidth(150);
        algorithmic_delay_msColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>(
                "algorithmic_delay_ms"));
        codec_categoryColl.setMinWidth(75);
        codec_categoryColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>("codec_category"));
        compression_familyColl.setMinWidth(75);
        compression_familyColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>("compression_family"));
        compression_variantColl.setMinWidth(75);
        compression_variantColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>(
                "compression_variant"));
        mipsColl.setMinWidth(160);
        mipsColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>("mips"));
        mosColl.setMinWidth(50);
        mosColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>("mos"));

        String allLabelsString[] = {"Nazwa kodeka", "Zakres częstotliwości", "Maksymalna przepływność (kb/s)", "Ramka" +
                " (ms)", "Maksymalna liczba bitów na ramkę", "Opóźnienie algorytmiczne (ms)", "Kategoria kodeka",
                "Rodzina " +
                "kompresji", "Wariant kompresji", "Maksymalna wartość MIPS", "MOS"};
        TableColumn allColumnsCodecs[] = {codec_nameColl, frequency_rangeColl, max_kbps_bitrateColl, frame_msColl,
                max_bits_per_frameColl, algorithmic_delay_msColl, codec_categoryColl, compression_familyColl,
                compression_variantColl, mipsColl, mosColl};

        for (int i = 0; i < allColumnsCodecs.length; i++) {
            Label newLabel = new Label(allLabelsString[i]);
            String strTooltip = parameterDescriptionData.get(i).toString();
            Tooltip tooltip = new Tooltip(strTooltip);
            tooltip.setPrefWidth(300);
            tooltip.setWrapText(true);
            newLabel.setTooltip(tooltip);
            allColumnsCodecs[i].setGraphic(newLabel);
        }
    }

    public TableView<TableCodecs> getCodecsTableView() {
        codecsTableView = new TableView<TableCodecs>();
        codecsTableView.setMinWidth(1240);
        codecsTableData = FXCollections.observableArrayList(codecsTableList);
        codecsTableView.setItems(codecsTableData);
        codecsTableView.getColumns().addAll(codec_nameColl, frequency_rangeColl, max_kbps_bitrateColl, frame_msColl,
                max_bits_per_frameColl, algorithmic_delay_msColl, codec_categoryColl, compression_familyColl,
                compression_variantColl, mipsColl, mosColl); //codec_idColl,
        return codecsTableView;
    }

    public TableView<TableCodecs> getCodecsTableView(ObservableList<TableCodecs> codecsTableData2) {
        codecsTableData = codecsTableData2;
        codecsTableView = new TableView<TableCodecs>();
        codecsTableView.setMinWidth(1240);
        codecsTableView.setItems(codecsTableData2);
        codecsTableView.getColumns().addAll(codec_nameColl, frequency_rangeColl, max_kbps_bitrateColl, frame_msColl,
                max_bits_per_frameColl, algorithmic_delay_msColl, codec_categoryColl, compression_familyColl,
                compression_variantColl, mipsColl, mosColl); // codec_idColl,
        return codecsTableView;
    }

    public String getParametersDescription() {
        if (strParamDesc == "\n") {
            for (int i = 0; i < parameterDescriptionData.size(); i++) {
                strParamDesc = strParamDesc + parameterDescriptionData.get(i) + "\n\n";
            }
        }
        return strParamDesc;
    }

    public String getStringWriteToFile() {
        String strWriteToFile = "";
        for (int i = 0; i < codecsTableData.size(); i++) {
            strWriteToFile = strWriteToFile + codecsTableData.get(i) + "\n";
        }
        return strWriteToFile;
    }
}

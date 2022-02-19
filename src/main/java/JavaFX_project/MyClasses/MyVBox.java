package JavaFX_project.MyClasses;

import JavaFX_project.Database.TableCodecs;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class MyVBox {

    public final Label labelParameterDescription = new Label("Opis parametrów");
    public Text paramDescription = new Text();

    public final Label labelCodecsTable = new Label("Kodeki");

    /* menubutton
    public MenuItem menuItemCodecs = new MenuItem("Kodeki");
    public MenuItem menuItemParameter = new MenuItem("Opis parametrów");
    public MenuButton menuButton; */

    public ChoiceBox choiceBox_codec_name = new ChoiceBox(FXCollections.observableArrayList("-", "AMR-NB", "AMR-WB (G.722.2)", "BV16", "BV32", "G.711", "G.722", "G.722.1", "G.723.1", "G.726", "G.728", "G.729" , "G.729A", "G.729D", "G.729E", "GSM-EFR", "GSM-FR", "GSM-HR", "Speex (NB)", "Speex (WB)", "iLBC"));
    public ChoiceBox choiceBox_Frequency = new ChoiceBox(FXCollections.observableArrayList("-", "Szeroki", "Wąski"));
    public TextField fieldFromMax_kbps_bitrate = new TextField();
    public TextField fieldToMax_kbps_bitrate = new TextField();
    public TextField fieldFromFrame_ms = new TextField();
    public TextField fieldToFrame_ms = new TextField();
    public TextField fieldFromMax_bits_per_frame = new TextField();
    public TextField fieldToMax_bits_per_frame = new TextField();
    public TextField fieldFromAlgorithmic_delay_ms = new TextField();
    public TextField fieldToAlgorithmic_delay_ms = new TextField();
    public ChoiceBox choiceBox_Category = new ChoiceBox(FXCollections.observableArrayList("-", "falowy", "predykcyjny"
    ));
    public ChoiceBox choiceBox_Compression_family = new ChoiceBox(FXCollections.observableArrayList("-", "CELP", "LPC", "MDCT", "NFC", "PCM"));
    public ChoiceBox choiceBox_Compression_variant = new ChoiceBox(FXCollections.observableArrayList("-", "ACELP", "ADPCM", "CELP", "CS-ACELP", "CS-ACELP LPC", "LD-CELP", "LPC", "MLT", "MP-MLQ", "PCM", "RPE-LTP", "SB-ADPCM", "TSNFC", "VSELP"));
    public TextField fieldFromMips = new TextField();
    public TextField fieldToMips = new TextField();
    public TextField fieldFromMos = new TextField();
    public TextField fieldToMos = new TextField();

    public Button searchButton = new Button("Szukaj");
    public Button saveButton = new Button("Zapisz");
    public Button resetButton = new Button("Reset");
    private ToolBar toolBarButtons = new ToolBar();

    private HBox hBox1, hBox2, hBox3, hBox4;

    public MyVBox() {
        /*  menubutton
        labelParameterDescription.setFont(new Font("Arial", 20));
        menuButton = new MenuButton("opcje wyświetlania", null, menuItemCodecs, menuItemParameter); */
        labelCodecsTable.setFont(new Font("Arial", 20));

        /* do szukania */
        // nazwy kodeków
        String[] codec_names = {"-", "AMR-NB", "AMR-WB (G.722.2)", "BV16", "BV32", "G.711", "G.722", "G.722.1", "G.723.1", "G.726", "G.728", "G.729" , "G.729A", "G.729D", "G.729E", "GSM-EFR", "GSM-FR", "GSM-HR", "Speex (NB)", "Speex (WB)", "iLBC"};
        Label labelCodecName = new Label("Nazwa kodeka: ");
        choiceBox_codec_name.setTooltip(new Tooltip("Wybierz nazwę kodeka"));
        choiceBox_codec_name.setValue(codec_names[0]);

        HBox hBoxCodecs = new HBox(labelCodecName, choiceBox_codec_name);
        hBoxCodecs.setSpacing(20);
        hBoxCodecs.setMinWidth(400);

        // zakres_czestotliwosci
        String[] frequency_ranges = {"-", "Szeroki", "Wąski"};
        Label labelFrequency = new Label("Zakres częstotliwości: ");
        choiceBox_Frequency.setTooltip(new Tooltip("Wybierz zakres częstotliwości"));
        choiceBox_Frequency.setValue(frequency_ranges[0]);

        HBox hBoxFrequency = new HBox(labelFrequency, choiceBox_Frequency);
        hBoxFrequency.setSpacing(20);
        hBoxFrequency.setMinWidth(400);

        // maks_przeplywnosc_kbps
        Label labelMax_kbps_bitrate = new Label("Maksymalna przepływność (kb/s) (od - do): ");
        fieldFromMax_kbps_bitrate.setMaxWidth(50);
        fieldToMax_kbps_bitrate.setMaxWidth(50);

        HBox hBoxBitrate = new HBox(labelMax_kbps_bitrate, fieldFromMax_kbps_bitrate, fieldToMax_kbps_bitrate);
        hBoxBitrate.setSpacing(20);
        hBoxBitrate.setMinWidth(350);

        // ramka_ms
        Label labelFrame_ms = new Label("Ramka (ms) (od - do): ");
        fieldFromFrame_ms.setMaxWidth(50);
        fieldToFrame_ms.setMaxWidth(50);

        HBox hBoxFrame = new HBox(labelFrame_ms, fieldFromFrame_ms, fieldToFrame_ms);
        hBoxFrame.setSpacing(20);
        hBoxFrame.setMinWidth(400);

        // maks_ilosc_bitow_na_ramke
        Label labelMax_bits_per_frame = new Label("Maksymalna ilość bitów na ramkę (od - do): ");
        fieldFromMax_bits_per_frame.setMaxWidth(50);
        fieldToMax_bits_per_frame.setMaxWidth(50);

        HBox hBoxBitsPerFrame = new HBox(labelMax_bits_per_frame, fieldFromMax_bits_per_frame,
                fieldToMax_bits_per_frame);
        hBoxBitsPerFrame.setSpacing(20);
        hBoxBitsPerFrame.setMinWidth(400);

        // opoznienie_algorytmiczne_ms
        Label labelAlgorithmic_delay_ms = new Label("Opóźnienie algorytmiczne (ms) (od - do): ");
        fieldFromAlgorithmic_delay_ms.setMaxWidth(50);
        fieldToAlgorithmic_delay_ms.setMaxWidth(50);

        HBox hBoxDelay = new HBox(labelAlgorithmic_delay_ms, fieldFromAlgorithmic_delay_ms,
                fieldToAlgorithmic_delay_ms);
        hBoxDelay.setSpacing(20);
        hBoxDelay.setMinWidth(350);

        // kategoria
        Label labelCategory = new Label("Kategoria kodeka: ");
        String[] codecs_category = {"-", "falowy", "predykcyjny"};
        choiceBox_Category.setTooltip(new Tooltip("Wybierz kategorię kodeka"));
        choiceBox_Category.setValue(codecs_category[0]);

        HBox hBoxCategory = new HBox(labelCategory, choiceBox_Category);
        hBoxCategory.setSpacing(20);
        hBoxCategory.setMinWidth(400);

        // rodzina kompresji
        Label labelCompression_family = new Label("Rodzina kompresji: ");
        String[] compresssions_family = {"-", "CELP", "LPC", "MDCT", "NFC", "PCM"};
        choiceBox_Compression_family.setTooltip(new Tooltip("Wybierz rodzinę kompresji"));
        choiceBox_Compression_family.setValue(compresssions_family[0]);

        HBox hBoxCompressionFamily = new HBox(labelCompression_family, choiceBox_Compression_family);
        hBoxCompressionFamily.setSpacing(20);
        hBoxCompressionFamily.setMinWidth(400);

        // wariant_kompresji
        Label labelCompression = new Label("Wariant kompresji: ");
        String[] compression_types = {"-", "ACELP", "ADPCM", "CELP", "CS-ACELP", "CS-ACELP LPC", "LD-CELP", "LPC", "MLT", "MP-MLQ", "PCM", "RPE-LTP", "SB-ADPCM", "TSNFC", "VSELP"};
        choiceBox_Compression_variant.setTooltip(new Tooltip("Wybierz wariant kompresji"));
        choiceBox_Compression_variant.setValue(compression_types[0]);

        HBox hBoxCompressionVariant = new HBox(labelCompression, choiceBox_Compression_variant);
        hBoxCompressionVariant.setSpacing(20);
        hBoxCompressionVariant.setMinWidth(350);

        // maks_mips
        Label labelMips = new Label("Maksymalna wartość MIPS (od - do): ");
        fieldFromMips.setMaxWidth(50);
        fieldToMips.setMaxWidth(50);

        HBox hBoxMips = new HBox(labelMips, fieldFromMips, fieldToMips);
        hBoxMips.setSpacing(20);
        hBoxMips.setMinWidth(400);

        // mos
        Label labelMos = new Label("MOS (od - do): ");
        fieldFromMos.setMaxWidth(50);
        fieldToMos.setMaxWidth(50);

        HBox hBoxMos = new HBox(labelMos, fieldFromMos, fieldToMos);
        hBoxMos.setSpacing(20);
        hBoxMos.setMinWidth(400);

        hBox1 = new HBox(hBoxCodecs, hBoxFrequency, hBoxBitrate);
        hBox1.setSpacing(20);

        hBox2 = new HBox(hBoxFrame, hBoxBitsPerFrame, hBoxDelay);
        hBox2.setSpacing(20);

        hBox3 = new HBox(hBoxCategory, hBoxCompressionFamily, hBoxCompressionVariant);
        hBox3.setSpacing(20);

        hBox4 = new HBox(hBoxMips, hBoxMos);
        hBox4.setSpacing(20);

        /* przyciski */
        // przycisk do szukania
        Tooltip tooltipSearch = new Tooltip("Pokaż tabele z wynikami według powyższych ustawień.");
        tooltipSearch.setTextAlignment(TextAlignment.CENTER);
        searchButton.setTooltip(tooltipSearch);
        searchButton.setStyle("-fx-font: 20 arial; -fx-base: #b6e7c9;");

        // przycisk do zapisania wyników do pliku tekstowego
        Tooltip tooltipSave = new Tooltip("Stwórz nowy plik w domyślnym folderze o nazwie wyniki.txt z wynikiem " +
                "wyszukiwań. \nJeżeli takowy plik istnieje, zostanie zastąpiony.");
        tooltipSave.setTextAlignment(TextAlignment.CENTER);
        saveButton.setTooltip(tooltipSave);
        saveButton.setStyle("-fx-font: 20 arial; -fx-base: #b6e7c9;");

        // przycisk do zresetowania wyszukiwań
        Tooltip tooltipReset = new Tooltip("Zresetuj wyszukiwania, a następnie wyświetl całą tabelę.");
        tooltipReset.setTextAlignment(TextAlignment.CENTER);
        resetButton.setTooltip(tooltipReset);
        resetButton.setStyle("-fx-font: 20 arial; -fx-base: #b6e7c9;");

        // ToolBar Buttons
        toolBarButtons.getItems().add(searchButton);
        toolBarButtons.getItems().add(new Separator());
        toolBarButtons.getItems().add(saveButton);
        toolBarButtons.getItems().add(new Separator());
        toolBarButtons.getItems().add(resetButton);
        toolBarButtons.setMaxWidth(295);
    }

    public VBox getMyCodecsVBox(TableView<TableCodecs> codecsTableView) {
        VBox myVBox = new VBox();
        myVBox.setSpacing(5);
        myVBox.setPadding(new Insets(10, 0, 0, 10));
        myVBox.getChildren().addAll(labelCodecsTable, codecsTableView, new Separator(), hBox1, hBox2, hBox3, hBox4,
                toolBarButtons); // menuButton,
        return myVBox;
    }

    public VBox getMyParameterVBox(String strParamDesc) {
        VBox myVBox = new VBox();
        paramDescription = new Text(strParamDesc);
        paramDescription.setFont(new Font("Arial", 15));
        paramDescription.wrappingWidthProperty().set(1200);
        myVBox.setSpacing(5);
        myVBox.setPadding(new Insets(10, 0, 0, 10));
        myVBox.getChildren().addAll(labelParameterDescription, paramDescription); // menuButton,
        return myVBox;
    }
}

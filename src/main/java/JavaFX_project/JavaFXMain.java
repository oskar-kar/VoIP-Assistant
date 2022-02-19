package JavaFX_project;

import JavaFX_project.Database.TableCodecs;
import JavaFX_project.Database.TableDaoCodecs;
import JavaFX_project.MyClasses.MyTableData;
import JavaFX_project.MyClasses.MyVBox;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Pattern;

public class JavaFXMain extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        MyTableData myTableData = new MyTableData();
        MyVBox myVBox = new MyVBox();

        /* wybór co wyświetlać - action
        myVBox.menuItemCodecs.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VBox tempBox = myVBox.getMyCodecsVBox(myTableData.getCodecsTableView());
                Scene scene_2 = new Scene(new Group());
                ((Group) scene_2.getRoot()).getChildren().addAll(tempBox);
                stage.setScene(scene_2);
            }
        });

        myVBox.menuItemParameter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VBox tempBox = myVBox.getMyParameterVBox(myTableData.getParametersDescription());
                Scene scene_2 = new Scene(new Group());
                ((Group) scene_2.getRoot()).getChildren().addAll(tempBox);
                stage.setScene(scene_2);
            }
        });*/

        /* przyciski - action */
        myVBox.searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String codec_name = myVBox.choiceBox_codec_name.getValue().toString(),
                        frequency_type = myVBox.choiceBox_Frequency.getValue().toString(),
                        codec_category = myVBox.choiceBox_Category.getValue().toString(),
                        compression_family = myVBox.choiceBox_Compression_family.getValue().toString(),
                        compression_variant = myVBox.choiceBox_Compression_variant.getValue().toString();

                boolean onlyNumbers = true;
                Pattern pattern = Pattern.compile("([0-9]*)|([0-9]+\\.[0-9]+)");
                if (pattern.matcher(myVBox.fieldFromMax_kbps_bitrate.getText()).matches() == false) {
                    onlyNumbers = false;
                }
                if (pattern.matcher(myVBox.fieldToMax_kbps_bitrate.getText()).matches() == false) {
                    onlyNumbers = false;
                }
                if (pattern.matcher(myVBox.fieldFromFrame_ms.getText()).matches() == false) {
                    onlyNumbers = false;
                }
                if (pattern.matcher(myVBox.fieldToFrame_ms.getText()).matches() == false) {
                    onlyNumbers = false;
                }
                if (pattern.matcher(myVBox.fieldFromMax_bits_per_frame.getText()).matches() == false) {
                    onlyNumbers = false;
                }
                if (pattern.matcher(myVBox.fieldToMax_bits_per_frame.getText()).matches() == false) {
                    onlyNumbers = false;
                }
                if (pattern.matcher(myVBox.fieldFromAlgorithmic_delay_ms.getText()).matches() == false) {
                    onlyNumbers = false;
                }
                if (pattern.matcher(myVBox.fieldToAlgorithmic_delay_ms.getText()).matches() == false) {
                    onlyNumbers = false;
                }
                if (pattern.matcher(myVBox.fieldFromMips.getText()).matches() == false) {
                    onlyNumbers = false;
                }
                if (pattern.matcher(myVBox.fieldToMips.getText()).matches() == false) {
                    onlyNumbers = false;
                }
                if (pattern.matcher(myVBox.fieldFromMos.getText()).matches() == false) {
                    onlyNumbers = false;
                }
                if (pattern.matcher(myVBox.fieldToMos.getText()).matches() == false) {
                    onlyNumbers = false;
                }

                VBox tempBox;
                if (onlyNumbers) {
                    TableDaoCodecs tableDaoCodecs2 = new TableDaoCodecs();
                    List<TableCodecs> tableCodecsList2 = tableDaoCodecs2.getSpecified(codec_name, frequency_type,
                            myVBox.fieldFromMax_kbps_bitrate.getText(), myVBox.fieldToMax_kbps_bitrate.getText(),
                            myVBox.fieldFromFrame_ms.getText(), myVBox.fieldToFrame_ms.getText(),
                            myVBox.fieldFromMax_bits_per_frame.getText(), myVBox.fieldToMax_bits_per_frame.getText(),
                            myVBox.fieldFromAlgorithmic_delay_ms.getText(),
                            myVBox.fieldToAlgorithmic_delay_ms.getText(), codec_category, compression_family,
                            compression_variant, myVBox.fieldFromMips.getText(), myVBox.fieldToMips.getText(),
                            myVBox.fieldFromMos.getText(), myVBox.fieldToMos.getText());
                    if (tableCodecsList2.isEmpty()) {
                        tempBox = myVBox.getMyCodecsVBox(myTableData.getCodecsTableView());
                        Label info = new Label("Żaden rekord nie spełnia podanych warunków.");
                        info.setFont(new Font("Arial", 15));
                        info.setTextFill(Color.RED);
                        tempBox.getChildren().addAll(info);
                    } else {
                        ObservableList<TableCodecs> dataTableCodecs2 =
                                FXCollections.observableArrayList(tableCodecsList2);
                        tempBox = myVBox.getMyCodecsVBox(myTableData.getCodecsTableView(dataTableCodecs2));
                    }
                } else {
                    tempBox = myVBox.getMyCodecsVBox(myTableData.getCodecsTableView());
                    Label info = new Label("W polach parametrów umieszczaj tylko dodatnie wartości liczbowe.");
                    info.setFont(new Font("Arial", 15));
                    info.setTextFill(Color.RED);
                    tempBox.getChildren().addAll(info);
                }
                Scene scene_2 = new Scene(new Group());
                ((Group) scene_2.getRoot()).getChildren().addAll(tempBox);
                stage.setScene(scene_2);
                stage.show();
            }
        });

        myVBox.saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                PrintWriter zapis = null;
                try {
                    zapis = new PrintWriter("wyniki.txt");
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                zapis.println(myTableData.getStringWriteToFile());
                zapis.close();
            }
        });

        myVBox.resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                myVBox.choiceBox_codec_name.setValue("-");
                myVBox.choiceBox_Frequency.setValue("-");
                myVBox.choiceBox_Category.setValue("-");
                myVBox.choiceBox_Compression_family.setValue("-");
                myVBox.choiceBox_Compression_variant.setValue("-");
                myVBox.fieldFromMax_kbps_bitrate.setText("");
                myVBox.fieldToMax_kbps_bitrate.setText("");
                myVBox.fieldFromFrame_ms.setText("");
                myVBox.fieldToFrame_ms.setText("");
                myVBox.fieldFromMax_bits_per_frame.setText("");
                myVBox.fieldToMax_bits_per_frame.setText("");
                myVBox.fieldFromAlgorithmic_delay_ms.setText("");
                myVBox.fieldToAlgorithmic_delay_ms.setText("");
                myVBox.fieldFromMips.setText("");
                myVBox.fieldToMips.setText("");
                myVBox.fieldFromMos.setText("");
                myVBox.fieldToMos.setText("");

                VBox tempBox = myVBox.getMyCodecsVBox(myTableData.getCodecsTableView());
                Scene scene_2 = new Scene(new Group());
                ((Group) scene_2.getRoot()).getChildren().addAll(tempBox);
                stage.setScene(scene_2);
                stage.show();
            }
        });

        // dodawanie cieni do przyciskow
        DropShadow shadow = new DropShadow();
        myVBox.searchButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                myVBox.searchButton.setEffect(shadow);
            }
        });
        myVBox.searchButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                myVBox.searchButton.setEffect(null);
            }
        });

        myVBox.saveButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                myVBox.saveButton.setEffect(shadow);
            }
        });
        myVBox.saveButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                myVBox.saveButton.setEffect(null);
            }
        });

        myVBox.resetButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                myVBox.resetButton.setEffect(shadow);
            }
        });
        myVBox.resetButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                myVBox.resetButton.setEffect(null);
            }
        });

        // końcowe rzeczy
        stage.setTitle("Aplikacja wspomagająca");
        stage.setWidth(1280);
        stage.setHeight(720);
        VBox vBox = myVBox.getMyCodecsVBox(myTableData.getCodecsTableView());
        Scene scene = new Scene(new Group());

        boolean first = true;
        if (first) {
            ((Group) scene.getRoot()).getChildren().addAll(vBox);
            stage.setScene(scene);
            first = false;
        }
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

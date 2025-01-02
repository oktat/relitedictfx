/*
* File: MainController.java
* Author: Sallai András
* Copyright: 2025, Sallai András
* Date: 2025-01-02
* Web: https://szit.hu
*
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; either version 2
* of the License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details:
* http://www.gnu.org/licenses/gpl.html
*
*/

package lan.zold;

import java.io.FileWriter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MainController {

    /*
     * Add button
     */
    @FXML
    private Button ab;

    /* Delete button */
    @FXML
    private Button db;

    @FXML
    private Button deleteallButton;

    /* Fruit list */
    @FXML
    private ListView<String> fru;

    @FXML
    private Button modifyButton;

    @FXML
    private Button saveButton;

    @FXML
    private TextField wordTextField;

    @FXML
    private void initialize() {
        fru.getItems().addAll("körte", "galagonya", "alma", "málna", "barack", "áfonya", "szőlő", "som", "meggy", "szilva");
        ab.setOnAction(event -> {
            fru.getItems().add(wordTextField.getText());
            wordTextField.clear();
        }); //ab.setAction End
        modifyButton.setOnAction(event -> {
            fru.getItems().set(fru.getSelectionModel().getSelectedIndex(), wordTextField.getText());
            wordTextField.clear();
        }); //modifyButton.setAction End
        db.setOnAction(event -> {
            fru.getItems().remove(fru.getSelectionModel().getSelectedIndex());
        }); //db.setAction End
        saveButton.setOnAction(event -> {
            fru.getItems().clear();
        }); //saveButton.setAction End
        deleteallButton.setOnAction(event -> {
            FileWriter fw = null;
            try {
                fw = new FileWriter("list.txt");
                for (String item : fru.getItems()) {
                    System.out.println(item);
                    fw.write(item + "\n");
                }
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

@FXML
void onClickFruitList(MouseEvent event) {
if (event.getClickCount() == 2) {
wordTextField.setText(fru.getSelectionModel().getSelectedItem());
}
}    

}

/*Program name: AppGUI.java
* Author: Laura Amorim
* Date last updated: 03/07/2026
* Purpose: display GUI for user selection
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class AppGUI extends Application {

    private Library library = new Library();
    private ListView<String> listView = new ListView<>();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) 
    {
        stage.setTitle("Laura's library ♡"); //input fields

        TextField titleField = new TextField();
        titleField.setPromptText("Work title");

        TextField authorField = new TextField();
        authorField.setPromptText("Author");

        TextField extraField = new TextField();
        extraField.setPromptText("Genre / Narrator");

        TextField lengthField = new TextField();
        lengthField.setPromptText("Pages / Audio length");

        ComboBox<Integer> ratingBox = new ComboBox<>();
        ratingBox.getItems().addAll(0, 1, 2, 3, 4, 5);
        ratingBox.setValue(0);

        ComboBox<Media.Status> statusBox = new ComboBox<>();
        statusBox.getItems().addAll(Media.Status.values());
        statusBox.setValue(Media.Status.TO_BE_READ);

        Label statLabel = new Label("Reading Status: ");
        Label ratingLabel = new Label("Rating: ");

        ratingBox.setDisable(true);
        statusBox.setOnAction(e -> 
        {
            if (statusBox.getValue() == Media.Status.FINISHED) 
            {
                ratingBox.setDisable(false);
            } else 
                {
                ratingBox.setDisable(true);
                ratingBox.setValue(0);
                }
        });

        RadioButton bookButton = new RadioButton("Book"); //buttons + toggles
        RadioButton audioButton = new RadioButton("Audio Book");
        Button updateButton = new Button("Update entry");

        ToggleGroup group = new ToggleGroup();
        bookButton.setToggleGroup(group);
        audioButton.setToggleGroup(group);
        bookButton.setSelected(true);

        Button addButton = new Button("Add new work");
        Button displayButton = new Button("Display library list");

        addButton.setOnAction(e -> //media creatiion actions
        {
            try
            {
                String title = titleField.getText();
                String author = authorField.getText();
                String extra = extraField.getText();
                int rating = ratingBox.getValue();
                Media.Status status = statusBox.getValue();

                if (bookButton.isSelected()) 
                {
                    int pages = Integer.parseInt(lengthField.getText());
                    Book book = new Book(title, author, extra, pages);
                    book.setStatus(status);
                    book.setRating(rating);
                    library.addBook(book);
                } else 
                    {
                    double length = Double.parseDouble(lengthField.getText());
                    AudioBook audiobook = new AudioBook(title, author, extra, length);
                    audiobook.setStatus(status);
                    audiobook.setRating(rating);
                    library.addAudioBook(audiobook);
                    }

                listView.getItems().add(title + " sucessfully added");

                titleField.clear(); //clears all fields
                authorField.clear();
                extraField.clear();
                lengthField.clear();
                ratingBox.setValue(0);
                statusBox.setValue(Media.Status.TO_BE_READ);
                bookButton.setSelected(true);
        
            } catch (Exception ex)
                {
                    listView.getItems().add("Invalid input. Please try again.");
                }
        });

        listView.setOnMouseClicked(e -> 
        {
            int index = listView.getSelectionModel().getSelectedIndex();

            if  (index < library.getBooks().size()) 
            {
                Book book = library.getBooks().get(index);

                titleField.setText(book.getTitle());
                authorField.setText(book.getAuthor());
                extraField.setText(book.getGenre());
                lengthField.setText(String.valueOf(book.getPages()));
                statusBox.setValue(book.getStatus());
                ratingBox.setValue(book.getRating());

                bookButton.setSelected(true);
            } else 
                {
                    int audioIndex = index - library.getBooks().size();
                    AudioBook audioBook = library.getAudioBooks().get(audioIndex);

                    titleField.setText(audioBook.getTitle());
                    authorField.setText(audioBook.getAuthor());
                    extraField.setText(audioBook.getNarrator());
                    lengthField.setText(String.valueOf(audioBook.getAudioLength()));
                    statusBox.setValue(audioBook.getStatus());
                    ratingBox.setValue(audioBook.getRating());

                    audioButton.setSelected(true);
                }
        });

        displayButton.setOnAction(e -> //displays added work actions
        {
            listView.getItems().clear();
            for (Book b : library.getBooks())
            {
                listView.getItems().add(b.toString());
            }

            for (AudioBook a : library.getAudioBooks())
            {
                listView.getItems().add(a.toString());
            }

            listView.getItems().add("Total in library: " + library.getTotal());

        });

        updateButton.setOnAction(e -> //edits entries upon selection
        { 
            int index = listView.getSelectionModel().getSelectedIndex();

            if (index < library.getBooks().size())
            {
                Book book = library.getBooks().get(index);

                book.setTitle(titleField.getText());
                book.setAuthor(authorField.getText());
                book.setGenre(extraField.getText());
                book.setPages(Integer.parseInt(lengthField.getText()));
                book.setStatus(statusBox.getValue());
                book.setRating(ratingBox.getValue());

                listView.getItems().set(index, book.toString());
            } else
                {
                    int audioIndex = index - library.getBooks().size();
                    AudioBook audioBook = library.getAudioBooks().get(audioIndex);

                    audioBook.setTitle(titleField.getText());
                    audioBook.setAuthor(authorField.getText());
                    audioBook.setNarrator(extraField.getText());
                    audioBook.setAudioLength(Double.parseDouble(lengthField.getText()));
                    audioBook.setStatus(statusBox.getValue());
                    audioBook.setRating(ratingBox.getValue());

                    listView.getItems().set(index, audioBook.toString());
                }
        });

        VBox layout = new VBox(10, titleField, authorField, extraField, lengthField,statLabel, statusBox, ratingLabel, ratingBox, //vbox with all items
                                bookButton, audioButton, addButton, displayButton,updateButton, listView);
        layout.setPadding(new Insets(15));
        layout.setStyle("-fx-background-color: #f8f4f4;"); //aesthetic add ons
        addButton.setStyle("-fx-background-color: #d0b5b5;");
        displayButton.setStyle("-fx-background-color: #e4d4d4;");
        updateButton.setStyle("-fx-background-color: #dac5c5;");
        statusBox.setStyle("-fx-background-color: #d0b5b5;");
        ratingBox.setStyle("-fx-background-color: #e4d4d4;");
        statLabel.setStyle("-fx-font-weight: bold;");
        ratingLabel.setStyle("-fx-font-weight: bold;");


        Scene scene = new Scene(layout, 500, 600);
        stage.setScene(scene);
        stage.show();
    
    }
    
}
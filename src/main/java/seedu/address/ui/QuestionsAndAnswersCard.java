package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.question.Question;

/**
 * An UI component that displays information of a {@code Answer}.
 */
public class QuestionsAndAnswersCard extends UiPart<Region> {
    private static final String FXML = "QuestionsAndAnswersListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Question question;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private FlowPane tags;

    public QuestionsAndAnswersCard(Question question, int displayedIndex) {
        super(FXML);
        this.question = question;
        id.setText(displayedIndex + ". ");
        name.setText(question.getQuestion() + " Answer: " + question.getAnswer());
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof QuestionsAndAnswersCard)) {
            return false;
        }

        // state check
        QuestionsAndAnswersCard card = (QuestionsAndAnswersCard) other;
        return name.getText().equals(card.name.getText())
                && question.equals(card.question);
    }
}

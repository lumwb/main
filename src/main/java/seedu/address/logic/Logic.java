package seedu.address.logic;

import java.io.IOException;
import java.nio.file.Path;

import javafx.collections.ObservableList;
import jfxtras.icalendarfx.components.VEvent;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.note.Note;
import seedu.address.model.person.Person;
import seedu.address.model.question.Question;
import seedu.address.model.statistics.Statistics;
import seedu.address.model.student.Student;

/**
 * API of the Logic component
 */
public interface Logic {

    /**
     * Executes the command and returns the result.
     *
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException   If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException, IOException;

    //region AddressBook

    /**
     * Returns the AddressBook.
     *
     * @see seedu.address.model.Model#getAddressBook()
     */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns an unmodifiable view of the filtered list of persons
     */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();
    //endregion

    //region Questions
    /**
     * Returns the list of slideshow questions
     *
     * @see seedu.address.model.Model#getSlideshowQuestions()
     */
    ObservableList<Question> getSlideshowQuestions();
    //endregion

    //region Statistics
    /**
     * Returns an unmodifiable view of the processed statistics of students
     */
    ObservableList<Statistics> getProcessedStatistics();
    //endregion

    //region Notes
    /**
     * Returns an unmodifiable view of the filtered list of notes
     */
    ObservableList<Note> getFilteredNotesList();

    /**
     * Returns the user prefs' notes record file path.
     */
    Path getNotesRecordFilePath();
    //endregion

    /**
     * Returns an unmodifiable view of the filtered list of students
     */
    ObservableList<Student> getFilteredStudentList();

    /**
     * Returns an unmodifiable view of the students in queried group.
     */
    ObservableList<Student> getStudentsInGroup();

    //region VEvents
    ObservableList<VEvent> getVEventList();
    //endregion

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);
}

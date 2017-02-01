package seedu.addressbook.ui;
import static seedu.addressbook.common.Messages.*;
import static seedu.addressbook.ui.Formatter.DISPLAYED_INDEX_OFFSET;
import static seedu.addressbook.ui.Formatter.DIVIDER;
import static seedu.addressbook.ui.Formatter.MESSAGE_INDEXED_LIST_ITEM;
import static seedu.addressbook.ui.Formatter.getIndexedListItem;
import seedu.addressbook.commands.CommandResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class Formatter {
	
    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    public static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    public static final String LS = System.lineSeparator();

    public static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    public static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    public static final String COMMENT_LINE_FORMAT_REGEX = "#.*";
    
    
    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    public static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }
    
    public String getResultToShowToUser(CommandResult result){
    	 final Optional<List<? extends ReadOnlyPerson>> resultPersons = result.getRelevantPersons();
         if (resultPersons.isPresent()) {
             getShowPersonListView(resultPersons.get());
         }
         return result.feedbackToUser + DIVIDER;
    }
    
    /**
     * Shows a list of persons to the user, formatted as an indexed list.
     * Private contact details are hidden.
     */
    private String getShowPersonListView(List<? extends ReadOnlyPerson> persons) {
        final List<String> formattedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : persons) {
            formattedPersons.add(person.getAsTextHidePrivate());
        }
        return getIndexedListForViewing(formattedPersons);
        
    }

}

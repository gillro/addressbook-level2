package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

    @Test
    public void isSimilar() throws IllegalValueException {
        
        //same name
        Name myName = new Name("John Smith");
        Name otherName = new Name("John Smith");
        assertTrue(myName.isSimilar(otherName));
        
        //totally different name
        Name myName2 = new Name("John Smith");
        Name otherName2 = new Name("Jane Kim");
        assertFalse(myName2.isSimilar(otherName2));
    }

}

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
        
        //First name same
        Name myName3 = new Name("John Smith");
        Name otherName3 = new Name("John Tan");
        assertTrue(myName3.isSimilar(otherName3));
        
        //Last name same
        Name myName4 = new Name("John Smith");
        Name otherName4 = new Name("Jane Smith");
        assertTrue(myName4.isSimilar(otherName4));
        
        //First name same as other last name
        Name myName5 = new Name("John Smith");
        Name otherName5 = new Name("Tim John");
        assertTrue(myName5.isSimilar(otherName5));
        
        //lowercase name same name as uppercase name
        Name myName6 = new Name("John Smith");
        Name otherName6 = new Name("john smith");
        assertTrue(myName6.isSimilar(otherName6));
        
        //mixed lowercase/uppercase names that are same
        Name myName7 = new Name("JOHn SMIth");
        Name otherName7 = new Name("JOHN SMITH");
        assertTrue(myName7.isSimilar(otherName7));
        
        //First name same with one extra middle name
        Name myName8 = new Name("John M Smith");
        Name otherName8 = new Name("John Kim");
        assertTrue(myName8.isSimilar(otherName8));
    }

}

package seedu.addressbook.data;

import seedu.addressbook.data.tag.Tag;

public class Tagging {
    String add = "+";
    String deleted = "-";
    Tag tag;
    String op;
    
    public Tagging(String operation, Tag tag){
        if (operation.equals("add")){
            this.op = add;
        }else{
            this.op = deleted;
        }
        this.tag = tag;
    }
}

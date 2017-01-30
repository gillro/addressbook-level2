package seedu.addressbook.data.person;

public class Block {
	
	private String blkNum;
	
	public Block(String blockNumber){
		this.blkNum = blockNumber;
	}
	
	public String getBlock(){
		return this.blkNum;
	}
}

/**
 * Shell blockchain consisting of 3 classes: Block, Blockchain, and TestBlockchain.
 * Implementation of this blockchain consists of:
 * Block#
 * Version
 * Timestamp
 * listing of previous hash
 * Status if block chain is valid
 * 
 */

/**
 * Imported libraries 
 * @param java.util.List: Gives control over where in the list each element is inserted. 
 * 						  The user can access elements by their integer index, and search for elements in the list
 * @param: java.util.ArrayList: Resizable-array implementation of the List interface. Implements all optional list operations, and permits all elements, including null. 
 * 								In adddition to implementing the List interface, this class provides methods to manipulate the size of the array that is used internally
 * 								to store the list. 
 */ 
import java.util.List;
import java.util.ArrayList;

/**
 * Blockchain class which has a constructor(Blockchain), which takes in no parameters. 
 * private list called "chain" that will hold all of the blocks
 * Uses an array listto make the chain dynamic 
 */
public class Blockchain {
	
	private List<Block> chain; 
	
	public Blockchain() {
		
		chain = new ArrayList<Block>();
/**
 * Method created in order to generate Genesis, the first block in a blockchain.  
 * 
 */
		chain.add(generateGenesis());
		
	}
/**
 * new block called "Genesis" 
 * @param Block genesis: 			1. Passes in relevant information such as the version, dates, and synthetic data called <transactions>
 * @param genesis.setPreviousHash: 	2. Points to null since the Genesis block points to nothing
 * @return genesis: 				3. Adds to the chain
 */
	private Block generateGenesis() {
		Block genesis = new Block("0x200", new java.util.Date(), "<transactions>");
		genesis.setPreviousHash(null); 
		genesis.computeHash();
		return genesis;
	}
	
/**
 * Method that adds a block to the chain
 * 
 * @param blk takes in an argument of type Block 
 * @param chain: stores all of the blocks
 * @param newBlock: Creates a new block and sets it to that block 
 * @param newBlock.setPreviousHash: gets the last block added to the chain and get the hash of the last block. 
 * @param newBlock.computeHash(): now that previous hash has been set, we now need to compute the hash for the block
 * @param this.chain.add(newBlock): with new hash computed with previous hash, this is added to the blockchain. 
 */
	public void addBlock(Block blk) {
		Block newBlock = blk;
		newBlock.setPreviousHash(chain.get(chain.size()-1).getHash());
		newBlock.computeHash();
		this.chain.add(newBlock);
	}
/**
 * Method that displays the content of the chain
 * Loops through the chain, gets all of the data via the getters and setter implemented in Block class 
 * @param chain.get(i).getVersion())
 * @param chain.get(i).getTimestamp())
 * @param chain.get(i).getPreviousHash())
 */
	public void displayChain() {
		for(int i=0;i<chain.size();i++) {
			System.out.println("Block: " + i);
			System.out.println("Version: " + chain.get(i).getVersion());
			System.out.println("Timestamp: " + chain.get(i).getTimestamp());
			System.out.println("PreviousHash: " + chain.get(i).getPreviousHash());
			System.out.println();
		}
	}
/**
 * Method that allows the user to tamper with the block chain	
 * @return this.chain.get(chain.size()-1)
 */
	public Block getLatestBlock() {
		return this.chain.get(chain.size()-1);
	}
	
/** 
 * Method that correctyl verifies the validity of the chain. 
 * Tests 2 paramenters for validity: 
 * @param if( !(chain.get(i).getHash().equals(chain.get(i).computeHash())) ): checks thats computing the hash of the block is equal to
 * 																			  the hash stored in the block.
 * @param if( !(chain.get(i).getPreviousHash().equals(chain.get(i-1).computeHash())) ): checks that the previous hash of the block is
 * 																						equal to the computed hash of that block
 * 	@see if user gets the previous hash and actually compute the hash of the previous block, then they should be equal, if they are not equal then the chain is not valid
 * 
 *  @return breaks out of the for loop implement, if it doesnt break out of the for loop, then the chain is valid. 																		   
 */
	public void isValid() {
		
		for(int i=chain.size()-1;i>0;i--) {
			if( !(chain.get(i).getHash().equals(chain.get(i).computeHash())) ) {
				System.out.println("Chain is not valid");
				return;
			}
			
			if( !(chain.get(i).getPreviousHash().equals(chain.get(i-1).computeHash())) ) {
				System.out.println("Chain is not valid");
				return;
			}
		}
		
		System.out.println("Chain is valid");
			
			
		}
	
}

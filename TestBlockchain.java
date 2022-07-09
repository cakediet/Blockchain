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
public class TestBlockchain {

	/**
	 * Main method with Object where the coin is called. 3 blocks are created where data is passsed through, then added to the blockchain.
	 * The chain is then displayed.
	 * @see to determine if the chain has been linked successfully, notice the previous hash and compare to next block. 
	 * 	@see isValid: 
	 * @see getLatestBlock().setPreviousHash("") this will allow the user to tamper with the previous hash and break the block chain.
	 * @param args
	 */
	
	public static void main(String args[]) {
		
		Blockchain AlexCoin = new Blockchain();
		
		Block a = new Block("0x200", new java.util.Date(), "<transactions>");
		Block b = new Block("0x200", new java.util.Date(), "<transactions>");
		Block c = new Block("0x200", new java.util.Date(), "<transactions>");
		
		AlexCoin.addBlock(a);
		AlexCoin.addBlock(b);
		AlexCoin.addBlock(c);
		
		AlexCoin.getLatestBlock().setPreviousHash("ABCDEFG");
		
		AlexCoin.displayChain();
		
		AlexCoin.isValid();
		
	}

}

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

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

public class Block {
/**
 * Declares information for the header section
 */
	private String version;
	private Date Timestamp;
	private String hash;
	private String previousHash;
	private String data;
/**
 * Constructor called block. Takes in 3 arguments(version, timestamp, data). Initializes version, timestamp, data.  	
 * 
 * @param version
 * @param timestamp
 * @param data
 * @param hash: is computed when it gets called/ created as an object. Therefore, computeHash().   
 */
	public Block(String version, Date timestamp, String data) {
		this.version = version;
		this.Timestamp = timestamp;
		this.data = data;
		this.hash = computeHash();
	}
	
/**
 * Method implemented where the SHA-256 hash function is calculated onto some data. 
 * @see: https://www.freeformatter.com/sha256-generator.html#sha256-explained
 * 		  - Hashes are one-way functions, taking in data and outputting data called a digest. 
 * @param: this.hash: sets the has of the block, 
 * @return the hash of the block 
 */
	public String computeHash() {
		
		String dataToHash = "" + this.version + this.Timestamp + this.previousHash + this.data;//concatenates the data of the header section
		//then passes into the hash function, then placed into a variable called encoded. 
		
		MessageDigest digest;
		String encoded = null;
		
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8));
			encoded = Base64.getEncoder().encodeToString(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		this.hash = encoded;
		return encoded;
		
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(Date timestamp) {
		Timestamp = timestamp;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
	
}

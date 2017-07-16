package dna;

/**
* FastqRecord contains the defline, sequence, and quality string
* from a record in a fastq file.
*/


public class FastqRecord implements DNARecord, Comparable<FastqRecord> 
{
	private String 		defline;
	private String		sequence;
	private String		quality;

	/**
	 * Ctor for FastqRecord
	 * @param defline 
	 * @param sequence
	 * @param quality
	 * @throws RecordFormatException if defline does not contain '@' as first char
	 */
	public FastqRecord (String defline, String sequence, String quality) throws RecordFormatException
	{
		if (!(defline.charAt(0) == '@')){
			throw new RecordFormatException("Bad first char in defline fastq record: saw " + defline.substring(0,1) + ", expected '@'");
		}
		this.defline = defline;
		this.sequence = sequence;
		this.quality = quality;
	}
	
	/**
	 * Implementation from DNARecord
	 */
	@Override
	public String getDefline(){
		return defline;
	}
	
	/**
	 * Implementation from DNARecord
	 */
	@Override
	public String getSequence(){
		return sequence;
	}

	/**
	 * Check for deep equality between FastqRecord objects 
	 * by comparing defline, sequence, and quality instance variables using compareTo method
	 * @return true or false
	 */
	@Override
	public boolean equals(Object other){
		FastqRecord fastqOther = (FastqRecord) other;
		return this.compareTo(fastqOther) == 0;
	}
	
	public int compareTo(FastqRecord other){
		if (this.defline.compareTo(other.defline) != 0){
			return this.defline.compareTo(other.defline);
		}
		else if (this.sequence.compareTo(other.sequence) != 0){
				return this.sequence.compareTo(other.sequence);
			}
		else return this.quality.compareTo(other.quality);
	}
	
	/**
	 * Returns the sum of the hash codes of defline, sequence and quality instance variables
	 */
	@Override
	public int hashCode(){
		return this.defline.hashCode() + this.sequence.hashCode() + this.quality.hashCode();
	}
	
	/**
	 * 
	 * @return true if quality instance variable contains three exclamation points ('!')
	 */
	public boolean qualityIsHigh()
	{
		int numberOfExclamationPoints = 0;
		for(int i = 0; i < quality.length(); i++){
			char currentChar = quality.charAt(i);
			if (currentChar == '!'){
				numberOfExclamationPoints++;
			}
		}
		if (numberOfExclamationPoints >= 3){
			return true;
		}
		else return false;
	}
	

	/**
	 * return a string consisting of defline, followed by a newline, followed by sequence, followed by a newline, followed by quality
	 */
	public String toString()
	{
		return defline + "\n" + sequence + "\n" + quality;
	}

}

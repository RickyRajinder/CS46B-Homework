package dna;


public class FastaRecord implements DNARecord, Comparable<FastaRecord> 
{	
	private String defline;
	private String sequence;
	
	/**
	 * Ctor for FastaRecord
	 * @param defline
	 * @param sequence
	 * @throws RecordFormatException if defline does not start with '>' char
	 */
	public FastaRecord(String defline, String sequence) throws RecordFormatException
	{
		if (!(defline.substring(0,1).equals(">")) ){
			throw new RecordFormatException("Bad first char in defline fasta record: saw " + defline.substring(0,1) + ", expected '>'");
		}
		this.defline = defline;
		this.sequence = sequence;
	}
	
	
	/**
	 * Second ctor for FastaRecord
	 * @param fastqRec takes a FastqRecord as the arg
	 * replaces the first char in the defline with '>'
	 */
	public FastaRecord(FastqRecord fastqRec)
	{
		this.defline = fastqRec.getDefline().replace("@", ">");
		this.sequence = fastqRec.getSequence();
	}

	/**
	 * DNARecord implementation
	 * @return the defline
	 */
	public String getDefline(){
		return defline;
	}
	
	/**
	 * DNARecord Implementation
	 * @return the sequence
	 */
	public String getSequence(){
		return sequence;
	}
	
	/**
	 * Check for deep equality between FastqRecord objects 
	 * by comparing defline and sequence instance variables using compareTo method
	 * @return true or false
	 */
	@Override
	public boolean equals(Object other){
		FastaRecord fastaOther = (FastaRecord) other;
		return this.compareTo(fastaOther) == 0;
	}
	
	/**
	 * Used to implement best practice equals method
	 */
	public int compareTo(FastaRecord other){
		if (this.defline.compareTo(other.defline) != 0){
			return this.defline.compareTo(other.defline);
		}
		else return this.sequence.compareTo(other.sequence);
			}
	
	/**
	 * @return a string consisting of the defline, a newline char, the sequence, and a newline char
	 */
	public String toString(){
		return defline + "\n" + sequence + "\n";
	}

	/**
	 * @return the sum of the hash codes of defline and sequence
	 */
	@Override
	public int hashCode(){
		return defline.hashCode() + sequence.hashCode();
	}
}

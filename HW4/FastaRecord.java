package dna;


public class FastaRecord implements DNARecord 
{	
	//
	// Add a precondition check: throw FastqException if the 1st char of the defline is 
	// not '>'. You will have to change the ctor declaration to say that it throws
	// the exception. The exception should contain a useful informative message.
	//
	public FastaRecord(String defline, String sequence)
	{
	}
	
	
	// Initialize defline and sequence from the input record. The defline should be the
	// defline of the fastq record, but with a '>' in the first position rather than a '@'.
	public FastaRecord(FastqRecord fastqRec)
	{

	}
	
	

	// 
	// Provide the 2 methods that satisfy the interface.
	//

	
	
	//
	// Provide an equals() method. 
	//
	


	
	
	//
	// Provide a toString () method. 
	//
	

	//
	// Provide a hashCode() method that returns the sum of the hashcodes of 
	// defline and sequence.
	//
}

package dna;

/**
 * Subclass of exception, uesd if fastq or fasta input does not accepted 
 * @author singh
 *
 */
public class RecordFormatException extends Exception
{
	public RecordFormatException(String message)
	{
		super(message);
	}
}

package dna;

import java.io.*;


/**
 * Uses PrintWriter to write a fasta record
 * @author singh
 *
 */


public class FastaWriter 
{
	private PrintWriter thePrintWriter;
	
	public FastaWriter(PrintWriter thePrintWriter){
		this.thePrintWriter = thePrintWriter;
	}
	
	/**
	 * Writes the defline and the sequence of a fasta record on two separate lines
	 * @param rec a Fasta record to write
	 * @throws IOException
	 */
	public void writeRecord(FastaRecord rec) throws IOException
	{
		thePrintWriter.println(rec.getDefline());
		thePrintWriter.println(rec.getSequence());
		
	}
}

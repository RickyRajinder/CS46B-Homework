package dna;

/**
 * Interface with methods to return the defline and the sequence of a fasta record or a fastq record
 * @author singh
 *
 */
public interface DNARecord 
{
	String		getDefline();
	String		getSequence();
}

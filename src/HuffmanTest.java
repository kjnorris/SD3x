import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HuffmanTest {

	/*
	@Test
	void testHuffman() {
		Huffman test = new Huffman("aaabbc");
		fail("Not yet implemented");
	}
	*/

	@Test
	void testEncode() {
		String myInput = "abcdabcaba";
		Huffman test = new Huffman(myInput);
		
		assertEquals("0101111100101110100", test.encode());
	}

	@Test
	void testDecode() {
		String myInput = "abcdabcaba";
		Huffman test = new Huffman(myInput);
		assertEquals(myInput, test.decode("0101111100101110100"));
	}

}

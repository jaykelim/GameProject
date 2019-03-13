package LaptopR;

public interface TextFileIOer {
	public String read1LineFromFile(String fileName);
	public String readFile(String fileName);
	public String readDelimetedFile(String fileName);
	
	public void createNewFile(String fileName);
	public void writeToNewFile(String fileName, String fileContent);
	public void appendToFile(String fileName, String fileContent);

	public boolean copyFile(String fileName);
	public boolean copyFile(String fileName1, String fileName2);
	public boolean deleteFile(String fileName);

}

package vo;

public class Carousel {
	private String fileId;
	private String filePath;
	private String fileDescribe;
	public Carousel(String fileId, String filePath, String fileDescribe) {
		super();
		this.fileId = fileId;
		this.filePath = filePath;
		this.fileDescribe = fileDescribe;
	}
	public Carousel() {
		super();
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileDescribe() {
		return fileDescribe;
	}
	public void setFileDescribe(String fileDescribe) {
		this.fileDescribe = fileDescribe;
	}
	@Override
	public String toString() {
		return "Carousel [fileId=" + fileId + ", filePath=" + filePath + ", fileDescribe=" + fileDescribe + "]";
	}
	
	
}

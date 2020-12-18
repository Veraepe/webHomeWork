package vo;

public class Menu {
	private String parentName;
	private String itemName;
	private String itemLink;
	private String itemId;
	private String parentId;
	public Menu(String parentName, String itemName, String itemLink, String itemId, String parentId) {
		super();
		this.parentName = parentName;
		this.itemName = itemName;
		this.itemLink = itemLink;
		this.itemId = itemId;
		this.parentId = parentId;
	}
	public Menu() {
		super();
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemLink() {
		return itemLink;
	}
	public void setItemLink(String itemLink) {
		this.itemLink = itemLink;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "Menu [parentName=" + parentName + ", itemName=" + itemName + ", itemLink=" + itemLink + ", itemId="
				+ itemId + ", parentId=" + parentId + "]";
	}
	
	
}

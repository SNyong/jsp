package vo;

public class Inventory {
	private int InventoryNum;
	private int InOutcomming;
	private String I_Date;
	private int ProductCount;
	private int ProductCode;
	private int TotalCount;
	private String ProductName;
	
	

	public Inventory(int inventoryNum, int inOutcomming, String i_Date, int productCount, int productCode,
			int totalCount, String productName) {
		super();
		InventoryNum = inventoryNum;
		InOutcomming = inOutcomming;
		I_Date = i_Date;
		ProductCount = productCount;
		ProductCode = productCode;
		TotalCount = totalCount;
		ProductName = productName;
	}

	public Inventory() {
		super();
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public int getTotalCount() {
		return TotalCount;
	}
	public void setTotalCount(int totalCount) {
		TotalCount = totalCount;
	}
	public int getInventoryNum() {
		return InventoryNum;
	}
	public void setInventoryNum(int inventoryNum) {
		InventoryNum = inventoryNum;
	}
	public int getInOutcomming() {
		return InOutcomming;
	}
	public void setInOutcomming(int inOutcomming) {
		InOutcomming = inOutcomming;
	}
	public String getI_Date() {
		return I_Date;
	}
	public void setI_Date(String i_Date) {
		I_Date = i_Date;
	}
	public int getProductCount() {
		return ProductCount;
	}
	public void setProductCount(int productCount) {
		ProductCount = productCount;
	}
	public int getProductCode() {
		return ProductCode;
	}
	public void setProductCode(int productCode) {
		ProductCode = productCode;
	}
}
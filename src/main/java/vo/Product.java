package vo;

public class Product {

	private int ProductCode;
	private String ProductName;
	private int Category;
	private int ProductBuyPrice;
	private int ProductSellPrice;
	private String Note;
	private int TotalCount;
	private String Image;
	private int Hidden;
	private int DetailQ;

	public Product() {
		super();
	}
	

	public Product(int productCode, String productName, int category, int productBuyPrice, int productSellPrice,
			String note, int totalCount, String image, int hidden, int detailQ) {
		super();
		ProductCode = productCode;
		ProductName = productName;
		Category = category;
		ProductBuyPrice = productBuyPrice;
		ProductSellPrice = productSellPrice;
		Note = note;
		TotalCount = totalCount;
		Image = image;
		Hidden = hidden;
		DetailQ = detailQ;
	}


	public int getDetailQ() {
		return DetailQ;
	}


	public void setDetailQ(int detailQ) {
		DetailQ = detailQ;
	}


	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public int getTotalCount() {
		return TotalCount;
	}
	public void setTotalCount(int totalCount) {
		TotalCount = totalCount;
	}
	public int getProductCode() {
		return ProductCode;
	}
	public void setProductCode(int productCode) {
		ProductCode = productCode;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getCategory() {
		return Category;
	}
	public void setCategory(int category) {
		Category = category;
	}
	public int getProductBuyPrice() {
		return ProductBuyPrice;
	}
	public void setProductBuyPrice(int productBuyPrice) {
		ProductBuyPrice = productBuyPrice;
	}
	public int getProductSellPrice() {
		return ProductSellPrice;
	}
	public void setProductSellPrice(int productSellPrice) {
		ProductSellPrice = productSellPrice;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	public int getHidden() {
		return Hidden;
	}
	public void setHidden(int hidden) {
		Hidden = hidden;
	}
	
}
package vo;

public class OrderDetail {
	private int DetailCode;
	private int DetailQ;
	private int ProductCode;
	private int OrderCode;
	
	private int ProductName;
	private int ProductSellPrice;
	private String MemberId;
	private int BucketCode;
	
	
	public OrderDetail() {
		super();
	}

	public OrderDetail(int detailCode, int detailQ, int productCode, int orderCode, int productName,
			int productSellPrice, String memberId, int bucketCode) {
		super();
		DetailCode = detailCode;
		DetailQ = detailQ;
		ProductCode = productCode;
		OrderCode = orderCode;
		ProductName = productName;
		ProductSellPrice = productSellPrice;
		MemberId = memberId;
		BucketCode = bucketCode;
	}





	public int getBucketCode() {
		return BucketCode;
	}





	public void setBucketCode(int bucketCode) {
		BucketCode = bucketCode;
	}





	public int getDetailCode() {
		return DetailCode;
	}
	public void setDetailCode(int detailCode) {
		DetailCode = detailCode;
	}
	public int getDetailQ() {
		return DetailQ;
	}
	public void setDetailQ(int detailQ) {
		DetailQ = detailQ;
	}
	public int getProductCode() {
		return ProductCode;
	}
	public void setProductCode(int productCode) {
		ProductCode = productCode;
	}
	public int getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(int orderCode) {
		OrderCode = orderCode;
	}

	public int getProductName() {
		return ProductName;
	}
	public void setProductName(int productName) {
		ProductName = productName;
	}
	public int getProductSellPrice() {
		return ProductSellPrice;
	}
	public void setProductSellPrice(int productSellPrice) {
		ProductSellPrice = productSellPrice;
	}
	public String getMemberId() {
		return MemberId;
	}
	public void setMemberId(String memberId) {
		MemberId = memberId;
	}
}
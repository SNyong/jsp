package vo;

public class Bucket {

	
	int BucketCode;
	int BucketQ;
	String MemberId;
	int ProductCode;
	String ProductName;
	int ProductSellPrice;
	String Image;
	
	
	
	
	public Bucket(int bucketCode, int bucketQ, String memberId, int productCode, String productName,
			int productSellPrice, String image) {
		super();
		BucketCode = bucketCode;
		BucketQ = bucketQ;
		MemberId = memberId;
		ProductCode = productCode;
		ProductName = productName;
		ProductSellPrice = productSellPrice;
		Image = image;
	}
	public Bucket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBucketCode() {
		return BucketCode;
	}
	public void setBucketCode(int bucketCode) {
		BucketCode = bucketCode;
	}
	public int getBucketQ() {
		return BucketQ;
	}
	public void setBucketQ(int bucketQ) {
		BucketQ = bucketQ;
	}
	public String getMemberId() {
		return MemberId;
	}
	public void setMemberId(String memberId) {
		MemberId = memberId;
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
	public int getProductSellPrice() {
		return ProductSellPrice;
	}
	public void setProductSellPrice(int productSellPrice) {
		ProductSellPrice = productSellPrice;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	
	
}

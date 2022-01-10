package vo;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private int OrderCode;
	private String OrderDate;
	private int Position;
	private int TotalPrice;
	private String MemberId;
	private String Address;

	
	private int DetailCode;
	private int DetailQ;
	private int ProductCode;
	private List<OrderDetail> orderList = new ArrayList<>();
	
	
	private String ProductName;
	private int Category;
	private int ProductBuyPrice;
	private int ProductSellPrice;
	private String Note;
	private int TotalCount;
	private String Image;
	private int Hidden;

	public Order() {
		super();
	}

//	public Order(int orderCode, String orderDate, int position, int totalPrice,
//				 String memberId, String Address, List<OrderDetail> orderList) {
//		super();
//		this.OrderCode = orderCode;
//		this.OrderDate = orderDate;
//		this.Position = position;
//		this.TotalPrice = totalPrice;
//		this.MemberId = memberId;
//		this.Address = Address;
//		this.orderList = orderList;
//	}
	
	
	

	public int getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(int orderCode) {
		OrderCode = orderCode;
	}
	
	public Order(int orderCode, String orderDate, int position, int totalPrice, String memberId, String address,
		int detailCode, int detailQ, int productCode, List<OrderDetail> orderList, String productName, int category,
		int productBuyPrice, int productSellPrice, String note, int totalCount, String image, int hidden) {
	super();
	OrderCode = orderCode;
	OrderDate = orderDate;
	Position = position;
	TotalPrice = totalPrice;
	MemberId = memberId;
	Address = address;
	DetailCode = detailCode;
	DetailQ = detailQ;
	ProductCode = productCode;
	this.orderList = orderList;
	ProductName = productName;
	Category = category;
	ProductBuyPrice = productBuyPrice;
	ProductSellPrice = productSellPrice;
	Note = note;
	TotalCount = totalCount;
	Image = image;
	Hidden = hidden;
}


	public String getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}
	public int getPosition() {
		return Position;
	}
	public void setPosition(int position) {
		Position = position;
	}
	public int getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		TotalPrice = totalPrice;
	}
	public String getMemberId() {
		return MemberId;
	}
	public void setMemberId(String memberId) {
		MemberId = memberId;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
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

	public List<OrderDetail> getOrderList() {
		return this.orderList;
	}

	public void setOrderList(List<OrderDetail> orderList) {
		this.orderList = orderList;
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

	public int getTotalCount() {
		return TotalCount;
	}

	public void setTotalCount(int totalCount) {
		TotalCount = totalCount;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public int getHidden() {
		return Hidden;
	}

	public void setHidden(int hidden) {
		Hidden = hidden;
	}
}
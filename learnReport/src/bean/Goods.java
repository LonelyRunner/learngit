package bean;
/**
 *  @author ZH
 *	商品ID int goodsId
 *	商品名称 String goodsName
 *	成本价 int costPrice
 *	售价 int sellingPrice
 *	制造商 String manufacturer
 */
public class Goods {
	private int goodsId;
	private String goodsName;
	private int costPrice;
	private int sellingPrice;
	private String manufacturer;
	
	public Goods(){
		
	}
	
	public Goods(int goodsId, String goodsName, int costPrice, int sellingPrice, String manufacturer) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.manufacturer = manufacturer;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(int costPrice) {
		this.costPrice = costPrice;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", costPrice=" + costPrice + ", sellingPrice="
				+ sellingPrice + ", manufacturer=" + manufacturer + "]";
	}
}

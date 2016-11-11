package bean;

public class TradingInf {
	private int tradingId;
	private int tradingGoodsId;
	private String tradingUserId;
	private int tradingNumber;
	
	public TradingInf(){
		
	}

	public TradingInf(int tradingId, int tradingGoodsId, String tradingUserId, int tradingNumber) {
		super();
		this.tradingId = tradingId;
		this.tradingGoodsId = tradingGoodsId;
		this.tradingUserId = tradingUserId;
		this.tradingNumber = tradingNumber;
	}

	public int getTradingId() {
		return tradingId;
	}

	public void setTradingId(int tradingId) {
		this.tradingId = tradingId;
	}

	public int getTradingGoodsId() {
		return tradingGoodsId;
	}

	public void setTradingGoodsId(int tradingGoodsId) {
		this.tradingGoodsId = tradingGoodsId;
	}

	public String getTradingUserId() {
		return tradingUserId;
	}

	public void setTradingUserId(String tradingUserId) {
		this.tradingUserId = tradingUserId;
	}

	public int getTradingNumber() {
		return tradingNumber;
	}

	public void setTradingNumber(int tradingNumber) {
		this.tradingNumber = tradingNumber;
	}

	@Override
	public String toString() {
		return "TradingInf [tradingId=" + tradingId + ", tradingGoodsId=" + tradingGoodsId + ", tradingUserId="
				+ tradingUserId + ", tradingNumber=" + tradingNumber + "]";
	}
}

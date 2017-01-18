package springboot.pojo;

public class ReturnPojo {

	private int RetCode;
	
	private Object RetData;
	
	private String RetMsg;

	public int getRetCode() {
		return RetCode;
	}

	public void setRetCode(int retCode) {
		RetCode = retCode;
	}

	public Object getRetData() {
		return RetData;
	}

	public void setRetData(Object retData) {
		RetData = retData;
	}

	public String getRetMsg() {
		return RetMsg;
	}

	public void setRetMsg(String retMsg) {
		RetMsg = retMsg;
	}

	@Override
	public String toString() {
		return "ReturnPojo [RetCode=" + RetCode + ", RetData=" + RetData + ", RetMsg=" + RetMsg + "]";
	}
}

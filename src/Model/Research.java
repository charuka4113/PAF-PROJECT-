package Model;

public class Research {
private int rid;
	
	private String type;
	private String description;
	private String size;
	private String framework;
	private String timeperiod;
	public Research(int rid, String type, String description, String size, String framework, String timeperiod) {
		super();
		this.rid = rid;
		this.type = type;
		this.description = description;
		this.size = size;
		this.framework = framework;
		this.timeperiod = timeperiod;
	}
	public Research(String type, String description, String size, String framework, String timeperiod) {
		super();
		this.type = type;
		this.description = description;
		this.size = size;
		this.framework = framework;
		this.timeperiod = timeperiod;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getFramework() {
		return framework;
	}
	public void setFramework(String framework) {
		this.framework = framework;
	}
	public String getTimeperiod() {
		return timeperiod;
	}
	public void setTimeperiod(String timeperiod) {
		this.timeperiod = timeperiod;
	}

	
}

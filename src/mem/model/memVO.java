package mem.model;

import java.io.Serializable;

public class memVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mem_name;
	private String mem_account;
	private String mem_password;
	private Integer mem_id;
	
	public memVO(){};
	public String getMem_name() {
		return mem_name;
	}
	public Integer getMem_id() {
		return mem_id;
	}
	public void setMem_id(Integer mem_id) {
		this.mem_id = mem_id;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_account() {
		return mem_account;
	}
	public void setMem_account(String mem_account) {
		this.mem_account = mem_account;
	}
	public String getMem_password() {
		return mem_password;
	}
	public void setMem_password(String mem_password) {
		this.mem_password = mem_password;
	}
	
}

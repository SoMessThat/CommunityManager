package mess.wkb.cm.code.dto;

import java.util.List;

public class PowerDTO {
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 图表
	 */
	private String icon;
	
	/**
	 * 动作
	 */
	private String jump;
	
	/**
	 * 子权限
	 */
	private List<PowerDTO> list;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getJump() {
		return jump;
	}
	public void setJump(String jump) {
		this.jump = jump;
	}
	public List<PowerDTO> getList() {
		return list;
	}
	public void setList(List<PowerDTO> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		System.out.println("PowerDTO [title=" + title + ", icon=" + icon + ", jump=" + jump + ", list=" + list + "]");
		return "PowerDTO [title=" + title + ", icon=" + icon + ", jump=" + jump + ", list=" + list + "]";
	}
	
}

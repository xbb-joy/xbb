package com.ep.model.entity;

import javax.persistence.Table;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


@Table ( name ="tb_datas" )
public class Datas  implements Serializable {


	@Id
	private String id;

	private String name;

	private Date createTime;

	private Date updateTime;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}

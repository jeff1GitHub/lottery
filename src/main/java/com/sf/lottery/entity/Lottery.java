package com.sf.lottery.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jeff
 * @since 2018-01-03
 */
@TableName("t_lottery")
public class Lottery extends Model<Lottery> {

    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 彩票名称
     */
	private String name;
    /**
     * 彩票类型
     */
	private Integer type;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Lottery{" +
			"id=" + id +
			", name=" + name +
			", type=" + type +
			"}";
	}
}

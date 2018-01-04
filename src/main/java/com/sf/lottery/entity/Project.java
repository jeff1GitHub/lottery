package com.sf.lottery.entity;

import java.io.Serializable;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableField;
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
@TableName("t_project")
public class Project extends Model<Project> {

    private static final long serialVersionUID = 1L;

    /**
     * 项目编号
     */
	private Integer id;
    /**
     * 项目名称
     */
	private String name;
    /**
     * 彩票id
     */
	@TableField("lottery_id")
	private Integer lotteryId;
    /**
     * 赔率
     */
	private BigDecimal odds;


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

	public Integer getLotteryId() {
		return lotteryId;
	}

	public void setLotteryId(Integer lotteryId) {
		this.lotteryId = lotteryId;
	}

	public BigDecimal getOdds() {
		return odds;
	}

	public void setOdds(BigDecimal odds) {
		this.odds = odds;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Project{" +
			"id=" + id +
			", name=" + name +
			", lotteryId=" + lotteryId +
			", odds=" + odds +
			"}";
	}
}

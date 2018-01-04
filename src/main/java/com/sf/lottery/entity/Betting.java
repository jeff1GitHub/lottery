package com.sf.lottery.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
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
@TableName("t_betting")
public class Betting extends Model<Betting> {

    private static final long serialVersionUID = 1L;

    /**
     * 注单流水号
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 期号
     */
	private String period;
    /**
     * 投注时间
     */
	@TableField("betting_time")
	private Date bettingTime;
    /**
     * 彩票id
     */
	@TableField("lottery_id")
	private Integer lotteryId;
    /**
     * 投注项
     */
	private Integer project;
    /**
     * 赔率
     */
	private BigDecimal odds;
    /**
     * 投注金额
     */
	private BigDecimal money;
    /**
     * 是否结算
     */
	private Integer square;
    /**
     * 结算时间
     */
	@TableField("square_time")
	private Date squareTime;
    /**
     * 是否派彩
     */
	private Integer prize;
    /**
     * 派奖时间
     */
	@TableField("prize_time")
	private Date prizeTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Date getBettingTime() {
		return bettingTime;
	}

	public void setBettingTime(Date bettingTime) {
		this.bettingTime = bettingTime;
	}

	public Integer getLotteryId() {
		return lotteryId;
	}

	public void setLotteryId(Integer lotteryId) {
		this.lotteryId = lotteryId;
	}

	public Integer getProject() {
		return project;
	}

	public void setProject(Integer project) {
		this.project = project;
	}

	public BigDecimal getOdds() {
		return odds;
	}

	public void setOdds(BigDecimal odds) {
		this.odds = odds;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Integer getSquare() {
		return square;
	}

	public void setSquare(Integer square) {
		this.square = square;
	}

	public Date getSquareTime() {
		return squareTime;
	}

	public void setSquareTime(Date squareTime) {
		this.squareTime = squareTime;
	}

	public Integer getPrize() {
		return prize;
	}

	public void setPrize(Integer prize) {
		this.prize = prize;
	}

	public Date getPrizeTime() {
		return prizeTime;
	}

	public void setPrizeTime(Date prizeTime) {
		this.prizeTime = prizeTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Betting{" +
			"id=" + id +
			", period=" + period +
			", bettingTime=" + bettingTime +
			", lotteryId=" + lotteryId +
			", project=" + project +
			", odds=" + odds +
			", money=" + money +
			", square=" + square +
			", squareTime=" + squareTime +
			", prize=" + prize +
			", prizeTime=" + prizeTime +
			"}";
	}
}

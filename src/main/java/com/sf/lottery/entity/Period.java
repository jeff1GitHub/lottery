package com.sf.lottery.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("t_period")
public class Period extends Model<Period> {

    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 期号
     */
	private String code;
    /**
     * 彩票id
     */
	@TableField("game_id")
	private Integer gameId;
    /**
     * 开盘时间
     */
	@TableField("start_time")
	private Date startTime;
    /**
     * 封盘时间
     */
	@TableField("end_time")
	private Date endTime;
    /**
     * 开奖时间
     */
	@TableField("finish_time")
	private Date finishTime;
    /**
     * 开奖结果
     */
	private String result;
    /**
     * 状态
     */
	private Integer status;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Period{" +
			"id=" + id +
			", code=" + code +
			", gameId=" + gameId +
			", startTime=" + startTime +
			", endTime=" + endTime +
			", finishTime=" + finishTime +
			", result=" + result +
			", status=" + status +
			"}";
	}
}

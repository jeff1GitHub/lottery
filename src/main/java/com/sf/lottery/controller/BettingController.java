package com.sf.lottery.controller;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.lottery.common.Context;
import com.sf.lottery.common.IdGenerator;
import com.sf.lottery.entity.Betting;
import com.sf.lottery.entity.Lottery;
import com.sf.lottery.entity.Period;
import com.sf.lottery.entity.Project;
import com.sf.lottery.service.IBettingService;
import com.sf.lottery.service.ILotteryService;
import com.sf.lottery.service.IPeriodService;
import com.sf.lottery.utils.JsonResult;
import com.sf.lottery.utils.ResultCode;

/**
 * 前端控制器
 */
@RestController()
@RequestMapping("/lottery/betting")
public class BettingController {
	private final Logger logger = LoggerFactory.getLogger(BettingController.class);
	@Resource
	private Context context;
	@Resource
	private IdGenerator idGenerator;
    @Resource
    private ILotteryService lotteryService;
    @Resource
    private IPeriodService periodService;
    @Resource
    private IBettingService bettingService;

    /**
     * 玩家投注
     * @param betting
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "betting")
    public JsonResult<String> betting(int lotteryId, String periodCode, int projectId, BigDecimal odds, BigDecimal money) {
        // 获取彩票信息
        Lottery lottery = this.lotteryService.getLotteryById(lotteryId);
        if (lottery == null) {
        	return new JsonResult<>(ResultCode.PARAMS_ERROR, "彩票不存在!");
        }

        // 获取彩票期号
        Period period = this.periodService.getPeriod(lotteryId, periodCode);
        if (period == null) {
            return new JsonResult<>(ResultCode.PARAMS_ERROR, "彩票期号不存在!");
        }

        // 判断当期时间
        long nowTime = Instant.now().toEpochMilli();
        if (period.getStartTime().getTime() >= nowTime || period.getEndTime().getTime() <= nowTime) {
            return new JsonResult<>(ResultCode.PARAMS_ERROR, "投注时间无效!");
        }
        
        // 判断投注项
        Project project = this.context.getProjectById(projectId);
        if (project == null) {
        	return new JsonResult<>(ResultCode.PARAMS_ERROR, "投注项无效!");
        }
        
        // 判断赔率
        if (project.getOdds().compareTo(odds) != 0) {
        	return new JsonResult<>(ResultCode.PARAMS_ERROR, "赔率有变动!");
        }

        // 执行彩票投注方法
        long newId;
        try {
        	newId = this.idGenerator.createId();
		} catch (Exception e) {
			logger.error("create id error.", e);
			return new JsonResult<>(ResultCode.EXCEPTION, "投注失败!");
		}
        
        Betting betting = new Betting(newId, period.getCode(), new Date(), lotteryId, project.getId(), odds, money);
        JsonResult<String> ret;
        if (this.bettingService.saveBetting(betting)) {
            ret = new JsonResult<>(ResultCode.SUCCESS);
        } else {
            ret = new JsonResult<>(ResultCode.EXCEPTION);
        }
        return ret;
    }
}

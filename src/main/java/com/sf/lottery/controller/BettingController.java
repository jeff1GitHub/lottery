package com.sf.lottery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.lottery.entity.Betting;
import com.sf.lottery.entity.Lottery;
import com.sf.lottery.entity.Period;
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
    @Autowired
    private ILotteryService lotteryService;
    @Autowired
    private IPeriodService periodService;
    @Autowired
    private IBettingService bettingService;

    /**
     * 玩家投注
     * @param betting
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "betting")
    public JsonResult<String> betting(int lotteryId, String periodCode, int typeId, float odds, int money) {
        // 获取彩票信息
        Lottery lottery = this.lotteryService.getLotteryById(lotteryId);
        if (lottery == null) {
        	return new JsonResult<>(ResultCode.PARAMS_ERROR, "彩票不存在!");
        }

        // 获取彩票期号
        Period period = periodService.getPeriod(lotteryId, periodCode);
        if (period == null) {
            return new JsonResult<>(ResultCode.PARAMS_ERROR, "彩票期号不存在!");
        }

        // 判断当期时间
        long nowTime = System.currentTimeMillis();
        if (period.getStartTime().getTime() >= nowTime || period.getEndTime().getTime() <= nowTime) {
            return new JsonResult<>(ResultCode.PARAMS_ERROR, "投注时间无效!");
        }

        // 执行彩票投注方法
        Betting betting = new Betting();
        JsonResult<String> ret;
        if (this.bettingService.saveBetting(betting)) {
            ret = new JsonResult<>(ResultCode.SUCCESS);
        } else {
            ret = new JsonResult<>(ResultCode.EXCEPTION);
        }
        return ret;
    }
}

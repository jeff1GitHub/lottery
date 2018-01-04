package com.sf.lottery.controller;


import com.sf.lottery.entity.Betting;
import com.sf.lottery.entity.Lottery;
import com.sf.lottery.entity.Period;
import com.sf.lottery.exception.LotteryException;
import com.sf.lottery.service.IBettingService;
import com.sf.lottery.service.ILotteryService;
import com.sf.lottery.service.IPeriodService;
import com.sf.lottery.utils.JsonResult;
import com.sf.lottery.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Calendar;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jeff
 * @since 2018-01-03
 */
@Controller
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
     *
     * @param betting
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "betting", method = RequestMethod.POST)
    public JsonResult betting(@Valid Betting betting, BindingResult bindingResult) {
        JsonResult ret;

        // 获取彩票信息
        Lottery lottery = this.lotteryService.getLotteryById(betting.getLotteryId());
        if (lottery == null) {
            throw new LotteryException("彩票不存在!");
        }

        // 获取彩票期号
        Period period = periodService.getPeriod(betting.getLotteryId(), betting.getPeriod());
        if (period == null) {
            throw new LotteryException("彩票期号不存在!");
        }

        // 判断当期时间
        long nowTime = Calendar.getInstance().getTimeInMillis();
        if (period.getStartTime().getTime() >= nowTime || period.getEndTime().getTime() <= nowTime) {
            throw new LotteryException("投注时间无效!");
        }

        // 执行彩票投注方法
        if (this.bettingService.saveBetting(betting)) {
            ret = new JsonResult();
        } else {
            ret = new JsonResult(ResultCode.EXCEPTION);
        }
        return ret;
    }
}

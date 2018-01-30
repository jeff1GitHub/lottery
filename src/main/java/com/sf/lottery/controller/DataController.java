package com.sf.lottery.controller;

import com.sf.lottery.common.Context;
import com.sf.lottery.entity.Period;
import com.sf.lottery.utils.JsonResult;
import com.sf.lottery.utils.ResultCode;
import com.sf.lottery.vo.PeriodVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DataController {
    @Resource
    private Context context;

    /**
     * 获取首页需要的数据
     *
     * @return
     */
    @RequestMapping("indexData")
    public JsonResult getIndexData() {
        Map<String, Object> data = new HashMap();


        data.put("lotteryName", "什么什么时时彩");// 彩票名称
        data.put("drawCountnum", 12);// 已经开采多少期
        data.put("sdrawCountnext", 21); // 剩余期数

        // 获取当前期
        Period period = context.getCurrentPeriod(1);
        PeriodVo vo = period == null ? null : new PeriodVo(period);
        data.put("nowPeriod", vo);

        // 获取上一期
        period = context.getBeforPeriod(1);
        vo = period == null ? null : new PeriodVo(period);
        data.put("berforPeriod", vo);

        return new JsonResult<>(ResultCode.SUCCESS, data);
    }



    /**
     * 获取历史开奖数据
     *
     * @return
     */
    @RequestMapping("historyData")
    public JsonResult getHistoryData() {
        // TODO 没有数据
        return new JsonResult<>(ResultCode.SUCCESS);
    }
}

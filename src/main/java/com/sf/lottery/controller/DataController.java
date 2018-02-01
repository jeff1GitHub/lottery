package com.sf.lottery.controller;

import com.sf.lottery.common.Context;
import com.sf.lottery.entity.PageInfo;
import com.sf.lottery.entity.Period;
import com.sf.lottery.service.IPeriodService;
import com.sf.lottery.utils.JsonResult;
import com.sf.lottery.utils.ResultCode;
import com.sf.lottery.vo.PeriodVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DataController {
    @Resource
    private Context context;
    @Resource
	private IPeriodService periodService;

    /**
     * 获取首页需要的数据
     * @return
     */
    @RequestMapping("indexData")
    public JsonResult< Map<String, Object>> getIndexData() {
    	// 获取当前期
        Period period = context.getCurrentPeriod(1);
        int drawCountnum = 0;
        if(period != null) {
        	String code = period.getCode();
        	drawCountnum = Integer.parseInt(code.substring(code.length() - 3));
        }
        
        Map<String, Object> data = new HashMap<>();
        data.put("lotteryName", "重庆时时彩");// 彩票名称
        data.put("drawCountnum", drawCountnum);// 已经开采多少期
        data.put("sdrawCountnext", 120 - drawCountnum); // 剩余期数

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
     * @return
     */
    @RequestMapping("historyData")
    public JsonResult<PageInfo> getHistoryData(int pageNum) {
    	LocalDate date = LocalDate.now().minusDays(1);
		String dateStr = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
		
		PageInfo info = periodService.getHistoryPeriodByDate(1, dateStr, pageNum);
		JsonResult<PageInfo> result = new JsonResult<>(ResultCode.SUCCESS, info);
		return result;
    }
}

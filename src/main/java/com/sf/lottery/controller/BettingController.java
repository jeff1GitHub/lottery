package com.sf.lottery.controller;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    @RequestMapping(value = "betting", method = RequestMethod.POST)
    public JsonResult<String> betting(int lotteryId, String periodCode, int money, String projects) {
    	if(money < 10) {
    		return new JsonResult<>(ResultCode.PARAMS_ERROR, "下注金额最少10元!");
    	}
    	
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
        
        // 判断当期状态
        if (period.getStatus() != 0) {
        	return new JsonResult<>(ResultCode.PARAMS_ERROR, "已停止投注!");
        }

        // 判断当期时间
        long nowTime = Instant.now().toEpochMilli();
        if (nowTime < period.getStartTime().getTime() || nowTime >= period.getEndTime().getTime()) {
            return new JsonResult<>(ResultCode.PARAMS_ERROR, "投注时间无效!");
        }
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json;
    	try {
    		json = mapper.readTree(projects);
		} catch (Exception e) {
			return new JsonResult<>(ResultCode.PARAMS_ERROR, "投注项错误!");
		}
    	
    	String acc = SecurityContextHolder.getContext().getAuthentication().getName();
		long userId = context.getUser(acc).getId();
    	
    	JsonNode node = null;
    	List<Betting> bettings = new ArrayList<>();
		for(Iterator<JsonNode> iter=json.iterator(); iter.hasNext();){
			node = iter.next();
			int projectId = node.get("id").asInt();
			BigDecimal odds = new BigDecimal(node.get("odds").asText());
			
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
	        
	        Betting betting = new Betting(newId, userId, acc, period.getCode(), LocalDateTime.now(), lotteryId, project.getId(), odds, new BigDecimal(money));
	        bettings.add(betting);
		}
        
        JsonResult<String> ret;
        if (this.bettingService.saveBetting(bettings)) {
            ret = new JsonResult<>(ResultCode.SUCCESS, "下注成功!");
        } else {
            ret = new JsonResult<>(ResultCode.EXCEPTION);
        }
        return ret;
    }
    
}

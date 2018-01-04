package com.sf.lottery.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sf.lottery.entity.Betting;
import com.sf.lottery.entity.Project;
import com.sf.lottery.exception.LotteryException;
import com.sf.lottery.mapper.BettingMapper;
import com.sf.lottery.service.IBettingService;
import com.sf.lottery.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 注单服务实现类
 * </p>
 *
 * @author jeff
 * @since 2018-01-03
 */
@Service
public class BettingServiceImpl extends ServiceImpl<BettingMapper, Betting> implements IBettingService {

    @Autowired
    private IProjectService projectService;

    @Override
    public List<Betting> getBettingList(Integer lotteryId, String period) {
        EntityWrapper<Betting> wrapper = new EntityWrapper<>();
        wrapper.eq("lottery_id", lotteryId);
        wrapper.eq("period", period);
        return super.selectList(wrapper);
    }

    @Override
    public boolean saveBetting(Betting betting) {
        // 设置注单时间
        betting.setBettingTime(new Date());

        // 验证投注项目
        Project project = this.projectService.getProject(betting.getProject());
        if (project == null) {
            throw new LotteryException("投注项目不存在!");
        }

        // 设置注单赔率
        betting.setOdds(project.getOdds());

        // 保存注单
        return super.insert(betting);
    }
}

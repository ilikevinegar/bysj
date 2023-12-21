package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YuangongjixiaokaoheDao;
import com.entity.YuangongjixiaokaoheEntity;
import com.service.YuangongjixiaokaoheService;
import com.entity.vo.YuangongjixiaokaoheVO;
import com.entity.view.YuangongjixiaokaoheView;

@Service("yuangongjixiaokaoheService")
public class YuangongjixiaokaoheServiceImpl extends ServiceImpl<YuangongjixiaokaoheDao, YuangongjixiaokaoheEntity> implements YuangongjixiaokaoheService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuangongjixiaokaoheEntity> page = this.selectPage(
                new Query<YuangongjixiaokaoheEntity>(params).getPage(),
                new EntityWrapper<YuangongjixiaokaoheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuangongjixiaokaoheEntity> wrapper) {
		  Page<YuangongjixiaokaoheView> page =new Query<YuangongjixiaokaoheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YuangongjixiaokaoheVO> selectListVO(Wrapper<YuangongjixiaokaoheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuangongjixiaokaoheVO selectVO(Wrapper<YuangongjixiaokaoheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuangongjixiaokaoheView> selectListView(Wrapper<YuangongjixiaokaoheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuangongjixiaokaoheView selectView(Wrapper<YuangongjixiaokaoheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<YuangongjixiaokaoheEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<YuangongjixiaokaoheEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<YuangongjixiaokaoheEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

}

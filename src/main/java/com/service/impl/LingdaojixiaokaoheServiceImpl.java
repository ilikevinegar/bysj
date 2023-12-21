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


import com.dao.LingdaojixiaokaoheDao;
import com.entity.LingdaojixiaokaoheEntity;
import com.service.LingdaojixiaokaoheService;
import com.entity.vo.LingdaojixiaokaoheVO;
import com.entity.view.LingdaojixiaokaoheView;

@Service("lingdaojixiaokaoheService")
public class LingdaojixiaokaoheServiceImpl extends ServiceImpl<LingdaojixiaokaoheDao, LingdaojixiaokaoheEntity> implements LingdaojixiaokaoheService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LingdaojixiaokaoheEntity> page = this.selectPage(
                new Query<LingdaojixiaokaoheEntity>(params).getPage(),
                new EntityWrapper<LingdaojixiaokaoheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LingdaojixiaokaoheEntity> wrapper) {
		  Page<LingdaojixiaokaoheView> page =new Query<LingdaojixiaokaoheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LingdaojixiaokaoheVO> selectListVO(Wrapper<LingdaojixiaokaoheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LingdaojixiaokaoheVO selectVO(Wrapper<LingdaojixiaokaoheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LingdaojixiaokaoheView> selectListView(Wrapper<LingdaojixiaokaoheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LingdaojixiaokaoheView selectView(Wrapper<LingdaojixiaokaoheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<LingdaojixiaokaoheEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<LingdaojixiaokaoheEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<LingdaojixiaokaoheEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

}

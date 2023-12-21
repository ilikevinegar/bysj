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


import com.dao.BumenlingdaoDao;
import com.entity.BumenlingdaoEntity;
import com.service.BumenlingdaoService;
import com.entity.vo.BumenlingdaoVO;
import com.entity.view.BumenlingdaoView;

@Service("bumenlingdaoService")
public class BumenlingdaoServiceImpl extends ServiceImpl<BumenlingdaoDao, BumenlingdaoEntity> implements BumenlingdaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BumenlingdaoEntity> page = this.selectPage(
                new Query<BumenlingdaoEntity>(params).getPage(),
                new EntityWrapper<BumenlingdaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BumenlingdaoEntity> wrapper) {
		  Page<BumenlingdaoView> page =new Query<BumenlingdaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BumenlingdaoVO> selectListVO(Wrapper<BumenlingdaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BumenlingdaoVO selectVO(Wrapper<BumenlingdaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BumenlingdaoView> selectListView(Wrapper<BumenlingdaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BumenlingdaoView selectView(Wrapper<BumenlingdaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

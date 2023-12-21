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


import com.dao.GongzuojiluDao;
import com.entity.GongzuojiluEntity;
import com.service.GongzuojiluService;
import com.entity.vo.GongzuojiluVO;
import com.entity.view.GongzuojiluView;

@Service("gongzuojiluService")
public class GongzuojiluServiceImpl extends ServiceImpl<GongzuojiluDao, GongzuojiluEntity> implements GongzuojiluService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GongzuojiluEntity> page = this.selectPage(
                new Query<GongzuojiluEntity>(params).getPage(),
                new EntityWrapper<GongzuojiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GongzuojiluEntity> wrapper) {
		  Page<GongzuojiluView> page =new Query<GongzuojiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GongzuojiluVO> selectListVO(Wrapper<GongzuojiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GongzuojiluVO selectVO(Wrapper<GongzuojiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GongzuojiluView> selectListView(Wrapper<GongzuojiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GongzuojiluView selectView(Wrapper<GongzuojiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

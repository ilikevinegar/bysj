package com.dao;

import com.entity.GongzuojiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GongzuojiluVO;
import com.entity.view.GongzuojiluView;


/**
 * 工作记录
 * 
 * @author 
 * @email 
 * @date 2030-02-26 16:39:09
 */
public interface GongzuojiluDao extends BaseMapper<GongzuojiluEntity> {
	
	List<GongzuojiluVO> selectListVO(@Param("ew") Wrapper<GongzuojiluEntity> wrapper);
	
	GongzuojiluVO selectVO(@Param("ew") Wrapper<GongzuojiluEntity> wrapper);
	
	List<GongzuojiluView> selectListView(@Param("ew") Wrapper<GongzuojiluEntity> wrapper);

	List<GongzuojiluView> selectListView(Pagination page,@Param("ew") Wrapper<GongzuojiluEntity> wrapper);
	
	GongzuojiluView selectView(@Param("ew") Wrapper<GongzuojiluEntity> wrapper);
	

}

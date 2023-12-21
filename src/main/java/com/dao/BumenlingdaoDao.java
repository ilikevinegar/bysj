package com.dao;

import com.entity.BumenlingdaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BumenlingdaoVO;
import com.entity.view.BumenlingdaoView;


/**
 * 部门领导
 * 
 * @author 
 * @email 
 * @date 2030-02-26 16:39:08
 */
public interface BumenlingdaoDao extends BaseMapper<BumenlingdaoEntity> {
	
	List<BumenlingdaoVO> selectListVO(@Param("ew") Wrapper<BumenlingdaoEntity> wrapper);
	
	BumenlingdaoVO selectVO(@Param("ew") Wrapper<BumenlingdaoEntity> wrapper);
	
	List<BumenlingdaoView> selectListView(@Param("ew") Wrapper<BumenlingdaoEntity> wrapper);

	List<BumenlingdaoView> selectListView(Pagination page,@Param("ew") Wrapper<BumenlingdaoEntity> wrapper);
	
	BumenlingdaoView selectView(@Param("ew") Wrapper<BumenlingdaoEntity> wrapper);
	

}

package com.dao;

import com.entity.LingdaojixiaokaoheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LingdaojixiaokaoheVO;
import com.entity.view.LingdaojixiaokaoheView;


/**
 * 领导绩效考核
 * 
 * @author 
 * @email 
 * @date 2030-02-26 16:39:09
 */
public interface LingdaojixiaokaoheDao extends BaseMapper<LingdaojixiaokaoheEntity> {
	
	List<LingdaojixiaokaoheVO> selectListVO(@Param("ew") Wrapper<LingdaojixiaokaoheEntity> wrapper);
	
	LingdaojixiaokaoheVO selectVO(@Param("ew") Wrapper<LingdaojixiaokaoheEntity> wrapper);
	
	List<LingdaojixiaokaoheView> selectListView(@Param("ew") Wrapper<LingdaojixiaokaoheEntity> wrapper);

	List<LingdaojixiaokaoheView> selectListView(Pagination page,@Param("ew") Wrapper<LingdaojixiaokaoheEntity> wrapper);
	
	LingdaojixiaokaoheView selectView(@Param("ew") Wrapper<LingdaojixiaokaoheEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params")Map<String, Object> params,@Param("ew") Wrapper<LingdaojixiaokaoheEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LingdaojixiaokaoheEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LingdaojixiaokaoheEntity> wrapper);
}

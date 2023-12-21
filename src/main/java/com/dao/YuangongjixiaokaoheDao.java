package com.dao;

import com.entity.YuangongjixiaokaoheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuangongjixiaokaoheVO;
import com.entity.view.YuangongjixiaokaoheView;


/**
 * 员工绩效考核
 * 
 * @author 
 * @email 
 * @date 2030-02-26 16:39:09
 */
public interface YuangongjixiaokaoheDao extends BaseMapper<YuangongjixiaokaoheEntity> {
	
	List<YuangongjixiaokaoheVO> selectListVO(@Param("ew") Wrapper<YuangongjixiaokaoheEntity> wrapper);
	
	YuangongjixiaokaoheVO selectVO(@Param("ew") Wrapper<YuangongjixiaokaoheEntity> wrapper);
	
	List<YuangongjixiaokaoheView> selectListView(@Param("ew") Wrapper<YuangongjixiaokaoheEntity> wrapper);

	List<YuangongjixiaokaoheView> selectListView(Pagination page,@Param("ew") Wrapper<YuangongjixiaokaoheEntity> wrapper);
	
	YuangongjixiaokaoheView selectView(@Param("ew") Wrapper<YuangongjixiaokaoheEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params")Map<String, Object> params,@Param("ew") Wrapper<YuangongjixiaokaoheEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YuangongjixiaokaoheEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YuangongjixiaokaoheEntity> wrapper);
}

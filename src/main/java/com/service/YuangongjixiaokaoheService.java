package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuangongjixiaokaoheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuangongjixiaokaoheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuangongjixiaokaoheView;


/**
 * 员工绩效考核
 *
 * @author 
 * @email 
 * @date 2030-02-26 16:39:09
 */
public interface YuangongjixiaokaoheService extends IService<YuangongjixiaokaoheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuangongjixiaokaoheVO> selectListVO(Wrapper<YuangongjixiaokaoheEntity> wrapper);
   	
   	YuangongjixiaokaoheVO selectVO(@Param("ew") Wrapper<YuangongjixiaokaoheEntity> wrapper);
   	
   	List<YuangongjixiaokaoheView> selectListView(Wrapper<YuangongjixiaokaoheEntity> wrapper);
   	
   	YuangongjixiaokaoheView selectView(@Param("ew") Wrapper<YuangongjixiaokaoheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuangongjixiaokaoheEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<YuangongjixiaokaoheEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<YuangongjixiaokaoheEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<YuangongjixiaokaoheEntity> wrapper);
}


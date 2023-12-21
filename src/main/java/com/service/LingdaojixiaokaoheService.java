package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LingdaojixiaokaoheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LingdaojixiaokaoheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LingdaojixiaokaoheView;


/**
 * 领导绩效考核
 *
 * @author 
 * @email 
 * @date 2030-02-26 16:39:09
 */
public interface LingdaojixiaokaoheService extends IService<LingdaojixiaokaoheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LingdaojixiaokaoheVO> selectListVO(Wrapper<LingdaojixiaokaoheEntity> wrapper);
   	
   	LingdaojixiaokaoheVO selectVO(@Param("ew") Wrapper<LingdaojixiaokaoheEntity> wrapper);
   	
   	List<LingdaojixiaokaoheView> selectListView(Wrapper<LingdaojixiaokaoheEntity> wrapper);
   	
   	LingdaojixiaokaoheView selectView(@Param("ew") Wrapper<LingdaojixiaokaoheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LingdaojixiaokaoheEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<LingdaojixiaokaoheEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<LingdaojixiaokaoheEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<LingdaojixiaokaoheEntity> wrapper);
}


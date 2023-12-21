package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GongzuojiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GongzuojiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GongzuojiluView;


/**
 * 工作记录
 *
 * @author 
 * @email 
 * @date 2030-02-26 16:39:09
 */
public interface GongzuojiluService extends IService<GongzuojiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GongzuojiluVO> selectListVO(Wrapper<GongzuojiluEntity> wrapper);
   	
   	GongzuojiluVO selectVO(@Param("ew") Wrapper<GongzuojiluEntity> wrapper);
   	
   	List<GongzuojiluView> selectListView(Wrapper<GongzuojiluEntity> wrapper);
   	
   	GongzuojiluView selectView(@Param("ew") Wrapper<GongzuojiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GongzuojiluEntity> wrapper);
   	

}


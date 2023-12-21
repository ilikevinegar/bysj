package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BumenlingdaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BumenlingdaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BumenlingdaoView;


/**
 * 部门领导
 *
 * @author 
 * @email 
 * @date 2030-02-26 16:39:08
 */
public interface BumenlingdaoService extends IService<BumenlingdaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BumenlingdaoVO> selectListVO(Wrapper<BumenlingdaoEntity> wrapper);
   	
   	BumenlingdaoVO selectVO(@Param("ew") Wrapper<BumenlingdaoEntity> wrapper);
   	
   	List<BumenlingdaoView> selectListView(Wrapper<BumenlingdaoEntity> wrapper);
   	
   	BumenlingdaoView selectView(@Param("ew") Wrapper<BumenlingdaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BumenlingdaoEntity> wrapper);
   	

}


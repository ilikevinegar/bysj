package com.entity.view;

import com.entity.GongzuorenwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 工作任务
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2030-02-26 16:39:09
 */
@TableName("gongzuorenwu")
public class GongzuorenwuView  extends GongzuorenwuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GongzuorenwuView(){
	}
 
 	public GongzuorenwuView(GongzuorenwuEntity gongzuorenwuEntity){
 	try {
			BeanUtils.copyProperties(this, gongzuorenwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

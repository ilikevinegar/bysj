package com.entity.view;

import com.entity.BumenlingdaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 部门领导
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2030-02-26 16:39:08
 */
@TableName("bumenlingdao")
public class BumenlingdaoView  extends BumenlingdaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BumenlingdaoView(){
	}
 
 	public BumenlingdaoView(BumenlingdaoEntity bumenlingdaoEntity){
 	try {
			BeanUtils.copyProperties(this, bumenlingdaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

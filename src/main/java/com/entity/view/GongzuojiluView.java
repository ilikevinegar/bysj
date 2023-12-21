package com.entity.view;

import com.entity.GongzuojiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 工作记录
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2030-02-26 16:39:09
 */
@TableName("gongzuojilu")
public class GongzuojiluView  extends GongzuojiluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GongzuojiluView(){
	}
 
 	public GongzuojiluView(GongzuojiluEntity gongzuojiluEntity){
 	try {
			BeanUtils.copyProperties(this, gongzuojiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

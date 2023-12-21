package com.entity.view;

import com.entity.YuangongjixiaokaoheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 员工绩效考核
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2030-02-26 16:39:09
 */
@TableName("yuangongjixiaokaohe")
public class YuangongjixiaokaoheView  extends YuangongjixiaokaoheEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YuangongjixiaokaoheView(){
	}
 
 	public YuangongjixiaokaoheView(YuangongjixiaokaoheEntity yuangongjixiaokaoheEntity){
 	try {
			BeanUtils.copyProperties(this, yuangongjixiaokaoheEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

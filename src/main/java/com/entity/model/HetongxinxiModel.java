package com.entity.model;

import com.entity.HetongxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 合同信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2030-02-26 16:39:08
 */
public class HetongxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 合同名称
	 */
	
	private String hetongmingcheng;
		
	/**
	 * 合同类型
	 */
	
	private String hetongleixing;
		
	/**
	 * 合同文件
	 */
	
	private String hetongwenjian;
		
	/**
	 * 员工工号
	 */
	
	private String yuangonggonghao;
		
	/**
	 * 员工姓名
	 */
	
	private String yuangongxingming;
		
	/**
	 * 部门
	 */
	
	private String bumen;
		
	/**
	 * 职位
	 */
	
	private String zhiwei;
		
	/**
	 * 日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date riqi;
		
	/**
	 * 合同信息
	 */
	
	private String hetongxinxi;
		
	/**
	 * 合同说明
	 */
	
	private String hetongshuoming;
		
	/**
	 * 领导账号
	 */
	
	private String lingdaozhanghao;
		
	/**
	 * 领导姓名
	 */
	
	private String lingdaoxingming;
				
	
	/**
	 * 设置：合同名称
	 */
	 
	public void setHetongmingcheng(String hetongmingcheng) {
		this.hetongmingcheng = hetongmingcheng;
	}
	
	/**
	 * 获取：合同名称
	 */
	public String getHetongmingcheng() {
		return hetongmingcheng;
	}
				
	
	/**
	 * 设置：合同类型
	 */
	 
	public void setHetongleixing(String hetongleixing) {
		this.hetongleixing = hetongleixing;
	}
	
	/**
	 * 获取：合同类型
	 */
	public String getHetongleixing() {
		return hetongleixing;
	}
				
	
	/**
	 * 设置：合同文件
	 */
	 
	public void setHetongwenjian(String hetongwenjian) {
		this.hetongwenjian = hetongwenjian;
	}
	
	/**
	 * 获取：合同文件
	 */
	public String getHetongwenjian() {
		return hetongwenjian;
	}
				
	
	/**
	 * 设置：员工工号
	 */
	 
	public void setYuangonggonghao(String yuangonggonghao) {
		this.yuangonggonghao = yuangonggonghao;
	}
	
	/**
	 * 获取：员工工号
	 */
	public String getYuangonggonghao() {
		return yuangonggonghao;
	}
				
	
	/**
	 * 设置：员工姓名
	 */
	 
	public void setYuangongxingming(String yuangongxingming) {
		this.yuangongxingming = yuangongxingming;
	}
	
	/**
	 * 获取：员工姓名
	 */
	public String getYuangongxingming() {
		return yuangongxingming;
	}
				
	
	/**
	 * 设置：部门
	 */
	 
	public void setBumen(String bumen) {
		this.bumen = bumen;
	}
	
	/**
	 * 获取：部门
	 */
	public String getBumen() {
		return bumen;
	}
				
	
	/**
	 * 设置：职位
	 */
	 
	public void setZhiwei(String zhiwei) {
		this.zhiwei = zhiwei;
	}
	
	/**
	 * 获取：职位
	 */
	public String getZhiwei() {
		return zhiwei;
	}
				
	
	/**
	 * 设置：日期
	 */
	 
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	
	/**
	 * 获取：日期
	 */
	public Date getRiqi() {
		return riqi;
	}
				
	
	/**
	 * 设置：合同信息
	 */
	 
	public void setHetongxinxi(String hetongxinxi) {
		this.hetongxinxi = hetongxinxi;
	}
	
	/**
	 * 获取：合同信息
	 */
	public String getHetongxinxi() {
		return hetongxinxi;
	}
				
	
	/**
	 * 设置：合同说明
	 */
	 
	public void setHetongshuoming(String hetongshuoming) {
		this.hetongshuoming = hetongshuoming;
	}
	
	/**
	 * 获取：合同说明
	 */
	public String getHetongshuoming() {
		return hetongshuoming;
	}
				
	
	/**
	 * 设置：领导账号
	 */
	 
	public void setLingdaozhanghao(String lingdaozhanghao) {
		this.lingdaozhanghao = lingdaozhanghao;
	}
	
	/**
	 * 获取：领导账号
	 */
	public String getLingdaozhanghao() {
		return lingdaozhanghao;
	}
				
	
	/**
	 * 设置：领导姓名
	 */
	 
	public void setLingdaoxingming(String lingdaoxingming) {
		this.lingdaoxingming = lingdaoxingming;
	}
	
	/**
	 * 获取：领导姓名
	 */
	public String getLingdaoxingming() {
		return lingdaoxingming;
	}
			
}

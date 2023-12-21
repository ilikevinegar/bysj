package com.entity.model;

import com.entity.YuangongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 员工
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2030-02-26 16:39:08
 */
public class YuangongModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 密码
	 */
	
	private String mima;
		
	/**
	 * 员工姓名
	 */
	
	private String yuangongxingming;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 头像
	 */
	
	private String touxiang;
		
	/**
	 * 人员
	 */
	
	private Integer renyuan;
		
	/**
	 * 职位
	 */
	
	private String zhiwei;
		
	/**
	 * 手机
	 */
	
	private String shouji;
		
	/**
	 * 地址
	 */
	
	private String dizhi;
		
	/**
	 * 教育经历
	 */
	
	private String jiaoyujingli;
		
	/**
	 * 工作经历
	 */
	
	private String gongzuojingli;
		
	/**
	 * 家庭背景
	 */
	
	private String jiatingbeijing;
		
	/**
	 * 培训经历
	 */
	
	private String peixunjingli;
		
	/**
	 * 语言能力
	 */
	
	private String yuyannengli;
		
	/**
	 * 个人职称
	 */
	
	private String gerenzhicheng;
		
	/**
	 * 领导账号
	 */
	
	private String lingdaozhanghao;
		
	/**
	 * 领导姓名
	 */
	
	private String lingdaoxingming;
		
	/**
	 * 部门
	 */
	
	private String bumen;
				
	
	/**
	 * 设置：密码
	 */
	 
	public void setMima(String mima) {
		this.mima = mima;
	}
	
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
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
	 * 设置：性别
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：头像
	 */
	 
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
				
	
	/**
	 * 设置：人员
	 */
	 
	public void setRenyuan(Integer renyuan) {
		this.renyuan = renyuan;
	}
	
	/**
	 * 获取：人员
	 */
	public Integer getRenyuan() {
		return renyuan;
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
	 * 设置：手机
	 */
	 
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
				
	
	/**
	 * 设置：地址
	 */
	 
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	
	/**
	 * 获取：地址
	 */
	public String getDizhi() {
		return dizhi;
	}
				
	
	/**
	 * 设置：教育经历
	 */
	 
	public void setJiaoyujingli(String jiaoyujingli) {
		this.jiaoyujingli = jiaoyujingli;
	}
	
	/**
	 * 获取：教育经历
	 */
	public String getJiaoyujingli() {
		return jiaoyujingli;
	}
				
	
	/**
	 * 设置：工作经历
	 */
	 
	public void setGongzuojingli(String gongzuojingli) {
		this.gongzuojingli = gongzuojingli;
	}
	
	/**
	 * 获取：工作经历
	 */
	public String getGongzuojingli() {
		return gongzuojingli;
	}
				
	
	/**
	 * 设置：家庭背景
	 */
	 
	public void setJiatingbeijing(String jiatingbeijing) {
		this.jiatingbeijing = jiatingbeijing;
	}
	
	/**
	 * 获取：家庭背景
	 */
	public String getJiatingbeijing() {
		return jiatingbeijing;
	}
				
	
	/**
	 * 设置：培训经历
	 */
	 
	public void setPeixunjingli(String peixunjingli) {
		this.peixunjingli = peixunjingli;
	}
	
	/**
	 * 获取：培训经历
	 */
	public String getPeixunjingli() {
		return peixunjingli;
	}
				
	
	/**
	 * 设置：语言能力
	 */
	 
	public void setYuyannengli(String yuyannengli) {
		this.yuyannengli = yuyannengli;
	}
	
	/**
	 * 获取：语言能力
	 */
	public String getYuyannengli() {
		return yuyannengli;
	}
				
	
	/**
	 * 设置：个人职称
	 */
	 
	public void setGerenzhicheng(String gerenzhicheng) {
		this.gerenzhicheng = gerenzhicheng;
	}
	
	/**
	 * 获取：个人职称
	 */
	public String getGerenzhicheng() {
		return gerenzhicheng;
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
			
}

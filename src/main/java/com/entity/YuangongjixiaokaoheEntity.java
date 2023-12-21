package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 员工绩效考核
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2030-02-26 16:39:09
 */
@TableName("yuangongjixiaokaohe")
public class YuangongjixiaokaoheEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YuangongjixiaokaoheEntity() {
		
	}
	
	public YuangongjixiaokaoheEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 考核名称
	 */
					
	private String kaohemingcheng;
	
	/**
	 * 考核范围
	 */
					
	private String kaohefanwei;
	
	/**
	 * 考核周期
	 */
					
	private String kaohezhouqi;
	
	/**
	 * 考核月份
	 */
					
	private String kaoheyuefen;
	
	/**
	 * 考核打分
	 */
					
	private Integer kaohedafen;
	
	/**
	 * 考核评级
	 */
					
	private String kaohepingji;
	
	/**
	 * 考核评价
	 */
					
	private String kaohepingjia;
	
	/**
	 * 考核内容
	 */
					
	private String kaoheneirong;
	
	/**
	 * 考核日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date kaoheriqi;
	
	/**
	 * 考核备注
	 */
					
	private String kaohebeizhu;
	
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
	 * 领导账号
	 */
					
	private String lingdaozhanghao;
	
	/**
	 * 领导姓名
	 */
					
	private String lingdaoxingming;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：考核名称
	 */
	public void setKaohemingcheng(String kaohemingcheng) {
		this.kaohemingcheng = kaohemingcheng;
	}
	/**
	 * 获取：考核名称
	 */
	public String getKaohemingcheng() {
		return kaohemingcheng;
	}
	/**
	 * 设置：考核范围
	 */
	public void setKaohefanwei(String kaohefanwei) {
		this.kaohefanwei = kaohefanwei;
	}
	/**
	 * 获取：考核范围
	 */
	public String getKaohefanwei() {
		return kaohefanwei;
	}
	/**
	 * 设置：考核周期
	 */
	public void setKaohezhouqi(String kaohezhouqi) {
		this.kaohezhouqi = kaohezhouqi;
	}
	/**
	 * 获取：考核周期
	 */
	public String getKaohezhouqi() {
		return kaohezhouqi;
	}
	/**
	 * 设置：考核月份
	 */
	public void setKaoheyuefen(String kaoheyuefen) {
		this.kaoheyuefen = kaoheyuefen;
	}
	/**
	 * 获取：考核月份
	 */
	public String getKaoheyuefen() {
		return kaoheyuefen;
	}
	/**
	 * 设置：考核打分
	 */
	public void setKaohedafen(Integer kaohedafen) {
		this.kaohedafen = kaohedafen;
	}
	/**
	 * 获取：考核打分
	 */
	public Integer getKaohedafen() {
		return kaohedafen;
	}
	/**
	 * 设置：考核评级
	 */
	public void setKaohepingji(String kaohepingji) {
		this.kaohepingji = kaohepingji;
	}
	/**
	 * 获取：考核评级
	 */
	public String getKaohepingji() {
		return kaohepingji;
	}
	/**
	 * 设置：考核评价
	 */
	public void setKaohepingjia(String kaohepingjia) {
		this.kaohepingjia = kaohepingjia;
	}
	/**
	 * 获取：考核评价
	 */
	public String getKaohepingjia() {
		return kaohepingjia;
	}
	/**
	 * 设置：考核内容
	 */
	public void setKaoheneirong(String kaoheneirong) {
		this.kaoheneirong = kaoheneirong;
	}
	/**
	 * 获取：考核内容
	 */
	public String getKaoheneirong() {
		return kaoheneirong;
	}
	/**
	 * 设置：考核日期
	 */
	public void setKaoheriqi(Date kaoheriqi) {
		this.kaoheriqi = kaoheriqi;
	}
	/**
	 * 获取：考核日期
	 */
	public Date getKaoheriqi() {
		return kaoheriqi;
	}
	/**
	 * 设置：考核备注
	 */
	public void setKaohebeizhu(String kaohebeizhu) {
		this.kaohebeizhu = kaohebeizhu;
	}
	/**
	 * 获取：考核备注
	 */
	public String getKaohebeizhu() {
		return kaohebeizhu;
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

package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.GongzuojiluEntity;
import com.entity.view.GongzuojiluView;

import com.service.GongzuojiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 工作记录
 * 后端接口
 * @author 
 * @email 
 * @date 2030-02-26 16:39:09
 */
@RestController
@RequestMapping("/gongzuojilu")
public class GongzuojiluController {
    @Autowired
    private GongzuojiluService gongzuojiluService;
//	 后端列表
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GongzuojiluEntity gongzuojilu, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date tijiaoriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date tijiaoriqiend,
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			gongzuojilu.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("bumenlingdao")) {
			gongzuojilu.setLingdaozhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GongzuojiluEntity> ew = new EntityWrapper<GongzuojiluEntity>();
                if(tijiaoriqistart!=null) ew.ge("tijiaoriqi", tijiaoriqistart);
                if(tijiaoriqiend!=null) ew.le("tijiaoriqi", tijiaoriqiend);
		PageUtils page = gongzuojiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzuojilu), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GongzuojiluEntity gongzuojilu, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date tijiaoriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date tijiaoriqiend,
		HttpServletRequest request){
        EntityWrapper<GongzuojiluEntity> ew = new EntityWrapper<GongzuojiluEntity>();
                if(tijiaoriqistart!=null) ew.ge("tijiaoriqi", tijiaoriqistart);
                if(tijiaoriqiend!=null) ew.le("tijiaoriqi", tijiaoriqiend);
		PageUtils page = gongzuojiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzuojilu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GongzuojiluEntity gongzuojilu){
       	EntityWrapper<GongzuojiluEntity> ew = new EntityWrapper<GongzuojiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongzuojilu, "gongzuojilu")); 
        return R.ok().put("data", gongzuojiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GongzuojiluEntity gongzuojilu){
        EntityWrapper< GongzuojiluEntity> ew = new EntityWrapper< GongzuojiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongzuojilu, "gongzuojilu")); 
		GongzuojiluView gongzuojiluView =  gongzuojiluService.selectView(ew);
		return R.ok("查询工作记录成功").put("data", gongzuojiluView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GongzuojiluEntity gongzuojilu = gongzuojiluService.selectById(id);
        return R.ok().put("data", gongzuojilu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GongzuojiluEntity gongzuojilu = gongzuojiluService.selectById(id);
        return R.ok().put("data", gongzuojilu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GongzuojiluEntity gongzuojilu, HttpServletRequest request){
    	gongzuojilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongzuojilu);

        gongzuojiluService.insert(gongzuojilu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GongzuojiluEntity gongzuojilu, HttpServletRequest request){
    	gongzuojilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongzuojilu);

        gongzuojiluService.insert(gongzuojilu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GongzuojiluEntity gongzuojilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongzuojilu);
        gongzuojiluService.updateById(gongzuojilu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gongzuojiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<GongzuojiluEntity> wrapper = new EntityWrapper<GongzuojiluEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			wrapper.eq("yuangonggonghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("bumenlingdao")) {
			wrapper.eq("lingdaozhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = gongzuojiluService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}

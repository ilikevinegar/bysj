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

import com.entity.YuangongjixiaokaoheEntity;
import com.entity.view.YuangongjixiaokaoheView;

import com.service.YuangongjixiaokaoheService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 员工绩效考核
 * 后端接口
 * @author 
 * @email 
 * @date 2030-02-26 16:39:09
 */
@RestController
@RequestMapping("/yuangongjixiaokaohe")
public class YuangongjixiaokaoheController {
    @Autowired
    private YuangongjixiaokaoheService yuangongjixiaokaoheService;
//  后端列表
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuangongjixiaokaoheEntity yuangongjixiaokaohe, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date kaoheriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date kaoheriqiend,
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			yuangongjixiaokaohe.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("bumenlingdao")) {
			yuangongjixiaokaohe.setLingdaozhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuangongjixiaokaoheEntity> ew = new EntityWrapper<YuangongjixiaokaoheEntity>();
                if(kaoheriqistart!=null) ew.ge("kaoheriqi", kaoheriqistart);
                if(kaoheriqiend!=null) ew.le("kaoheriqi", kaoheriqiend);
		PageUtils page = yuangongjixiaokaoheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangongjixiaokaohe), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuangongjixiaokaoheEntity yuangongjixiaokaohe, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date kaoheriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date kaoheriqiend,
		HttpServletRequest request){
        EntityWrapper<YuangongjixiaokaoheEntity> ew = new EntityWrapper<YuangongjixiaokaoheEntity>();
                if(kaoheriqistart!=null) ew.ge("kaoheriqi", kaoheriqistart);
                if(kaoheriqiend!=null) ew.le("kaoheriqi", kaoheriqiend);
		PageUtils page = yuangongjixiaokaoheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangongjixiaokaohe), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuangongjixiaokaoheEntity yuangongjixiaokaohe){
       	EntityWrapper<YuangongjixiaokaoheEntity> ew = new EntityWrapper<YuangongjixiaokaoheEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuangongjixiaokaohe, "yuangongjixiaokaohe")); 
        return R.ok().put("data", yuangongjixiaokaoheService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuangongjixiaokaoheEntity yuangongjixiaokaohe){
        EntityWrapper< YuangongjixiaokaoheEntity> ew = new EntityWrapper< YuangongjixiaokaoheEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuangongjixiaokaohe, "yuangongjixiaokaohe")); 
		YuangongjixiaokaoheView yuangongjixiaokaoheView =  yuangongjixiaokaoheService.selectView(ew);
		return R.ok("查询员工绩效考核成功").put("data", yuangongjixiaokaoheView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuangongjixiaokaoheEntity yuangongjixiaokaohe = yuangongjixiaokaoheService.selectById(id);
        return R.ok().put("data", yuangongjixiaokaohe);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuangongjixiaokaoheEntity yuangongjixiaokaohe = yuangongjixiaokaoheService.selectById(id);
        return R.ok().put("data", yuangongjixiaokaohe);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuangongjixiaokaoheEntity yuangongjixiaokaohe, HttpServletRequest request){
    	yuangongjixiaokaohe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuangongjixiaokaohe);

        yuangongjixiaokaoheService.insert(yuangongjixiaokaohe);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuangongjixiaokaoheEntity yuangongjixiaokaohe, HttpServletRequest request){
    	yuangongjixiaokaohe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuangongjixiaokaohe);

        yuangongjixiaokaoheService.insert(yuangongjixiaokaohe);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YuangongjixiaokaoheEntity yuangongjixiaokaohe, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuangongjixiaokaohe);
        yuangongjixiaokaoheService.updateById(yuangongjixiaokaohe);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuangongjixiaokaoheService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<YuangongjixiaokaoheEntity> wrapper = new EntityWrapper<YuangongjixiaokaoheEntity>();
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

		int count = yuangongjixiaokaoheService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<YuangongjixiaokaoheEntity> ew = new EntityWrapper<YuangongjixiaokaoheEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yuangong")) {
            ew.eq("yuangonggonghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("bumenlingdao")) {
            ew.eq("lingdaozhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = yuangongjixiaokaoheService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<YuangongjixiaokaoheEntity> ew = new EntityWrapper<YuangongjixiaokaoheEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yuangong")) {
            ew.eq("yuangonggonghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("bumenlingdao")) {
            ew.eq("lingdaozhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = yuangongjixiaokaoheService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<YuangongjixiaokaoheEntity> ew = new EntityWrapper<YuangongjixiaokaoheEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yuangong")) {
            ew.eq("yuangonggonghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("bumenlingdao")) {
            ew.eq("lingdaozhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = yuangongjixiaokaoheService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }
}

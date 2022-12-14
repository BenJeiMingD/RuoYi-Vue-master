package com.ruoyi.web.controller.cyDepcombin;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.domain.CyDeptpo;
import com.ruoyi.system.domain.Deptform;
import com.ruoyi.system.domain.Deptsum;
import com.ruoyi.system.service.IDeptformService;
import com.ruoyi.system.service.IDeptsumService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.CyDepcombin;
import com.ruoyi.system.service.ICyDepcombinService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 合并汇总Controller
 *
 * @author ruoyi
 * @date 2022-10-13
 */
@RestController
@DataSource(value = DataSourceType.SLAVE)
public class CyDepcombinController extends BaseController
{
    @Autowired
    private ICyDepcombinService cyDepcombinService;

    @Autowired
    private IDeptsumService deptsumService;

    @Autowired
    private IDeptformService deptformService;

    private static String SummaryBy;

    /**
     * 查询合并汇总列表
     */
    /*@PreAuthorize("@ss.hasPermi('system:depcombin:list')")*/
    @GetMapping("/system/depcombin/list")
    public TableDataInfo list(CyDepcombin cyDepcombin)
    {
        List<CyDepcombin> list = cyDepcombinService.selectCyDepcombinList(cyDepcombin);
        return getDataTable(list);
    }
    /*用户状态信息*/
    @PostMapping("/system/depcombin/state")
    public TableDataInfo state(@RequestBody String string)
    {
        JSONObject jsonObject = JSON.parseObject(string).getJSONObject("data");
        //JSON.toJavaObject 将 jsonObject对象转换成 自建对象 cyDepcombin，用来调用自己属性的get，set方法
        Deptform deptform = JSON.toJavaObject(jsonObject, Deptform.class);
        List<Deptform> list = deptformService.selectDeptformList(deptform);
        return getDataTable(list);
    }

    /**
     * 新增合并汇总
     */
    /*@PreAuthorize("@ss.hasPermi('system:depcombin:add')")*/
    /*@Log(title = "合并汇总", businessType = BusinessType.INSERT)*/
    @PostMapping("/system/depcombin/add") // --只为存储 summaryBy
    public AjaxResult add(@RequestBody String string)
    {   //getJSONObject("data")，对data进行剥离，返回 jsonObject对象
        JSONObject jsonObject = JSON.parseObject(string).getJSONObject("data");
        //JSON.toJavaObject 将 jsonObject对象转换成 自建对象 cyDepcombin，用来调用自己属性的get，set方法
        CyDepcombin cyDepcombin = JSON.toJavaObject(jsonObject, CyDepcombin.class);
        String summaryBy = cyDepcombin.getSummaryBy();
        if (summaryBy!=null){//如果不为空，存储静态变量
            SummaryBy = summaryBy;
        }
        //先有汇总人，再新增的时候插入新数据
        List<Deptsum> deptsums = deptsumService.selectDeptsumList(new Deptsum());
        if (deptsums.size()!=0){
            Deptsum deptsum = deptsums.get(deptsums.size() - 1);
        }
        return null;
    }
    /**
     *  合并的时候新增最新一期  ---
     * @param string
     * @return
     */
    @GetMapping("/system/depcombin/inster")
    public AjaxResult addIS(String string)
    {
        String summaryBy = SummaryBy;
        //先有汇总人，再新增的时候插入新数据
        List<Deptsum> deptsums = deptsumService.selectDeptsumList(new Deptsum());
        Deptsum deptsum = deptsums.get(deptsums.size() - 1);
        Integer issueNumber = deptsum.getIssueNumber();
        CyDepcombin depcombin = new CyDepcombin();
        depcombin.setIssueNumber(issueNumber);
        List<CyDepcombin> cyDepcombins = cyDepcombinService.selectCyDepcombinList(depcombin);
        if (deptsums.size()!=0&&cyDepcombins.size()==0){//这里说明汇总表有数据 ，合并表没有数据则执行插入
            Integer merger = deptsum.getMerger();
            Date startTime = deptsum.getStartTime();
            Date endTime = deptsum.getEndTime();
            String confirmedBy = deptsum.getConfirmedBy();
            Integer state = deptsum.getState();
            Date confirmedTime = deptsum.getConfirmedTime();
            CyDepcombin cyDepcombin = new CyDepcombin();
            cyDepcombin.setSummaryBy(summaryBy);
            cyDepcombin.setIssueNumber(issueNumber);
            cyDepcombin.setConfirmedBy(confirmedBy);
            cyDepcombin.setStartTime(startTime);
            cyDepcombin.setEndTime(endTime);
            cyDepcombin.setState(state);
            cyDepcombin.setMerger(merger);
            cyDepcombin.setConfirmedTime(confirmedTime);
            cyDepcombinService.insertCyDepcombin(cyDepcombin);
            Integer id = cyDepcombin.getId();
            CyDepcombin cyDepcombin1 = cyDepcombinService.selectCyDepcombinById(id);
            return AjaxResult.success(cyDepcombin1);
        }
        return null;
    }

    /**
     * 删除合并汇总
     */
    /*@PreAuthorize("@ss.hasPermi('system:depcombin:remove')")
    @Log(title = "合并汇总", businessType = BusinessType.DELETE)*/
    @PostMapping("/system/depcombin/delete")
    public AjaxResult remove(@RequestBody String string)
    {
        System.out.println("id = " + string);
        JSONObject jsonObject = JSON.parseObject(string).getJSONObject("data");
        CyDepcombin cyDepcombin = JSON.toJavaObject(jsonObject, CyDepcombin.class);
        Integer id = cyDepcombin.getId();
        return toAjax(cyDepcombinService.deleteCyDepcombinById(id));
    }
}

package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CyCompleterptrcvx;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public interface CyCompleterptrcvxMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param rcvlotno 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public CyCompleterptrcvx selectCyCompleterptrcvxByRcvlotno(String rcvlotno);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param cyCompleterptrcvx 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<CyCompleterptrcvx> selectCyCompleterptrcvxList(CyCompleterptrcvx cyCompleterptrcvx);

    /**
     * 新增【请填写功能名称】
     * 
     * @param cyCompleterptrcvx 【请填写功能名称】
     * @return 结果
     */
    public int insertCyCompleterptrcvx(CyCompleterptrcvx cyCompleterptrcvx);

    /**
     * 修改【请填写功能名称】
     * 
     * @param cyCompleterptrcvx 【请填写功能名称】
     * @return 结果
     */
    public int updateCyCompleterptrcvx(CyCompleterptrcvx cyCompleterptrcvx);

    /**
     * 删除【请填写功能名称】
     * 
     * @param rcvlotno 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteCyCompleterptrcvxByRcvlotno(String rcvlotno);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param rcvlotnos 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCyCompleterptrcvxByRcvlotnos(String[] rcvlotnos);
}

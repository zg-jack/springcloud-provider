package com.zhuguang.jack.dao;

import java.util.List;
import java.util.Map;

import com.zhuguang.jack.bean.ConsultConfigArea;
import com.zhuguang.jack.bean.ConsultContent;
import com.zhuguang.jack.bean.ConsultContract;
import com.zhuguang.jack.bean.ConsultIdCardInfo;
import com.zhuguang.jack.bean.ConsultRecord;
import com.zhuguang.jack.bean.ConsultRecordCount;

public interface CommonMapper {
    
    int saveArea(ConsultConfigArea area);
    
    int deleteArea(Map param);
    
    int deleteAreaAll();
    
    int updateArea(ConsultConfigArea area);
    
    List<ConsultConfigArea> queryAreaByAreaCode(Map param);
    
    List<ConsultRecord> queryConsultRecords(Map param);
    
    List<Map> queryUserByPsptId(Map param);
    
    int saveUser(ConsultIdCardInfo record);
    
    int saveRecord(ConsultRecord record);
    
    int saveRecordCount(ConsultRecordCount recordCount);
    
    List<ConsultRecord> queryRecords(Map param);
    
    List<ConsultRecord> queryRecordshaveH(Map param);
    
    //@Select("select * from consult_content where type = #{type}")
    //    @Select({"<script>", "select * from consult_content a where a.state = 0",
    //            "<if test='type != null'>",
    //            "and a.type = #{type,jdbcType=VARCHAR}", "</if>",
    //            "order by a.itemindex", "</script>"})
    List<ConsultContent> queryContent(Map param);
    
    int updateRecords(Map param);
    
    int updateRecordsByPsptId(Map param);
    
    List<ConsultRecordCount> queryRecordCount(Map param);
    
    int updateRecordCount(Map param);
    
    List<ConsultConfigArea> qryArea(Map param);
    
    List<ConsultContract> qryContracts(Map param);
    
    int saveContracts(List<ConsultContract> contracts);
    
    int updateConsultRecord(Map param);
}

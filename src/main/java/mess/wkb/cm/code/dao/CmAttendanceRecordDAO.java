package mess.wkb.cm.code.dao;

import java.util.Map;

import org.springframework.stereotype.Component;

import mess.wkb.cm.code.po.CmAttendanceRecordPO;
import mess.wkb.cm.code.vo.CmAttendanceRecord;

@Component
public interface CmAttendanceRecordDAO extends BaseDAO<CmAttendanceRecord> {
    /**
     *
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     */
    int insertSelective(CmAttendanceRecordPO obj);

    /**
     *
     */
    CmAttendanceRecordPO selectByPrimaryKey(Long id);

    /**
     *
     */
    int updateByPrimaryKeySelective(CmAttendanceRecordPO obj);

    /**
     *
     */
    int updateByPrimaryKey(CmAttendanceRecord record);

	void seat(Map<String, String> map);

	CmAttendanceRecordPO getAttend(CmAttendanceRecordPO po);
}
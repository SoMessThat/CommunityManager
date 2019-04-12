package mess.wkb.cm.code.dao;

import org.springframework.stereotype.Component;

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
    int insertSelective(CmAttendanceRecord record);

    /**
     *
     */
    CmAttendanceRecord selectByPrimaryKey(Long id);

    /**
     *
     */
    int updateByPrimaryKeySelective(CmAttendanceRecord record);

    /**
     *
     */
    int updateByPrimaryKey(CmAttendanceRecord record);
}
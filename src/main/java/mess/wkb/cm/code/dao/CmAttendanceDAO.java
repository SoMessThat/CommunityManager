package mess.wkb.cm.code.dao;

import org.springframework.stereotype.Component;

import mess.wkb.cm.code.vo.CmAttendance;

@Component
public interface CmAttendanceDAO extends BaseDAO<CmAttendance> {
    /**
     *
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     */
    int insertSelective(CmAttendance record);

    /**
     *
     */
    CmAttendance selectByPrimaryKey(Long id);

    /**
     *
     */
    int updateByPrimaryKeySelective(CmAttendance record);

    /**
     *
     */
    int updateByPrimaryKey(CmAttendance record);
}
package mess.wkb.cm.code.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import mess.wkb.cm.code.po.CmAttendancePO;
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
    CmAttendancePO selectByPrimaryKey(Long id);

    /**
     *
     */
    int updateByPrimaryKeySelective(CmAttendance record);

    /**
     *
     */
    int updateByPrimaryKey(CmAttendance record);

	List<CmAttendancePO> queryListCmAttendance(CmAttendancePO obj);

	CmAttendancePO selectMeeting( @RequestParam Map<String, String> map);

	Map<String, String> getCount(Map<String, String> map);

	List<Map<String, String>> getSeat(Map<String, String> map);
}
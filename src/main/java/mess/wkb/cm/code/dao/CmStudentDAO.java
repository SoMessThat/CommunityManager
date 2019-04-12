package mess.wkb.cm.code.dao;

import org.springframework.stereotype.Component;

import mess.wkb.cm.code.vo.CmStudent;

@Component
public interface CmStudentDAO extends BaseDAO<CmStudent> {
    /**
     *
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     */
    int insertSelective(CmStudent record);

    /**
     *
     */
    CmStudent selectByPrimaryKey(String id);

    /**
     *
     */
    int updateByPrimaryKeySelective(CmStudent record);

    /**
     *
     */
    int updateByPrimaryKey(CmStudent record);
}
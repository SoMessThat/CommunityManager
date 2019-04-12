package mess.wkb.cm.code.dao;

import org.springframework.stereotype.Component;

import mess.wkb.cm.code.vo.CmDepartment;

@Component
public interface CmDepartmentDAO extends BaseDAO<CmDepartment>  {
    /**
     *
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     */
    int insertSelective(CmDepartment record);

    /**
     *
     */
    CmDepartment selectByPrimaryKey(String id);

    /**
     *
     */
    int updateByPrimaryKeySelective(CmDepartment record);

    /**
     *
     */
    int updateByPrimaryKey(CmDepartment record);
}
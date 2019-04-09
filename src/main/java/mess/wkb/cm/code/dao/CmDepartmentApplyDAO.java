package mess.wkb.cm.code.dao;

import org.springframework.stereotype.Component;

import mess.wkb.cm.code.vo.CmDepartmentApply;

@Component
public interface CmDepartmentApplyDAO extends BaseDAO<CmDepartmentApply> {
    /**
     *
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     */
    int insertSelective(CmDepartmentApply record);

    /**
     *
     */
    CmDepartmentApply selectByPrimaryKey(Long id);

    /**
     *
     */
    int updateByPrimaryKeySelective(CmDepartmentApply record);

    /**
     *
     */
    int updateByPrimaryKey(CmDepartmentApply record);
}
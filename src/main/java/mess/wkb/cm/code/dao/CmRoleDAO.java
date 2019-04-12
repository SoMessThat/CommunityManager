package mess.wkb.cm.code.dao;

import org.springframework.stereotype.Component;

import mess.wkb.cm.code.vo.CmRole;

@Component
public interface CmRoleDAO extends BaseDAO<CmRole> {
    /**
     *
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     */
    int insertSelective(CmRole record);

    /**
     *
     */
    CmRole selectByPrimaryKey(Long id);

    /**
     *
     */
    int updateByPrimaryKeySelective(CmRole record);

    /**
     *
     */
    int updateByPrimaryKey(CmRole record);
}
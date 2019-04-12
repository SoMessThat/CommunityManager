package mess.wkb.cm.code.dao;

import org.springframework.stereotype.Component;

import mess.wkb.cm.code.vo.CmScheme;

@Component
public interface CmSchemeDAO extends BaseDAO<CmScheme> {
    /**
     *
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     */
    int insertSelective(CmScheme record);

    /**
     *
     */
    CmScheme selectByPrimaryKey(Long id);

    /**
     *
     */
    int updateByPrimaryKeySelective(CmScheme record);

    /**
     *
     */
    int updateByPrimaryKey(CmScheme record);
}
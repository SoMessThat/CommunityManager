package mess.wkb.cm.code.dao;

import org.springframework.stereotype.Component;

import mess.wkb.cm.code.vo.CmPower;

@Component
public interface CmPowerDAO extends BaseDAO<CmPower> {
    /**
     *
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     */
    int insertSelective(CmPower record);

    /**
     *
     */
    CmPower selectByPrimaryKey(String id);

    /**
     *
     */
    int updateByPrimaryKeySelective(CmPower record);

    /**
     *
     */
    int updateByPrimaryKey(CmPower record);
}
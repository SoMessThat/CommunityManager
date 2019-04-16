package mess.wkb.cm.code.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import mess.wkb.cm.code.dto.PowerDTO;
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
    
    /**
     * 查找权限菜单树
     */
    List<PowerDTO> selectPowerRootByUserID(String userID);
}
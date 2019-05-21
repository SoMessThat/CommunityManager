package mess.wkb.cm.code.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import mess.wkb.cm.code.dto.UserInfoDTO;
import mess.wkb.cm.code.vo.CmUser;

@Component
public interface CmUserDAO extends BaseDAO<CmUser> {
    /**
     *
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     */
    int insertSelective(CmUser record);

    /**
     *
     */
    CmUser selectByPrimaryKey(String id);

    /**
     *
     */
    int updateByPrimaryKeySelective(CmUser record);

    /**
     *
     */
    int updateByPrimaryKey(CmUser record);

    /**
     * 获取用户信息
     * @param id
     * @return
     */
	UserInfoDTO getCmUserById(String id);

	void updateUserInfo(CmUser obj);

	List<UserInfoDTO> queryEmployee(String departmentId);
}
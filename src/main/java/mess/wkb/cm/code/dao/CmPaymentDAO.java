package mess.wkb.cm.code.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import mess.wkb.cm.code.vo.CmPayment;

@Component
public interface CmPaymentDAO extends BaseDAO<CmPayment> {
    /**
     *
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     */
    int insertSelective(CmPayment record);

    /**
     *
     */
    CmPayment selectByPrimaryKey(Long id);

    /**
     *
     */
    int updateByPrimaryKeySelective(CmPayment record);

    /**
     *
     */
    int updateByPrimaryKey(CmPayment record);

	List<Map<String, String>> getEmplayee(String departmentId);
}
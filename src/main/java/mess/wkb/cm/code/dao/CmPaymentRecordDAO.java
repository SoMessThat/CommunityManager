package mess.wkb.cm.code.dao;

import org.springframework.stereotype.Component;

import mess.wkb.cm.code.vo.CmPaymentRecord;

@Component
public interface CmPaymentRecordDAO extends BaseDAO<CmPaymentRecord> {
    /**
     *
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     */
    int insertSelective(CmPaymentRecord record);

    /**
     *
     */
    CmPaymentRecord selectByPrimaryKey(Long id);

    /**
     *
     */
    int updateByPrimaryKeySelective(CmPaymentRecord record);

    /**
     *
     */
    int updateByPrimaryKey(CmPaymentRecord record);
}
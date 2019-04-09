package mess.wkb.cm.code.dao;

import org.springframework.stereotype.Component;

import mess.wkb.cm.code.vo.CmWorkSummary;

@Component
public interface CmWorkSummaryDAO extends BaseDAO<CmWorkSummary> {
    /**
     *
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     */
    int insertSelective(CmWorkSummary record);

    /**
     *
     */
    CmWorkSummary selectByPrimaryKey(Long id);

    /**
     *
     */
    int updateByPrimaryKeySelective(CmWorkSummary record);

    /**
     *
     */
    int updateByPrimaryKey(CmWorkSummary record);
}
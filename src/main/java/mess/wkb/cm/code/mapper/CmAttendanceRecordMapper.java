package mess.wkb.cm.code.mapper;

import mess.wkb.cm.code.vo.CmAttendanceRecord;

public interface CmAttendanceRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_attendance_record
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_attendance_record
     *
     * @mbg.generated
     */
    int insert(CmAttendanceRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_attendance_record
     *
     * @mbg.generated
     */
    int insertSelective(CmAttendanceRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_attendance_record
     *
     * @mbg.generated
     */
    CmAttendanceRecord selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_attendance_record
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CmAttendanceRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_attendance_record
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CmAttendanceRecord record);
}
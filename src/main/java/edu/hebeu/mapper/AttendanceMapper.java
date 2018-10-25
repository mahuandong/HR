package edu.hebeu.mapper;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import edu.hebeu.entity.Attendance;

public interface AttendanceMapper extends BaseMapper<Attendance>{

	/**
	 * 根据employeeNumber和day查询记录
	 * @param employeeNumber
	 * @return
	 */
	Attendance selectByNumber(@Param("employeeNumber")Integer employeeNumber,
			@Param("day")Date day, @Param("timeType")String timeType);

	/**
	 * 考勤天数
	 * @param record
	 * @return
	 */
	int Late(Attendance record);

	/**
	 * 加班数
	 * @param record
	 * @return
	 */
	int Overtime(Attendance record);


	List<Attendance> selectAll();
}

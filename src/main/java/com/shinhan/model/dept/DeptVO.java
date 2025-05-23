package com.shinhan.model.dept;

import com.shinhan.model.job.JobDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//JavaBeans(기본생성자, get/set)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class DeptVO {
	private Integer department_id;
	private String department_name;
	private Integer manager_id;
	private Integer location_id;
	
	//has-a관계
	JobDTO job;
}

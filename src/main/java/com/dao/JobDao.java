package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.JobBean;
import com.bean.StudentBean;

@Repository
public class JobDao {

	@Autowired
	JdbcTemplate stmt;

	public void insertJob(JobBean job) {
		stmt.update("insert into job (title,jdurl) values (?,?) ", job.getTitle(), job.getJdUrl());
	}

	public List<JobBean> getalljobs() {
		List<JobBean> jobs = stmt.query("select * from job", new BeanPropertyRowMapper<JobBean>(JobBean.class));
		return jobs;
	}

	public void deletejob(int jobId) {
		stmt.update("delete from job where jobid=? ", jobId);

	}

	public JobBean getjobbyId(int jobId) {
		
		return stmt.queryForObject("select * from job where jobid=?",new BeanPropertyRowMapper<JobBean>(JobBean.class), new Object[] {jobId});
	}

}

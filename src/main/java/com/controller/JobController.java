package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.JobBean;
import com.dao.JobDao;

@Controller
public class JobController {

	@Autowired
	JobDao jobdao;
	
	@GetMapping("/newjob")
	public String newJob()
	{
		return "NewJob";
	}
	@PostMapping("/savejob")
	public String saveJob(JobBean job) {
		System.out.println(job);
		System.out.println(job.getTitle());
		System.out.println(job.getDescription().getOriginalFilename());// uploaded file name
		System.out.println(job.getDescription().getSize());// uploaded file size

		try {
			Date d=new Date();
			long ts=d.getTime();
			File f = new File("D:\\Royaljava\\Placement\\src\\main\\webapp\\resources\\jd", ts+"_"+job.getDescription().getOriginalFilename());

			byte b[] = job.getDescription().getBytes(); // read all bytes;

			FileOutputStream fos = new FileOutputStream(f);
			fos.write(b);
			fos.close();
			job.setJdUrl("resources\\jd\\"+ts+"_"+job.getDescription().getOriginalFilename());
			jobdao.insertJob(job);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//jobdao.insertJob(job);
		return "redirect:/home";
	}
	
	@GetMapping("/listalljobs")
	public String listAllJobs(Model model)
	{
		List<JobBean> jobs=jobdao.getalljobs();
		model.addAttribute("jobs",jobs);
		return "Listjobs";
	}
	
	@GetMapping("/deletejob")
	public String deleteJob(@RequestParam("jobId") int jobId)
	{
		jobdao.deletejob(jobId);
		return "redirect:/listalljobs";
	}
	
	@GetMapping("/editjob")
	public String editJob(@RequestParam("jobId")int jobId,Model model)
	{
		JobBean job=jobdao.getjobbyId(jobId);
		model.addAttribute("job", job);
		return "EditJob";
	}
	
	
}

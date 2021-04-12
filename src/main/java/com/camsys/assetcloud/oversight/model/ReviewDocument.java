package com.camsys.assetcloud.oversight.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.camsys.assetcloud.model.WorkflowStage;

@Entity
@Table(name="CS_ReviewDocument")
public class ReviewDocument {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Integer id;
	
	@Column(name="filename_prefix")
	public String filenamePrefix;

	public String name;

	public String program;
	
	@Column(name="workflow_stage")
	public WorkflowStage workflowStage = WorkflowStage.FINAL;
	
}

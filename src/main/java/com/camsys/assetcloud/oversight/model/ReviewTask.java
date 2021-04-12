package com.camsys.assetcloud.oversight.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.camsys.assetcloud.model.WorkflowStage;

@Entity
@Table(name="CS_ReviewTask")
public class ReviewTask {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Integer id;
	
	public String name;

	@Column(name="workflow_stage")
	public WorkflowStage workflowStage = WorkflowStage.FINAL;

}

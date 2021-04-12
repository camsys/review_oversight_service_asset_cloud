package com.camsys.assetcloud.oversight.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.camsys.assetcloud.model.Organization;
import com.camsys.assetcloud.model.WorkflowStage;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="CS_Review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Integer id;

	public String name;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinColumn(name="id")
	public Review template;

	@Column(name="review_type")
	public String reviewType;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	public List<ReviewDocument> requiredDocuments;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	public List<ReviewTask> requiredTasks;
		
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name="id", referencedColumnName="reviewer_id")	
	public Organization reviewer;
	
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name="id", referencedColumnName="reviewee_id")	
	public Organization reviewee;
	
	@Column(name="workflow_stage")
	public WorkflowStage workflowStage = WorkflowStage.FINAL;
}

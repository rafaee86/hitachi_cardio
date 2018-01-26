/*
 * @Author Mohammad Rafaee Bin Suhai
 * @CreatedDate 26/01/2018 * 
 */

package com.hitachiebwork.cardiochallenges.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CHALLENGES")
public class Challenges implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "int(8)")
	@GeneratedValue
	private Long pkid;
	
	@Column(nullable = false)
	private String description;
	
	@JoinColumn(referencedColumnName = "PKID", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private ChallengeLevel level;
	
	@Column(nullable = false, columnDefinition = "int(10)")
	private Integer pointValue;	

	@Column(nullable = false, columnDefinition = "int(10)")
	private Integer caloriesValue;

	public Long getPkid() {
		return pkid;
	}

	public void setPkid(Long pkid) {
		this.pkid = pkid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ChallengeLevel getLevel() {
		return level;
	}

	public void setLevel(ChallengeLevel level) {
		this.level = level;
	}

	public Integer getPointValue() {
		return pointValue;
	}

	public void setPointValue(Integer pointValue) {
		this.pointValue = pointValue;
	}

	public Integer getCaloriesValue() {
		return caloriesValue;
	}

	public void setCaloriesValue(Integer caloriesValue) {
		this.caloriesValue = caloriesValue;
	}
}

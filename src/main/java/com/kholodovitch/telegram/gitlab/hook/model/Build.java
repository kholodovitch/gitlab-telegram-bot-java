package com.kholodovitch.telegram.gitlab.hook.model;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;

import net.karneim.pojobuilder.GeneratePojoBuilder;

/**
 * @author Alexander Kholodovitch
 */
@GeneratePojoBuilder(intoPackage = "*.builder.generated", withFactoryMethod = "*")
public class Build {

	private int id;
	private String stage;
	private String name;
	private String status;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdAt;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startedAt;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date finishedAt;
	private String when;
	private boolean manual;
	private User user;
	private Runner runner;
	private ArtifactsFile artifactsFile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}

	public Date getFinishedAt() {
		return finishedAt;
	}

	public void setFinishedAt(Date finishedAt) {
		this.finishedAt = finishedAt;
	}

	public String getWhen() {
		return when;
	}

	public void setWhen(String when) {
		this.when = when;
	}

	public boolean isManual() {
		return manual;
	}

	public void setManual(boolean manual) {
		this.manual = manual;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Runner getRunner() {
		return runner;
	}

	public void setRunner(Runner runner) {
		this.runner = runner;
	}

	public ArtifactsFile getArtifactsFile() {
		return artifactsFile;
	}

	public void setArtifactsFile(ArtifactsFile artifactsFile) {
		this.artifactsFile = artifactsFile;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Build build = (Build) o;
		return new EqualsBuilder()
				.append(getId(), build.getId())
				.append(getStage(), build.getStage())
				.append(getName(), build.getName())
				.append(getStatus(), build.getStatus())
				.append(getCreatedAt(), build.getCreatedAt())
				.append(getStartedAt(), build.getStartedAt())
				.append(getFinishedAt(), build.getFinishedAt())
				.append(getWhen(), build.getWhen())
				.append(isManual(), build.isManual())
				.append(getUser(), build.getUser())
				.append(getRunner(), build.getRunner())
				.append(getArtifactsFile(), build.getArtifactsFile())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(getId())
				.append(getStage())
				.append(getName())
				.append(getStatus())
				.append(getCreatedAt())
				.append(getStartedAt())
				.append(getFinishedAt())
				.append(getWhen())
				.append(isManual())
				.append(getUser())
				.append(getRunner())
				.append(getArtifactsFile())
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("id", getId())
				.append("stage", getStage())
				.append("name", getName())
				.append("status", getStatus())
				.append("createdAt", getCreatedAt())
				.append("finishedAt", getFinishedAt())
				.append("when", getWhen())
				.append("manual", isManual())
				.append("user", getUser())
				.append("runner", getRunner())
				.append("artifactsFile", getArtifactsFile())
				.toString();
	}

}

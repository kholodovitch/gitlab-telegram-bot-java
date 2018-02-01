package com.kholodovitch.telegram.gitlab.hook.model;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import net.karneim.pojobuilder.GeneratePojoBuilder;

/**
 * @author Milena Zachow
 * @author Alexander Kholodovitch
 */
@GeneratePojoBuilder(intoPackage = "*.builder.generated", withFactoryMethod = "*")
public class PipelineHook extends WebHook {

	private User user;
	private Commit commit;
	private Project project;
	private PipelineEventObjectAttributes objectAttributes;
	private List<Build> builds;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Commit getCommit() {
		return commit;
	}

	public void setCommit(Commit commit) {
		this.commit = commit;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public PipelineEventObjectAttributes getObjectAttributes() {
		return objectAttributes;
	}

	public void setObjectAttributes(PipelineEventObjectAttributes objectAttributes) {
		this.objectAttributes = objectAttributes;

	}

	public List<Build> getBuilds() {
		return builds;
	}

	public void setBuilds(List<Build> builds) {
		this.builds = builds;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PipelineHook that = (PipelineHook) o;
		return new EqualsBuilder()
				.append(user, that.user)
				.append(project, that.project)
				.append(commit, that.commit)
				.append(objectAttributes, that.objectAttributes)
				.append(builds, that.builds)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(user)
				.append(project)
				.append(commit)
				.append(objectAttributes)
				.append(builds)
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("user", user)
				.append("project", project)
				.append("objectAttributes", objectAttributes)
				.append("commit", commit)
				.append("builds", builds)
				.toString();
	}
}

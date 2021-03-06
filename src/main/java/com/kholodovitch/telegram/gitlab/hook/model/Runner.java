package com.kholodovitch.telegram.gitlab.hook.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import net.karneim.pojobuilder.GeneratePojoBuilder;

/**
 * @author Alexander Kholodovitch
 */
@GeneratePojoBuilder(intoPackage = "*.builder.generated", withFactoryMethod = "*")
public class Runner {

	private int id;
	private String description;
	private boolean active;
	private boolean isIsShared;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isIsShared() {
		return isIsShared;
	}

	public void setIsShared(boolean isIsShared) {
		this.isIsShared = isIsShared;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Runner runner = (Runner) o;
		return new EqualsBuilder()
				.append(id, runner.id)
				.append(description, runner.description)
				.append(active, runner.active)
				.append(isIsShared(), runner.isIsShared())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(id)
				.append(description)
				.append(active)
				.append(isIsShared())
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("id", id)
				.append("description", description)
				.append("active", active)
				.append("isShared", isIsShared())
				.toString();
	}

}

package sportszer.api.organization.bean;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A Sportszer Organization
 * 
 * @author Siddharth Pandey
 * @since July 20, 2016
 */
@ApiModel(value = "Organization", description = "A Sportszer Organization")
@DynamoDBTable(tableName = "Organization")
public class Organization {

	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	private String organizationId;

	@ApiModelProperty(value = "Organization name", required = true)
	@DynamoDBIndexHashKey(globalSecondaryIndexName = "name") //global secondary index
	private String name;

	public Organization() {
	}

	public Organization(String organizationId, String name) {
		setOrganizationId(organizationId);
		setName(name);
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Organization [organizationId=" + organizationId + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((organizationId == null) ? 0 : organizationId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Organization other = (Organization) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (organizationId == null) {
			if (other.organizationId != null)
				return false;
		} else if (!organizationId.equals(other.organizationId))
			return false;
		return true;
	}
}

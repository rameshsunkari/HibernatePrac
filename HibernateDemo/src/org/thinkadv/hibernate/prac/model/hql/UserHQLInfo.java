package org.thinkadv.hibernate.prac.model.hql;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "USER_INFO_HQL")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)

@NamedQueries(value = {
		@NamedQuery(name = "User.byId", query = "from UserHQLInfo where id = :id"),
		@NamedQuery(name = "User.byName", query = "from UserHQLInfo where name = :name")

})
@NamedNativeQueries(value = {
		@NamedNativeQuery(name = "User.getById", query = "SELECT * FROM USER_INFO_HQL WHERE ID = ? ", resultClass = UserHQLInfo.class),
		@NamedNativeQuery(name = "User.getByName", query = "SELECT * FROM USER_INFO_HQL WHERE NAME = :NAME ", resultClass = UserHQLInfo.class)
})
public class UserHQLInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + "]";
	}

}

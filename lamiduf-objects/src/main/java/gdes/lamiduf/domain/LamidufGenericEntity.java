package gdes.lamiduf.domain;

import java.util.UUID;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import santeos.hibernate.domain.GenericEntity;

@MappedSuperclass
public abstract class LamidufGenericEntity extends GenericEntity {

	@Override
	public abstract Long getId();

	@Transient
	private String idTemp;

	public String getIdTemp() {
		return idTemp;
	}

	public void setIdTemp(String idTemp) {
		this.idTemp = idTemp;
	}

	public LamidufGenericEntity() {
		this.idTemp = UUID.randomUUID().toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LamidufGenericEntity) {
			if (obj.getClass() == this.getClass()) {
				if (this.getIdTemp() != null) {
					if (((LamidufGenericEntity) obj).getIdTemp() != null) {
						if (this.getIdTemp().equals(((LamidufGenericEntity) obj).getIdTemp())) {
							if (this.getId() != null) {
								if (((LamidufGenericEntity) obj).getId() == null) {
									return false;
								} else if (!this.getId().equals(((LamidufGenericEntity) obj).getId())) {
									return false;
								}
							}
							return true;
						}
					}
				}
				if (this.getId() != null) {
					if (((LamidufGenericEntity) obj).getId() != null) {
						if (this.getId().equals(((LamidufGenericEntity) obj).getId())) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}

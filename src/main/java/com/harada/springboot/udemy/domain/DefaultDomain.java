package com.harada.springboot.udemy.domain;

import java.io.Serializable;

public abstract class DefaultDomain implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public abstract Integer getId();
	
	public abstract void setId(Integer id);
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		DefaultDomain o = (DefaultDomain) obj;
		if (getId() == null) {
			if (o.getId() != null)
				return false;
		} else if (!getId().equals(o.getId()))
			return false;
		return true;
	}
	
}

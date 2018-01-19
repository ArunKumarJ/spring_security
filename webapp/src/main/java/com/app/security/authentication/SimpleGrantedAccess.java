package com.app.security.authentication;

public class SimpleGrantedAccess implements GrantedAccess {

	private String access;
	private boolean allowed;

	public SimpleGrantedAccess(String access, boolean allowed) {
		this.access = access;
		this.allowed = allowed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((access == null) ? 0 : access.hashCode());
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
		SimpleGrantedAccess other = (SimpleGrantedAccess) obj;
		if (access == null) {
			if (other.access != null)
				return false;
		} else if (!access.equals(other.access))
			return false;
		return true;
	}

	@Override
	public String getAccess() {
		return access;
	}

	@Override
	public boolean isAllowed() {
		return allowed;
	}

}

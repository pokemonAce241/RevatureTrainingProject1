package dev.jason.entities;

public class Reimbursement {
	
	private int id;
	
	private String sender;
	private String item;
	private double cost;
	private String reason;
	private int submitterID;
	private String status;
	private String managerComment;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int id, String sender, String item, double cost, String reason, int submitterID, String status,
			String managerComment) {
		super();
		this.id = id;
		this.sender = sender;
		this.item = item;
		this.cost = cost;
		this.reason = reason;
		this.submitterID = submitterID;
		this.status = status;
		this.managerComment = managerComment;
	}
	
	public Reimbursement(int id, String sender, String item, double cost, String reason, int submitterID) {
		super();
		this.id = id;
		this.sender = sender;
		this.item = item;
		this.cost = cost;
		this.reason = reason;
		this.submitterID = submitterID;
		this.status = "pending";
		this.managerComment = "waiting for approval/denial";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getSubmitterID() {
		return submitterID;
	}

	public void setSubmitterID(int submitterID) {
		this.submitterID = submitterID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getManagerComment() {
		return managerComment;
	}

	public void setManagerComment(String managerComment) {
		this.managerComment = managerComment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((managerComment == null) ? 0 : managerComment.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + submitterID;
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
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (id != other.id)
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (managerComment == null) {
			if (other.managerComment != null)
				return false;
		} else if (!managerComment.equals(other.managerComment))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (submitterID != other.submitterID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", sender=" + sender + ", item=" + item + ", cost=" + cost + ", reason="
				+ reason + ", submitterID=" + submitterID + ", status=" + status + ", managerComment=" + managerComment
				+ "]";
	}
	
	
	
	
	

}

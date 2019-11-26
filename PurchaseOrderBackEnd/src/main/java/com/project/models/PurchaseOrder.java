package com.project.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Purchase_Order")
public class PurchaseOrder {

	@Id
	@GeneratedValue
	private int purchaseOrderId;
	
	@Column(name="Delivery_Address")
	private String deliveryAddress;
	
	@Column(name="created_Date")
	private LocalDate createdDate;
	
	@Column(name="delivery_Date")
	private LocalDate deliveryDate;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name="buyer_Id")
	private User buyerObj;
	
	@ManyToOne
	@JoinColumn(name="Seller_Id")
	private User sellerObj;
	
	@OneToMany(mappedBy="purchaseOrderObj",cascade=CascadeType.ALL)
	private List<POItems> poItemsObj;

	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public User getBuyerObj() {
		return buyerObj;
	}

	public void setBuyerObj(User buyerObj) {
		this.buyerObj = buyerObj;
	}

	public User getSellerObj() {
		return sellerObj;
	}

	public void setSellerObj(User sellerObj) {
		this.sellerObj = sellerObj;
	}

	public List<POItems> getPoItemsObj() {
		return poItemsObj;
	}

	public void setPoItemsObj(List<POItems> poItemsObj) {
		this.poItemsObj = poItemsObj;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [purchaseOrderId=" + purchaseOrderId + ", deliveryAddress=" + deliveryAddress
				+ ", createdDate=" + createdDate + ", deliveryDate=" + deliveryDate + ", status=" + status
				+ ", buyerObj=" + buyerObj + ", sellerObj=" + sellerObj + ", poItemsObj=" + poItemsObj + "]";
	}

	
	
	
		
}
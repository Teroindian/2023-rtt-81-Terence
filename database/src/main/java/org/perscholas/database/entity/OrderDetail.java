package org.perscholas.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetails")
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
//	@Column(name = "order_id",  insertable = false, updatable = false)
//	private Integer orderId;
	
	         @ManyToOne(fetch = FetchType.EAGER, optional = false)
              @JoinColumn(name = "order_id", nullable = false)
              private Order order;
	         
	         
	         @ManyToOne(fetch = FetchType.EAGER, optional = false)
             @JoinColumn(name = "product_id", nullable = false)
             private Product product;
	         
	         
	         
	
//	@Column(name = "product_id", insertable = false, updatable = false)
//	private Integer productId;
	
	@Column(name = "quantity_ordered")
	private Integer quantityOrdered;
	
	@Column(name = "price_each", columnDefinition = "Decimal(10,2)")
	private Double PriceEach;
	
	@Column(name = "order_line_number", columnDefinition = "SMALLINT")
	private Integer orderLineNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public Integer getOrderId() {
//		return orderId;
//	}

//	public void setOrderId(Integer orderId) {
//		this.orderId = orderId;
//	}
//
//	public Integer getProductId() {
//		return productId;
//	}
//
//	public void setProductId(Integer productId) {
//		this.productId = productId;
//	}

	public Integer getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(Integer quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public Double getPriceEach() {
		return PriceEach;
	}

	public void setPriceEach(Double priceEach) {
		PriceEach = priceEach;
	}

	public Integer getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(Integer orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	
	
	
	
	
	
	
	
}

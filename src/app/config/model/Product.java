package app.config.model;
// Generated 2015/10/18 �U�� 12:51:13 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "Product", catalog = "AdventureWorks2012", uniqueConstraints = { @UniqueConstraint(columnNames = "Name"),
		@UniqueConstraint(columnNames = "ProductNumber") })
public class Product implements java.io.Serializable {

	private int productId;
	private String name;
	private String productNumber;
	private short safetyStockLevel;
	private short reorderPoint;
	private BigDecimal standardCost;
	private BigDecimal listPrice;
	private String size;

	
	public Product() {
	}

	public Product(int productId, String name, String productNumber, boolean makeFlag, boolean finishedGoodsFlag,
			short safetyStockLevel, short reorderPoint, BigDecimal standardCost, BigDecimal listPrice,
			int daysToManufacture, Date sellStartDate, String rowguid, Date modifiedDate) {
		this.productId = productId;
		this.name = name;
		this.productNumber = productNumber;
		this.safetyStockLevel = safetyStockLevel;
		this.reorderPoint = reorderPoint;
		this.standardCost = standardCost;
		this.listPrice = listPrice;
	}

	
	@Id

	@Column(name = "ProductID", unique = true, nullable = false)
	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Column(name = "Name", unique = true, nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ProductNumber", unique = true, nullable = false, length = 25)
	public String getProductNumber() {
		return this.productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	@Column(name = "SafetyStockLevel", nullable = false)
	public short getSafetyStockLevel() {
		return this.safetyStockLevel;
	}

	public void setSafetyStockLevel(short safetyStockLevel) {
		this.safetyStockLevel = safetyStockLevel;
	}

	@Column(name = "ReorderPoint", nullable = false)
	public short getReorderPoint() {
		return this.reorderPoint;
	}

	public void setReorderPoint(short reorderPoint) {
		this.reorderPoint = reorderPoint;
	}

	@Column(name = "StandardCost", nullable = false, scale = 4)
	public BigDecimal getStandardCost() {
		return this.standardCost;
	}

	public void setStandardCost(BigDecimal standardCost) {
		this.standardCost = standardCost;
	}

	@Column(name = "ListPrice", nullable = false, scale = 4)
	public BigDecimal getListPrice() {
		return this.listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	@Column(name = "Size", length = 5)
	public String getSize() {
		return this.size;
	}
	
	public void setSize(String size){
		this.size = size;
	}

}
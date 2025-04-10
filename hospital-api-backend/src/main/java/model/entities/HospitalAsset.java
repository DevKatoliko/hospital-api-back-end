package model.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import model.enums.AssetType;
@Entity
@Table(name="hospital_assets")
public class HospitalAsset implements Serializable{
	private static final long serialVersionUID = 1L;
	public static final String NULL_ERROR_HOSPITAL = "O ativo precisa de um hospital associado!";
	public static final String NULL_ERROR_QUANTITY= "O ativo precisa de uma quantidade!";
	public static final String NULL_ERROR_ASSET_TYPE= "O tipo do ativo precisa ser especificado!";
	public static final String NULL_ERROR_DESCRIPTION= "A descrição do ativo é necessária!";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(optional = false)
	@JoinColumn(name="hospital_id", referencedColumnName = "id")
	@NotNull(message = NULL_ERROR_HOSPITAL)
	private Hospital hospital;
	@Column(nullable = false)
	@PositiveOrZero
	@NotNull(message = NULL_ERROR_QUANTITY)
	private int quantity;
	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	@NotNull(message = NULL_ERROR_ASSET_TYPE)
	private AssetType assetType;
	@Column(nullable = false)
	@NotBlank(message = "É necessário que haja uma descrição do ativo!")
	@NotNull(message = NULL_ERROR_DESCRIPTION)
	private String description; // Describes what is the asset
	
	public HospitalAsset(Hospital hospital, int quantity, AssetType assetType, String description) {
		this.hospital = Objects.requireNonNull(hospital, NULL_ERROR_HOSPITAL);
		this.quantity = Objects.requireNonNull(quantity, NULL_ERROR_QUANTITY);
		if(quantity < 0) throw new IllegalArgumentException("A quantidade deve ser um numero positivo!");
		this.assetType = Objects.requireNonNull(assetType, NULL_ERROR_ASSET_TYPE);
		this.description = Objects.requireNonNull(description, NULL_ERROR_DESCRIPTION);
	}

	public Long getId() {
		return id;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = Objects.requireNonNull(hospital, NULL_ERROR_HOSPITAL);
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = Objects.requireNonNull(quantity, NULL_ERROR_QUANTITY);
		if(quantity < 0) throw new IllegalArgumentException("A quantidade deve ser um numero positivo!");
		 
	}

	public AssetType getAssetType() {
		return assetType;
	}

	public void setAssetType(AssetType assetType) {
		this.assetType =  Objects.requireNonNull(assetType, NULL_ERROR_ASSET_TYPE);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = Objects.requireNonNull(description, NULL_ERROR_DESCRIPTION);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HospitalAsset other = (HospitalAsset) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}

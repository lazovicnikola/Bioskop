//package me.fit.model.rest.client;
//
//import javax.xml.crypto.Data;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.NamedQueries;
//import jakarta.persistence.NamedQuery;
//
//
//public class IpClient {
//	public static final String GET = "client.get";
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
//	@JsonIgnore
//	private Long id;
//	private String ipString;
//	private String ipType;
//	private Data createdDate;
//	
//	public IpClient() {
//		super();
//	}
//
//
//	public Long getId() {
//		return id;
//	}
//
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//
//	public String getIpString() {
//		return ipString;
//	}
//
//
//	public void setIpString(String ipString) {
//		this.ipString = ipString;
//	}
//
//
//	public String getIpType() {
//		return ipType;
//	}
//
//
//	public void setIpType(String ipType) {
//		this.ipType = ipType;
//	}
//
//
//	public Data getCreatedDate() {
//		return createdDate;
//	}
//
//
//	public void setCreatedDate(Data createdDate) {
//		this.createdDate = createdDate;
//	}
//
//
//
//	
//	
//	
//}

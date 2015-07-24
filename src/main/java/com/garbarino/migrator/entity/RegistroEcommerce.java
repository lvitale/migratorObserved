
package com.garbarino.migrator.entity;


import java.io.Serializable;
import java.util.Date;

public class RegistroEcommerce implements Serializable{

	private Long idCarrito;
	private String nombre;
	private String apellido;
	private Long documento;
	
	private String calle;
	private String altura;
	private String piso;
	private String departamento;
	private String localidad;
	private String partido;
	private String provincia;
	private String pais;
	
	private String codPostal;
	private String telefono;
	private String celular;
	private String mail;
	
	private Date fechaRegistro;
	private String empresa;
	private String ip;
	private String bloqueado;
	private Date fechaCarrito;
	private Integer sucursal;
	private Integer nroVendedor;
	private Integer idUsuario;
	private Date fechaProcesoUx;
	private String motivoRechazoUx;
	private String sexo;
	private String codProvincia;
	private String origen;
	private Date fechaEntrega;
	private Long party;
	private Integer tipoPedido;
	private Integer codEmpresa;
	private Integer codDireccionAlternativa;
	private String entreCalleUno;
	private String entreCalleDos;
	private String listaCasamiento;
	private Integer addressIdFact;
	
	public Long getIdCarrito() {
		return idCarrito;
	}
	public void setIdCarrito(Long idCarrito) {
		this.idCarrito = idCarrito;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Long getDocumento() {
		return documento;
	}
	public void setDocumento(Long documento) {
		this.documento = documento;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getBloqueado() {
		return bloqueado;
	}
	public void setBloqueado(String bloqueado) {
		this.bloqueado = bloqueado;
	}
	public Date getFechaCarrito() {
		return fechaCarrito;
	}
	public void setFechaCarrito(Date fechaCarrito) {
		this.fechaCarrito = fechaCarrito;
	}
	public Integer getSucursal() {
		return sucursal;
	}
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}
	public Integer getNroVendedor() {
		return nroVendedor;
	}
	public void setNroVendedor(Integer nroVendedor) {
		this.nroVendedor = nroVendedor;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Date getFechaProcesoUx() {
		return fechaProcesoUx;
	}
	public void setFechaProcesoUx(Date fechaProcesoUx) {
		this.fechaProcesoUx = fechaProcesoUx;
	}
	public String getMotivoRechazoUx() {
		return motivoRechazoUx;
	}
	public void setMotivoRechazoUx(String motivoRechazoUx) {
		this.motivoRechazoUx = motivoRechazoUx;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCodProvincia() {
		return codProvincia;
	}
	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public Long getParty() {
		return party;
	}
	public void setParty(Long party) {
		this.party = party;
	}
	public Integer getTipoPedido() {
		return tipoPedido;
	}
	public void setTipoPedido(Integer tipoPedido) {
		this.tipoPedido = tipoPedido;
	}
	public Integer getCodEmpresa() {
		return codEmpresa;
	}
	public void setCodEmpresa(Integer codEmpresa) {
		this.codEmpresa = codEmpresa;
	}
	public Integer getCodDireccionAlternativa() {
		return codDireccionAlternativa;
	}
	public void setCodDireccionAlternativa(Integer codDireccionAlternativa) {
		this.codDireccionAlternativa = codDireccionAlternativa;
	}
	public String getEntreCalleUno() {
		return entreCalleUno;
	}
	public void setEntreCalleUno(String entreCalleUno) {
		this.entreCalleUno = entreCalleUno;
	}
	public String getEntreCalleDos() {
		return entreCalleDos;
	}
	public void setEntreCalleDos(String entreCalleDos) {
		this.entreCalleDos = entreCalleDos;
	}
	public String getListaCasamiento() {
		return listaCasamiento;
	}
	public void setListaCasamiento(String listaCasamiento) {
		this.listaCasamiento = listaCasamiento;
	}
	public Integer getAddressIdFact() {
		return addressIdFact;
	}
	public void setAddressIdFact(Integer addressIdFact) {
		this.addressIdFact = addressIdFact;
	}
	
	
}

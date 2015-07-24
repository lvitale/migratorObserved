package com.garbarino.migrator.entity;

import java.io.Serializable;
import java.util.Date;

public class RegistroVerificado implements Serializable, Cloneable{

	private Long idOperacion;
	private Date fechaProceso;
	private String usuario;
	private String codCta;
	private String apynom;
	private String tipoDoc;
	private String numDoc;
	private String nroTel;
	private String direccion;
	private String localidad;
	private String provincia;
	private String codigoPostal;
	private String estado;
	private String observaciones;
	private Integer codEmpresa;
	private Integer codEstado;
	private Date fechaProcesoUx;
	private String strEmpresa;
	private Integer estadoFinal;
	private Integer codDirAlter;
	private Integer sucursal;
	private Date fechaBaja;
	private String auto;
	private Integer motivoId;
	
	public Long getIdOperacion() {
		return idOperacion;
	}
	public void setIdOperacion(Long idOperacion) {
		this.idOperacion = idOperacion;
	}
	public Date getFechaProceso() {
		return fechaProceso;
	}
	public void setFechaProceso(Date fechaProceso) {
		this.fechaProceso = fechaProceso;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getCodCta() {
		return codCta;
	}
	public void setCodCta(String codCta) {
		this.codCta = codCta;
	}
	public String getApynom() {
		return apynom;
	}
	public void setApynom(String apynom) {
		this.apynom = apynom;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}
	public String getNroTel() {
		return nroTel;
	}
	public void setNroTel(String nroTel) {
		this.nroTel = nroTel;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Integer getCodEmpresa() {
		return codEmpresa;
	}
	public void setCodEmpresa(Integer codEmpresa) {
		this.codEmpresa = codEmpresa;
	}
	public Integer getCodEstado() {
		return codEstado;
	}
	public void setCodEstado(Integer codEstado) {
		this.codEstado = codEstado;
	}
	public Date getFechaProcesoUx() {
		return fechaProcesoUx;
	}
	public void setFechaProcesoUx(Date fechaProcesoUx) {
		this.fechaProcesoUx = fechaProcesoUx;
	}
	public String getStrEmpresa() {
		return strEmpresa;
	}
	public void setStrEmpresa(String strEmpresa) {
		this.strEmpresa = strEmpresa;
	}
	public Integer getEstadoFinal() {
		return estadoFinal;
	}
	public void setEstadoFinal(Integer estadoFinal) {
		this.estadoFinal = estadoFinal;
	}
	public Integer getCodDirAlter() {
		return codDirAlter;
	}
	public void setCodDirAlter(Integer codDirAlter) {
		this.codDirAlter = codDirAlter;
	}
	public Integer getSucursal() {
		return sucursal;
	}
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}
	public Date getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	public String getAuto() {
		return auto;
	}
	public void setAuto(String auto) {
		this.auto = auto;
	}
	public Integer getMotivoId() {
		return motivoId;
	}
	public void setMotivoId(Integer motivoId) {
		this.motivoId = motivoId;
	}

	
}

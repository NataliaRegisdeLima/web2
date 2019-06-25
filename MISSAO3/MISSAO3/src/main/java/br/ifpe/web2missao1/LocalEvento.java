package br.ifpe.web2missao1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LocalEvento {
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer codigo;
	private String nomeLocal;
	private String endereco;
	private String maps;
	private int capacidade;
	private String localAberto;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNomeLocal() {
		return nomeLocal;
	}
	public void setNomeLocal(String nomeLocal) {
		this.nomeLocal = nomeLocal;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getMaps() {
		return maps;
	}
	public void setMaps(String maps) {
		this.maps = maps;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public String getLocalAberto() {
		return localAberto;
	}
	public void setLocalAberto(String localAberto) {
		this.localAberto = localAberto;
	}

}

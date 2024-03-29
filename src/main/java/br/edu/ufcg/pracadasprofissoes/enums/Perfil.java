package br.edu.ufcg.pracadasprofissoes.enums;

public enum Perfil {
	
	ADMIN(1, "ROLE_ADMIN"),
	USUARIO(2, "ROLE_USUARIO");
	
	private int cod;
	private String descricao;
	
	private Perfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static String getPerfil(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Perfil x: Perfil.values()) {
			if (cod.equals(x.getCod())) {
				return x.getDescricao();
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
	public static Perfil toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Perfil x: Perfil.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}

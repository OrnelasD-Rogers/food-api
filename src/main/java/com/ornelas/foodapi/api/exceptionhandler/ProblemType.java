package com.ornelas.foodapi.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {
    DADOS_INVALIDOS("/dados-invalidos", "Dados Inválidos"),
    ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de Sistema"),
    PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro Invalido"),
    PROPRIEDADE_DESCONHECIDA("/propriedade-desconhecida", "Propriedade Desconhecida"),
    PROPRIEDADE_INEXISTENTE("/propriedade-inexistente", "Propriedade inexistente"),
    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível"),
    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
    ENTIDADE_EM_USO("/entidade-em-uso", "Entidade está em uso"),
    ERRO_NEGOCIO("/erro-negocio", "Violação da regra de Negócio");

    private String title;
    private String path;

    ProblemType( String path, String title) {
        this.path = "https://foodapi.com.br" + path;
        this.title = title;
    }
}

package com.flworks.ProjetoExcel.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name="sinapi_analitico")
public class SinapiAnalitico {
    @Id
    private Long id;

    @Column(name = "desc_custo_composicao")
    private String descricaoCustoComposicao; // CUSTO DE COMPOSICAO ANALITICO OU SINTETICO

    @Column(name = "data_emissao")
    private Date dataEmissao;

    @Column(name = "data_RT")
    private Date dataRT;

    @Column(name = "encargo_social_hora")
    private Double encargoSocialHora;

    @Column(name = "encargo_social_mes")
    private Double encargoSocialMes;

    @Column(name = "abrangencia")
    private String abrangencia;

    @Column(name = "des_classe")
    private String descricaoClasse;

    @Column(name = "sigla_classe")
    private String siglaClasse;

    @Column(name = "desc_tipo1")
    private String descricaoTipo1;

    @Column(name = "sigla_tipo1")
    private String siglaTipo1;

    @Column(name = "cod_agrupador")
    private String codigoAgrupador;

    @Column(name = "desc_agrupador")
    private String descricaoAgrupador;

    @Column(name = "cod_composicao")
    private String codigoComposicao;

    @Column(name = "desc_composicao")
    private String descricaoComposicao;

    @Column(name = "unidade")
    private String unidade;

    @Column(name = "origem_preco")
    private String origemPreco;

    @Column(name = "custo_total_composicao")
    private Double custoTotalComposicao;

    @Column(name = "tp_item")
    private String tipoItem;

    @Column(name = "cod_item")
    private String codigoItem;

    @Column(name = "desc_item")
    private String descricaoItem;

    @Column(name = "unidade_item")
    private String unidadeItem;

    @Column(name = "origem_preco_item")
    private String origemPrecoItem;

    @Column(name = "coeficiente")
    private String coeficiente;

    @Column(name = "preco_unitario")
    private Double precoUnitario;

    @Column(name = "custo_total_item")
    private Double custoTotalItem;

    @Column(name = "custo_mao_obra")
    private Double custoMaoObra;

    @Column(name = "porcentagem_mao_obra")
    private Double porcentagemMaoObra;

    @Column(name = "custo_material")
    private Double custoMaterial;

    @Column(name = "porcentagem_material")
    private Double porcentagemMaterial;

    @Column(name = "custo_equipamento")
    private Double custoEquipamento;

    @Column(name = "porcentagem_equipamento")
    private Double porcentagemEquipamento;

    @Column(name = "custo_servico_terceiros")
    private Double custoServicoTerceiros;

    @Column(name = "porcentagem_servico_terceiros")
    private Double porcentagemServicoTerceiros;

    @Column(name = "custo_outros")
    private Double custoOutros;

    @Column(name = "porcentagem_outros")
    private Double porcentagemOutros;

    @Column(name = "porcentagem_atribuido_sp")
    private Double porcentagemAtribuidoSp;

    @Column(name = "vinculo")
    private String vinculo;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
